package com.mifos.api.local;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Rajan Maurya on 23/06/16.
 */
public class MifosBaseModel extends BaseModel {

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
