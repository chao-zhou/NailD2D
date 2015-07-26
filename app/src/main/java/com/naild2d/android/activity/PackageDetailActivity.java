package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naild2d.android.R;
import com.naild2d.android.component.ImageTextView;
import com.naild2d.android.component.MyImageView;
import com.naild2d.android.component.PriceTextView;
import com.naild2d.android.model.PackageInfo;

import java.util.ArrayList;


public class PackageDetailActivity extends NailD2DListActivity<Integer> {

    private PackageInfo packageInfo = null;

    private MyImageView pkgThumbnail = null;
    private PriceTextView pkgPriceView = null;
    private TextView pkgAboutView = null;
    private ImageTextView usageView = null;
    private ImageTextView evaluationView = null;
    private ImageTextView shopNameView = null;

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
        pkgAboutView = (TextView) findViewById(R.id.pkg_description);
        usageView = (ImageTextView) findViewById(R.id.pkg_usage);
        evaluationView = (ImageTextView) findViewById(R.id.pkg_evaluation_count);
        shopNameView = (ImageTextView) findViewById(R.id.pkg_shop_name);

        updateView();
    }

    private void updateView() {
        pkgThumbnail.setImageId(packageInfo.getThumbnail());

        String price = String.format("%03d", (int) packageInfo.getPrice());
        pkgPriceView.setPrice(price);

        setUsage(packageInfo.getServed());
        setEvaluationCount((int) packageInfo.getEcount());

        pkgAboutView.setText(packageInfo.getAbout());
        shopNameView.setText(packageInfo.getShop());

    }

    private void setEvaluationCount(int count) {
        String format = getString(R.string.string_format_package_evaluation_count);
        String value = String.format(format, count);
        evaluationView.setText(value);
    }

    private void setUsage(int count) {
        String format = getString(R.string.string_format_package_usage);
        String value = String.format(format, count);
        usageView.setText(value);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_service);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, Integer data) {

    }

}
