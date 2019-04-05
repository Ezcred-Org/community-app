package com.mifos.objects.client;

import lombok.Data;

@Data
public class ClientIdentifierCheckResponse {

  private final boolean success;
  private final Long clientId;
  private final String userMessage;

  private final boolean allowUpdatePan;
  private final boolean allowUpdatePhoneNumber;
}
