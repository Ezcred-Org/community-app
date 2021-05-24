package com.mifos.objects.accounts.loan;


public enum LoanApplicantionType {
  MAIN("Main"),
  GUARANTOR("Guarantor"),
  CO_APPLICANT("Co-Applicant"),
  VERIFICATION_LOAN("Verification Loan");

  private final String value;

  LoanApplicantionType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static LoanApplicantionType getLoanApplicationType(String loanApplicantType) {
    try {
      if (loanApplicantType != null) {
        return valueOf(loanApplicantType);
      }
    } catch (IllegalArgumentException ignore) {
      for (LoanApplicantionType loanApplicantTypeEnum : values()) {
        if (loanApplicantTypeEnum.getValue().equals(loanApplicantType)) {
          return loanApplicantTypeEnum;
        }
      }
    }

    return null;
  }
}
