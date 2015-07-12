package com.naild2d.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ebread on 2015/6/30.
 */
public abstract class NailD2DActivity extends Activity {

    protected LayoutInflater layoutInflater = null;

    public void back(View view) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    protected void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showMessage(String msg, int duration) {
        Toast.makeText(this, msg, duration).show();
    }

    protected View getViewById(int id) {
        return layoutInflater.inflate(id, null);
    }
}
