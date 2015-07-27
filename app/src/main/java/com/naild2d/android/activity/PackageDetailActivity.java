package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.naild2d.android.R;
import com.naild2d.android.activity.extend.NailD2DAsyncHandler;
import com.naild2d.android.component.ImageTextView;
import com.naild2d.android.component.MyImageView;
import com.naild2d.android.component.OrderDatePanelView;
import com.naild2d.android.component.PriceTextView;
import com.naild2d.android.component.ToggleServiceThumbnailView;
import com.naild2d.android.model.PackageInfo;
import com.naild2d.android.model.ServiceInfo;
import com.naild2d.android.service.PackageService;

import java.util.ArrayList;


public class PackageDetailActivity extends NailD2DListActivity<ServiceInfo> {

    private PackageInfo packageInfo = null;

    private MyImageView pkgThumbnail = null;
    private PriceTextView pkgPriceView = null;
    private TextView pkgAboutView = null;
    private ImageTextView usageView = null;
    private ImageTextView evaluationView = null;
    private ImageTextView shopNameView = null;
    private OrderDatePanelView pkgScheduleView = null;
    private ScrollView pkgScrollView = null;

    private PackageService packageService = null;


    @Override
    protected boolean IsAutoAdjustListHeight() {
        return true;
    }

    @Override
    protected void fillItems(final ArrayList items) {
        doInBackground(new NailD2DAsyncHandler() {
            @Override
            public Object doAsync(Object... params) {
                return packageService.getServiceInfoList(String.valueOf(packageInfo.getId()), 0, 10);
            }

            @Override
            public void asyncSuccess(Object result) {
                ServiceInfo[] serviceInfoArray = (ServiceInfo[]) result;
                for (ServiceInfo info : serviceInfoArray) {
                    items.add(info);
                }
                myAdapter.notifyDataSetChanged();
                refreshListView();
                pkgScrollView.scrollTo(0, 0);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_detail);

        packageInfo = (PackageInfo) getTempData(PackageListActivity.TEMP_KEY_PKG_DETAILS);
        packageService = new PackageService(this);

        pkgThumbnail = (MyImageView) findViewById(R.id.pkg_thumbnail);
        pkgPriceView = (PriceTextView) findViewById(R.id.pkg_price);
        pkgAboutView = (TextView) findViewById(R.id.pkg_description);
        usageView = (ImageTextView) findViewById(R.id.pkg_usage);
        evaluationView = (ImageTextView) findViewById(R.id.pkg_evaluation_count);
        shopNameView = (ImageTextView) findViewById(R.id.pkg_shop_name);
        pkgScheduleView = (OrderDatePanelView) findViewById(R.id.pkg_schedule);
        pkgScrollView = (ScrollView) findViewById(R.id.pkg_scroll);

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

        pkgScheduleView.setPackageId(packageInfo.getId());

        pkgScheduleView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pkgScheduleView.setVisibility(View.GONE);
            }
        });
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
    public void bindData(int position, View convertView, ViewGroup parent, ServiceInfo data) {
        if (packageInfo == null) {
            return;
        }


        ToggleServiceThumbnailView service1 = (ToggleServiceThumbnailView) convertView.findViewById(R.id.item_service1);
        if (position * 2 < items.size()) {
            ServiceInfo serviceInfo1 = items.get(position * 2);
            service1.setImageId(serviceInfo1.getPic());
            service1.setServiceName(serviceInfo1.getName());
            service1.setServicePrice(serviceInfo1.getPrice());
        } else {
            service1.setVisibility(View.INVISIBLE);
        }

        ToggleServiceThumbnailView service2 = (ToggleServiceThumbnailView) convertView.findViewById(R.id.item_service2);
        if (position * 2 + 1 < items.size()) {
            ServiceInfo serviceInfo2 = items.get(position * 2 + 1);
            service2.setImageId(serviceInfo2.getPic());
            service2.setServiceName(serviceInfo2.getName());
            service2.setServicePrice(serviceInfo2.getPrice());
            service2.setVisibility(View.VISIBLE);

        } else {
            service2.setVisibility(View.INVISIBLE);
        }
    }


    public void showSchedule(View view) {
        pkgScheduleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (pkgScheduleView.getVisibility() == View.VISIBLE) {
            pkgScheduleView.setVisibility(View.GONE);
            return;
        }

        super.onBackPressed();
    }
}
