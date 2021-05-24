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

  public static LoanApplicantionType getLoanApplicationType(String loanApplicationType) {
    try {
      if (loanApplicationType != null) {
        return valueOf(loanApplicationType);
      }
    } catch (IllegalArgumentException ignore) {
      for (LoanApplicantionType loanApplicantTypeEnum : values()) {
        if (loanApplicantTypeEnum.getValue().equals(loanApplicationType)) {
          return loanApplicantTypeEnum;
        }
      }
    }

    return null;
  }
}
