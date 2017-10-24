/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.client.Address;
import com.mifos.objects.organisation.Office;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * @author fomenkoo
 */
public interface OfficeService {
    /**
     * Fetches List of All the Offices
     *
     * @param listOfOfficesCallback
     */
    @GET(APIEndPoint.OFFICES)
    Observable<List<Office>> getAllOffices();

    @GET(APIEndPoint.OFFICES + "/{officeId}")
    Observable<Office> getOfficeDetails(@Path("officeId") long officeId);

    @GET(APIEndPoint.ADDRESS + "/{addressId}")
    Observable<Address> getOfficeAddress(@Path("addressId") long addressId);
}
