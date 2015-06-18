package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class EvaluationApi extends Api {

    //-3.27
    public String post(String orderId,
                       double post, double attitude, double quality, double punctual,
                       String comment){
        ServiceRequest req = new ServiceRequest("/evaluation");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "order", orderId);
        addParams(req,"post",String.valueOf(post));
        addParams(req,"attitude",String.valueOf(attitude));
        addParams(req,"quality",String.valueOf(quality));
        addParams(req,"punctual",String.valueOf(punctual));
        addParams(req,"comment",comment);
        return getResponseString(req);
    }

    //-3.28
    public String update(String evaluationId,
                         double post, double attitude, double quality, double punctual,
                         String comment, int pic) {
        ServiceRequest req = new ServiceRequest("/evaluation/" + evaluationId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"post",String.valueOf(post));
        addParams(req,"attitude",String.valueOf(attitude));
        addParams(req,"quality",String.valueOf(quality));
        addParams(req,"punctual",String.valueOf(punctual));
        addParams(req,"comment",comment);
        addParams(req, "comment", String.valueOf(pic));
        return getResponseString(req);
    }

    //-3.29
    public String update(String order){
        ServiceRequest req = new ServiceRequest("/evaluation/"+order);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }
}
