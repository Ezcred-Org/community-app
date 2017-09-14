package com.mifos.api.services;


import lombok.Data;

@Data
public class UserUpdateToken {
  private String firstname;
  private String password;
  private String repeatPassword;

}
