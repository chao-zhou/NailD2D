package com.naild2d.android.model;

import com.naild2d.android.json.JsonWrapper;
import com.naild2d.android.model.shop.ShopPosition;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/18.
 */
public class ShopInfo extends JsonWrapper {
    private int id;
    private String name;
    private ShopPosition position;
    private String phone;
    private String pic;
    private double distance;

    public ShopInfo(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        name = json.getString("name");
        phone = json.getString("phone");
        pic = json.getString("pic");
        distance = json.getDouble("distance");

        String jString = json.getString("position");
        position = new ShopPosition(new JSONObject(jString));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopPosition getPosition() {
        return position;
    }

    public void setPosition(ShopPosition position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
