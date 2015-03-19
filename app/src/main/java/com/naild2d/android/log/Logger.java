package com.naild2d.android.log;

import android.util.Log;

/**
 * Created by ebread on 2015/3/19.
 */
public class Logger {

    private final static String tag = "naild2d";

    public static void e(Throwable tr){
        Log.e(tag, tr.getMessage(), tr);
    }

    public static void e(String msg, Throwable tr){
        Log.e(tag, msg, tr);
    }

}
