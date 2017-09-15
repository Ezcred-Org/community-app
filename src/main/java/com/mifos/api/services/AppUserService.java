package com.mifos.api.services;/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.appuser.AppUser;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Nishant-Pathak
 */
public interface AppUserService {

    @POST(APIEndPoint.USERS)
    Observable<Response<String>> createUser(@Body AppUser createUserRequest);

    @PUT("users/{userId}")
    Observable<String> updatePassword(@Path("userId") int userId, @Body UserUpdateToken userUpdateToken);
}
