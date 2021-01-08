/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.mifos.utils.AESUtil;
import com.mifos.utils.PrefManager;
import java.io.IOException;
import java.security.GeneralSecurityException;
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
    public static final String HEADER_MULTIPART_FORM_DATA= "multipart/form-data";
    public static final String HEADER_FORM_URLENCODED = "application/x-www-form-urlencoded";


    private final PrefManager prefManager;
    private final SharedPreferences sharedPreferences;
    private final boolean encryptRequestBody;
    private final String dataEncryptionAlgorithm;
    private final String dataEncryptionSecretKey;

    public MifosInterceptor(
        PrefManager prefManager,
        SharedPreferences sharedPreferences,
        boolean encryptRequestBody,
        String dataEncryptionAlgorithm,
        String dataEncryptionSecretKey
    ) {
        this.prefManager = prefManager;
        this.sharedPreferences = sharedPreferences;
        this.encryptRequestBody = encryptRequestBody;
        this.dataEncryptionAlgorithm = dataEncryptionAlgorithm;
        this.dataEncryptionSecretKey = dataEncryptionSecretKey;
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

        encryptRequestBodyIfNeeded(chianrequest.body(), builder, chianrequest.method());

        Request request = builder.build();
        Response response = chain.proceed(request);
        return decryptResponseIfNeeded(response);
    }

    private void encryptRequestBodyIfNeeded(RequestBody requestBody, Builder builder, String method)
        throws IOException {
        if (encryptRequestBody) {
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null
                    && mediaType.toString().toLowerCase().contains(HEADER_MULTIPART_FORM_DATA)
                ) {
                    return;
                }
                builder.header(DATA_SECURITY_HEADER, "true");
                builder.header(CONTENT_TYPE_HEADER, HEADER_TEXT_PLAIN);
                final Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                String oldBodyString = buffer.readUtf8();

                String encryptedBodyString;
                try {
                    encryptedBodyString = AESUtil.encrypt(
                        oldBodyString, dataEncryptionAlgorithm, dataEncryptionSecretKey
                    );
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }

                if (!TextUtils.isEmpty(encryptedBodyString)) {
                    RequestBody encryptedRequestBody = RequestBody.create(
                        MediaType.parse(HEADER_TEXT_PLAIN),
                        encryptedBodyString
                    );
                    builder.method(method, encryptedRequestBody);
                    builder.header(CONTENT_TYPE_HEADER, HEADER_TEXT_PLAIN);
                }
            } else {
                builder.header(DATA_SECURITY_HEADER, "true");
                builder.header(CONTENT_TYPE_HEADER, HEADER_TEXT_PLAIN);
            }
        }
    }

    private Response decryptResponseIfNeeded(Response response) throws IOException {
        Response newResponse = response;
        if (response != null && response.isSuccessful()) {
            String contentType = response.header(CONTENT_TYPE_HEADER);
            boolean decrypt = Boolean.parseBoolean(response.header(DATA_SECURITY_HEADER));
            if (decrypt) {
                Response.Builder newResponseBuilder = response.newBuilder();
                if (TextUtils.isEmpty(contentType)) {
                    contentType = HEADER_APPLICATION_JSON;
                }

                String responseString = null;
                if (response.body() != null) {
                    responseString = response.body().string();
                }

                if (!TextUtils.isEmpty(responseString)) {
                    try {
                        String decryptedString = AESUtil.decrypt(
                            responseString, dataEncryptionAlgorithm, dataEncryptionSecretKey
                        );
                        newResponseBuilder.body(ResponseBody.create(
                            MediaType.parse(contentType), decryptedString
                        ));
                        newResponse = newResponseBuilder.build();
                    } catch (GeneralSecurityException e) {
                        throw new IOException(e);
                    }
                }
            }
        }
        return newResponse;
    }
}
