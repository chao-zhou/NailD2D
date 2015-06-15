package com.naild2d.android.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.naild2d.android.service.ServicePack;

/**
 * Created by ebread on 2015/3/21.
 */
public class ServicePackLoader extends AsyncTaskLoader<ServicePack> {

    public ServicePackLoader(Context context) {
        super(context);
    }

    @Override
    public ServicePack loadInBackground() {
        return null;
    }
}
