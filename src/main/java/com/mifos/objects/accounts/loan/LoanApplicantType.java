package com.mifos.objects.accounts.loan;

import timber.log.Timber;

public enum LoanApplicantType {
  MAIN("Main"),
  GUARANTOR("Guarantor"),
  CO_APPLICANT("Co-Applicant"),
  VERIFICATION_LOAN("Verification Loan");

  private final String value;

  LoanApplicantType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static LoanApplicantType getLoanApplicantType(String loanApplicantType) {
    try {
      if (loanApplicantType != null) {
        return valueOf(loanApplicantType);
      }
    } catch (IllegalArgumentException iae) {
      Timber.d("Failed to parse " + loanApplicantType);
    }

    return null;
  }
}
