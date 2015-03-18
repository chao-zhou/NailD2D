package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class EvaluationApi extends Api {

    //3.28
    public String post(String order,
                       float post,float attitude,float quality,float punctual,
                       String comment,String user){
        ServiceRequest req = new ServiceRequest("/evaluation");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"order",order);
        addParams(req,"post",String.valueOf(post));
        addParams(req,"attitude",String.valueOf(attitude));
        addParams(req,"quality",String.valueOf(quality));
        addParams(req,"punctual",String.valueOf(punctual));
        addParams(req,"comment",comment);
        addParams(req,"user",user);
        return getResponseString(req);
    }

    //3.29
    public String update(String order,
                         float post,float attitude,float quality,float punctual,
                         String comment,String user){
        ServiceRequest req = new ServiceRequest("/evaluation/"+order);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"post",String.valueOf(post));
        addParams(req,"attitude",String.valueOf(attitude));
        addParams(req,"quality",String.valueOf(quality));
        addParams(req,"punctual",String.valueOf(punctual));
        addParams(req,"comment",comment);
        addParams(req,"user",user);
        return getResponseString(req);
    }

    //3.30
    public String update(String order){
        ServiceRequest req = new ServiceRequest("/evaluation/"+order);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }
}
