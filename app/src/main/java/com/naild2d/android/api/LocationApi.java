package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class LocationApi extends Api {

    //3.15
    public String getAddress(double lat,double lon,String phone){
        ServiceRequest req = new ServiceRequest("/address");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"lat",String.valueOf(lat));
        addParams(req,"lon",String.valueOf(lon));
        addParams(req,"user",phone);
        return getResponseString(req);
    }
}
