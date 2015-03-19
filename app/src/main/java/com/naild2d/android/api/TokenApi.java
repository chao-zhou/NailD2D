package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class TokenApi extends Api {

    //3.4
    public String getRequestToken(){
        ServiceRequest req = new ServiceRequest("/token");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        return getResponseString(req);
    }

    //3.6
    public String getAccessToken(){
        ServiceRequest req = new ServiceRequest("/exchange");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_REQUEST);
        return getResponseString(req);
    }
}
