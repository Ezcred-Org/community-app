package com.mifos.api;

import android.support.annotation.Nullable;
import com.mifos.api.services.OAuthService;
import com.mifos.utils.PrefManager;
import java.io.IOException;
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
  public Request authenticate(Route route, Response response) throws IOException {
    Request request = null;
    if (prefManager != null && oAuthService != null) {
      synchronized (this) {
        prefManager.setToken("");

        return null;

      }
    } else {
      return null;
    }
  }

}
