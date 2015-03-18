package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class AccountApi extends Api {

    //3.2
    public String requestNewUser(String phone){
        ServiceRequest req = new ServiceRequest("/user");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"phone",phone);
        return getResponseString(req);
    }

    //3.3
    public String register(String phone, String pwd, String code, String ref){
        ServiceRequest req = new ServiceRequest("/user/"+phone);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"pwd",pwd);
        addParams(req,"code",code);
        addParams(req,"ref",ref);
        return getResponseString(req);
    }

    //3.5
    public String profile(String phone, String pwd){
        ServiceRequest req = new ServiceRequest("/user");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_REQUEST);
        addParams(req,"phone",phone);
        addParams(req,"pwd",pwd);
        return getResponseString(req);
    }

    //3,7
    public String requestResetPwd(String phone){
        ServiceRequest req = new ServiceRequest("/user/"+ phone);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"act","validate");
        return getResponseString(req);
    }

    //3.8
    public String resetPwd(String phone,String old_pw , String new_pw){
        ServiceRequest req = new ServiceRequest("/user/"+ phone);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        addParams(req,"old_pw",old_pw);
        addParams(req,"new_pw",new_pw);
        return getResponseString(req);
    }
}
