package com.mifos.api.local.databasehelper;

import static com.raizlabs.android.dbflow.sql.language.SQLite.select;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mifos.objects.accounts.ClientAccounts;
import com.mifos.objects.accounts.loan.LoanAccount;
import com.mifos.objects.accounts.savings.SavingsAccount;
import com.mifos.objects.client.Client;
import com.mifos.objects.client.ClientDate;
import com.mifos.objects.client.ClientPayload;
import com.mifos.objects.client.Page;
import com.mifos.objects.group.GroupWithAssociations;
import com.mifos.objects.noncore.ColumnHeader;
import com.mifos.objects.noncore.ColumnValue;
import com.mifos.objects.noncore.DataTable;
import com.mifos.objects.noncore.DataTablePayload;
import com.mifos.objects.templates.clients.ClientsTemplate;
import com.mifos.objects.templates.clients.InterestType;
import com.mifos.objects.templates.clients.OfficeOptions;
import com.mifos.objects.templates.clients.Options;
import com.mifos.objects.templates.clients.SavingProductOptions;
import com.mifos.objects.templates.clients.StaffOptions;
import com.mifos.utils.Constants;
import com.mifos.utils.MapDeserializer;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;


/**
 * This DatabaseHelper Managing all Database logic and staff (Saving, Update, Delete).
 * Whenever DataManager send response to save or request to read from Database then this class
 * save the response or read the all values from database and return as accordingly.
 * <p/>
 * Created by Rajan Maurya on 24/06/16.
 */
@Singleton
public class DatabaseHelperClient {

    public static final String GENDER_OPTIONS = "genderOptions";
    public static final String CLIENT_TYPE_OPTIONS = "clientTypeOptions";
    public static final String CLIENT_CLASSIFICATION_OPTIONS = "clientClassificationOptions";

    private Gson gson;
    private Type type;

    @Inject
    public DatabaseHelperClient() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<HashMap<String, Object>>() {
                }.getType(), new MapDeserializer());
        gson = gsonBuilder.create();
        type = new TypeToken<HashMap<String, Object>>() {
        }.getType();
    }

    /**
     * This Method save the single Client in Database with ClientId as Primary Id
     *
     * @param client Client
     * @return saved Client
     */
    public Observable<Client> saveClient(final Client client) {
        return Observable.defer(new Func0<Observable<Client>>() {
            @Override
            public Observable<Client> call() {
                //Saving Client in Database
                ClientDate clientDate = new ClientDate(client.getId(), 0,
                        client.getActivationDate().get(0),
                        client.getActivationDate().get(1),
                        client.getActivationDate().get(2));
                client.setClientDate(clientDate);
                return Observable.just(client);
            }
        });
    }

    /**
     * Reading All Clients from table of Client and return the ClientList
     *
     * @return List Of Client
     */
    //TODO Implement Observable Transaction to load Client List
    public Observable<Page<Client>> readAllClients() {
        return Observable.just(null);

    }

    public Observable<GroupWithAssociations> getGroupAssociateClients(final int groupId) {
        return Observable.just(null);
    }

    /**
     * This Method select query with clientId, In return the Client Details will be come.
     *
     * @param clientId of the client
     * @return Client
     */
    public Observable<Client> getClient(final int clientId) {
        return Observable.just(null);
    }


    /**
     * This Method  write the ClientAccount in tho DB. According to Schema Defined in Model
     *
     * @param clientAccounts Model of List of LoanAccount and SavingAccount
     * @param clientId       Client Id
     * @return null
     */
    public Observable<ClientAccounts> saveClientAccounts(final ClientAccounts clientAccounts,
                                                         final int clientId) {

        return Observable.just(null);
    }


    /**
     * This Method Read the Table of LoanAccount and SavingAccount and return the List of
     * LoanAccount and SavingAccount according to clientId
     *
     * @param clientId Client Id
     * @return Return the ClientAccount according to client Id
     */
    public Observable<ClientAccounts> realClientAccounts(final int clientId) {
        return Observable.just(null);
    }


    /**
     * Saving ClientTemplate into Database ClientTemplate_Table
     *
     * @param clientsTemplate fetched from Server
     * @return void
     */
    public Observable<ClientsTemplate> saveClientTemplate(final ClientsTemplate clientsTemplate) {
        return Observable.just(null);
    }


    /**
     * Reading ClientTemplate from Database ClientTemplate_Table
     *
     * @return ClientTemplate
     */
    public Observable<ClientsTemplate> readClientTemplate() {
        return Observable.just(null);
    }


    /**
     * Saving ClientPayload into Database ClientPayload_Table
     *
     * @param clientPayload created in offline mode
     * @return Client
     */
    public Observable<Client> saveClientPayloadToDB(final ClientPayload clientPayload) {
        return Observable.just(null);
    }


    /**
     * Reading All Entries in the ClientPayload_Table
     *
     * @return List<ClientPayload></>
     */
    public Observable<List<ClientPayload>> readAllClientPayload() {
        return Observable.just(null);
    }


    /**
     * This Method for deleting the client payload from the Database according to Id and
     * again fetch the client List from the Database ClientPayload_Table
     *
     * @param id is Id of the Client Payload in which reference client was saved into Database
     * @return List<ClientPayload></>
     */
    public Observable<List<ClientPayload>> deleteAndUpdatePayloads(final int id,
                                                                   final long clientCreationTIme) {
        return Observable.just(null);
    }

    public Observable<ClientPayload> updateDatabaseClientPayload(final ClientPayload
                                                                         clientPayload) {
        return Observable.just(null);
    }
}
