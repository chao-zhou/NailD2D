package com.naild2d.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naild2d.android.R;
import com.naild2d.android.activity.extend.NailD2DAsyncHandler;
import com.naild2d.android.model.CouponInfo;
import com.naild2d.android.model.UserProfile;
import com.naild2d.android.service.CouponService;

import java.util.ArrayList;


public class MyCouponActivity extends NailD2DListActivity<CouponInfo> {

    CouponService couponService = null;

    @Override
    protected void fillItems(final ArrayList<CouponInfo> items) {
//        for (int i = 0; i < 10; i++) {
//            items.add(new CouponInfo());
//        }

        doInBackground(new NailD2DAsyncHandler() {
            @Override
            public Object doAsync(Object... params) {
                return couponService.getOnDoorCoupons(0, 10);
            }

            @Override
            public void asyncSuccess(Object result) {
                if (result == null) {
                    return;
                }

                CouponInfo[] infos = (CouponInfo[]) result;
                for (CouponInfo info : infos) {
                    items.add(info);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_coupon);

        if (UserProfile.getUserProfile() == null) {
            startActivity(new Intent(this, LoginActivity.class));
        }

        couponService = new CouponService(this);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_order_coupon);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, CouponInfo data) {
        TextView priceView = (TextView) convertView.findViewById(R.id.item_price);
        TextView nameView = (TextView) convertView.findViewById(R.id.item_name);
        TextView dateView = (TextView) convertView.findViewById(R.id.item_date);

        priceView.setText(data.getTemplate().getValue());
        nameView.setText(data.getTemplate().getName());
        dateView.setText(data.getExpired());
    }
}
