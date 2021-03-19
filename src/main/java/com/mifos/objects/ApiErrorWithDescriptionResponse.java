package com.mifos.objects;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ApiErrorWithDescriptionResponse {

  @SerializedName("error")
  private final String error;

  @SerializedName("error_description")
  private final String errorDescription;
}
