package com.naild2d.android.json;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class IndexJsonObject {

    private JSONObject json = null;

    public IndexJsonObject(String jsonStr) throws JSONException {
        json = new JSONObject(jsonStr);
    }

    private static <T extends JsonWrapper> T getObject(Class<T> clazz, JSONObject json)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return clazz.getDeclaredConstructor(JSONObject.class).newInstance(json);
    }

    public int length() {
        return json.length();
    }

    public <T extends JsonWrapper> T[] getObjectArray(Class<T> clazz)
            throws JSONException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<T> list = new ArrayList<>();
        Iterator<String> it = json.keys();
        while (it.hasNext()) {
            String key = it.next();
            JSONObject jObj = json.getJSONObject(key);
            list.add(getObject(clazz, jObj));
        }
        T[] tArray = (T[]) Array.newInstance(clazz, list.size());
        return list.toArray(tArray);
    }

    public <T extends JsonWrapper> T getObject(Class<T> clazz)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return getObject(clazz, json);
    }

    public int[] getIntArray() throws JSONException {
        List<Integer> list = new ArrayList<>();
        Iterator<String> it = json.keys();
        while (it.hasNext()) {
            String key = it.next();
            int val = json.getInt(key);
            list.add(val);
        }

        int[] ints = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            ints[index] = list.get(index);
        }
        return ints;
    }
}
