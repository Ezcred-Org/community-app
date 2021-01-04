package com.mifos.api;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mifos.utils.PrefManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import timber.log.Timber;

/**
 * Created by Rajan Maurya on 16/06/16.
 */
public class MifosOkHttpClient {

  public OkHttpClient.Builder getMifosOkHttpClientBuilder(
      PrefManager prefManager,
      SharedPreferences loanScopeSharedPref,
      MifosTokenAuthenticator mifosTokenAuthenticator,
      boolean encryptRequestBody
  ) {

    OkHttpClient.Builder builder = new OkHttpClient.Builder();

    //Setting Timeout 50 Seconds
    builder.connectTimeout(50, TimeUnit.SECONDS);
    builder.readTimeout(50, TimeUnit.SECONDS);
    builder.retryOnConnectionFailure(true);

    if (mifosTokenAuthenticator != null) {
      builder.authenticator(mifosTokenAuthenticator);
    }

    builder.addInterceptor(new MifosInterceptor(
        prefManager, loanScopeSharedPref, encryptRequestBody
    ));

    //Enable Full Body Logging
    HttpLoggingInterceptor logger = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
      @Override
      public void log(@NonNull String s) {
        Timber.d(s);
      }
    });

    logger.setLevel(Level.BODY);
    //Interceptor :> Full Body Logger and ApiRequest Header
    builder.addInterceptor(logger);
    builder.addNetworkInterceptor(new StethoInterceptor());

    return builder;

  }
}
