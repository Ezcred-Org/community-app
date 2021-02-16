/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginData {

  public static final String USERNAME = "username";
  public static final String PASSWORD = "password";

  @SerializedName(USERNAME)
  private final String username;

  @SerializedName(PASSWORD)
  private final String password;
}
