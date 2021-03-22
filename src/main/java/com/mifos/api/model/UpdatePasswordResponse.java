/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api.model;

import lombok.Data;

@Data
public class UpdatePasswordResponse {

  private final Long officeId;
  private final Long resourceId;
  private final UpdatePasswordChanges changes;

  @Data
  public static class UpdatePasswordChanges {

    private final String passwordEncoded;
  }
}
