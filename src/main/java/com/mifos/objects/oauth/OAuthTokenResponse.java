/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.oauth;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * { "access_token": "a0f50984-9f99-4ac2-b447-2c4946cf6146", "token_type": "bearer",
 * "refresh_token": "e515c262-a416-49a5-a0b6-6f14af9b53e2", "expires_in": 3599, "scope": "all" }
 */
@Data
public class OAuthTokenResponse {

  public static final String ACCESS_TOKEN = "access_token";
  public static final String REFRESH_TOKEN = "refresh_token";
  public static final String TOKEN_TYPE = "token_type";
  public static final String EXPIRES_IN = "expires_in";
  public static final String SCOPE = "scope";
  public static final String ENCODED_CREDENTIALS = "encoded_credentials";

  @SerializedName(ACCESS_TOKEN)
  private final String accessToken;

  @SerializedName(REFRESH_TOKEN)
  private final String refreshToken;

  @SerializedName(TOKEN_TYPE)
  private final String tokenType;

  @SerializedName(EXPIRES_IN)
  private final long expiresIn;

  @SerializedName(SCOPE)
  private final String scope;

  @SerializedName(ENCODED_CREDENTIALS)
  private final String encodedCredentials;
}
