package com.naild2d.android.model;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/3/21.
 */
public class PackageInfo extends JsonWrapper {

    private int id;
    private String title;
    private int thumbnail;
    private double price;
    private int wty;
    private String shop;
    private String about;
    private double attitude;
    private double quality;
    private double punctual;
    private double post;
    private double ecount;
    private int served;

    public PackageInfo(JSONObject json) throws JSONException {
        super(json);
    }


    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        title = json.getString("title");
        thumbnail = json.getInt("thumbnail");
        wty = json.getInt("wty");
        shop = json.getString("shop");
        about = json.getString("about");
        attitude = json.getDouble("attitude");
        quality = json.getDouble("quality");
        punctual = json.getDouble("punctual");
        post = json.getDouble("post");
        ecount = json.getDouble("ecount");
        served = json.getInt("served");
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

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public double getAttitude() {
        return attitude;
    }

    public void setAttitude(double attitude) {
        this.attitude = attitude;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getPunctual() {
        return punctual;
    }

    public void setPunctual(double punctual) {
        this.punctual = punctual;
    }

    public double getPost() {
        return post;
    }

    public void setPost(double post) {
        this.post = post;
    }

    public double getEcount() {
        return ecount;
    }

    public void setEcount(double ecount) {
        this.ecount = ecount;
    }

    public int getServed() {
        return served;
    }

    public void setServed(int served) {
        this.served = served;
    }
}
