package com.naild2d.android.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.naild2d.android.activity.extend.NailD2DAsyncHandler;
import com.naild2d.android.activity.extend.NailD2DAsyncTask;
import com.naild2d.android.activity.extend.NailD2DTimerMessageHandler;
import com.naild2d.android.activity.extend.NailD2DTimerTask;
import com.naild2d.android.activity.transfer.TempData;

import java.util.Timer;

/**
 * Created by ebread on 2015/6/30.
 */
public abstract class NailD2DActivity extends Activity {

    protected NailD2DAsyncTask asyncTask = null;
    protected Timer timer = null;
    protected LayoutInflater layoutInflater = null;

    public void back(View view) {
        finish();
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    ///View
    protected View getViewById(int id) {
        return layoutInflater.inflate(id, null);
    }


    ///Toast Message
    protected void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showMessage(String msg, int duration) {
        Toast.makeText(this, msg, duration).show();
    }


    ///Timer
    protected void starTimer(NailD2DTimerMessageHandler handler, long delay, long period) {
        timer = NailD2DTimerTask.startTimer(handler, delay, period);
    }

    protected void stopTimer() {
        timer.cancel();
    }

    ///Background
    protected void doInBackground(NailD2DAsyncHandler handler, Object... params) {
        asyncTask = NailD2DAsyncTask.doInBackground(handler, params);
    }

    //Data
    public void setTempData(String key, Object value) {
        TempData.setData(key, value);
    }

    public Object getTempData(String key) {
        return TempData.getData(key);
    }

    //View
    protected View getRootView() {
        return ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
    }
}

