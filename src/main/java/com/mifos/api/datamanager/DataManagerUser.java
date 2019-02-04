package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class DataManagerUser {
  public final BaseApiManager mBaseApiManager;

  @Inject
  public DataManagerUser(BaseApiManager mBaseApiManager) {
    this.mBaseApiManager = mBaseApiManager;
  }

  public Observable<User> getUser(long userId) {
    return mBaseApiManager.getUserApi().getUser(userId);
  }
}
