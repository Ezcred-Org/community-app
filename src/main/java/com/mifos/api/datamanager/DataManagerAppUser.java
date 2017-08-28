package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.appuser.AppUser;

import javax.inject.Singleton;

import retrofit2.Response;
import rx.Observable;

@Singleton
public class DataManagerAppUser {
  public final BaseApiManager mBaseApiManager;

  public DataManagerAppUser(BaseApiManager mBaseApiManager) {
    this.mBaseApiManager = mBaseApiManager;
  }

  public Observable<Response> registerUser(AppUser appUser) {
    return mBaseApiManager.getAppUserService().createUser(appUser);
  }
}
