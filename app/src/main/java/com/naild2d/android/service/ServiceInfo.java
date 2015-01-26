package com.naild2d.android.service;

/**
 * Created by chao_zhou on 15/1/26.
 */
public class ServiceInfo {
    private int id;
    private String name;
    private int thumbnail;
    private double price;
    private String about;
    private int wty;
    private int served;

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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getWty() {
        return wty;
    }

    public void setWty(int wty) {
        this.wty = wty;
    }

    public int getServed() {
        return served;
    }

    public void setServed(int served) {
        this.served = served;
    }
}
