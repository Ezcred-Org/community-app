package com.mifos.objects.appuser;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class AppUser {

  private final String username;

  private final String firstname;

  private final String lastname;

  private final String email;

  private Long officeId;

  private Long staffId;

  private List<Long> roles;

  private final Boolean sendPasswordToEmail;

  private final Boolean isSelfServiceUser;

  private Boolean enabled;

  private String password;

  private String repeatPassword;

  private final String mobile;

  private List<Long> clients;

  /**
   * ezcred related params. 1. List of imei's. 2. Android phone device id.
   */

  private final List<String> imeis;

  private final String deviceId;

  private Double lat;

  private Double lng;

  private AuthData authData;

  public AppUser(String mobile, String deviceId, List<String> imeis, Target target) {
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
      List<String> imeis, String firstname,
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
  public static class AuthData {

    private final String dataId;
    private final String data;
    private final Mode mode;

    public enum Mode {
      FIREBASE,
      OTP_SMS,
      OUTBOUND_CALL,
      GOOGLE_AUTH,
      PARTNER_AUTH
    }
  }

  // To identify whether request came from agent, dealer, or consumer app
  private final Target target;

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