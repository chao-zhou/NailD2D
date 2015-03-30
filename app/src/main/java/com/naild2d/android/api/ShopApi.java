package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class ShopApi extends Api{
    //-3.23
    public String info(String shopId){
        ServiceRequest req = new ServiceRequest("/shop/"+shopId);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }
}
