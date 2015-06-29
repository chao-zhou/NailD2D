package com.naild2d.android.service;

import android.content.Context;

/**
 * Created by ebread on 2015/6/29.
 */
public abstract class BaseService {
    protected Context context = null;

    public BaseService(Context context) {
        this.context = context;
    }
}
