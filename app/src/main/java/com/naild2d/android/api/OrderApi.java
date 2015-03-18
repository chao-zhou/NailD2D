package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class OrderApi extends Api{

    //3.17
    public String order(double lat, double lon,
                        String location, String address,
                        String schedule, String pack, String services ,
                        String remark){
        ServiceRequest req = new ServiceRequest("/order");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"lat",String.valueOf(lat));
        addParams(req,"lon",String.valueOf(lon));
        addParams(req,"location",location);
        addParams(req,"address",address);
        addParams(req,"schedule",schedule);
        addParams(req,"pack",pack);
        addParams(req,"services",services);
        addParams(req,"remark",remark);
        return getResponseString(req);
    }

    //3.31
    public String list(String user, String status, int page_size, int page){
        ServiceRequest req = new ServiceRequest("/order");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"lat",String.valueOf(page_size));
        addParams(req,"lon",String.valueOf(page));
        addParams(req,"user",user);
        addParams(req,"status",status);
        return getResponseString(req);
    }

    //3.18
    public String status(String orderId){
        ServiceRequest req = new ServiceRequest("/order/"+orderId);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }



    //3.21
    public String cancel(String orderId,String user){
        ServiceRequest req = new ServiceRequest("/order/"+orderId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"status","cancelled");
        addParams(req,"user",user);
        return getResponseString(req);
    }



}
