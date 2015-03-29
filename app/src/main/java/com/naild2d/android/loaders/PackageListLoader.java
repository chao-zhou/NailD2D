package com.naild2d.android.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.naild2d.android.model.PackageListItem;

/**
 * Created by ebread on 2015/3/21.
 */
public class PackageListLoader extends AsyncTaskLoader<PackageListItem> {

    public PackageListLoader(Context context) {
        super(context);
    }

    @Override
    public PackageListItem loadInBackground() {
        return null;
    }
}
