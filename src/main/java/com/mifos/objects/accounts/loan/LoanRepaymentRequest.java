/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.accounts.loan;

import android.os.Parcel;
import android.os.Parcelable;

import com.mifos.api.local.MifosBaseModel;
import com.mifos.api.local.MifosDatabase;




/**
 * Created by ishankhanna on 22/05/14.
 */


public class LoanRepaymentRequest extends MifosBaseModel implements Parcelable {


    
    transient long timeStamp;

    
    transient Integer loanId;

    
    transient String errorMessage;

    
    String dateFormat;

    
    String locale;

    
    String transactionDate;

    
    String transactionAmount;

    
    String paymentTypeId;

    
    String note;

    
    String accountNumber;

    
    String checkNumber;

    
    String routingCode;

    
    String receiptNumber;

    
    String bankNumber;

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dateFormat);
        dest.writeString(this.locale);
        dest.writeString(this.transactionDate);
        dest.writeString(this.transactionAmount);
        dest.writeString(this.paymentTypeId);
        dest.writeString(this.note);
        dest.writeString(this.accountNumber);
        dest.writeString(this.checkNumber);
        dest.writeString(this.routingCode);
        dest.writeString(this.receiptNumber);
        dest.writeString(this.bankNumber);
    }

    public LoanRepaymentRequest() {
    }

    protected LoanRepaymentRequest(Parcel in) {
        this.dateFormat = in.readString();
        this.locale = in.readString();
        this.transactionDate = in.readString();
        this.transactionAmount = in.readString();
        this.paymentTypeId = in.readString();
        this.note = in.readString();
        this.accountNumber = in.readString();
        this.checkNumber = in.readString();
        this.routingCode = in.readString();
        this.receiptNumber = in.readString();
        this.bankNumber = in.readString();
    }

    public static final Parcelable.Creator<LoanRepaymentRequest> CREATOR =
            new Parcelable.Creator<LoanRepaymentRequest>() {
        @Override
        public LoanRepaymentRequest createFromParcel(Parcel source) {
            return new LoanRepaymentRequest(source);
        }

        @Override
        public LoanRepaymentRequest[] newArray(int size) {
            return new LoanRepaymentRequest[size];
        }
    };
}
