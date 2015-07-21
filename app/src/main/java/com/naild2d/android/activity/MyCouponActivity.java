package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.naild2d.android.R;
import com.naild2d.android.model.CouponInfo;

import java.util.ArrayList;


public class MyCouponActivity extends NailD2DListActivity<CouponInfo> {


    @Override
    protected void fillItems(ArrayList<CouponInfo> items) {
        for (int i = 0; i < 10; i++) {
            items.add(new CouponInfo());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_coupon);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_order_coupon);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, CouponInfo data) {

    }
}
