package com.mifos.api.model;

import lombok.Data;

@Data
public class UpdatePasswordPayload {
  private final String password;
  private final String repeatPassword;
}
