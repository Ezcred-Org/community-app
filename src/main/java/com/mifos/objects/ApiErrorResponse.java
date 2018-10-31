package com.mifos.objects;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ApiErrorResponse {
  @SerializedName(value = "developerMessage", alternate = {"exception"})
  private final String developerMessage;
  private final String defaultUserMessage;
  private final String userMessageGlobalisationCode;
  private final Object[] errors;

  @SerializedName(value = "httpStatusCode", alternate = {"status"})
  private final Integer httpStatusCode;
}
