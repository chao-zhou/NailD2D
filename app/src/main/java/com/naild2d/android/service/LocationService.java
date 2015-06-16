package com.naild2d.android.service;

import com.naild2d.android.api.LocationApi;
import com.naild2d.android.log.Logger;

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
}
