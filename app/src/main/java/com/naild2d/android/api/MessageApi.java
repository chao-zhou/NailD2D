package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class MessageApi extends Api {
    //-3.34
    public String list(boolean read, String type,int pageSize, int page){
        ServiceRequest req = new ServiceRequest("/notice");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"read",String.valueOf(read));
        addParams(req,"type",type);
        addParams(req,"page_size",String.valueOf(pageSize));
        addParams(req,"page",String.valueOf(page));
        return getResponseString(req);
    }

    //-3.35
    public String details(String messageId){
        ServiceRequest req = new ServiceRequest("/notice/"+messageId);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }

    //-3.36
    public String markRead(String messageId){
        ServiceRequest req = new ServiceRequest("/notice/"+messageId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"read","true");
        return getResponseString(req);
    }
}
