package com.mifos.api.local.databasehelper;

import android.os.AsyncTask;
import android.support.annotation.Nullable;

import com.mifos.objects.client.Page;
import com.mifos.objects.group.Center;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Rajan Maurya on 28/6/16.
 */
@Singleton
public class DatabaseHelperCenter {

    @Inject
    public DatabaseHelperCenter() {
    }


    /**
     * Saving Centers in Database using DBFlow.
     * save() method save the value reference to primary key if its exist the update if not the
     * insert.
     *
     * @param centerPage
     * @return null
     */
    @Nullable
    public Observable<Void> saveAllCenters(final Page<Center> centerPage) {
        return null;
    }

    /**
     * Reading All Centers from table of Center and return the CenterList
     *
     * @return List Of Centers
     */
    //TODO Implement Observable Transaction to load Center List
    public Observable<Page<Center>> readAllCenters() {

        return null;

    }

}
