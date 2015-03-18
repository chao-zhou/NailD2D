package com.naild2d.android.model;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class Advertisement extends JsonWrapper{

    private int id;
    private String title;
    private int imageId;

    public Advertisement(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    public void wrap(JSONObject json) throws JSONException {
        this.id = json.getInt("id");
        this.title = json.getString("title");
        this.imageId = json.getInt("image");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }
}
