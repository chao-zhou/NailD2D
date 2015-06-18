package com.naild2d.android.model;

import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/15.
 */
public class Evaluation extends JsonWrapper {
    private int id;
    private String date;
    private String time;
    private UserProfile user;
    private String comment;
    private int[] pics;

    public Evaluation(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        date = json.getString("date");
        time = json.getString("time");
        comment = json.getString("comment");
        user = new UserProfile(json.getJSONObject("user"));
        pics = new IndexJSONObject(json.getString("pics")).getIntArray();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int[] getPics() {
        return pics;
    }

    public void setPics(int[] pics) {
        this.pics = pics;
    }
}
