package com.naild2d.android.service;

import com.naild2d.android.api.PackageApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.PackageInfo;
import com.naild2d.android.model.PackageScheduleInfo;
import com.naild2d.android.model.ServiceInfo;

/**
 * Created by ebread on 2015/6/15.
 */
public class PackageService {

    private PackageApi packageApi = null;

    public PackageService() {
        packageApi = new PackageApi();
    }

    public PackageInfo[] getPackageInfo(double lat, double lon, int pageSize, int page) {
        String jString = packageApi.list(lat, lon, pageSize, page);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(PackageInfo.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public ServiceInfo getServiceInfo(String serviceId) {
        String jString = packageApi.getService(serviceId);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObject(ServiceInfo.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public PackageScheduleInfo[] getScheduleInfo(String packageId) {
        String jString = packageApi.getSchedule(packageId);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(PackageScheduleInfo.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }
}
