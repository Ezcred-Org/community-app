package com.mifos.objects.appuser;

import lombok.Data;

@Data
public class AppUser {
  // NOTE: username is phone number with country code
  private final String username;
  private final String firstname;
  private final String lastname;
  private final String email;
  private int officeId;
  private int[] roles;
  private final boolean sendPasswordToEmail;
  private final boolean isSelfServiceUser;
  private final String password;
  private final String repeatPassword;
  private final String deviceId;
  private final String[] imeis;
}