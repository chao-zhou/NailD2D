package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class CustomerServiceApi extends Api{

    //-3.24
    public String getOrderList(int pageSize, int page){
        ServiceRequest req = new ServiceRequest("/orderitem");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"page_size",String.valueOf(pageSize));
        addParams(req,"page",String.valueOf(page));
        return getResponseString(req);
    }

    //-3.25
    public String getOrderedItem(String orderId){
        ServiceRequest req = new ServiceRequest("/orderitem/"+orderId);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }

    //-3.26
    public String getCustomerServiceCode(String orderId){
        ServiceRequest req = new ServiceRequest("/orderitem/"+orderId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"status","inPost");
        return getResponseString(req);
    }
}
