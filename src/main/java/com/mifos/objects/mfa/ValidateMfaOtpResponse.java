/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.mfa;


import lombok.Data;

/**
 {
 "token": "ckldfjoeirfoorjfoer",
 "validFrom": 1743348252053,
 "validTo": 1743434652053
 }
 *  */
@Data
public class ValidateMfaOtpResponse {

  private final String status;
  private final String token;
  private final long validFrom;
  private final long validTo;
  private final String errorMessage;
}
