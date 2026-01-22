package com.mifos.api;

import android.text.TextUtils;
import android.util.Log;

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
      Log.d("MifosTokenAuth", "Skipping auth for refresh token API - Thread: " + Thread.currentThread().getName());
      return null;
    }

    if (prefManager == null || oAuthService == null || prefManager.getOauthData() == null) {
      return null;
    }

    try {
      // Wait up to 10 seconds to acquire the semaphore
      if (!refreshSemaphore.tryAcquire(10, TimeUnit.SECONDS)) {
        Log.d("MifosTokenAuth", "Timeout waiting for semaphore - Thread: " + Thread.currentThread().getName());
        return null;
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return null;
    }

    try {
      Log.d("MifosTokenAuth", "Acquired semaphore - Thread: " + Thread.currentThread().getName());

      OAuthTokenResponse oauthData = prefManager.getOauthData();
      if (oauthData == null || TextUtils.isEmpty(oauthData.getRefreshToken())) {
        return null;
      }

      // Check if token was already refreshed by previous thread
      if (!TextUtils.isEmpty(prefManager.getToken())
          && System.currentTimeMillis() - prefManager.getLastAccessTokenRefreshTime() < 10000
      ) {
        Log.d("MifosTokenAuth", "Using recently refreshed token - Thread: " + Thread.currentThread().getName());
        return response.request().newBuilder()
            .header(MifosInterceptor.HEADER_AUTH, prefManager.getToken())
            .build();
      }

      Log.d("MifosTokenAuth", "CALLING refreshOAuthTokenV1 - Thread: " + Thread.currentThread().getName());
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
      Log.d("MifosTokenAuth", "Token refreshed successfully - Thread: " + Thread.currentThread().getName());

      return response.request().newBuilder()
          .header(MifosInterceptor.HEADER_AUTH, newToken)
          .build();
    } catch (Exception e) {
      Log.d("MifosTokenAuth", "Token refresh failed - Thread: " + Thread.currentThread().getName());
      return null;
    } finally {
      refreshSemaphore.release();
      Log.d("MifosTokenAuth", "Released semaphore - Thread: " + Thread.currentThread().getName());
    }
  }
}
