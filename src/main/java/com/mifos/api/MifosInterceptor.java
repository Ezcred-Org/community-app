/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.mifos.utils.PrefManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/**
 * @author fomenkoo
 */
public class MifosInterceptor implements Interceptor {

    public static final String HEADER_TENANT = "Fineract-Platform-TenantId";
    public static final String HEADER_AUTH = "Authorization";
    public static final String X_EZCRED_SECRET_KEY = "x-ezcred-secret-key";
    public static final String X_REQUEST_TIME = "x-request-time";

    private final PrefManager prefManager;

    public MifosInterceptor(PrefManager prefManager) {
        this.prefManager = prefManager;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request chianrequest = chain.request();
        Builder builder = chianrequest.newBuilder();
        if (!TextUtils.isEmpty(prefManager.getTenant())) {
            builder.header(HEADER_TENANT, prefManager.getTenant());
        }
        if (!TextUtils.isEmpty(prefManager.getToken())) {
            builder.header(HEADER_AUTH, prefManager.getToken());
        }

        if (!TextUtils.isEmpty(prefManager.getEzcredSecretKey())) {
            builder.header(X_EZCRED_SECRET_KEY, prefManager.getEzcredSecretKey());
        }

        builder.header(X_REQUEST_TIME, String.valueOf(System.currentTimeMillis()));

        Request request = builder.build();
        return chain.proceed(request);
    }
}
