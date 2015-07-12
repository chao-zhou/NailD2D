package com.naild2d.android.model.order;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/16.
 */
public class OrderItem extends JsonWrapper {
    private int id;
    private OrderServiceInfo service;
    private double price;

    public OrderItem() {
    }

    public OrderItem(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        String jString = json.getString("service");
        service = new OrderServiceInfo(new JSONObject(jString));
        price = json.getDouble("price");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderServiceInfo getService() {
        return service;
    }

    public void setService(OrderServiceInfo service) {
        this.service = service;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
