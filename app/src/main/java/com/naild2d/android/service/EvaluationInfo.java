package com.naild2d.android.service;

import java.util.Date;

/**
 * Created by chao_zhou on 15/1/26.
 */
public class EvaluationInfo {
    private int id;
    private Date date;
    private String user;
    private double attitude;
    private double quality;
    private double punctual;
    private double post;
    private String comment;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
