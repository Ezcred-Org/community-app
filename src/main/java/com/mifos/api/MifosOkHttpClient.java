package com.mifos.api;

import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mifos.utils.PrefManager;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import timber.log.Timber;

/**
 * Created by Rajan Maurya on 16/06/16.
 */
public class MifosOkHttpClient {


    public OkHttpClient getMifosOkHttpClient(PrefManager prefManager) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(
                                X509Certificate[] chain,
                                String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(
                                X509Certificate[] chain,
                                String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            // Install the all-trusting trust manager
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            //Set SSL certificate to OkHttpClient Builder

            builder.sslSocketFactory(sslSocketFactory);

            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Setting Timeout 30 Seconds
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);


        builder.addInterceptor(new MifosInterceptor(prefManager));

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

        return builder.build();

    }
}
