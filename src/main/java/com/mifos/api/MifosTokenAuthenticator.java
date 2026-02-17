package com.mifos.api;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.mifos.api.services.OAuthService;
import com.mifos.objects.oauth.OAuthTokenResponse;
import com.mifos.utils.PrefManager;

import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

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

  // Only one thread can refresh token at a time, others wait
  private static final Semaphore refreshSemaphore = new Semaphore(1);

  public MifosTokenAuthenticator(PrefManager prefManager, OAuthService oAuthService) {
    this.prefManager = prefManager;
    this.oAuthService = oAuthService;
  }

  @Nullable
  @Override
  public Request authenticate(Route route, Response response) {
    // Avoid infinite loop - don't retry auth for the refresh token API itself
    String url = response.request().url().toString();
    if (url.endsWith("api/auth/refresh")) {
      return null;
    }

    if (prefManager == null || oAuthService == null || prefManager.getOauthData() == null) {
      return null;
    }

    try {
      // Wait up to 10 seconds to acquire the semaphore
      if (!refreshSemaphore.tryAcquire(10, TimeUnit.SECONDS)) {
        return null;
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return null;
    }

    try {

      OAuthTokenResponse oauthData = prefManager.getOauthData();
      if (oauthData == null || TextUtils.isEmpty(oauthData.getRefreshToken())) {
        return null;
      }

      // Check if token was already refreshed by previous thread
      if (!TextUtils.isEmpty(prefManager.getToken())
          && System.currentTimeMillis() - prefManager.getLastAccessTokenRefreshTime() < 60000
      ) {
        return response.request().newBuilder()
            .header(MifosInterceptor.HEADER_AUTH, prefManager.getToken())
            .build();
      }

      OAuthTokenResponse tokenResponse = oAuthService.refreshOAuthTokenV2(
          new HashMap<String, String>() {{
            put("refresh_token", oauthData.getRefreshToken());
          }}
      ).toBlocking().first();

      String newToken = String.format(
          "%s %s",
          tokenResponse.getTokenType(),
          tokenResponse.getAccessToken()
      );
      prefManager.setToken(newToken);
      prefManager.setOauthData(tokenResponse);

      return response.request().newBuilder()
          .header(MifosInterceptor.HEADER_AUTH, newToken)
          .build();
    } catch (Exception e) {
      return null;
    } finally {
      refreshSemaphore.release();
    }
  }
}
