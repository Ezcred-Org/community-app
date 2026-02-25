package com.mifos.objects;

import com.google.gson.annotations.SerializedName;

import com.mifos.objects.mifoserror.Errors;
import java.util.List;
import lombok.Data;

@Data
public class ApiErrorResponse {
  @SerializedName(value = "developerMessage", alternate = {"exception"})
  private final String developerMessage;

  @SerializedName(value = "defaultUserMessage", alternate = {"message"})
  private final String defaultUserMessage;

  @SerializedName(value = "userMessageGlobalisationCode", alternate = {"data"})
  private final String userMessageGlobalisationCode;

  private final List<Errors> errors;

  @SerializedName(value = "httpStatusCode", alternate = {"status"})
  private final Object httpStatusCode;

  @SerializedName(value = "errorHash")
  private final String errorHash;

  @SerializedName(value = "error")
  private final ErrorDetail error;

  @Data
  public static class ErrorDetail {
    @SerializedName(value = "message")
    private final String message;

    @SerializedName(value = "errorCode")
    private final String errorCode;
  }
}
