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
import okhttp3.ResponseBody;
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
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String POS_HEADER = "X-PoS";
    public static final String HEADER_APPLICATION_JSON = "application/json";
    public static final String HEADER_TEXT_PLAIN = "text/plain";



    private final PrefManager prefManager;
    private final SharedPreferences sharedPreferences;
    private final boolean encryptRequestBody;
    private final boolean decryptResponseBody;

    public MifosInterceptor(
        PrefManager prefManager,
        SharedPreferences sharedPreferences,
        boolean encryptRequestBody,
        boolean decryptResponseBody
    ) {
        this.prefManager = prefManager;
        this.sharedPreferences = sharedPreferences;
        this.encryptRequestBody = encryptRequestBody;
        this.decryptResponseBody = decryptResponseBody;
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

        if (encryptRequestBody) {
            String encryptedBodyString = encryptRequestBody(chianrequest.body());
            if (!TextUtils.isEmpty(encryptedBodyString)) {
                MediaType mediaType = MediaType.parse(HEADER_TEXT_PLAIN);
                RequestBody requestBody = RequestBody.create(mediaType, encryptedBodyString);
                builder.method(chianrequest.method(), requestBody);
                builder.header(DATA_SECURITY_HEADER, "true");
                if (requestBody.contentType() != null) {
                    builder.header(CONTENT_TYPE_HEADER, requestBody.contentType().toString());
                }
            }
        }

        Request request = builder.build();
        Response response = chain.proceed(request);

        if (decryptResponseBody) {
            response = decryptResponse(response);
        }
        return response;
    }

    private String encryptRequestBody(RequestBody requestBody) throws IOException {
        String encryptedBodyString = null;
        if (requestBody != null) {
            MediaType mediaType = requestBody.contentType();
            if (mediaType != null
                && mediaType.toString().toLowerCase().contains("multipart/form-data")
            ) {
                return null;
            }
            final Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            String oldBodyString = buffer.readUtf8();

            encryptedBodyString = Base64.encodeToString(oldBodyString.getBytes(), Base64.NO_WRAP);
        }

        return encryptedBodyString;
    }

    private Response decryptResponse(Response response) {
        Response newResponse = response;
        if (response != null && response.isSuccessful()) {
            Response.Builder newResponseBuilder = response.newBuilder();
            String contentType = response.header(CONTENT_TYPE_HEADER);
            if (TextUtils.isEmpty(contentType)) {
                contentType = HEADER_APPLICATION_JSON;
            }
            String responseString = null;
            if (response.body() != null) {
                responseString = response.body().toString();
            }

            if (!TextUtils.isEmpty(responseString)) {
                byte[] decryptedBytes = Base64.decode(responseString, Base64.NO_WRAP);
                String decryptedString = new String(decryptedBytes);
                newResponseBuilder.body(ResponseBody.create(
                    MediaType.parse(contentType), decryptedString)
                );

                newResponse = newResponseBuilder.build();
            }
        }
        return newResponse;
    }
}
