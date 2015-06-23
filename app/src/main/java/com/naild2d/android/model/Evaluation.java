package com.naild2d.android.model;

import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/23.
 */
public class Evaluation extends JsonWrapper {
    private int id;
    private double post;
    private double attitude;
    private double quality;
    private double punctual;
    private String date;
    private String time;
    private String comment;
    private int[] pic;

    public Evaluation(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        post = json.getDouble("post");
        attitude = json.getDouble("attitude");
        quality = json.getDouble("quality");
        punctual = json.getDouble("punctual");
        date = json.getString("date");
        time = json.getString("time");
        comment = json.getString("comment");
        try {
            pic = new IndexJSONObject(json.getString("pic")).getIntArray();
        } catch (Exception e) {

        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPost() {
        return post;
    }

    public void setPost(double post) {
        this.post = post;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int[] getPic() {
        return pic;
    }

    public void setPic(int[] pic) {
        this.pic = pic;
    }
}
