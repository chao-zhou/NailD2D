package com.naild2d.android.service;

import com.naild2d.android.api.PackageApi;
import com.naild2d.android.json.IndexJsonObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.ServicePackage;

/**
 * Created by ebread on 2015/6/15.
 */
public class ServicePack {

    private PackageApi packageApi = null;

    public ServicePack() {
        packageApi = new PackageApi();
    }

    public ServicePackage[] getServicePackage(double lat, double lon, int pageSize, int page) {
        String jString = packageApi.list(lat, lon, pageSize, page);
        try {
            IndexJsonObject json = new IndexJsonObject(jString);
            return json.getObjectArray(ServicePackage.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }


}
