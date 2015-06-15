package com.naild2d.android.service;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/15.
 */
public class ServiceInfo extends JsonWrapper {
    private int id;
    private String name;
    private int pic;
    private String about;
    private int wty;
    private int served;

    protected ServiceInfo(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        name = json.getString("name");
        pic = json.getInt("pic");
        about = json.getString("about");
        wty = json.getInt("wty");
        served = json.getInt("served");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getWty() {
        return wty;
    }

    public void setWty(int wty) {
        this.wty = wty;
    }

    public int getServed() {
        return served;
    }

    public void setServed(int served) {
        this.served = served;
    }
}
