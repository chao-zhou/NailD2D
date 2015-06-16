package com.naild2d.android.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.naild2d.android.service.PackageService;

/**
 * Created by ebread on 2015/3/21.
 */
public class ServicePackLoader extends AsyncTaskLoader<PackageService> {

    public ServicePackLoader(Context context) {
        super(context);
    }

    @Override
    public PackageService loadInBackground() {
        return null;
    }
}
