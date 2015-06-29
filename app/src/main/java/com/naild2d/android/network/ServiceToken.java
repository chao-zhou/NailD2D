package com.naild2d.android.network;

import android.content.Context;

import com.naild2d.android.storage.SettingsStorageHelper;

/**
 * Created by ebread on 2015/3/8.
 */
public class ServiceToken {
    // Use for David Computer
    //public static String CUSTOMER_ID = "e223f0bcd548fc6343a366df32f30bae05503c37b";
    //public static String CUSTOMER_SECRET = "7b1b4436c6491959de56a1eba3c29847";

    //public static final String CUSTOMER_ID = "b2859f4e474373fe5c7b108adb33e7e405503dc0c";
    //public static String CUSTOMER_SECRET = "c15c27f09aa17a78bc8fa55558cf06ed";

    public static final String CUSTOMER_ID = "67d5832a74e8540f70b1afc9052a9d48054f191a6";
    public static String CUSTOMER_SECRET = "99c6af7336eedc11d322364f2b159d56";

    public static String REQUEST_TOKEN = null;
    public static String REQUEST_SECRET = null;

    public static String ACCESS_TOKEN = null;
    public static String ACCESS_SECRET = null;

    public static void save(Context context) {
        SettingsStorageHelper helper = SettingsStorageHelper.getInstance(context);
        helper.save("ACCESS_TOKEN", ACCESS_TOKEN);
        helper.save("ACCESS_SECRET", ACCESS_SECRET);
    }

    public static void load(Context context) {
        SettingsStorageHelper helper = SettingsStorageHelper.getInstance(context);
        ACCESS_TOKEN = helper.load("ACCESS_TOKEN");
        ACCESS_SECRET = helper.load("ACCESS_SECRET");
    }
}
