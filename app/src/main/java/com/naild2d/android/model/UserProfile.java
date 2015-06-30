package com.naild2d.android.model;

import android.content.Context;

import com.naild2d.android.json.JsonWrapper;
import com.naild2d.android.storage.SettingsStorageHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/15.
 */
public class UserProfile extends JsonWrapper {

    public static final String SettingKey = "UserProfile";
    private static UserProfile userProfile = null;

    private String nickName;
    private String avatar;
    private String phone;
    private String verifier;

    public UserProfile(String jString) throws JSONException {
        super(new JSONObject(jString));
    }

    public UserProfile(JSONObject json) throws JSONException {
        super(json);
    }

    public static UserProfile getUserProfile() {
        return userProfile;
    }

    public static void setUserProfile(UserProfile profile) {
        userProfile = profile;
    }

    public static void save(Context context) {
        if (userProfile == null)
            return;

        SettingsStorageHelper helper = SettingsStorageHelper.getInstance(context);
        helper.save(SettingKey, userProfile.toString());
    }

    public static void load(Context context) {
        if (userProfile != null)
            return;

        SettingsStorageHelper helper = SettingsStorageHelper.getInstance(context);
        String value = helper.load(SettingKey);
        if (value == null)
            return;

        try {
            userProfile = new UserProfile(value);
        } catch (JSONException e) {

        }
    }

    @Override
    protected void wrap(JSONObject json) throws JSONException {
        nickName = json.getString("nickname");
        avatar = json.getString("avatar");
        phone = json.getString("phone");
        verifier = json.getString("verifier");
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nickname", nickName);
            jsonObject.put("avatar", avatar);
            jsonObject.put("phone", phone);
            jsonObject.put("verifier", verifier);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }



}
