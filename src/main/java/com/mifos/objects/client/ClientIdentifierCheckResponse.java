package com.mifos.objects.client;

import lombok.Data;

@Data
public class ClientIdentifierCheckResponse {

  private final boolean success;
  private final long clientId;

  private final String userMessage;
  private final boolean updatePan;
  private final boolean updatePhoneNumber;
}
