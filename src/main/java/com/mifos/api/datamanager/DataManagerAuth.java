package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.api.GenericResponse;
import com.mifos.api.model.FcmToken;
import com.mifos.objects.user.CreateUserRequest;
import com.mifos.objects.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;
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

    public Observable<String> saveFcmToken(int userId, String token) {
        return baseApiManager.getAuthApi().setFcmToken(userId, new FcmToken(token));
    }

    public Observable<GenericResponse> registerUser(
      String userName, String firstName, String lastName,
      String email, int officeId, int[] roles, boolean sendPasswordToEmail,
      boolean isSelfServiceUser, String password, String repeatPassword
    ) {
        CreateUserRequest createUserRequest =
          new CreateUserRequest(
            userName, firstName, lastName,
            email, officeId, roles, sendPasswordToEmail,
            isSelfServiceUser, password, repeatPassword
          );
        return baseApiManager.getUserService().createUser(createUserRequest);
    }
}
