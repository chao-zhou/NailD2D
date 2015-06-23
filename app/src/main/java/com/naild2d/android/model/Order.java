package com.naild2d.android.model;

import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.json.JsonWrapper;
import com.naild2d.android.model.order.OrderItem;
import com.naild2d.android.model.order.OrderPackageInfo;
import com.naild2d.android.model.order.OrderPosition;
import com.naild2d.android.model.order.OrderScheduleInfo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/23.
 */
public class Order extends JsonWrapper {
    private int id;
    private OrderPosition position;
    private OrderScheduleInfo schedule;
    private String date;
    private String time;
    private OrderPackageInfo pack;
    private OrderItem[] orderItems;


    public Order(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        date = json.getString("date");
        time = json.getString("time");

        String jString = json.getString("position");
        position = new OrderPosition(new JSONObject(jString));

        jString = json.getString("schedule");
        schedule = new OrderScheduleInfo(new JSONObject(jString));

        jString = json.getString("pack");
        pack = new OrderPackageInfo(new JSONObject(jString));

        jString = json.getString("orderItems");
        try {
            orderItems = new IndexJSONObject(jString).getObjectArray(OrderItem.class);
        } catch (Exception ex) {

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderPosition getPosition() {
        return position;
    }

    public void setPosition(OrderPosition position) {
        this.position = position;
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
}
