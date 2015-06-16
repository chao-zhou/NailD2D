package com.naild2d.android.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by chaozhou on 3/17/2015.
 */
public abstract class JsonWrapper {

    public JsonWrapper(JSONObject json) throws JSONException {
        wrap(json);
    }

    protected abstract void wrap(JSONObject json) throws JSONException;
}
