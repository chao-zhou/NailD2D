package com.naild2d.android.model;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/23.
 */
public class City extends JsonWrapper {
    private String name;

    public City(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        name = json.getString("name");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
