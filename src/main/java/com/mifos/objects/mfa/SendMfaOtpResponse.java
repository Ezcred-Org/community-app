/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.mfa;


import lombok.Data;

/**
 * * {
 *  *     "tokenLiveTimeInSec": 0,
 *  *     "extendedAccessToken": false,
 *  *     "status": "SUCCESS",
 *  *     "displayMessage": "Please enter OTP sent on XXXXXXXXXX634"
 *  * } */
@Data
public class SendMfaOtpResponse {

  private final String status;
  private final long tokenLiveTimeInSec;
  private final boolean extendedAccessToken;
  private final String displayMessage;
}
