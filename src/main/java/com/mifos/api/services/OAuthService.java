package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.oauth.OAuthTokenResponse;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface OAuthService {

  @POST(APIEndPoint.TOKEN)
  Observable<OAuthTokenResponse> fetchOAuthToken(
      @Query("username") String userName,
      @Query("password") String password,
      @Query("client_id") String clientId,
      @Query("client_secret") String clientSecret,
      @Query("grant_type") String grantType
  );

  @POST(APIEndPoint.TOKEN)
  Observable<OAuthTokenResponse> refreshOAuthToken(
      @Query("refresh_token") String refreshToken,
      @Query("client_id") String clientId,
      @Query("client_secret") String clientSecret,
      @Query("grant_type") String grantType
  );
}
