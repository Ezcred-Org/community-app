package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.user.User;

import java.util.Collections;
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

  public Observable<User> getUser(String accessToken, String accessTokenWithType) {
    return mBaseApiManager.getUserApi()
            .getUser(Collections.singletonMap("access_token", accessToken), accessTokenWithType);
  }
}
