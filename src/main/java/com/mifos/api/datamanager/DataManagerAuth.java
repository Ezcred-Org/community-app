package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.api.model.FcmToken;
import com.mifos.api.model.UpdatePasswordPayload;
import com.mifos.api.model.UpdatePasswordResponse;
import com.mifos.objects.oauth.GrantType;
import com.mifos.objects.oauth.OAuthTokenResponse;
import com.mifos.objects.user.LoginData;
import com.mifos.objects.user.User;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Rajan Maurya on 19/02/17.
 */
@Singleton
public class DataManagerAuth {

    private final BaseApiManager baseApiManager;

    @Inject
    public DataManagerAuth(BaseApiManager baseApiManager) {
        this.baseApiManager = baseApiManager;
    }

    /**
     * @param username Username
     * @param password Password
     * @return Basic OAuth
     */
    public Observable<User> login(String username, String password) {
        return baseApiManager.getAuthApi().authenticate(new LoginData(username, password));
    }

    public Observable<OAuthTokenResponse> fetchOAuthToken(String userName, String password) {
//        return baseApiManager.getoAuthService().fetchOAuthToken(
//            userName, password, "community-app", "123", GrantType.password
//        );

        Map<String, String> payload = new HashMap<>();
        payload.put("username", userName);
        payload.put("password", password);

        return baseApiManager.getoAuthService().fetchOAuthTokenV1(payload);
    }

    public Observable<OAuthTokenResponse> refreshOAuthToken(String refreshToken) {
//        return baseApiManager.getoAuthService().refreshOAuthToken(
//            refreshToken, "community-app", "123", GrantType.refresh_token
//        );
        return baseApiManager.getoAuthService().refreshOAuthTokenV1(
            new HashMap<String, String>() {{
                put("refresh_token", refreshToken);
            }}
        );
    }

    public Observable<String> saveFcmToken(int userId, String token) {
        return baseApiManager.getAuthApi().setFcmToken(userId, new FcmToken(token));
    }

    public Observable<UpdatePasswordResponse> updatePassword(long userId, String password, String repeatPassword, String existingAuth) {
        UpdatePasswordPayload updatePasswordPayload = new UpdatePasswordPayload(password, repeatPassword);
        return baseApiManager.getAuthApi().updatePassword(existingAuth, userId, updatePasswordPayload);
  }
}
