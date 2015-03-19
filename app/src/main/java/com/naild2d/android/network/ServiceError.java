package com.naild2d.android.network;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ebread on 2015/3/17.
 */
public class ServiceError {

    private static final Map<Integer,String> statusCodeErrorMap;

    static {
        statusCodeErrorMap = new HashMap<>();
        statusCodeErrorMap.put(400, "Bad Request");
        statusCodeErrorMap.put(404, "Not Found");
        statusCodeErrorMap.put(204, "No Content");
        statusCodeErrorMap.put(401, "Unauthorized");
        statusCodeErrorMap.put(500, "Server Error ");
    }

    public static boolean isSuccess(int code){
        return !statusCodeErrorMap.containsKey(code);
    }

    public static String getErrorMsg(int code) {
        if(isSuccess(code))
            return null;
        return statusCodeErrorMap.get(code);
    }

    public static Exception getError(int code){
        if(isSuccess(code))
            return null;
        return new Exception(getErrorMsg(code));
    }

    public static void riseError(int code) throws Exception{
        if(isSuccess(code))
            return;
        throw  getError(code);
    }
}
