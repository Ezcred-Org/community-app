package com.mifos.api.local.databasehelper;

import android.os.AsyncTask;

import com.mifos.objects.client.Charges;
import com.mifos.objects.client.ClientDate;
import com.mifos.objects.client.Page;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Rajan Maurya on 4/7/16.
 */
@Singleton
public class DatabaseHelperCharge {

    @Inject
    public DatabaseHelperCharge() {

    }


    /**
     * This Method save the All Client Charges in Database and save the Charge Due date in the
     * ClientDate as reference with Charge Id.
     *
     * @param chargesPage
     * @param clientId
     * @return null
     */
    public Observable<Void> saveClientCharges(final Page<Charges> chargesPage,
                                              final int clientId) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {

                for (Charges charges : chargesPage.getPageItems()) {
                    charges.setClientId(clientId);

                    ClientDate clientDate = new ClientDate(0, charges.getId(),
                            charges.getDueDate().get(2),
                            charges.getDueDate().get(1),
                            charges.getDueDate().get(0));
                    charges.setChargeDueDate(clientDate);
                }
            }
        });
        return null;
    }


    /**
     * This method Retrieve the Charges from Charges_Table and set the Charges Due date after
     * loading the Charge due date from the ChargeDate_table as reference with charge Id.
     *
     * @param clientId Client ID
     * @return Page of Charges
     */
    public Observable<Page<Charges>> readClientCharges(final int clientId) {
        return Observable.just(null);

    }

}
