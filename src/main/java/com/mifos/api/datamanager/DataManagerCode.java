package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.system.Code;
import com.mifos.objects.system.CodeValue;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class DataManagerCode {
  public final BaseApiManager mBaseApiManager;

  @Inject
  public DataManagerCode(BaseApiManager mBaseApiManager) {
    this.mBaseApiManager = mBaseApiManager;
  }

  public Observable<List<Code>> getCode() {
    return mBaseApiManager.getCodeService().getCode();
  }
  public Observable<List<CodeValue>> getCodeValueByCodeId(long codeId) {
    return mBaseApiManager.getCodeService().getCodeValue(codeId);
  }
}
