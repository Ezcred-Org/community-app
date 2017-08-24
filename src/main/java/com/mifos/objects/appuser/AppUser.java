package com.mifos.objects.appuser;

import lombok.Data;

@Data
public class AppUser {
  public final String username;
  public final String firstname;
  public final String lastname;
  public final String email;
  public int officeId;
  public int[] roles;
  public final boolean sendPasswordToEmail;
  public final boolean isSelfServiceUser;
  public final String password;
  public final String repeatPassword;
  public final String phoneNumber;
  public final String deviceId;
}
