package com.mifos.api.local.databasehelper;

import android.os.AsyncTask;

import com.mifos.objects.organisation.Office;
import com.mifos.objects.organisation.OfficeOpeningDate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Rajan Maurya on 7/7/16.
 */
@Singleton
public class DatabaseHelperOffices {


    @Inject
    public DatabaseHelperOffices() {

    }


    public Observable<Void> saveAllOffices(final List<Office> offices) {
        return Observable.just(null);
    }


    public Observable<List<Office>> readAllOffices() {
        return Observable.just(Collections.<Office>emptyList());
    }
}
