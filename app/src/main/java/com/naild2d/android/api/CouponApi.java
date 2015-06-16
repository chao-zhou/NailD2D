package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/10/2015.
 */
public class CouponApi extends Api {
    //-3.17
    public String getOnDoorCoupon(int pageSize, int page) {
        ServiceRequest req = new ServiceRequest("/coupon");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "filter", "enabled");
        addParams(req, "page_size", String.valueOf(pageSize));
        addParams(req, "page", String.valueOf(page));
        return getResponseString(req);
    }

    //-3.31
    public String getOnShopCoupon(int pageSize, int page) {
        ServiceRequest req = new ServiceRequest("/voucher");
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "page_size", String.valueOf(pageSize));
        addParams(req, "page", String.valueOf(page));
        return getResponseString(req);
    }

    //-3.32
    public String details(String voucher) {
        ServiceRequest req = new ServiceRequest("/voucher/" + voucher);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }

    //-3.33
    public String useOnShopCoupon(String voucher) {
        ServiceRequest req = new ServiceRequest("/voucher/" + voucher);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }
}
