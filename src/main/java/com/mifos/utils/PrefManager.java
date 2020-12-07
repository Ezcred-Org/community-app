package com.mifos.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.mifos.api.BaseUrl;
import com.mifos.objects.appuser.AppUser.EzCredAuthData;
import com.mifos.objects.organisation.Staff;
import com.mifos.objects.user.User;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Singleton;
import lombok.Data;

/**
 * @author fomenkoo
 */
@Singleton
@SuppressWarnings("unused")
public class PrefManager {

    private static final String PREF_MANAGER = "pref_manager";

    private static final String USER_ID = "preferences_user_id";
    private static final String TOKEN = "preferences_token";
    private static final String TENANT = "preferences_tenant";
    private static final String INSTANCE_URL = "instance_url";
    private static final String OAUTH_URL = "oauth_url";
    private static final String INSTANCE_DOMAIN = "preferences_domain";
    private static final String USER_STATUS = "user_status";
    private static final String USER_DETAILS = "user_details";
    private static final String STAFF_DETAILS = "staff_details";
    private static final String STAFF_CONFIG = "staff_config";
    private static final String RETAILER_CONFIG = "retailer_config";
    private static final String EZCRED_SECRET_KEY = "ezcred_secret_key";
    private static final String EZCRED_LAST_APP_VERSION_CODE = "ezcred_last_app_version_code";
    private static final String EZCRED_LAST_APP_VERSION_NAME = "ezcred_last_app_version_name";
    private static final String FCM_TOKEN_UPDATE_TIME = "firebase_token_update_time";
    private static final String NACH_SAMPLE_SHOWN = "nach_sample_shown";
    private static final String DEVICE_SYNC_DONE = "device_sync_done";
    private static final String GEO_LOCATION = "geo_location";
    private static final String PARTNER_AUTH_DATA = "partner_auth_data";
    private static final String LOGIN_BY_PARTNER = "login_by_partner";
    private static final String LAST_LOGIN_TIME = "last_login_time";
    private static final String LAST_INTERACTION_PAUSE_TIME= "last_interaction_pause_time";

    private final Gson gson;

