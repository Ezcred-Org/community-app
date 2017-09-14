package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.api.services.UserUpdateToken;
import com.mifos.objects.appuser.AppUser;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;
import rx.Observable;

@Singleton
public class DataManagerAppUser {
  public final BaseApiManager mBaseApiManager;

  @Inject
  public DataManagerAppUser(BaseApiManager mBaseApiManager) {
    this.mBaseApiManager = mBaseApiManager;
  }

  public Observable<Response<String>> registerUser(AppUser appUser) {
    return mBaseApiManager.getAppUserService().createUser(appUser);
  }

  public Observable<String> updatePassword(int userId, String firstname, String password, String repeatPassword) {
    UserUpdateToken userUpdateToken = new UserUpdateToken();
    userUpdateToken.setFirstname(firstname);
    userUpdateToken.setPassword(password);
    userUpdateToken.setRepeatPassword(repeatPassword);

    return mBaseApiManager.getAppUserService().updatePassword(userId,userUpdateToken);
  }
}
