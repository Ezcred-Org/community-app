package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.oauth.GrantType;
import com.mifos.objects.oauth.OAuthTokenResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface OAuthService {

  @FormUrlEncoded
  @POST(APIEndPoint.TOKEN)
  Observable<OAuthTokenResponse> fetchOAuthToken(
      @Field("username") String userName,
      @Field("password") String password,
      @Field("client_id") String clientId,
      @Field("client_secret") String clientSecret,
      @Field("grant_type") GrantType grantType
  );

  @FormUrlEncoded
  @POST(APIEndPoint.TOKEN)
  Observable<OAuthTokenResponse> refreshOAuthToken(
      @Field("refresh_token") String refreshToken,
      @Field("client_id") String clientId,
      @Field("client_secret") String clientSecret,
      @Field("grant_type") GrantType grantType
  );

  @FormUrlEncoded
  @POST(APIEndPoint.TOKEN)
  Observable<Void> logout(@Field("access_token") String accessToken);
}
