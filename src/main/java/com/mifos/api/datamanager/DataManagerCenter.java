package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.api.local.databasehelper.DatabaseHelperCenter;
import com.mifos.objects.client.ActivatePayload;
import com.mifos.objects.client.Page;
import com.mifos.objects.group.Center;
import com.mifos.objects.group.CenterWithAssociations;
import com.mifos.objects.organisation.Office;
import com.mifos.api.GenericResponse;
import com.mifos.services.data.CenterPayload;
import com.mifos.utils.PrefManager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * This DataManager is for Managing Center API, In which Request is going to Server
 * and In Response, We are getting Center API Observable Response using Retrofit2.
 * DataManagerCenter saving response in Database and response to Presenter as accordingly.
 * Created by Rajan Maurya on 28/6/16.
 */
@Singleton
public class DataManagerCenter {

    public final BaseApiManager mBaseApiManager;
    public final DatabaseHelperCenter mDatabaseHelperCenter;
    public final PrefManager prefManager;

    @Inject
    public DataManagerCenter(
      BaseApiManager baseApiManager,
      DatabaseHelperCenter databaseHelperCenter, PrefManager prefManager
    ) {
        mBaseApiManager = baseApiManager;
        mDatabaseHelperCenter = databaseHelperCenter;
        this.prefManager = prefManager;
    }


    /**
     * This Method sending the Request to REST API if UserStatus is 0 and
     * get list of the centers. The response will pass Presenter to show in the view
     * <p/>
     * If the offset is zero and UserStatus is 1 then fetch all Center list from Database and show
     * on the view.
     *
     * else if offset is not zero and UserStatus is 1 then return default empty response to
     * presenter
     *
     * @param paged  True Enable the Pagination of the center list REST API
     * @param offset Value give from which position Fetch CentersList
     * @param limit  Maximum Number of centers will come in response
     * @return Centers List page from offset to max Limit
     */
    public Observable<Page<Center>> getCenters(boolean paged, int offset, int limit) {
        switch (prefManager.getUserStatus()) {
            case 0:
                return mBaseApiManager.getCenterApi().getCenters(paged, offset, limit);

            case 1:
                /**
                 * Return All Centers List from DatabaseHelperCenter only one time.
                 * If offset is zero this means this is first request and
                 * return all clients from DatabaseHelperCenter
                 */
                if (offset == 0)
                    return mDatabaseHelperCenter.readAllCenters();

            default:
                return Observable.just(new Page<Center>());
        }
    }

    /**
     * Method Fetching CollectionSheet of the Center from :
     * demo.openmf.org/fineract-provider/api/v1/centers/{centerId}
     * ?associations=groupMembers,collectionMeetingCalendar
     *
     * @param id of the center
     * @return Collection Sheet
     */
    public Observable<CenterWithAssociations> getCentersGroupAndMeeting(int id) {
        return mBaseApiManager
                .getCenterApi()
                .getCenterWithGroupMembersAndCollectionMeetingCalendar(id);
    }

    public Observable<GenericResponse> createCenter(CenterPayload centerPayload) {
        return mBaseApiManager.getCenterApi().createCenter(centerPayload);
    }

    public Observable<List<Office>> getOffices() {
        return mBaseApiManager.getOfficeApi().getAllOffices();
    }

    /**
     * This method is activating the center
     *
     * @param centerId
     * @return GenericResponse
     */
    public Observable<GenericResponse> activateCenter(int centerId,
                                                                    ActivatePayload activatePayload) {
        return mBaseApiManager.getCenterApi().activateCenter(centerId, activatePayload);
    }
}
