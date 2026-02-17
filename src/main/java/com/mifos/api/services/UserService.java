package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.user.User;

import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface UserService {

  @GET(APIEndPoint.USERS + "/{userId}")
  Observable<User> getUser(
      @Path("userId") long userId
  );

  @POST(APIEndPoint.USERDETAILS)
  Observable<User> getUser(
      @Body Map<String, String> accessTokenBody,
      @Header("Authorization") String auth
  );
}
