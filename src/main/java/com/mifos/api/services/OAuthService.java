package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.user.User;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface OAuthService {

  @GET(APIEndPoint.TOKEN)
  Observable<User> getUser(
      @Path("userId") long userId
  );
}
