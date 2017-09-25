package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.client.Address;

import javax.inject.Inject;

import rx.Observable;

public class DataManagerAddress {

  private final BaseApiManager baseApiManager;

  @Inject
  public DataManagerAddress(BaseApiManager baseApiManager) {
    this.baseApiManager = baseApiManager;
  }

  public Observable<Address> getAddress(long addressId) {
    return baseApiManager.getAddressApi().getAddress(addressId);
  }
}
