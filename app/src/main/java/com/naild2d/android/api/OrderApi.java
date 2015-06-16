package com.naild2d.android.api;

import com.naild2d.android.network.ServiceRequest;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class OrderApi extends Api {

    //-3.18
    public String submit(double lat, double lon,
                         String location, String address,
                         int schedule, int pack, String services,
                         String remark, int coupon) {
        ServiceRequest req = new ServiceRequest("/order");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "lat", String.valueOf(lat));
        addParams(req, "lon", String.valueOf(lon));
        addParams(req, "location", location);
        addParams(req, "address", address);
        addParams(req, "schedule", String.valueOf(schedule));
        addParams(req, "pack", String.valueOf(pack));
        addParams(req, "services", services);
        addParams(req, "remark", remark);
        addParams(req, "coupon", String.valueOf(coupon));
        return getResponseString(req);
    }

    //-3.19
    public String status(String orderId) {
        ServiceRequest req = new ServiceRequest("/order/" + orderId);
        req.setMethod(ServiceRequest.METHOD_GET);
        req.setType(ServiceRequest.TYPE_ACCESS);
        return getResponseString(req);
    }

    //-3.20
    public boolean cancel(String orderId) {
        ServiceRequest req = new ServiceRequest("/order/" + orderId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "act", "cancel");
        return getResponse(req).getStatusLine().getStatusCode() == 204;
    }

    //-3.21
    public String confirm(String orderId) {
        ServiceRequest req = new ServiceRequest("/order/" + orderId);
        req.setMethod(ServiceRequest.METHOD_PUT);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "act", "confirm");
        return getResponseString(req);
    }

    //-3.30
    public String list(String status, int pageSize, int page) {
        ServiceRequest req = new ServiceRequest("/order");
        req.setMethod(ServiceRequest.METHOD_POST);
        req.setType(ServiceRequest.TYPE_ACCESS);
        addParams(req, "lat", String.valueOf(pageSize));
        addParams(req, "lon", String.valueOf(page));
        addParams(req, "status", status);
        return getResponseString(req);
    }


}
