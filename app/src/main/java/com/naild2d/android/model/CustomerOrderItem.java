package com.naild2d.android.model;

import com.naild2d.android.json.JsonWrapper;
import com.naild2d.android.model.customer.CustomerServiceInfo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/18.
 */
public class CustomerOrderItem extends JsonWrapper {
    private int id;
    private CustomerServiceInfo service;
    private double price;
    private String status;
    private int order;
    private String expired;
    private String shop;


    public CustomerOrderItem(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        price = json.getDouble("price");
        status = json.getString("status");
        order = json.getInt("order");
        expired = json.getString("expired");
        shop = json.getString("shop");

        String jString = json.getString("service");
        service = new CustomerServiceInfo(new JSONObject(jString));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerServiceInfo getService() {
        return service;
    }

    public void setService(CustomerServiceInfo service) {
        this.service = service;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
