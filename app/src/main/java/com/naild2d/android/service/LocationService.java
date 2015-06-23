package com.naild2d.android.service;

import com.naild2d.android.api.LocationApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.City;

import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/16.
 */
public class LocationService {
    private LocationApi locationApi = null;

    public LocationService() {
        locationApi = new LocationApi();
    }

    public String getAddress(double lat, double lon) {
        String jString = locationApi.getAddress(lat, lon);
        try {
            JSONObject json = new JSONObject(jString);
            return json.getString("address");
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public City[] getCityList() {
        String jString = locationApi.getCityList();
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(City.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }
}
