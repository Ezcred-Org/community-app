package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.system.Code;
import com.mifos.objects.system.CodeValue;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface CodeService {

  @GET(APIEndPoint.CODES)
  Observable<List<Code>> getCode();


  @GET(APIEndPoint.CODES + "/{codeId}/codevalues")
  Observable<List<CodeValue>> getCodeValue(@Path("codeId") long codeId);

}
