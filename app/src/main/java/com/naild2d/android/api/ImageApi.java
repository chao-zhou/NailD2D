package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class ImageApi extends Api {

    //-3.1
    public String getAds() {
        ServiceRequest req = new ServiceRequest("/ad");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        return getResponseString(req);
    }

    //-3.10
    public byte[] getThumbnail(String id) {
        ServiceRequest req = new ServiceRequest("/thumbnail/" + id);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        return getResponseBytes(req);
    }

    //-3.12
    public byte[] getImage(String id, String device) {
        ServiceRequest req = new ServiceRequest("/image/" + id);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req, "device", device);
        return getResponseBytes(req);
    }

    public String uploadImage(byte[] bytes) {
        ServiceRequest req = new ServiceRequest("/pic/");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req, "file", new String(bytes));
        return getResponseString(req);
    }
}
