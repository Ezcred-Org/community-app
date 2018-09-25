package com.mifos.objects.appuser;

import android.text.TextUtils;

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
  private final String deviceId;
  private final String[] imeis;
  private final String target;


  // Firebase auth token: https://firebase.google.com/docs/auth/admin/create-custom-tokens
  private String token;
  private String password;
  private String repeatPassword;
  private Double lat;
  private Double lng;

  public AppUser(String mobile, String deviceId, String[] imeis, String target) {
    this.mobile = mobile;
    this.username = mobile;
    this.firstname = mobile;
    this.lastname = mobile;
    this.email = null;
    this.sendPasswordToEmail = false;
    this.isSelfServiceUser = true;
    this.deviceId = deviceId;
    this.imeis = imeis;
    this.target = target;
  }

  public AppUser(
    String mobile, String deviceId,
    String [] imeis, String firstname,
    String lastname, String email,
    String target
  ) {
    this.mobile = mobile;
    this.username = mobile;
    this.firstname = TextUtils.isEmpty(firstname) ?  mobile : firstname;
    this.lastname = TextUtils.isEmpty(lastname) ?  mobile : lastname;
    this.email = email;
    this.sendPasswordToEmail = false;
    this.isSelfServiceUser = true;
    this.deviceId = deviceId;
    this.imeis = imeis;
    this.target = target;
  }
}
