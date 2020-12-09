package com.mifos.api;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mifos.api.services.OAuthService;
import com.mifos.objects.oauth.OAuthTokenResponse;
import com.mifos.utils.PrefManager;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import rx.Subscriber;

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
        prefManager.setToken("");
        oAuthService.refreshOAuthToken(
            prefManager.getOauthData().getRefreshToken(),
            "community-app",
            "123",
            "refresh_token"
        )
            .subscribe(new Subscriber<OAuthTokenResponse>() {
              @Override
              public void onCompleted() {

              }

              @Override
              public void onError(Throwable e) {

              }

              @Override
              public void onNext(OAuthTokenResponse oAuthTokenResponse) {
                prefManager.setToken(String.format(
                    "%s %s",
                    oAuthTokenResponse.getTokenType(),
                    oAuthTokenResponse.getAccessToken()
                ));

                prefManager.setOauthData(oAuthTokenResponse);
              }
            });

        if (!TextUtils.isEmpty(prefManager.getToken())) {
          request = response.request().newBuilder()
              .header(MifosInterceptor.HEADER_AUTH, prefManager.getToken())
              .build();
        }
      }
    }

    return request;
  }
}
