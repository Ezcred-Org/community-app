package com.mifos.objects.accounts.loan;

public enum OrderByColumns {
  ID("id");

  private final String name;

  OrderByColumns(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
