package com.naild2d.android.activity.extend;

import android.os.AsyncTask;

/**
 * Created by ebread on 2015/7/20.
 */
public class NailD2DAsyncTask extends AsyncTask<Object, Object, Object> {
    private NailD2DAsyncHandler mHandler = null;

    public NailD2DAsyncTask(NailD2DAsyncHandler handler) {
        mHandler = handler;
    }

    public static NailD2DAsyncTask doInBackground(NailD2DAsyncHandler handler, Object... params) {
        NailD2DAsyncTask asyncTask = new NailD2DAsyncTask(handler);
        asyncTask.execute(params);
        return asyncTask;
    }

    @Override
    protected Object doInBackground(Object... params) {
        return mHandler.doAsync(params);
    }

    @Override
    protected void onPostExecute(Object o) {
        mHandler.asyncSuccess(o);
    }
}
