package com.mifos.objects;

import lombok.Data;

@Data
public class ApiErrorResponse {
  private final String developerMessage;
  private final String defaultUserMessage;
  private final String userMessageGlobalisationCode;
  private final String[] errors;
  private final int httpStatusCode;
}
