/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api;

import java.util.Map;

import lombok.Data;

@Data
public class GenericResponse {
    private Long commandId;
    private Long officeId;
    private Long groupId;
    private Long clientId;
    private Long loanId;
    private Long savingsId;
    private Long resourceId;
    private Long subResourceId;
    private String transactionId;
    private String resourceIdentifier;
    private Map<String, Object> changes;
}
