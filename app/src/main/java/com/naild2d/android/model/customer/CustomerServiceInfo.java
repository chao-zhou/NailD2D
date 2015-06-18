package com.naild2d.android.model.customer;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/18.
 */
public class CustomerServiceInfo extends JsonWrapper {
    private int id;
    private String name;
    private int thumbnail;

    public CustomerServiceInfo(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        name = json.getString("name");
        thumbnail = json.getInt("thumbnail");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
