package com.mifos.objects.client;

import android.os.Parcel;
import android.os.Parcelable;

import com.mifos.objects.templates.clients.Options;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Rajan Maurya on 15/12/16.
 */

public class Address implements Parcelable {
  public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
    @Override
    public Address createFromParcel(Parcel source) {
      return new Address(source);
    }

    @Override
    public Address[] newArray(int size) {
      return new Address[size];
    }
  };

  private Long client_id;
  private String addressType;
  private Long addressId;
  private Long addressTypeId;
  private Boolean isActive;
  private String street;
  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private String townVillage;
  private String city;
  private String countyDistrict;
  private Long stateProvinceId;
  private Long addressOwnershipTypeId;
  private String countryName;
  private String stateName;
  private Long countryId;
  private String postalCode;
  private String monthlyRent;
  private String yearsAtAddress;
  private String monthsAtAddress;
  private String yearsAtCity;
  private String monthsAtCity;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private String createdBy;
  private Date createdOn;
  private String updatedBy;
  private Date updatedOn;
  private List<Options> countryIdOptions;
  private List<Options> stateProvinceIdOptions;
  private List<Options> addressTypeIdOptions;
  private List<Options> addressOwnershipTypeIdOptions;
  private final String locale = "en";

  public Address() {
  }

  protected Address(Parcel in) {
    this.addressType = (String) in.readValue(String.class.getClassLoader());
    this.addressId = (Long) in.readValue(Long.class.getClassLoader());
    this.addressTypeId = (Long) in.readValue(Long.class.getClassLoader());
    this.isActive = (Boolean) in.readValue(Boolean.class.getClassLoader());
    this.street = (String) in.readValue(String.class.getClassLoader());
    this.addressLine1 = (String) in.readValue(String.class.getClassLoader());
    this.addressLine2 = (String) in.readValue(String.class.getClassLoader());
    this.addressLine3 = (String) in.readValue(String.class.getClassLoader());
    this.townVillage = (String) in.readValue(String.class.getClassLoader());
    this.city = (String) in.readValue(String.class.getClassLoader());
    this.countyDistrict = (String) in.readValue(String.class.getClassLoader());
    this.stateProvinceId = (Long) in.readValue(Long.class.getClassLoader());
    this.addressOwnershipTypeId = (Long) in.readValue(Long.class.getClassLoader());
    this.countryName = (String) in.readValue(String.class.getClassLoader());
    this.stateName = (String) in.readValue(String.class.getClassLoader());
    this.countryId = (Long) in.readValue(Long.class.getClassLoader());
    this.postalCode = (String) in.readValue(String.class.getClassLoader());
    this.monthlyRent = (String) in.readValue(String.class.getClassLoader());
    this.yearsAtAddress = (String) in.readValue(String.class.getClassLoader());
    this.monthsAtAddress = (String) in.readValue(String.class.getClassLoader());
    this.yearsAtCity = (String) in.readValue(String.class.getClassLoader());
    this.monthsAtCity = (String) in.readValue(String.class.getClassLoader());
    this.latitude = (BigDecimal) in.readValue(BigDecimal.class.getClassLoader());
    this.longitude = (BigDecimal) in.readValue(BigDecimal.class.getClassLoader());
    this.createdBy = (String) in.readValue(String.class.getClassLoader());
    this.createdOn = (Date) in.readValue(Date.class.getClassLoader());
    this.updatedBy = (String) in.readValue(String.class.getClassLoader());
    this.updatedOn = (Date) in.readValue(Date.class.getClassLoader());
    this.countryIdOptions = in.createTypedArrayList(Options.CREATOR);
    this.stateProvinceIdOptions = in.createTypedArrayList(Options.CREATOR);
    this.addressTypeIdOptions = in.createTypedArrayList(Options.CREATOR);
    this.addressOwnershipTypeIdOptions = in.createTypedArrayList(Options.CREATOR);
  }

  public Long getClient_id() {
    return client_id;
  }

  public void setClient_id(Long client_id) {
    this.client_id = client_id;
  }

  public String getAddressType() {
    return addressType;
  }

  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public Long getAddressTypeId() {
    return addressTypeId;
  }

  public void setAddressTypeId(Long addressTypeId) {
    this.addressTypeId = addressTypeId;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getAddressLine3() {
    return addressLine3;
  }

  public void setAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
  }

  public String getTownVillage() {
    return townVillage;
  }

  public void setTownVillage(String townVillage) {
    this.townVillage = townVillage;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountyDistrict() {
    return countyDistrict;
  }

  public void setCountyDistrict(String countyDistrict) {
    this.countyDistrict = countyDistrict;
  }

  public Long getStateProvinceId() {
    return stateProvinceId;
  }

  public void setStateProvinceId(Long stateProvinceId) {
    this.stateProvinceId = stateProvinceId;
  }

  public Long getAddressOwnershipTypeId() {
    return addressOwnershipTypeId;
  }

  public void setAddressOwnershipTypeId(Long addressOwnershipTypeId) {
    this.addressOwnershipTypeId = addressOwnershipTypeId;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public Long getCountryId() {
    return countryId;
  }

  public void setCountryId(Long countryId) {
    this.countryId = countryId;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getMonthlyRent() {
    return monthlyRent;
  }

  public void setMonthlyRent(String monthlyRent) {
    this.monthlyRent = monthlyRent;
  }

  public String getYearsAtAddress() {
    return yearsAtAddress;
  }

  public void setYearsAtAddress(String yearsAtAddress) {
    this.yearsAtAddress = yearsAtAddress;
  }

  public String getMonthsAtAddress() {
    return monthsAtAddress;
  }

  public void setMonthsAtAddress(String monthsAtAddress) {
    this.monthsAtAddress = monthsAtAddress;
  }

  public String getYearsAtCity() {
    return yearsAtCity;
  }

  public void setYearsAtCity(String yearsAtCity) {
    this.yearsAtCity = yearsAtCity;
  }

  
  public String getMonthsAtCity() {
    return monthsAtCity;
  }

  public void setMonthsAtCity(String monthsAtCity) {
    this.monthsAtCity = monthsAtCity;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  public List<Options> getCountryIdOptions() {
    return countryIdOptions;
  }

  public void setCountryIdOptions(List<Options> countryIdOptions) {
    this.countryIdOptions = countryIdOptions;
  }

  public List<Options> getStateProvinceIdOptions() {
    return stateProvinceIdOptions;
  }

  public void setStateProvinceIdOptions(List<Options> stateProvinceIdOptions) {
    this.stateProvinceIdOptions = stateProvinceIdOptions;
  }

  public List<Options> getAddressTypeIdOptions() {
    return addressTypeIdOptions;
  }

  public void setAddressTypeIdOptions(List<Options> addressTypeIdOptions) {
    this.addressTypeIdOptions = addressTypeIdOptions;
  }

  public List<Options> getAddressOwnershipTypeIdOptions() {
    return addressOwnershipTypeIdOptions;
  }

  public void setAddressOwnershipTypeIdOptions(List<Options> addressOwnershipTypeIdOptions) {
    this.addressOwnershipTypeIdOptions = addressOwnershipTypeIdOptions;
  }

  @Override
  public String toString() {
    return "Address{" +
      "client_id=" + client_id +
      ", addressType='" + addressType + '\'' +
      ", addressId=" + addressId +
      ", addressTypeId=" + addressTypeId +
      ", isActive=" + isActive +
      ", street='" + street + '\'' +
      ", addressLine1='" + addressLine1 + '\'' +
      ", addressLine2='" + addressLine2 + '\'' +
      ", addressLine3='" + addressLine3 + '\'' +
      ", townVillage='" + townVillage + '\'' +
      ", city='" + city + '\'' +
      ", countyDistrict='" + countyDistrict + '\'' +
      ", stateProvinceId=" + stateProvinceId +
      ", addressOwnershipTypeId=" + addressOwnershipTypeId +
      ", countryName='" + countryName + '\'' +
      ", stateName='" + stateName + '\'' +
      ", countryId=" + countryId +
      ", postalCode='" + postalCode + '\'' +
      ", monthlyRent='" + monthlyRent + '\'' +
      ", yearsAtAddress='" + yearsAtAddress + '\'' +
      ", monthsAtAddress='" + monthsAtAddress + '\'' +
      ", yearsAtCity='" + yearsAtCity + '\'' +
      ", monthsAtCity='" + monthsAtCity + '\'' +
      ", latitude=" + latitude +
      ", longitude=" + longitude +
      ", createdBy='" + createdBy + '\'' +
      ", createdOn=" + createdOn +
      ", updatedBy='" + updatedBy + '\'' +
      ", updatedOn=" + updatedOn +
      ", countryIdOptions=" + countryIdOptions +
      ", stateProvinceIdOptions=" + stateProvinceIdOptions +
      ", addressTypeIdOptions=" + addressTypeIdOptions +
      ", addressOwnershipTypeIdOptions=" + addressOwnershipTypeIdOptions +
      '}';
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.client_id);
    dest.writeString(this.addressType);
    dest.writeValue(this.addressId);
    dest.writeValue(this.addressTypeId);
    dest.writeValue(this.isActive);
    dest.writeString(this.street);
    dest.writeString(this.addressLine1);
    dest.writeString(this.addressLine2);
    dest.writeString(this.addressLine3);
    dest.writeString(this.townVillage);
    dest.writeString(this.city);
    dest.writeString(this.countyDistrict);
    dest.writeValue(this.stateProvinceId);
    dest.writeValue(this.addressOwnershipTypeId);
    dest.writeString(this.countryName);
    dest.writeString(this.stateName);
    dest.writeValue(this.countryId);
    dest.writeString(this.postalCode);
    dest.writeString(this.monthlyRent);
    dest.writeString(this.yearsAtAddress);
    dest.writeString(this.monthsAtAddress);
    dest.writeString(this.yearsAtCity);
    dest.writeString(this.monthsAtCity);
    dest.writeValue(this.latitude);
    dest.writeValue(this.longitude);
    dest.writeString(this.createdBy);
    dest.writeValue(this.createdOn);
    dest.writeString(this.updatedBy);
    dest.writeValue(this.updatedOn);
    dest.writeValue(this.addressTypeId);
    dest.writeValue(this.isActive);
    dest.writeString(this.street);
    dest.writeValue(this.stateProvinceId);
    dest.writeValue(this.countryId);
    dest.writeTypedList(this.countryIdOptions);
    dest.writeTypedList(this.stateProvinceIdOptions);
    dest.writeTypedList(this.addressTypeIdOptions);
    dest.writeTypedList(this.addressOwnershipTypeIdOptions);
  }
}
