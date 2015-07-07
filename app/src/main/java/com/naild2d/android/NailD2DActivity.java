package com.naild2d.android;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ebread on 2015/6/30.
 */
public abstract class NailD2DActivity extends Activity {

    public void back(View view) {
        finish();
    }

    protected void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showMessage(String msg, int duration) {
        Toast.makeText(this, msg, duration).show();
    }
}
