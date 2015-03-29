package com.naild2d.android.loaders;

import android.content.Context;
import android.support.v4.content.Loader;

import com.naild2d.android.model.PackageListItem;

/**
 * Created by ebread on 2015/3/21.
 */
public class PackageListLoader extends Loader<PackageListItem> {
    public PackageListLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    @Override
    protected void onAbandon() {
        super.onAbandon();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }
}
