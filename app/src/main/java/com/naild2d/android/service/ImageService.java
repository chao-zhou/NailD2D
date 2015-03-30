package com.naild2d.android.service;

import com.naild2d.android.api.ImageApi;
import com.naild2d.android.json.IndexJsonObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.Advertisement;

import org.json.JSONException;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class ImageService {
    private ImageApi imageApi = null;

    public ImageService(){
        imageApi = new ImageApi();
    }

    public Advertisement[] getAdvs(){
        String jString = imageApi.getAds();
        try {
            IndexJsonObject json = new IndexJsonObject(jString);
            return json.getObjectArray(Advertisement.class);
        } catch (JSONException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            Logger.e(e);
        }

        return null;
    }
}