    private final Context context;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    public PrefManager(Context context, Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    private SharedPreferences getPreferences() {
        return context.getSharedPreferences(PREF_MANAGER, Context.MODE_PRIVATE);
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

    public <T> void put(T object) {
        putString(object.getClass().getSimpleName(), gson.toJson(object));
    }

    public <T> T get(String key, Class<T> clazz) {
        return gson.fromJson(getString(key, "null"), clazz);
    }

    // Concrete methods

    /**
     * Authentication
     */

    public void login(User user, String token) {
        setUserId(user.getUserId());
        setToken(token);
        setUser(user);
    }

    public void logout() {
        setUserId(-1);
        clearToken();
        clearUser();
        clearStaffDetails();
        clearStaffConfig();
        setLastLoginTime(0);
        setLoginByPartner(false);
        clearRetailerConfig();
    }

    private void clearUser() {
        putString(USER_DETAILS, gson.toJson(null));
    }

    public User getUser() {
        return gson.fromJson(getString(USER_DETAILS, "null"),
                User.class);
    }

    public void setUser(User user) {
        putString(USER_DETAILS, gson.toJson(user));
    }

    private void clearStaffDetails() {
        putString(STAFF_DETAILS, gson.toJson(null));
    }

    public Staff getStaffDetails() {
        return gson.fromJson(getString(STAFF_DETAILS, null), Staff.class);
    }

    public void setStaffDetails(Staff staff) {
        putString(STAFF_DETAILS, gson.toJson(staff));
    }

    private void clearStaffConfig() {
        putString(STAFF_CONFIG, gson.toJson(null));
    }

    public <T> T getStaffConfig(Class<T> clazz) {
        return gson.fromJson(getString(STAFF_CONFIG, null), clazz);
    }

    public <T> void setStaffConfig(T object) {
        putString(STAFF_CONFIG, gson.toJson(object));
    }

    private void clearRetailerConfig() {
        putString(RETAILER_CONFIG, gson.toJson(null));
    }

    public <T> T getRetailerConfig(Class<T> clazz) {
        return gson.fromJson(getString(RETAILER_CONFIG, null), clazz);
    }

    public <T> void setRetailerConfig(T object) {
        putString(RETAILER_CONFIG, gson.toJson(object));
    }

    public void setToken(String token) {
        putString(TOKEN, token);
    }

    public void clearToken() {
        putString(TOKEN, "");
    }

    public String getToken() {
        return getString(TOKEN, "");
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

    /**
     * Connection
     */
    public String getInstanceUrl() {
        return getString(INSTANCE_URL, "");
    }

    public void setInstanceUrl(String instanceUrl) {
        putString(INSTANCE_URL, instanceUrl);
    }

    public String getOauthUrl() {
        return getString(OAUTH_URL, "");
    }

    public void setOauthUrl(String oauthUrl) {
        putString(OAUTH_URL, oauthUrl);
    }

    public String getInstanceDomain() {
        return getString(INSTANCE_DOMAIN, BaseUrl.API_ENDPOINT);
    }

    public void setInstanceDomain(String instanceDomain) {
        putString(INSTANCE_DOMAIN, instanceDomain);
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

    public String getEzcredLastAppVersionName() {
        return getString(EZCRED_LAST_APP_VERSION_NAME, "");
    }

    public void setEzcredLastAppVersionName(String versionName) {
        putString(EZCRED_LAST_APP_VERSION_NAME, versionName);
    }

    public long getFcmTokenUpdateTime() {
        return getLong(FCM_TOKEN_UPDATE_TIME, 0L);
    }

    public void setFcmTokenUpdateTime(long firebaseTokenUpdateTime) {
        putLong(FCM_TOKEN_UPDATE_TIME, firebaseTokenUpdateTime);
    }

    public boolean isNachSampleAlreadyShown() {
        return getBoolean(NACH_SAMPLE_SHOWN, false);
    }

    public void setNachSampleShown() {
        putBoolean(NACH_SAMPLE_SHOWN, true);
    }

    public boolean isDeviceSyncDone() {
        return getBoolean(DEVICE_SYNC_DONE, false);
    }

    public void setDeviceSyncDone() {
        putBoolean(DEVICE_SYNC_DONE, true);
    }

    public GeoLocation getGeoLocation() {
        readLock.lock();
        try {
            return gson.fromJson(getString(GEO_LOCATION, "null"), GeoLocation.class);
        } finally {
            readLock.unlock();
        }
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        writeLock.lock();
        try {
            putString(GEO_LOCATION, gson.toJson(geoLocation));
        } finally {
            writeLock.unlock();
        }
    }

    public String getPartnerDetails() {
        return getString(PARTNER_AUTH_DATA, null);
    }

    public void setPartnerDetails(EzCredAuthData ezCredAuthData) {
        putString(PARTNER_AUTH_DATA, gson.toJson(ezCredAuthData));
    }

    public void clearPartnerDetails() {
        putString(PARTNER_AUTH_DATA, null);
    }

    public boolean isLoginByPartner() {
        return getBoolean(LOGIN_BY_PARTNER, false);
    }

    public void setLoginByPartner(boolean loginByPartner) {
        putBoolean(LOGIN_BY_PARTNER, loginByPartner);
    }

    public long getLastLoginTime() {
        return getLong(LAST_LOGIN_TIME, new Date().getTime());
    }

    public void setLastLoginTime(long time) {
        putLong(LAST_LOGIN_TIME, time);
    }

    public long getLastInteractionPauseTime() {
        return getLong(LAST_INTERACTION_PAUSE_TIME, new Date().getTime());
    }

    public void setLastInteractionPauseTime(long time) {
        putLong(LAST_INTERACTION_PAUSE_TIME, time);
    }

    @Data
    public static final class GeoLocation {
        private final Double latitude;
        private final Double longitude;
        private final Long timestamp;
        private final float accuracy;
    }
}


