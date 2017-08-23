package com.mifos.objects.user;

import lombok.Data;

@Data
public class CreateUserRequest {
  public final String username;
  public final String firstname;
  public final String lastname;
  public final String email;
  public final int officeId;
  public final int[] roles;
  public final boolean sendPasswordToEmail;
  public final boolean isSelfServiceUser;
  public final String password;
  public final String repeatPassword;

}
