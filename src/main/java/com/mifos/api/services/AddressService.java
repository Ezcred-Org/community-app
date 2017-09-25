package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.client.Address;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface AddressService {

  @GET(APIEndPoint.ADDRESS + "/{addressId}")
  Observable<Address> getAddress(
    @Path("addressId") long addressId);

}
