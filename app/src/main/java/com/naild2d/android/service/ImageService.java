package com.naild2d.android.service;

import com.naild2d.android.api.ImageApi;
import com.naild2d.android.json.IndexJsonObject;
import com.naild2d.android.model.Advertisement;

import org.json.JSONException;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class ImageService {
    ImageApi imageApi = null;

    public ImageService(){
        imageApi = new ImageApi();
    }

    public Advertisement[] getAdvs(){
        String jString = imageApi.getAds();
        try {
            IndexJsonObject json = new IndexJsonObject(jString);
            //Object[] array = json.getObjectArray(new Advertisement());
            //Advertisement[] advs = Arrays.copyOf(array,array.length,Advertisement[].class);
            return json.getObjectArray(Advertisement.class);
        } catch (JSONException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
