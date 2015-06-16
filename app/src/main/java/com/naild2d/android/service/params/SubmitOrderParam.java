package com.naild2d.android.service.params;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ebread on 2015/6/16.
 */
public class SubmitOrderParam {
    private double lat;
    private double lon;
    private String location;
    private String address;
    private int schedule;
    private int pack;
    private int[] services;
    private String remark;
    private int coupon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getServicesJString() {
        Map<Integer, Integer> serviceMap = new HashMap<>();
        for (int index = 0; index < services.length; index++) {
            serviceMap.put(index, services[index]);
        }

        JSONObject json = new JSONObject(serviceMap);
        return json.toString();
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public int getPack() {
        return pack;
    }

    public void setPack(int pack) {
        this.pack = pack;
    }

    public int[] getServices() {
        return services;
    }

    public void setServices(int[] services) {
        this.services = services;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }
}
