package com.naild2d.android.model;

import com.naild2d.android.json.JsonWrapper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/16.
 */
public class CouponInfo extends JsonWrapper {
    private int id;
    private CouponTemplate template;
    private String created;
    private String expired;
    private boolean enable;

    public CouponInfo() {
    }

    public CouponInfo(JSONObject json) throws JSONException {
        super(json);
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        id = json.getInt("id");
        created = json.getString("created");
        expired = json.getString("expired");
        enable = json.getBoolean("enable");

        String templateJString = json.getString("template");
        template = new CouponTemplate(new JSONObject(templateJString));

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CouponTemplate getTemplate() {
        return template;
    }

    public void setTemplate(CouponTemplate template) {
        this.template = template;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
