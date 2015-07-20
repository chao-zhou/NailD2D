package com.naild2d.android.activity.extend;

/**
 * Created by ebread on 2015/7/20.
 */
public interface NailD2DAsyncHandler {
    Object doAsync(Object... params);

    void asyncSuccess(Object result);
}
