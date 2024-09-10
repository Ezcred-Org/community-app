package com.mifos.api.local.databasehelper;

import android.os.AsyncTask;

import com.mifos.objects.organisation.Staff;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Rajan Maurya on 7/7/16.
 */
@Singleton
public class DatabaseHelperStaff {


    @Inject
    public DatabaseHelperStaff() {

    }


    public Observable<Void> saveAllStaffOfOffices(final List<Staff> staffs) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {

                for (Staff staff : staffs) {
//                    staff.save();
                }

            }
        });

        return null;
    }


    public Observable<List<Staff>> readAllStaffOffices(final int officeId) {
       return null;
    }
}
