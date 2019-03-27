package com.mifos.objects.appuser;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

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
  private final Target target;


  // OtpData for Mobile auth otp:
  private OtpData otpData;
  private String password;
  private String repeatPassword;
  private Double lat;
  private Double lng;

  public AppUser(String mobile, String deviceId, String[] imeis, Target target) {
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
    String[] imeis, String firstname,
    String lastname, String email,
    Target target
  ) {
    this.mobile = mobile;
    this.username = mobile;
    this.firstname = TextUtils.isEmpty(firstname) ? mobile : firstname;
    this.lastname = TextUtils.isEmpty(lastname) ? mobile : lastname;
    this.email = email;
    this.sendPasswordToEmail = false;
    this.isSelfServiceUser = true;
    this.deviceId = deviceId;
    this.imeis = imeis;
    this.target = target;
  }

  @Data
  public static class OtpData {
    private final Long otpId;
    private final String otp;
    private final Mode mode;
  }
  
  public enum Mode {
    OTP_SMS,
    OUTBOUND_CALL,
    GOOGLE_AUTH,
    PARTNER_AUTH
  }

  @Data
  public static class EzCredAuthData {
    private final String partnerId;
    private final String data;
  }

  public enum Target {

    @SerializedName("consumer")
    CONSUMER,

    @SerializedName("agent")
    AGENT,

    @SerializedName("retailer")
    RETAILER;

    public static Target getTargetFromFlavor(String flavor) {
      switch (flavor) {
        case "dealer":
          return Target.RETAILER;
        case "agent":
          return Target.AGENT;
        case "consumer":
          return Target.CONSUMER;
      }
      return null;
    }
  }
}
