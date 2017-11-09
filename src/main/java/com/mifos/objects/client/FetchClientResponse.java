package com.mifos.objects.client;

import lombok.Data;

@Data
public class FetchClientResponse {

  private final boolean ekycRequired;
  private final long clientId;
}
