package com.naild2d.android.network.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ebread on 2015/6/24.
 */
public class HttpPostBody {
    private Map<String, String> keyValueMap = new HashMap<>();

    public HttpPostBody(String body) {
        String[] keyValuePairs = body.split("&");
        for (String pair : keyValuePairs) {
            String[] values = pair.split("=");
            keyValueMap.put(values[0], values[1]);
        }
    }

    public String getValue(String key) {
        return keyValueMap.get(key);
    }

    public boolean containKey(String key) {
        return keyValueMap.containsKey(key);
    }
}
