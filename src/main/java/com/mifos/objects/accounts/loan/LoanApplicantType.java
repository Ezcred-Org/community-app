package com.mifos.objects.accounts.loan;

import timber.log.Timber;

public enum LoanApplicantType {
  MAIN,
  GUARANTOR,
  CO_APPLICANT,
  VERIFICATION_LOAN;

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
