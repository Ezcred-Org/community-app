/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mifos.utils.JsonDateSerializer;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by ishankhanna on 24/06/14.
 */
public class GenericRequest {

    private final HashMap<String, Object> requestFields = new HashMap<>();

    public HashMap<String, Object> getRequestFields() {
        return requestFields;
    }

    public void setField(String key, Object value) {
        requestFields.put(key, value);
    }

    public static class GenericRequestSerializer implements JsonSerializer<GenericRequest> {

        private static final Gson GSON = new GsonBuilder()
          .registerTypeAdapter(Date.class, new JsonDateSerializer()).create();

        @Override
        public JsonElement serialize(GenericRequest src, Type typeOfSrc, JsonSerializationContext context) {
            return GSON.toJsonTree(src.getRequestFields());
        }
    }
}
