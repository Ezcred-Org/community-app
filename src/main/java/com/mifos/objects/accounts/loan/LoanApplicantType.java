package com.mifos.objects.accounts.loan;


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
    } catch (IllegalArgumentException ignore) {
      for (LoanApplicantType loanApplicantTypeEnum : values()) {
        if (loanApplicantTypeEnum.getValue().equals(loanApplicantType)) {
          return loanApplicantTypeEnum;
        }
      }
    }

    return null;
  }
}
