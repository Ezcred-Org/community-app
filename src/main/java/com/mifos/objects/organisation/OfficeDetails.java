package com.mifos.objects.organisation;

import com.mifos.objects.client.Address;

import lombok.Data;

@Data
public class OfficeDetails {
  private final Office officeDetails;
  private final Address address;
}
