package com.mifos.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import javax.inject.Singleton;


@Singleton
@SuppressWarnings("unused")
public class ConfigProperties {

  private static final String CONFIG_PROPERTIES = "config_properties";
  private static final String SENT_DEALER_ONBOARDING_MAIL = "sent_dealer_onboarding_mail";

  private final Context context;

  public ConfigProperties(Context context) {
    this.context = context;
  }

  private SharedPreferences getPreferences() {
    return context.getSharedPreferences(CONFIG_PROPERTIES, Context.MODE_PRIVATE);
  }

  public void clearPrefs() {
    getPreferences().edit().clear().apply();
  }

  private int getInt(String preferenceKey, int preferenceDefaultValue) {
    return getPreferences().getInt(preferenceKey, preferenceDefaultValue);
  }

  private void putInt(String preferenceKey, int preferenceValue) {
    getPreferences().edit().putInt(preferenceKey, preferenceValue).apply();
  }

  private long getLong(String preferenceKey, long preferenceDefaultValue) {
    return getPreferences().getLong(preferenceKey, preferenceDefaultValue);
  }

  private void putLong(String preferenceKey, long preferenceValue) {
    getPreferences().edit().putLong(preferenceKey, preferenceValue).apply();
  }

  private float getFloat(String preferenceKey, float preferenceDefaultValue) {
    return getPreferences().getFloat(preferenceKey, preferenceDefaultValue);
  }

  private void putFloat(String preferenceKey, float preferenceValue) {
    getPreferences().edit().putFloat(preferenceKey, preferenceValue).apply();
  }

  private boolean getBoolean(String preferenceKey, boolean preferenceDefaultValue) {
    return getPreferences().getBoolean(preferenceKey, preferenceDefaultValue);
  }

  private void putBoolean(String preferenceKey, boolean preferenceValue) {
    getPreferences().edit().putBoolean(preferenceKey, preferenceValue).apply();
  }

  private String getString(String preferenceKey, String preferenceDefaultValue) {
    return getPreferences().getString(preferenceKey, preferenceDefaultValue);
  }

  private void putString(String preferenceKey, String preferenceValue) {
    getPreferences().edit().putString(preferenceKey, preferenceValue).apply();
  }

  private void putStringSet(String preferencesKey, Set<String> values) {
    getPreferences().edit().putStringSet(preferencesKey, values).apply();
  }

  private Set<String> getStringSet(String preferencesKey) {
    return getPreferences().getStringSet(preferencesKey, null);
  }

  public boolean isDealerOnBoardingMailSent() {
    return getBoolean(SENT_DEALER_ONBOARDING_MAIL, false);
  }

  public void setDealerOnBoardingMailSent() {
    putBoolean(SENT_DEALER_ONBOARDING_MAIL, true);
  }
}


