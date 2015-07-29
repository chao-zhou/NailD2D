package com.naild2d.android.activity.transfer;

import java.util.HashMap;

/**
 * Created by ebread on 2015/7/26.
 */
public class GlobalData {

    private static HashMap<String, Object> tempData = null;

    static {
        tempData = new HashMap<>();
    }

    public static void setData(String key, Object value) {
        if (tempData.containsKey(key)) {
            tempData.remove(key);
        }

        tempData.put(key, value);
    }

    public static Object getData(String key) {
        if (!tempData.containsKey(key)) {
            return null;
        }

        Object value = tempData.get(key);
        return value;
    }
}
