package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class MessageApi extends Api {
    //3.35
    public String list(String user,boolean read, String type,int page_size, int page){
        ServiceRequest req = new ServiceRequest("/notice");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"user",user);
        addParams(req,"read",String.valueOf(read));
        addParams(req,"type",type);
        addParams(req,"page_size",String.valueOf(page_size));
        addParams(req,"page",String.valueOf(page));
        return getResponseString(req);
    }

    //3.36
    public String details(String messageId,String user){
        ServiceRequest req = new ServiceRequest("/notice/"+messageId);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"user",user);
        return getResponseString(req);
    }

    //3.37
    public String markRead(String messageId,String user,boolean read){
        ServiceRequest req = new ServiceRequest("/notice/"+messageId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"user",user);
        addParams(req,"read",String.valueOf(read));
        return getResponseString(req);
    }
}
