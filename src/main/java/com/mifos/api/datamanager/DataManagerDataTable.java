package com.mifos.api.datamanager;

import com.google.gson.JsonArray;
import com.mifos.api.BaseApiManager;
import com.mifos.api.local.databasehelper.DatabaseHelperDataTable;
import com.mifos.objects.noncore.DataTable;
import com.mifos.api.GenericResponse;
import com.mifos.objects.user.UserLocation;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;
import rx.Observable;

/**
 * This DataManager is for Managing DataTable API, In which Request is going to Server
 * and In Response, We are getting DataTable API Observable Response using Retrofit2
 *
 * Created by Rajan Maurya on 3/7/16.
 */
@Singleton
public class DataManagerDataTable {

    public final BaseApiManager mBaseApiManager;
    public final DatabaseHelperDataTable mDatabaseHelperDataTable;

    @Inject
    public DataManagerDataTable(BaseApiManager baseApiManager,
                                DatabaseHelperDataTable databaseHelperDataTable) {
        mBaseApiManager = baseApiManager;
        mDatabaseHelperDataTable = databaseHelperDataTable;
    }


    /**
     * This Method Request the REST API of Datatable and In response give the List of DataTable
     * for a given appTable
     * Type of DataTable is
     * 1. m_client
     * 2. m_savings_account
     * 3. m_loan
     * @param appTableName App Table Name
     * @return List<DataTable>
     */
    public Observable<List<DataTable>> getDataTable(String appTableName) {
        return mBaseApiManager.getDataTableApi().getTableOf(appTableName);
    }

    /**
     * This Method Request the REST API of Datatable and In response give the DataTable with
     * the given name.
     * @param dataTableName DataTable Name
     * @return DataTable
     */
    public Observable<DataTable> getDataTableByDataTableName(String dataTableName) {
        return mBaseApiManager.getDataTableApi().getTableOfByDataTableName(dataTableName);
    }

    public Observable<JsonArray> getDataTableInfo(String table, int entityId) {
        return mBaseApiManager.getDataTableApi().getDataOfDataTable(table, entityId);
    }

    public Observable<Response<GenericResponse>> addDataTableEntry(
            String table, int entityId, Map<String, Object> payload) {
        return mBaseApiManager.getDataTableApi()
                .createEntryInDataTable(table, entityId, payload);
    }

    public Observable<Response<GenericResponse>> updateEntryInDataTable(
      String table, int entityId, Map<String, Object> payload) {
        return mBaseApiManager.getDataTableApi()
          .updateEntryInDataTable(table, entityId, payload);
    }

    public Observable<GenericResponse> updateEntryInMultiRowDataTable(
      String table, long entityId, long rowId, Map<String, Object> payload) {
        return mBaseApiManager.getDataTableApi()
          .updateEntryInMultiRowDataTable(table, entityId, rowId, payload);
    }

    public Observable<GenericResponse> deleteDataTableEntry(String table, int entity, int rowId) {
        return mBaseApiManager.getDataTableApi().deleteEntryOfDataTableManyToMany(
                table, entity, rowId);
    }

    /**
     * This Method is adding the User Tracking Data in the data Table "user_tracking"
     *
     * @param userId UserId Id
     * @param userLocation  UserLocation
     * @return GenericResponse
     */
    public Observable<GenericResponse> addUserPathTracking(int userId,
                                                                         UserLocation userLocation) {
        return mBaseApiManager.getDataTableApi().addUserPathTracking(userId, userLocation);
    }

    /**
     * This Method is fetching the User Path Tracking from the DataTable "user_tracking"
     *
     * @param userId UserId Id
     * @return List<UserLocation>
     */
    public Observable<List<UserLocation>> getUserPathTracking(int userId) {
        return mBaseApiManager.getDataTableApi().getUserPathTracking(userId);
    }
}