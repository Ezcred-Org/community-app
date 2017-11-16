package com.mifos.objects.appuser;

import lombok.Data;

@Data
public class AppUser {
  // NOTE: username is mobile number without country code
  private final String mobile;
  private final String username;
  private final String firstname;
  private final String lastname;
  private final String email;
  private final boolean sendPasswordToEmail;
  private final boolean isSelfServiceUser;
  private final String password;
  private final String repeatPassword;
  private final String deviceId;
  private final String[] imeis;

  private Double lat;
  private Double lng;
}
