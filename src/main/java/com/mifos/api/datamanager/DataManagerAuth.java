package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.api.model.FcmToken;
import com.mifos.api.model.UpdatePasswordPayload;
import com.mifos.objects.oauth.OAuthTokenResponse;
import com.mifos.objects.user.User;

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
        return baseApiManager.getAuthApi().authenticate(username, password);
    }

    public Observable<OAuthTokenResponse> fetchOAuthToken(
        String userName,
        String password,
        String clientId,
        String clientSecret,
        String grantType
    ) {
        return baseApiManager.getoAuthService().fetchOAuthToken(
            userName, password, clientId, clientSecret, grantType
        );
    }

    public Observable<OAuthTokenResponse> refreshOAuthToken(
        String refreshToken,
        String clientId,
        String clientSecret,
        String grantType
    ) {
        return baseApiManager.getoAuthService().refreshOAuthToken(
            refreshToken, clientId, clientSecret, grantType
        );
    }

    public Observable<String> saveFcmToken(int userId, String token) {
        return baseApiManager.getAuthApi().setFcmToken(userId, new FcmToken(token));
    }

    public Observable<String> updatePassword(long userId, String password, String repeatPassword) {
        UpdatePasswordPayload updatePasswordPayload = new UpdatePasswordPayload(password, repeatPassword);
        return baseApiManager.getAuthApi().updatePassword(userId, updatePasswordPayload);
  }
}
