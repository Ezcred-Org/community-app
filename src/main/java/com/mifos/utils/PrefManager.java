package com.mifos.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.mifos.api.BaseUrl;
import com.mifos.objects.user.User;

import java.util.Set;

import javax.inject.Singleton;

/**
 * @author fomenkoo
 */
@Singleton
@SuppressWarnings("unused")
public class PrefManager {

    private static final String USER_ID = "preferences_user_id";
    private static final String TOKEN = "preferences_token";
    private static final String TENANT = "preferences_tenant";
    private static final String INSTANCE_URL = "preferences_instance";
    private static final String INSTANCE_DOMAIN = "preferences_domain";
    private static final String PORT = "preferences_port";
    private static final String USER_STATUS = "user_status";
    private static final String USER_DETAILS = "user_details";
    private static final String EZCRED_SECRET_KEY = "ezcred_secret_key";
    private static final String EZCRED_LAST_APP_VERSION_CODE = "ezcred_last_app_version_code";

    private final Gson gson;
    
    private final Context context;

    public PrefManager(Context context, Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    private SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void clearPrefs() {
        getPreferences().edit().clear().apply();
    }

    public int getInt(String preferenceKey, int preferenceDefaultValue) {
        return getPreferences().getInt(preferenceKey, preferenceDefaultValue);
    }

    public void putInt(String preferenceKey, int preferenceValue) {
        getPreferences().edit().putInt(preferenceKey, preferenceValue).apply();
    }

    public long getLong(String preferenceKey, long preferenceDefaultValue) {
        return getPreferences().getLong(preferenceKey, preferenceDefaultValue);
    }

    public void putLong(String preferenceKey, long preferenceValue) {
        getPreferences().edit().putLong(preferenceKey, preferenceValue).apply();
    }

    public float getFloat(String preferenceKey, float preferenceDefaultValue) {
        return getPreferences().getFloat(preferenceKey, preferenceDefaultValue);
    }

    public void putFloat(String preferenceKey, float preferenceValue) {
        getPreferences().edit().putFloat(preferenceKey, preferenceValue).apply();
    }

    public boolean getBoolean(String preferenceKey, boolean preferenceDefaultValue) {
        return getPreferences().getBoolean(preferenceKey, preferenceDefaultValue);
    }

    public void putBoolean(String preferenceKey, boolean preferenceValue) {
        getPreferences().edit().putBoolean(preferenceKey, preferenceValue).apply();
    }

    public String getString(String preferenceKey, String preferenceDefaultValue) {
        return getPreferences().getString(preferenceKey, preferenceDefaultValue);
    }

    public void putString(String preferenceKey, String preferenceValue) {
        getPreferences().edit().putString(preferenceKey, preferenceValue).apply();
    }

    public void putStringSet(String preferencesKey, Set<String> values) {
        getPreferences().edit().putStringSet(preferencesKey, values).apply();
    }

    public Set<String> getStringSet(String preferencesKey) {
        return getPreferences().getStringSet(preferencesKey, null);
    }

    // Concrete methods

    /**
     * Authentication
     */

    public void saveUser(User user) {
        putString(USER_DETAILS, gson.toJson(user));
    }

    public User getUser() {
        return gson.fromJson(getString(USER_DETAILS, "null"),
                User.class);
    }
    public void saveToken(String token) {
        putString(TOKEN, token);
    }

    public void clearToken() {
        putString(TOKEN, "");
    }

    public String getToken() {
        return getString(TOKEN, "");
    }

    public void saveEzcredSecretKey(String ezcredSecretKey) {
        putString(EZCRED_SECRET_KEY, ezcredSecretKey);
    }

    public String getEzcredSecretKey() {
        return getString(EZCRED_SECRET_KEY, "");
    }

    public boolean isAuthenticated() {
        return !TextUtils.isEmpty(getToken());
    }

    public int getUserId() {
        return getInt(USER_ID, -1);
    }

    public void setUserId(int id) {
        putInt(USER_ID, id);
    }

    public String getTenant() {
        return getString(TENANT, "default");
    }

    public void setTenant(String tenant) {
        if (!TextUtils.isEmpty(tenant))
            putString(TENANT, tenant);
    }

    public String getInstanceUrl() {
        return getString(INSTANCE_URL, "");
    }

    /**
     * Connection
     */
    public void setInstanceUrl(String instanceUrl) {
        putString(INSTANCE_URL, instanceUrl);
    }

    public String getInstanceDomain() {
        return getString(INSTANCE_DOMAIN, BaseUrl.API_ENDPOINT);
    }

    public void setInstanceDomain(String instanceDomain) {
        putString(INSTANCE_DOMAIN, instanceDomain);
    }

    public String getPort() {
        return getString(PORT, BaseUrl.PORT);
    }

    public void setPort(String port) {
        if (!TextUtils.isEmpty(port))
            putString(PORT, port);
    }

    /**
     * Set User Status,
     * If O then user is Online
     * If 1 then User is offline
     */
    public void setUserStatus(int statusCode) {
        putInt(USER_STATUS, statusCode);
    }

    /**
     * @return the Pref value of User status.
     * default is 0(User is online)
     */
    public int getUserStatus() {
        return getInt(USER_STATUS, 0);
    }

    public void setFirebaseToken(String firebaseToken) {
        putString(Constants.FIREBASE_TOKEN, firebaseToken);
    }

    public String getFirebaseToken() {
        return getString(Constants.FIREBASE_TOKEN, "");
    }

    public int getLastEzcredAppVersion() {
        return getInt(EZCRED_LAST_APP_VERSION_CODE, 0);
    }

    public void setLastEzcredAppVersion(int versionCode) {
        putInt(EZCRED_LAST_APP_VERSION_CODE, versionCode);
    }
}


