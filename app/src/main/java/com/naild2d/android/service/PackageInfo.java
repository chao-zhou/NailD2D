package com.naild2d.android.service;

/**
 * Created by chao_zhou on 15/1/26.
 */
public class PackageInfo {
    private int id;
    private String title;
    private double price;
    private int thumbnail;
    private int wty;
    private String shop;
    private String about;

    private double attitude;
    private double quality;
    private double punctual;
    private double post;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
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
}
