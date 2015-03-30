package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class PackageApi extends Api {

    //-3.9
    public String list(double lat,double lon, int pageSize, int page){
        ServiceRequest req = new ServiceRequest("/pack");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"lat",String.valueOf(lat));
        addParams(req,"lon",String.valueOf(lon));
        addParams(req,"page_size",String.valueOf(pageSize));
        addParams(req,"page",String.valueOf(page));
        return getResponseString(req);
    }

    //-3.11
    public String getServiceList(String pack, int pageSize, int page){
        ServiceRequest req = new ServiceRequest("/service");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"pack",pack);
        addParams(req,"page_size",String.valueOf(pageSize));
        addParams(req,"page",String.valueOf(page));
        return getResponseString(req);
    }

    //-3.13
    public String getEvaluation(String pack, int pageSize, int page){
        ServiceRequest req = new ServiceRequest("/evaluation");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"pack",pack);
        addParams(req,"page_size",String.valueOf(pageSize));
        addParams(req,"page",String.valueOf(page));
        return getResponseString(req);
    }

    //-3.14
    public  String getService(String id){
        ServiceRequest req = new ServiceRequest("/service/"+id);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        return getResponseString(req);
    }


    //-3.16
    public String getSchedule(String pack){
        ServiceRequest req = new ServiceRequest("/schedule");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"pack",pack);
        return getResponseString(req);
    }
}
