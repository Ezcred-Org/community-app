package com.mifos.objects.accounts.loan;


public enum LoanApplicationType {
  MAIN("Main"),
  GUARANTOR("Guarantor"),
  CO_APPLICANT("Co-Applicant"),
  VERIFICATION("Verification")
  ;

  private final String value;

  LoanApplicationType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static LoanApplicationType getLoanApplicationType(String loanApplicationType) {
    try {
      if (loanApplicationType != null) {
        return valueOf(loanApplicationType);
      }
    } catch (IllegalArgumentException ignore) {
      for (LoanApplicationType loanApplicantTypeEnum : values()) {
        if (loanApplicantTypeEnum.getValue().equals(loanApplicationType)) {
          return loanApplicantTypeEnum;
        }
      }
    }

    return null;
  }
}
