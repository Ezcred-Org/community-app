package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.user.User;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface UserService {

  @GET(APIEndPoint.USERS + "/{userId}")
  Observable<User> getUser(
      @Path("userId") long userId
  );

  @GET(APIEndPoint.USERDETAILS)
  Observable<User> getUser(
      @Query("access_token") String accessToken
  );
}
