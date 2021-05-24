/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.objects.accounts.loan;

/**
 * Created by nellyk on 2/20/2016.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class Loans implements Parcelable {

    @SerializedName("id")
    Integer id;

    @SerializedName(("loanId"))
    long loanId;

    @SerializedName("accountNo")
    String accountNo;

    @SerializedName("status")
    Status status;

    @SerializedName("clientId")
    Integer clientId;

    @SerializedName("clientName")
    String clientName;

    @SerializedName("clientOfficeId")
    Integer clientOfficeId;

    @SerializedName("officeId")
    long officeId;

    @SerializedName("loanProductId")
    Integer loanProductId;

    @SerializedName("loanApplicationType")
    String loanApplicationType;

    @SerializedName("loanProductName")
    String loanProductName;

    @SerializedName("loanProductDescription")
    String loanProductDescription;

    @SerializedName("fundId")
    Integer fundId;

    @SerializedName("fundName")
    String fundName;

    @SerializedName("loanOfficerId")
    Integer loanOfficerId;

    @SerializedName("loanOfficerName")
    String loanOfficerName;

    @SerializedName("loanType")
    LoanType loanType;

    @SerializedName("currency")
    Currency currency;

    @SerializedName("principal")
    Double principal;

    @SerializedName("approvedPrincipal")
    Double approvedPrincipal;

    @SerializedName("termFrequency")
    Integer termFrequency;

    @SerializedName("termPeriodFrequencyType")
    TermPeriodFrequencyType termPeriodFrequencyType;

    @SerializedName("numberOfRepayments")
    Integer numberOfRepayments;

    @SerializedName("repaymentEvery")
    Integer repaymentEvery;

    @SerializedName("repaymentFrequencyType")
    RepaymentFrequencyType repaymentFrequencyType;

    @SerializedName("interestRatePerPeriod")
    Double interestRatePerPeriod;

    @SerializedName("interestRateFrequencyType")
    InterestRateFrequencyType interestRateFrequencyType;

    @SerializedName("annualInterestRate")
    Double annualInterestRate;

    @SerializedName("amortizationType")
    AmortizationType amortizationType;

    @SerializedName("interestType")
    InterestType interestType;

    @SerializedName("interestCalculationPeriodType")
    InterestCalculationPeriodType interestCalculationPeriodType;

    @SerializedName("transactionProcessingStrategyId")
    Integer transactionProcessingStrategyId;

    @SerializedName("transactionProcessingStrategyName")
    String transactionProcessingStrategyName;

    @SerializedName("syncDisbursementWithMeeting")
    Boolean syncDisbursementWithMeeting;

    @SerializedName("timeline")
    Timeline timeline;

    @SerializedName("summary")
    Summary summary;

    @SerializedName("feeChargesAtDisbursementCharged")
    Double feeChargesAtDisbursementCharged;

    @SerializedName("loanCounter")
    Integer loanCounter;

    @SerializedName("loanProductCounter")
    Integer loanProductCounter;

    @SerializedName("multiDisburseLoan")
    Boolean multiDisburseLoan;

    @SerializedName("canDisburse")
    Boolean canDisburse;

    @SerializedName("inArrears")
    Boolean inArrears;

    @SerializedName("isNPA")
    Boolean isNPA;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getClientOfficeId() {
        return clientOfficeId;
    }

    public void setClientOfficeId(Integer clientOfficeId) {
        this.clientOfficeId = clientOfficeId;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
    }

    public String getLoanApplicationType() {
        return loanApplicationType;
    }

    public void setLoanApplicationType(String loanApplicationType) {
        this.loanApplicationType = loanApplicationType;
    }

    public String getLoanProductName() {
        return loanProductName;
    }

    public void setLoanProductName(String loanProductName) {
        this.loanProductName = loanProductName;
    }

    public String getLoanProductDescription() {
        return loanProductDescription;
    }

    public void setLoanProductDescription(String loanProductDescription) {
        this.loanProductDescription = loanProductDescription;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Integer getLoanOfficerId() {
        return loanOfficerId;
    }

    public void setLoanOfficerId(Integer loanOfficerId) {
        this.loanOfficerId = loanOfficerId;
    }

    public String getLoanOfficerName() {
        return loanOfficerName;
    }

    public void setLoanOfficerName(String loanOfficerName) {
        this.loanOfficerName = loanOfficerName;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getApprovedPrincipal() {
        return approvedPrincipal;
    }

    public void setApprovedPrincipal(Double approvedPrincipal) {
        this.approvedPrincipal = approvedPrincipal;
    }

    public Integer getTermFrequency() {
        return termFrequency;
    }

    public void setTermFrequency(Integer termFrequency) {
        this.termFrequency = termFrequency;
    }

    public TermPeriodFrequencyType getTermPeriodFrequencyType() {
        return termPeriodFrequencyType;
    }

    public void setTermPeriodFrequencyType(TermPeriodFrequencyType termPeriodFrequencyType) {
        this.termPeriodFrequencyType = termPeriodFrequencyType;
    }

    public Integer getNumberOfRepayments() {
        return numberOfRepayments;
    }

    public void setNumberOfRepayments(Integer numberOfRepayments) {
        this.numberOfRepayments = numberOfRepayments;
    }

    public Integer getRepaymentEvery() {
        return repaymentEvery;
    }

    public void setRepaymentEvery(Integer repaymentEvery) {
        this.repaymentEvery = repaymentEvery;
    }

    public RepaymentFrequencyType getRepaymentFrequencyType() {
        return repaymentFrequencyType;
    }

    public void setRepaymentFrequencyType(RepaymentFrequencyType repaymentFrequencyType) {
        this.repaymentFrequencyType = repaymentFrequencyType;
    }

    public Double getInterestRatePerPeriod() {
        return interestRatePerPeriod;
    }

    public void setInterestRatePerPeriod(Double interestRatePerPeriod) {
        this.interestRatePerPeriod = interestRatePerPeriod;
    }

    public InterestRateFrequencyType getInterestRateFrequencyType() {
        return interestRateFrequencyType;
    }

    public void setInterestRateFrequencyType(InterestRateFrequencyType interestRateFrequencyType) {
        this.interestRateFrequencyType = interestRateFrequencyType;
    }

    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public AmortizationType getAmortizationType() {
        return amortizationType;
    }

    public void setAmortizationType(AmortizationType amortizationType) {
        this.amortizationType = amortizationType;
    }

    public InterestType getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestType interestType) {
        this.interestType = interestType;
    }

    public InterestCalculationPeriodType getInterestCalculationPeriodType() {
        return interestCalculationPeriodType;
    }

    public void setInterestCalculationPeriodType(InterestCalculationPeriodType
                                                         interestCalculationPeriodType) {
        this.interestCalculationPeriodType = interestCalculationPeriodType;
    }

    public Integer getTransactionProcessingStrategyId() {
        return transactionProcessingStrategyId;
    }

    public void setTransactionProcessingStrategyId(Integer transactionProcessingStrategyId) {
        this.transactionProcessingStrategyId = transactionProcessingStrategyId;
    }

    public String getTransactionProcessingStrategyName() {
        return transactionProcessingStrategyName;
    }

    public void setTransactionProcessingStrategyName(String transactionProcessingStrategyName) {
        this.transactionProcessingStrategyName = transactionProcessingStrategyName;
    }

    public Boolean getSyncDisbursementWithMeeting() {
        return syncDisbursementWithMeeting;
    }

    public void setSyncDisbursementWithMeeting(Boolean syncDisbursementWithMeeting) {
        this.syncDisbursementWithMeeting = syncDisbursementWithMeeting;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Double getFeeChargesAtDisbursementCharged() {
        return feeChargesAtDisbursementCharged;
    }

    public void setFeeChargesAtDisbursementCharged(Double feeChargesAtDisbursementCharged) {
        this.feeChargesAtDisbursementCharged = feeChargesAtDisbursementCharged;
    }

    public Integer getLoanCounter() {
        return loanCounter;
    }

    public void setLoanCounter(Integer loanCounter) {
        this.loanCounter = loanCounter;
    }

    public Integer getLoanProductCounter() {
        return loanProductCounter;
    }

    public void setLoanProductCounter(Integer loanProductCounter) {
        this.loanProductCounter = loanProductCounter;
    }

    public Boolean getMultiDisburseLoan() {
        return multiDisburseLoan;
    }

    public void setMultiDisburseLoan(Boolean multiDisburseLoan) {
        this.multiDisburseLoan = multiDisburseLoan;
    }

    public Boolean getCanDisburse() {
        return canDisburse;
    }

    public void setCanDisburse(Boolean canDisburse) {
        this.canDisburse = canDisburse;
    }

    public Boolean getInArrears() {
        return inArrears;
    }

    public void setInArrears(Boolean inArrears) {
        this.inArrears = inArrears;
    }

    public Boolean getIsNPA() {
        return isNPA;
    }

    public void setIsNPA(Boolean isNPA) {
        this.isNPA = isNPA;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Boolean getNPA() {
        return isNPA;
    }

    public void setNPA(Boolean NPA) {
        isNPA = NPA;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.accountNo);
        dest.writeParcelable(this.status, flags);
        dest.writeValue(this.clientId);
        dest.writeString(this.clientName);
        dest.writeValue(this.clientOfficeId);
        dest.writeValue(this.loanProductId);
        dest.writeString(this.loanApplicationType);
        dest.writeString(this.loanProductName);
        dest.writeString(this.loanProductDescription);
        dest.writeValue(this.fundId);
        dest.writeString(this.fundName);
        dest.writeValue(this.loanOfficerId);
        dest.writeString(this.loanOfficerName);
        dest.writeParcelable(this.loanType, flags);
        dest.writeParcelable(this.currency, flags);
        dest.writeValue(this.principal);
        dest.writeValue(this.approvedPrincipal);
        dest.writeValue(this.termFrequency);
        dest.writeParcelable(this.termPeriodFrequencyType, flags);
        dest.writeValue(this.numberOfRepayments);
        dest.writeValue(this.repaymentEvery);
        dest.writeParcelable(this.repaymentFrequencyType, flags);
        dest.writeValue(this.interestRatePerPeriod);
        dest.writeParcelable(this.interestRateFrequencyType, flags);
        dest.writeValue(this.annualInterestRate);
        dest.writeParcelable(this.amortizationType, flags);
        dest.writeParcelable(this.interestType, flags);
        dest.writeParcelable(this.interestCalculationPeriodType, flags);
        dest.writeValue(this.transactionProcessingStrategyId);
        dest.writeString(this.transactionProcessingStrategyName);
        dest.writeValue(this.syncDisbursementWithMeeting);
        dest.writeParcelable(this.timeline, flags);
        dest.writeParcelable(this.summary, flags);
        dest.writeValue(this.feeChargesAtDisbursementCharged);
        dest.writeValue(this.loanCounter);
        dest.writeValue(this.loanProductCounter);
        dest.writeValue(this.multiDisburseLoan);
        dest.writeValue(this.canDisburse);
        dest.writeValue(this.inArrears);
        dest.writeValue(this.isNPA);
    }

    public Loans() {
    }

    protected Loans(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.accountNo = in.readString();
        this.status = in.readParcelable(Status.class.getClassLoader());
        this.clientId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.clientName = in.readString();
        this.clientOfficeId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.loanProductId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.loanApplicationType = in.readString();
        this.loanProductName = in.readString();
        this.loanProductDescription = in.readString();
        this.fundId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.fundName = in.readString();
        this.loanOfficerId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.loanOfficerName = in.readString();
        this.loanType = in.readParcelable(LoanType.class.getClassLoader());
        this.currency = in.readParcelable(Currency.class.getClassLoader());
        this.principal = (Double) in.readValue(Double.class.getClassLoader());
        this.approvedPrincipal = (Double) in.readValue(Double.class.getClassLoader());
        this.termFrequency = (Integer) in.readValue(Integer.class.getClassLoader());
        this.termPeriodFrequencyType = in.
                readParcelable(TermPeriodFrequencyType.class.getClassLoader());
        this.numberOfRepayments = (Integer) in.readValue(Integer.class.getClassLoader());
        this.repaymentEvery = (Integer) in.readValue(Integer.class.getClassLoader());
        this.repaymentFrequencyType = in.
                readParcelable(RepaymentFrequencyType.class.getClassLoader());
        this.interestRatePerPeriod = (Double) in.readValue(Double.class.getClassLoader());
        this.interestRateFrequencyType = in.
                readParcelable(InterestRateFrequencyType.class.getClassLoader());
        this.annualInterestRate = (Double) in.readValue(Double.class.getClassLoader());
        this.amortizationType = in.readParcelable(AmortizationType.class.getClassLoader());
        this.interestType = in.readParcelable(InterestType.class.getClassLoader());
        this.interestCalculationPeriodType = in.
                readParcelable(InterestCalculationPeriodType.class.getClassLoader());
        this.transactionProcessingStrategyId = (Integer)
                in.readValue(Integer.class.getClassLoader());
        this.transactionProcessingStrategyName = in.readString();
        this.syncDisbursementWithMeeting = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.timeline = in.readParcelable(Timeline.class.getClassLoader());
        this.summary = in.readParcelable(Summary.class.getClassLoader());
        this.feeChargesAtDisbursementCharged = (Double) in.readValue(Double.class.getClassLoader());
        this.loanCounter = (Integer) in.readValue(Integer.class.getClassLoader());
        this.loanProductCounter = (Integer) in.readValue(Integer.class.getClassLoader());
        this.multiDisburseLoan = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.canDisburse = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.inArrears = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.isNPA = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Loans> CREATOR =
            new Parcelable.Creator<Loans>() {
                @Override
                public Loans createFromParcel(Parcel source) {
                    return new Loans(source);
                }

                @Override
                public Loans[] newArray(int size) {
                    return new Loans[size];
                }
            };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loans)) return false;

        Loans loans = (Loans) o;

        if (id != null ? !id.equals(loans.id) : loans.id != null) return false;
        if (accountNo != null ? !accountNo.equals(loans.accountNo) : loans.accountNo != null)
            return false;
        if (status != null ? !status.equals(loans.status) : loans.status != null) return false;
        if (clientId != null ? !clientId.equals(loans.clientId) : loans.clientId != null)
            return false;
        if (clientName != null ? !clientName.equals(loans.clientName) : loans.clientName != null)
            return false;
        if (clientOfficeId != null ? !clientOfficeId.equals(loans.clientOfficeId) : loans.clientOfficeId != null)
            return false;
        if (loanProductId != null ? !loanProductId.equals(loans.loanProductId) : loans.loanProductId != null)
            return false;
        if (loanApplicationType != null ? !loanApplicationType.equals(loans.loanApplicationType) : loans.loanApplicationType != null)
            return false;
        if (loanProductName != null ? !loanProductName.equals(loans.loanProductName) : loans.loanProductName != null)
            return false;
        if (loanProductDescription != null ? !loanProductDescription.equals(loans.loanProductDescription) : loans.loanProductDescription != null)
            return false;
        if (fundId != null ? !fundId.equals(loans.fundId) : loans.fundId != null) return false;
        if (fundName != null ? !fundName.equals(loans.fundName) : loans.fundName != null)
            return false;
        if (loanOfficerId != null ? !loanOfficerId.equals(loans.loanOfficerId) : loans.loanOfficerId != null)
            return false;
        if (loanOfficerName != null ? !loanOfficerName.equals(loans.loanOfficerName) : loans.loanOfficerName != null)
            return false;
        if (loanType != null ? !loanType.equals(loans.loanType) : loans.loanType != null)
            return false;
        if (currency != null ? !currency.equals(loans.currency) : loans.currency != null)
            return false;
        if (principal != null ? !principal.equals(loans.principal) : loans.principal != null)
            return false;
        if (approvedPrincipal != null ? !approvedPrincipal.equals(loans.approvedPrincipal) : loans.approvedPrincipal != null)
            return false;
        if (termFrequency != null ? !termFrequency.equals(loans.termFrequency) : loans.termFrequency != null)
            return false;
        if (termPeriodFrequencyType != null ? !termPeriodFrequencyType.equals(loans.termPeriodFrequencyType) : loans.termPeriodFrequencyType != null)
            return false;
        if (numberOfRepayments != null ? !numberOfRepayments.equals(loans.numberOfRepayments) : loans.numberOfRepayments != null)
            return false;
        if (repaymentEvery != null ? !repaymentEvery.equals(loans.repaymentEvery) : loans.repaymentEvery != null)
            return false;
        if (repaymentFrequencyType != null ? !repaymentFrequencyType.equals(loans.repaymentFrequencyType) : loans.repaymentFrequencyType != null)
            return false;
        if (interestRatePerPeriod != null ? !interestRatePerPeriod.equals(loans.interestRatePerPeriod) : loans.interestRatePerPeriod != null)
            return false;
        if (interestRateFrequencyType != null ? !interestRateFrequencyType.equals(loans.interestRateFrequencyType) : loans.interestRateFrequencyType != null)
            return false;
        if (annualInterestRate != null ? !annualInterestRate.equals(loans.annualInterestRate) : loans.annualInterestRate != null)
            return false;
        if (amortizationType != null ? !amortizationType.equals(loans.amortizationType) : loans.amortizationType != null)
            return false;
        if (interestType != null ? !interestType.equals(loans.interestType) : loans.interestType != null)
            return false;
        if (interestCalculationPeriodType != null ? !interestCalculationPeriodType.equals(loans.interestCalculationPeriodType) : loans.interestCalculationPeriodType != null)
            return false;
        if (transactionProcessingStrategyId != null ? !transactionProcessingStrategyId.equals(loans.transactionProcessingStrategyId) : loans.transactionProcessingStrategyId != null)
            return false;
        if (transactionProcessingStrategyName != null ? !transactionProcessingStrategyName.equals(loans.transactionProcessingStrategyName) : loans.transactionProcessingStrategyName != null)
            return false;
        if (syncDisbursementWithMeeting != null ? !syncDisbursementWithMeeting.equals(loans.syncDisbursementWithMeeting) : loans.syncDisbursementWithMeeting != null)
            return false;
        if (timeline != null ? !timeline.equals(loans.timeline) : loans.timeline != null)
            return false;
        if (summary != null ? !summary.equals(loans.summary) : loans.summary != null) return false;
        if (feeChargesAtDisbursementCharged != null ? !feeChargesAtDisbursementCharged.equals(loans.feeChargesAtDisbursementCharged) : loans.feeChargesAtDisbursementCharged != null)
            return false;
        if (loanCounter != null ? !loanCounter.equals(loans.loanCounter) : loans.loanCounter != null)
            return false;
        if (loanProductCounter != null ? !loanProductCounter.equals(loans.loanProductCounter) : loans.loanProductCounter != null)
            return false;
        if (multiDisburseLoan != null ? !multiDisburseLoan.equals(loans.multiDisburseLoan) : loans.multiDisburseLoan != null)
            return false;
        if (canDisburse != null ? !canDisburse.equals(loans.canDisburse) : loans.canDisburse != null)
            return false;
        if (inArrears != null ? !inArrears.equals(loans.inArrears) : loans.inArrears != null)
            return false;
        if (isNPA != null ? !isNPA.equals(loans.isNPA) : loans.isNPA != null) return false;
        return additionalProperties != null ? additionalProperties.equals(loans.additionalProperties) : loans.additionalProperties == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientOfficeId != null ? clientOfficeId.hashCode() : 0);
        result = 31 * result + (loanProductId != null ? loanProductId.hashCode() : 0);
        result = 31 * result + (loanApplicationType != null ? loanApplicationType.hashCode() : 0);
        result = 31 * result + (loanProductName != null ? loanProductName.hashCode() : 0);
        result = 31 * result + (loanProductDescription != null ? loanProductDescription.hashCode() : 0);
        result = 31 * result + (fundId != null ? fundId.hashCode() : 0);
        result = 31 * result + (fundName != null ? fundName.hashCode() : 0);
        result = 31 * result + (loanOfficerId != null ? loanOfficerId.hashCode() : 0);
        result = 31 * result + (loanOfficerName != null ? loanOfficerName.hashCode() : 0);
        result = 31 * result + (loanType != null ? loanType.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (principal != null ? principal.hashCode() : 0);
        result = 31 * result + (approvedPrincipal != null ? approvedPrincipal.hashCode() : 0);
        result = 31 * result + (termFrequency != null ? termFrequency.hashCode() : 0);
        result = 31 * result + (termPeriodFrequencyType != null ? termPeriodFrequencyType.hashCode() : 0);
        result = 31 * result + (numberOfRepayments != null ? numberOfRepayments.hashCode() : 0);
        result = 31 * result + (repaymentEvery != null ? repaymentEvery.hashCode() : 0);
        result = 31 * result + (repaymentFrequencyType != null ? repaymentFrequencyType.hashCode() : 0);
        result = 31 * result + (interestRatePerPeriod != null ? interestRatePerPeriod.hashCode() : 0);
        result = 31 * result + (interestRateFrequencyType != null ? interestRateFrequencyType.hashCode() : 0);
        result = 31 * result + (annualInterestRate != null ? annualInterestRate.hashCode() : 0);
        result = 31 * result + (amortizationType != null ? amortizationType.hashCode() : 0);
        result = 31 * result + (interestType != null ? interestType.hashCode() : 0);
        result = 31 * result + (interestCalculationPeriodType != null ? interestCalculationPeriodType.hashCode() : 0);
        result = 31 * result + (transactionProcessingStrategyId != null ? transactionProcessingStrategyId.hashCode() : 0);
        result = 31 * result + (transactionProcessingStrategyName != null ? transactionProcessingStrategyName.hashCode() : 0);
        result = 31 * result + (syncDisbursementWithMeeting != null ? syncDisbursementWithMeeting.hashCode() : 0);
        result = 31 * result + (timeline != null ? timeline.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (feeChargesAtDisbursementCharged != null ? feeChargesAtDisbursementCharged.hashCode() : 0);
        result = 31 * result + (loanCounter != null ? loanCounter.hashCode() : 0);
        result = 31 * result + (loanProductCounter != null ? loanProductCounter.hashCode() : 0);
        result = 31 * result + (multiDisburseLoan != null ? multiDisburseLoan.hashCode() : 0);
        result = 31 * result + (canDisburse != null ? canDisburse.hashCode() : 0);
        result = 31 * result + (inArrears != null ? inArrears.hashCode() : 0);
        result = 31 * result + (isNPA != null ? isNPA.hashCode() : 0);
        result = 31 * result + (additionalProperties != null ? additionalProperties.hashCode() : 0);
        return result;
    }
}
