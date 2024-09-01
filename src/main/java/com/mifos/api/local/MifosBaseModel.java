package com.mifos.api.local;

import com.google.gson.Gson;


/**
 * Created by Rajan Maurya on 23/06/16.
 */
public class MifosBaseModel {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
