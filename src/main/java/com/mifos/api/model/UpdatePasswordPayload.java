package com.mifos.api.model;


import lombok.Data;

@Data
public class UpdatePasswordPayload {
  private String password;
  private String repeatPassword;
}
