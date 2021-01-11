/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.user;

import com.google.gson.annotations.SerializedName;
import com.mifos.objects.client.Role;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static final String AUTHENTICATION_KEY = "authenticationKey";

    private String username;

    @SerializedName(value = "userId", alternate = {"id"})
    private int userId;
    private String base64EncodedAuthenticationKey;

    private boolean authenticated;
    private int officeId;
    private String officeName;
    private boolean isSelfServiceUser;

    @SerializedName(value = "roles", alternate = {"selectedRoles"})
    private List<Role> roles = new ArrayList<Role>();
    private List<String> permissions = new ArrayList<String>();


    private int staffId;
    private String staffDisplayName;
    private String encodedCredentials;
    private String mobile;
    //{"username":"User1","userId":1,"base64EncodedAuthenticationKey":"VXNlcjE6dGVjaDRtZg\u003d
    // \u003d",
// "authenticated":true,"officeId":1,"officeName":"Office1",
// "roles":[{"id":1,"name":"Admin","description":"Admin"}],
// "permissions":["ALL_FUNCTIONS"],"shouldRenewPassword":false}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffDisplayName() {
        return staffDisplayName;
    }

    public void setStaffDisplayName(String staffDisplayName) {
        this.staffDisplayName = staffDisplayName;
    }

    public String getEncodedCredentials() {
        return encodedCredentials;
    }

    public void setEncodedCredentials(String encodedCredentials) {
        this.encodedCredentials = encodedCredentials;
    }

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public boolean isSelfServiceUser() {
        return isSelfServiceUser;
    }

    public void setSelfServiceUser(boolean isSelfServiceUser) {
        this.isSelfServiceUser = isSelfServiceUser;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getBase64EncodedAuthenticationKey() {
        return base64EncodedAuthenticationKey;
    }

    public void setBase64EncodedAuthenticationKey(String base64EncodedAuthenticationKey) {
        this.base64EncodedAuthenticationKey = base64EncodedAuthenticationKey;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userId=" + userId +
                ", base64EncodedAuthenticationKey='" + base64EncodedAuthenticationKey + '\'' +
                ", authenticated=" + authenticated +
                ", officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}
