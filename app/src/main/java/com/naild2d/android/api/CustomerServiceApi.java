package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class CustomerServiceApi extends Api{

    //3.25
    public String getOrderedItemList(String user,int pageSize, int page){
        ServiceRequest req = new ServiceRequest("/orderitem");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"user",user);
        addParams(req,"page_size",String.valueOf(pageSize));
        addParams(req,"page",String.valueOf(page));
        return getResponseString(req);
    }

    //3.26
    public String getOrderedItem(String orderId, String user){
        ServiceRequest req = new ServiceRequest("/orderitem/"+orderId);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"user",user);
        return getResponseString(req);
    }

    //3.27
    public String getCustomerServiceCode(String orderId, String status, String user){
        ServiceRequest req = new ServiceRequest("/orderitem/"+orderId);
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"user",user);
        addParams(req,"status",status);
        return getResponseString(req);
    }
}
