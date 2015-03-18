package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class CouponApi extends Api {
    //3.19
    public String getOnDoorCoupon(String user, int page_size,int page){
        ServiceRequest req = new ServiceRequest("/coupon");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"page_size",String.valueOf(page_size));
        addParams(req,"page",String.valueOf(page));
        addParams(req,"user",user);
        addParams(req,"type",String.valueOf(1));
        return getResponseString(req);
    }

    //3.32
    public String getOnShopCoupon(String user, int page_size,int page){
        ServiceRequest req = new ServiceRequest("/coupon");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"page_size",String.valueOf(page_size));
        addParams(req,"page",String.valueOf(page));
        addParams(req,"user",user);
        addParams(req,"type",String.valueOf(2));
        return getResponseString(req);
    }

    //3.33
    public String details(String coupon,String user){
        ServiceRequest req = new ServiceRequest("/coupon/"+coupon);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"user",user);
        return getResponseString(req);
    }

    //3.34
    public String useOnShopCoupon(String coupon){
        ServiceRequest req = new ServiceRequest("/order/"+coupon);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_PUBLIC);
        return getResponseString(req);
    }

    //3.20
    public String useOnDoorCoupon(String orderId,String coupon,String user){
        ServiceRequest req = new ServiceRequest("/order/"+orderId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req,"coupon",coupon);
        addParams(req,"user",user);
        return getResponseString(req);
    }
}
