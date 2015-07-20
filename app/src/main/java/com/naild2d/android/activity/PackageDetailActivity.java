package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.naild2d.android.R;

import java.util.ArrayList;


public class PackageDetailActivity extends NailD2DListActivity<Integer> {

    @Override
    protected boolean IsAutoAdjustListHeight() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_package_detail;
    }

    @Override
    protected void fillItems(ArrayList items) {
        for (int i = 0; i < 3; i++) {
            items.add(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_package_detail);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_service);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, Integer data) {

    }

}
