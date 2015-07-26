package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.naild2d.android.R;
import com.naild2d.android.component.MyImageView;
import com.naild2d.android.component.PriceTextView;
import com.naild2d.android.model.PackageInfo;

import java.util.ArrayList;


public class PackageDetailActivity extends NailD2DListActivity<Integer> {

    PackageInfo packageInfo = null;
    MyImageView pkgThumbnail = null;
    PriceTextView pkgPriceView = null;

    @Override
    protected boolean IsAutoAdjustListHeight() {
        return true;
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
        setContentView(R.layout.activity_package_detail);

        packageInfo = (PackageInfo) getTempData(PackageListActivity.TEMP_KEY_PKG_DETAILS);
        showMessage(packageInfo.getTitle());

        pkgThumbnail = (MyImageView) findViewById(R.id.pkg_thumbnail);
        pkgPriceView = (PriceTextView) findViewById(R.id.pkg_price);

        updateView();
    }

    private void updateView() {
        pkgThumbnail.setImageId(packageInfo.getThumbnail());

        String price = String.format("%03d", (int) packageInfo.getPrice());
        pkgPriceView.setPrice(price);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_service);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, Integer data) {

    }

}
