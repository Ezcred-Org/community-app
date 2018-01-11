/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api;

import android.content.SharedPreferences;
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
    public static final String CLIENT_LOAN_HEADER = "X-Client-Loan";
    public static final String APP_VERSION_HEADER = "X-App-Version";


    private final PrefManager prefManager;
    private final SharedPreferences sharedPreferences;

    public MifosInterceptor(PrefManager prefManager, SharedPreferences sharedPreferences) {
        this.prefManager = prefManager;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request chianrequest = chain.request();
        Builder builder = chianrequest.newBuilder();
        long clientId = sharedPreferences.getLong("CLIENT_ID", -1);
        long loanId = sharedPreferences.getLong("LOAN_ID", -1);
        builder.header(APP_VERSION_HEADER,  String.valueOf(prefManager.getEzcredLastAppVersionName()));
        if (clientId != -1 || loanId != -1) {
            builder.header(CLIENT_LOAN_HEADER, clientId + "-" + loanId);
        }

        if (!TextUtils.isEmpty(prefManager.getTenant())) {
            builder.header(HEADER_TENANT, prefManager.getTenant());
        }
        if (!TextUtils.isEmpty(prefManager.getToken())) {
            builder.header(HEADER_AUTH, prefManager.getToken());
        }

        Request request = builder.build();
        return chain.proceed(request);
    }
}
