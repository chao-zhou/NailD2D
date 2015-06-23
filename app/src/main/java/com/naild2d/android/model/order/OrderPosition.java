package com.naild2d.android.model.order;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/23.
 */
public class OrderPosition extends JsonWrapper {
    private int id;
    private double lat;
    private double lon;
    private String location;
    private String address;


    public OrderPosition(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        lat = json.getDouble("lat");
        lon = json.getDouble("lon");
        location = json.getString("location");
        address = json.getString("address");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
