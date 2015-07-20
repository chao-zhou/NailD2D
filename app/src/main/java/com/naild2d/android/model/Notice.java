package com.naild2d.android.model;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/23.
 */
public class Notice extends JsonWrapper {
    private int id;
    private String date;
    private String time;
    private String message;
    private boolean read;
    private String page;
    private int pid;

    public Notice() {
    }

    public Notice(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        date = json.getString("date");
        time = json.getString("time");
        message = json.getString("message");
        read = json.getBoolean("read");
        page = json.getString("page");
        pid = json.getInt("pid");
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
