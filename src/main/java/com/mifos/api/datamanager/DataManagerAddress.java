package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.client.Address;


import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class DataManagerAddress {
  private final BaseApiManager mBaseApiManager;

  @Inject
  public DataManagerAddress(BaseApiManager mBaseApiManager) {
    this.mBaseApiManager = mBaseApiManager;
  }

  public Observable<Address> getAddress(long addressId) {
    return mBaseApiManager.getAddressService().getAddress(addressId);
  }
}
