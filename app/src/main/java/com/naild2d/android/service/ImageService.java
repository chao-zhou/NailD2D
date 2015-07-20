package com.naild2d.android.service;

import android.content.Context;

import com.naild2d.android.api.ImageApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.Advertisement;

import org.json.JSONObject;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class ImageService extends BaseService {

    public static final String DEVICE_IPHONE_X2 = "ix2";
    public static final String DEVICE_IPHONE_X3 = "ix3";
    public static final String DEVICE_ANDROID_LOW = "al";
    public static final String DEVICE_ANDROID_HIGH = "ah";

    private ImageApi imageApi = null;

    public ImageService(Context context) {
        super(context);
        imageApi = new ImageApi();
    }

    public Advertisement[] getAdvs() {
        String jString = imageApi.getAds();
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(Advertisement.class);
        } catch (Exception e) {
            Logger.e(e);
        }

        return null;
    }

    public byte[] getThumbnail(String id) {
        return imageApi.getThumbnail(id);
    }

    public byte[] getImage(String id, String device) {
        return imageApi.getImage(id, device);
    }

    public int upload(byte[] bytes) {
        String jString = imageApi.getAds();
        try {
            JSONObject json = new JSONObject(jString);
            return json.getInt("pic");
        } catch (Exception e) {
            Logger.e(e);
        }
        return -1;
    }
}
