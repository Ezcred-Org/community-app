package com.mifos.api;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.mifos.api.services.OAuthService;
import com.mifos.objects.oauth.OAuthTokenResponse;
import com.mifos.utils.PrefManager;

import java.util.HashMap;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by Rajan Maurya on 16/06/16.
 */
public class MifosTokenAuthenticator implements Authenticator {

  private final PrefManager prefManager;
  private final OAuthService oAuthService;

  public MifosTokenAuthenticator(PrefManager prefManager, OAuthService oAuthService) {
    this.prefManager = prefManager;
    this.oAuthService = oAuthService;
  }

  @Nullable
  @Override
  public Request authenticate(Route route, Response response) {
    Request request = null;
    if (prefManager != null && oAuthService != null && prefManager.getOauthData() != null) {
      synchronized (this) {
        if (prefManager.getOauthData() == null) {
          return request;
        }

        if (!TextUtils.isEmpty(prefManager.getToken())
            && System.currentTimeMillis() - prefManager.getLastAccessTokenRefreshTime() < 10000
        ) {
          // Token is valid within the last 10 seconds
          return response.request().newBuilder()
              .header(MifosInterceptor.HEADER_AUTH, prefManager.getToken())
              .build();
        }

        try {
          OAuthTokenResponse tokenResponse = oAuthService.refreshOAuthTokenV1(
              new HashMap<String, String>() {{
                put("refresh_token", prefManager.getOauthData().getRefreshToken());
              }}
          ).toBlocking().first();

          prefManager.setToken(String.format(
              "%s %s",
              tokenResponse.getTokenType(),
              tokenResponse.getAccessToken()
          ));
          prefManager.setOauthData(tokenResponse);

          request = response.request().newBuilder()
              .header(MifosInterceptor.HEADER_AUTH, prefManager.getToken())
              .build();
        } catch (Exception e) {
          return null;
        }
      }
    }

    return request;
  }
}
