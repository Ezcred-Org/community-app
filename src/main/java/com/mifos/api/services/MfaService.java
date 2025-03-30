package com.mifos.api.services;

import com.mifos.objects.mfa.ValidateMfaOtpResponse;
import com.mifos.objects.oauth.OAuthTokenResponse;

import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface MfaService {


  @POST("twofactor?deliveryMethod=sms")
  Observable<OAuthTokenResponse> sendMfaOtp(
          @Header("Authorization") String accessToken
  );

  @POST("twofactor/validate")
  Observable<ValidateMfaOtpResponse> validateMfaOtp(
          @Header("Authorization") String accessToken,
          @Query("token") String otp
  );
}
