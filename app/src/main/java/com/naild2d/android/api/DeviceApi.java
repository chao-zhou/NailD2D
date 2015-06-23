package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by ebread on 2015/6/23.
 */
public class DeviceApi extends Api {

    public boolean register(String newToken, String oldToken) {
        ServiceRequest req = new ServiceRequest("/device");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req, "newToken", newToken);
        addParams(req, "oldToken", oldToken);
        return getResponse(req).getStatusLine().getStatusCode() == 204;
    }

    public boolean bind(String deviceToken) {
        ServiceRequest req = new ServiceRequest("/device");
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "token", deviceToken);
        return getResponse(req).getStatusLine().getStatusCode() == 204;
    }
}
