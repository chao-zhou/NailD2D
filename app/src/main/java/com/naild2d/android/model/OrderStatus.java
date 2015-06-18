package com.naild2d.android.model;

import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.json.JsonWrapper;
import com.naild2d.android.model.order.OrderItem;
import com.naild2d.android.model.order.OrderPackageInfo;
import com.naild2d.android.model.order.OrderScheduleInfo;
import com.naild2d.android.model.order.OrderUser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/16.
 */
public class OrderStatus extends JsonWrapper {
    private int id;
    private double lat;
    private double lon;
    private String location;
    private String address;
    private OrderScheduleInfo schedule;
    private String date;
    private String time;
    private OrderPackageInfo pack;
    private OrderItem[] orderItems;
    private String remark;
    private OrderUser user;
    private String evaluation;
    private String coupon;
    private String payment;
    private double price;
    private String status;

    public OrderStatus(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        lat = json.getDouble("lat");
        lon = json.getDouble("lon");
        location = json.getString("location");
        address = json.getString("address");
        date = json.getString("date");
        time = json.getString("time");
        remark = json.getString("remark");
        evaluation = json.getString("evaluation");
        coupon = json.getString("coupon");
        payment = json.getString("payment");
        price = json.getDouble("price");
        status = json.getString("status");

        String jString = json.getString("schedule");
        schedule = new OrderScheduleInfo(new JSONObject(jString));

        jString = json.getString("pack");
        pack = new OrderPackageInfo(new JSONObject(jString));

        jString = json.getString("orderItems");
        try {
            orderItems = new IndexJSONObject(jString).getObjectArray(OrderItem.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jString = json.getString("user");
        user = new OrderUser(new JSONObject(jString));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
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

    public OrderScheduleInfo getSchedule() {
        return schedule;
    }

    public void setSchedule(OrderScheduleInfo schedule) {
        this.schedule = schedule;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public OrderPackageInfo getPack() {
        return pack;
    }

    public void setPack(OrderPackageInfo pack) {
        this.pack = pack;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public OrderUser getUser() {
        return user;
    }

    public void setUser(OrderUser user) {
        this.user = user;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
