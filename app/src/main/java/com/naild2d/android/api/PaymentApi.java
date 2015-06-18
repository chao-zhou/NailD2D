package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class PaymentApi extends Api {
    //-3.22
    public String pay(String orderId) {
        ServiceRequest req = new ServiceRequest("/payment");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "order", orderId);
        return getResponseString(req);
    }
}
