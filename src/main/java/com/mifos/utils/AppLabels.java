package com.mifos.utils;

import lombok.Data;

@Data
public class AppLabels {
  private final boolean loanAmountRequired;
  private final String partnerName;
  private final boolean isAadhaarVerificationNeeded;
}
