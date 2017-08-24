/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.api.services;

import com.mifos.api.GenericResponse;
import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.user.CreateUserRequest;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface UserService {
  @POST(APIEndPoint.USERS)
  Observable<GenericResponse> createUser(@Body CreateUserRequest createUserRequest);
}

