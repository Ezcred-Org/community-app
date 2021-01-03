/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import android.util.Base64;
import com.mifos.utils.PrefManager;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * @author fomenkoo
 */
public class MifosInterceptor implements Interceptor {

    public static final String HEADER_TENANT = "Fineract-Platform-TenantId";
    public static final String HEADER_AUTH = "Authorization";
    public static final String DATA_SECURITY_HEADER = "X-Data-Security";
    public static final String CLIENT_LOAN_HEADER = "X-Client-Loan";
    public static final String APP_VERSION_HEADER = "X-App-Version";
    public static final String GEO_LOCATION_HEADER = "X-Geo-Location";
    public static final String POS_HEADER = "X-PoS";

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
        builder.header(APP_VERSION_HEADER,  prefManager.getEzcredLastAppVersionName());
        if (clientId != -1 || loanId != -1) {
            builder.header(CLIENT_LOAN_HEADER, clientId + "-" + loanId);
        }

        PrefManager.GeoLocation geoLocation = prefManager.getGeoLocation();
        if (geoLocation != null) {
            builder.header(GEO_LOCATION_HEADER,
              geoLocation.getLatitude() + ","
                + geoLocation.getLongitude() + ","
                + geoLocation.getTimestamp() + ","
                + geoLocation.getAccuracy()
            );
        }

        if (prefManager.getUser() != null) {
            builder.header(POS_HEADER,
              prefManager.getUser().getUserId() + ","
                + prefManager.getUser().getOfficeId());
        }

        if (!TextUtils.isEmpty(prefManager.getTenant())) {
            builder.header(HEADER_TENANT, prefManager.getTenant());
        }
        if (!TextUtils.isEmpty(prefManager.getToken())) {
            builder.header(HEADER_AUTH, prefManager.getToken());
        }

        String encryptedBodyString = encryptRequestBody(chianrequest.body());
        if (!TextUtils.isEmpty(encryptedBodyString)) {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody requestBody = RequestBody.create(mediaType, encryptedBodyString);
            builder.method(chianrequest.method(), requestBody);
            builder.header(DATA_SECURITY_HEADER, "true");
            if (requestBody.contentType() != null) {
                builder.header("Content-Type", requestBody.contentType().toString());
            }
        }

        Request request = builder.build();
        return chain.proceed(request);
    }

    private String encryptRequestBody(RequestBody requestBody) throws IOException {
        String encryptedBodyString = null;
        if (requestBody != null) {
            final Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            String oldBodyString = buffer.readUtf8();

            encryptedBodyString = Base64.encodeToString(oldBodyString.getBytes(), Base64.NO_WRAP);
        }

        return encryptedBodyString;
    }
}
