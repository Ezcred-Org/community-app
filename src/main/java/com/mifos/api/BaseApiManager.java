/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api;

import android.content.SharedPreferences;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mifos.api.services.AddressService;
import com.mifos.api.services.AuthService;
import com.mifos.api.services.CenterService;
import com.mifos.api.services.ChargeService;
import com.mifos.api.services.ClientAccountsService;
import com.mifos.api.services.ClientService;
import com.mifos.api.services.CodeService;
import com.mifos.api.services.DataTableService;
import com.mifos.api.services.DocumentService;
import com.mifos.api.services.GroupService;
import com.mifos.api.services.LoanService;
import com.mifos.api.services.NoteService;
import com.mifos.api.services.OAuthService;
import com.mifos.api.services.OfficeService;
import com.mifos.api.services.RunReportsService;
import com.mifos.api.services.SavingsAccountService;
import com.mifos.api.services.SearchService;
import com.mifos.api.services.StaffService;
import com.mifos.api.services.SurveyService;
import com.mifos.api.services.UserService;
import com.mifos.utils.JsonDateSerializer;
import com.mifos.utils.PrefManager;

import java.util.Date;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author fomenkoo
 */
public class BaseApiManager {


  private static Retrofit mRetrofit;
  private static Retrofit mRetrofitOAuth;
  private static AuthService authApi;
  private static CenterService centerApi;
  private static ClientAccountsService accountsApi;
  private static ClientService clientsApi;
  private static DataTableService dataTableApi;
  private static LoanService loanApi;
  private static SavingsAccountService savingsApi;
  private static ChargeService chargeApi;
  private static SearchService searchApi;
  private static GroupService groupApi;
  private static DocumentService documentApi;
  private static OfficeService officeApi;
  private static StaffService staffApi;
  private static SurveyService surveyApi;
  private static RunReportsService runreportsService;
  private static NoteService noteService;
  private static CodeService codeService;
  private static AddressService addressService;
  private static UserService userApi;
  private static OAuthService oAuthService;

  public BaseApiManager(
      PrefManager prefManager,
      SharedPreferences loanScopeSharedPreferences,
      RawCertificatePinner certificatePinner,
      boolean sslPinningEnabled,
      boolean encryptRequestBody,
      String dataEncryptionAlgorithm,
      String dataEncryptionSecretKey
  ) {
    createService(
        prefManager,
        loanScopeSharedPreferences,
        certificatePinner,
        sslPinningEnabled,
        oAuthService,
        encryptRequestBody,
        dataEncryptionAlgorithm,
        dataEncryptionSecretKey
    );
  }

  public static void init() {
    authApi = createApi(AuthService.class);
    centerApi = createApi(CenterService.class);
    accountsApi = createApi(ClientAccountsService.class);
    clientsApi = createApi(ClientService.class);
    dataTableApi = createApi(DataTableService.class);
    loanApi = createApi(LoanService.class);
    savingsApi = createApi(SavingsAccountService.class);
    searchApi = createApi(SearchService.class);
    groupApi = createApi(GroupService.class);
    documentApi = createApi(DocumentService.class);
    officeApi = createApi(OfficeService.class);
    staffApi = createApi(StaffService.class);
    surveyApi = createApi(SurveyService.class);
    chargeApi = createApi(ChargeService.class);
    runreportsService = createApi(RunReportsService.class);
    noteService = createApi(NoteService.class);
    codeService = createApi(CodeService.class);
    addressService = createApi(AddressService.class);
    userApi = createApi(UserService.class);
    oAuthService = createOAuthApi(OAuthService.class);
  }

  private static <T> T createApi(Class<T> clazz) {
    return mRetrofit.create(clazz);
  }

  private static <T> T createOAuthApi(Class<T> clazz) {
    if (mRetrofitOAuth != null) {
      return mRetrofitOAuth.create(clazz);
    }

    return null;
  }

  public static void createService(
      PrefManager prefManager,
      SharedPreferences loanScopeSharedPreferences,
      RawCertificatePinner certificatePinner,
      boolean sslPinningEnabled,
      OAuthService oAuthService,
      boolean encryptRequestBody,
      String dataEncryptionAlgorithm,
      String dataEncryptionSecretKey
  ) {

    Gson gson = new GsonBuilder()
      .registerTypeAdapter(Date.class, new JsonDateSerializer()).create();

    OkHttpClient.Builder okHttpClientBuilder = new MifosOkHttpClient().getMifosOkHttpClientBuilder(
        prefManager,
        loanScopeSharedPreferences,
        new MifosTokenAuthenticator(prefManager, oAuthService),
        encryptRequestBody,
        dataEncryptionAlgorithm,
        dataEncryptionSecretKey
    );
    if (sslPinningEnabled) {
      okHttpClientBuilder = certificatePinner.pinCertificate(okHttpClientBuilder);
    }
    OkHttpClient okHttpClient = okHttpClientBuilder.build();
    mRetrofit = new Retrofit.Builder()
      .baseUrl(prefManager.getInstanceUrl())
      .addConverterFactory(ScalarsConverterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(MifosErrorHandlingCallAdapterFactory.create())
      .client(okHttpClient)
      .build();

    if (!TextUtils.isEmpty(prefManager.getOauthUrl())) {
      mRetrofitOAuth = new Retrofit.Builder()
          .baseUrl(prefManager.getOauthUrl())
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(MifosErrorHandlingCallAdapterFactory.create())
          .client(okHttpClient)
          .build();
    }

    init();
  }

  public AuthService getAuthApi() {
    return authApi;
  }

  public OAuthService getoAuthService() {
    return oAuthService;
  }

  public CenterService getCenterApi() {
    return centerApi;
  }

  public ClientAccountsService getAccountsApi() {
    return accountsApi;
  }

  public ClientService getClientsApi() {
    return clientsApi;
  }

  public AddressService getAddressService() {
    return addressService;
  }

  public DataTableService getDataTableApi() {
    return dataTableApi;
  }

  public LoanService getLoanApi() {
    return loanApi;
  }

  public SavingsAccountService getSavingsApi() {
    return savingsApi;
  }

  public SearchService getSearchApi() {
    return searchApi;
  }

  public GroupService getGroupApi() {
    return groupApi;
  }

  public DocumentService getDocumentApi() {
    return documentApi;
  }

  public OfficeService getOfficeApi() {
    return officeApi;
  }

  public StaffService getStaffApi() {
    return staffApi;
  }

  public SurveyService getSurveyApi() {
    return surveyApi;
  }

  public ChargeService getChargeApi() {
    return chargeApi;
  }

  public RunReportsService getRunReportsService() {
    return runreportsService;
  }

  public NoteService getNoteApi() {
    return noteService;
  }

  public CodeService getCodeService() {
    return codeService;
  }

  public UserService getUserApi() {
    return userApi;
  }
}
