package com.naild2d.android.model.order;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/3/21.
 */
public class OrderPackageInfo extends JsonWrapper {

    private int id;
    private String title;
    private int thumbnail;
    private double price;
    private int wty;
    private OrderShop shop;


    public OrderPackageInfo(JSONObject json) throws JSONException {
        super(json);
    }


    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        title = json.getString("title");
        thumbnail = json.getInt("thumbnail");
        wty = json.getInt("wty");
        String jString = json.getString("shop");
        shop = new OrderShop(new JSONObject(jString));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWty() {
        return wty;
    }

    public void setWty(int wty) {
        this.wty = wty;
    }

    public OrderShop getShop() {
        return shop;
    }

    public void setShop(OrderShop shop) {
        this.shop = shop;
    }
}
