package com.naild2d.android;

import android.view.View;
import android.view.ViewGroup;

import com.naild2d.android.model.CouponInfo;

import java.util.ArrayList;


public class OrderCouponActivity extends NailD2DListActivity<CouponInfo> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_coupon;
    }

    @Override
    protected void fillItems(ArrayList<CouponInfo> items) {
        for (int i = 0; i < 10; i++) {
            items.add(new CouponInfo());
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_order_coupon);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, CouponInfo data) {

    }
}
