package com.naild2d.android.service;

import com.naild2d.android.api.DeviceApi;

/**
 * Created by ebread on 2015/6/23.
 */
public class DeviceService {
    private DeviceApi deviceApi = null;

    public DeviceService() {
        deviceApi = new DeviceApi();
    }

    public boolean register(String token) {
        return deviceApi.register(token, "");
    }

    public boolean update(String newToken, String oldToken) {
        return deviceApi.register(newToken, oldToken);
    }

    public boolean bind(String token) {
        return deviceApi.bind(token);
    }
}
