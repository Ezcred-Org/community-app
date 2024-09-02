package com.mifos.api.local.databasehelper;

import com.mifos.objects.PaymentTypeOption;
import com.mifos.objects.accounts.loan.ActualDisbursementDate;
import com.mifos.objects.accounts.loan.LoanRepaymentRequest;
import com.mifos.objects.accounts.loan.LoanRepaymentResponse;
import com.mifos.objects.accounts.loan.LoanWithAssociations;
import com.mifos.objects.accounts.loan.Timeline;
import com.mifos.objects.templates.loans.LoanRepaymentTemplate;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by Rajan Maurya on 15/07/16.
 */
@Singleton
public class DatabaseHelperLoan {


    @Inject
    public DatabaseHelperLoan() {

    }


    /**
     * This Method Saving the Loan In Database table according to Loan Id
     *
     * @param loanWithAssociations
     * @return LoanWithAssociation
     */
    public Observable<LoanWithAssociations> saveLoanById(final LoanWithAssociations
                                                                 loanWithAssociations) {
        return Observable.just(null);
    }


    /**
     * Retrieving LoanWithAssociation according to Loan Id from Database Table
     *
     * @param loanId
     * @return LoanWithAssociation
     */
    public Observable<LoanWithAssociations> getLoanById(final int loanId) {
        return Observable.just(null);
    }


    /**
     * This Method Saving the Loan Transaction Offline in Database Table
     *
     * @param loanId               Loan Id
     * @param loanRepaymentRequest Request Body of Loan Transaction
     * @return LoanRepaymentResponse
     */
    public Observable<LoanRepaymentResponse> saveLoanRepaymentTransaction(
            final int loanId, final LoanRepaymentRequest loanRepaymentRequest) {

        return Observable.just(null);
    }


    /**
     * Read All LoanRepaymentRequest from Database ascending Order of TimeStamp
     *
     * @return List<LoanRepaymentRequest>
     */
    public Observable<List<LoanRepaymentRequest>> readAllLoanRepaymentTransaction() {
        return Observable.just(null);
    }


    /**
     * This Method send a query to Sqlite Database and get the LoanRepaymentRequest Where
     * Loan Id is Loan Id,
     *
     * This method used to check that LoanRepayment in offline mode,
     * Is already done with this loanId or not, If Yes then new Transaction can be made if
     * old one will be sync to server.
     *
     * @param loanId Loan Id
     * @return LoanRepaymentRequest by Loan Id
     */
    public Observable<LoanRepaymentRequest> getDatabaseLoanRepaymentByLoanId(final int loanId) {
        return Observable.just(null);
    }

    /**
     * This method saves the LoanRepaymentTemplate in Database for making Transaction In offline
     * and As the Template is saved in the Database, its return the same LoanRepaymentTemplate.
     *
     * @param loanId                Loan Id of the LoanTemplate
     * @param loanRepaymentTemplate LoanRepaymentTemplate for saving in Database
     * @return LoanRepaymentTemplate
     */
    public Observable<LoanRepaymentTemplate> saveLoanRepaymentTemplate(
            final int loanId, final LoanRepaymentTemplate loanRepaymentTemplate) {

        return Observable.just(null);
    }


    /**
     * This Method retrieve the LoanRepaymentTemplate from Database LoanRepaymentTemplate_Table
     * according to Loan Id and retrieve the PaymentTypeOptions according to templateType
     * LoanRepaymentTemplate
     *
     * @param loanId Loan Id of the LoanRepaymentTemplate.
     * @return LoanRepaymentTemplate from Database Query.
     */
    public Observable<LoanRepaymentTemplate> getLoanRepayTemplate(final int loanId) {
        return Observable.just(null);
    }


    /**
     * This Method request a query to Database in PaymentTypeOption_Table with argument paymentType
     * and return the list of PaymentTypeOption
     *
     * @return List<PaymentTypeOption>
     */
    public Observable<List<PaymentTypeOption>> getPaymentTypeOption() {
        return Observable.just(null);
    }

    /**
     * This Method Deleting the LoanRepayment with the loanId and loading the
     * List<LoanRepaymentRequest> from Database and return to the DataManagerLoan
     * that synced LoanRepayment is deleted from Database and updated Database Table entries.
     *
     * @param loanId loan Id of the LoanRepayment
     * @return List<LoanRepaymentRequest>
     */
    public Observable<List<LoanRepaymentRequest>> deleteAndUpdateLoanRepayments(final int loanId) {
        return Observable.just(null);
    }

    /**
     * This Method updating the LoanRepayment to Database Table. this method will be called
     * whenever error will come during sync the LoanRepayment. This method saving the Error
     * message to the Table entry.
     *
     * @param loanRepaymentRequest LoanRepayment for update
     * @return LoanRepaymentRequest
     */
    public Observable<LoanRepaymentRequest> updateLoanRepaymentTransaction(
            final LoanRepaymentRequest loanRepaymentRequest) {
        return Observable.just(null);
    }

}
