package com.mifos.objects.accounts.loan;


public enum AssociatedEntityType {

  PARENT_LOAN("Parent"),
  MAIN("Main"),
  GUARANTOR("Guarantor"),
  CO_APPLICANT("Co-Applicant"),
  VERIFICATION("Verification");

  private final String value;

  AssociatedEntityType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static AssociatedEntityType convertToAssociatedEntityEnum(String associatedEntityType) {
    try {
      if (associatedEntityType != null) {
        return valueOf(associatedEntityType);
      }
    } catch (IllegalArgumentException ignore) {
      for (AssociatedEntityType associatedEntityTypeEnum : values()) {
        if (associatedEntityTypeEnum.getValue().equals(associatedEntityType)) {
          return associatedEntityTypeEnum;
        }
      }
    }

    return null;
  }
}
