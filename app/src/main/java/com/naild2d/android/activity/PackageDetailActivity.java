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
import com.naild2d.android.component.ServiceThumbnailClickEventListener;
import com.naild2d.android.component.ToggleServiceThumbnailView;
import com.naild2d.android.model.PackageInfo;
import com.naild2d.android.model.PackageScheduleInfo;
import com.naild2d.android.model.ServiceInfo;
import com.naild2d.android.service.PackageService;

import java.util.ArrayList;
import java.util.List;


public class PackageDetailActivity extends NailD2DListActivity<ServiceInfo[]> {

    public final static String GLOBAL_KEY_SELECTED_SERVICES = "selected_services";

    public final static String TEMP_KEY_SELECTED_SERVICE = "selected_service";
    public final static String TEMP_KEY_SELECTED_SCHEDULE = "selected_schedule";


    private PackageInfo packageInfo = null;
    private List<ServiceInfo> selectedServices = null;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_detail);

        packageInfo = (PackageInfo) getTempData(PackageListActivity.TEMP_KEY_PKG_DETAILS);
        packageService = new PackageService(this);

        selectedServices = new ArrayList<>();
        setGlobalData(GLOBAL_KEY_SELECTED_SERVICES, selectedServices);

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

    //----------------------------------------------
    // Order
    //----------------------------------------------
    public void submitOrder(View view) {
        PackageScheduleInfo scheduleInfo = pkgScheduleView.getSelectedSchedule();
        if (scheduleInfo == null) {
            showMessage("Please select schedule");
            showSchedule(null);
            return;
        }
        setTempData(TEMP_KEY_SELECTED_SCHEDULE, scheduleInfo);

        if (selectedServices.size() < 1) {
            showMessage("Please select one service at least.");
            return;
        }


        String orderInfo = "";
        orderInfo += String.format("Schedule: %s %s", scheduleInfo.getDate(), scheduleInfo.getTime());
        orderInfo += String.format("First Service: %s", selectedServices.get(0).getName());
        showMessage(orderInfo);

    }


    //-----------------------------------------------
    // Package Info
    //-----------------------------------------------
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


    //-----------------------------------------------
    // List View
    //-----------------------------------------------
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
                for (int i = 0; i < serviceInfoArray.length; i += 2) {
                    if (i + 1 < serviceInfoArray.length) {
                        items.add(new ServiceInfo[]{serviceInfoArray[i], serviceInfoArray[i + 1]});
                        continue;
                    }

                    items.add(new ServiceInfo[]{serviceInfoArray[i], null});
                }
                myAdapter.notifyDataSetChanged();
                refreshListView();
                pkgScrollView.scrollTo(0, 0);

            }
        });
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_service);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, ServiceInfo[] data) {
        if (packageInfo == null) {
            return;
        }

        ToggleServiceThumbnailView thumbnailView1 = (ToggleServiceThumbnailView) convertView.findViewById(R.id.item_service1);
        updateServiceThumbnailView(thumbnailView1, data[0]);

        ToggleServiceThumbnailView thumbnailView2 = (ToggleServiceThumbnailView) convertView.findViewById(R.id.item_service2);
        updateServiceThumbnailView(thumbnailView2, data[1]);

    }

    private void updateServiceThumbnailView(ToggleServiceThumbnailView thumbnailView, final ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            thumbnailView.setVisibility(View.INVISIBLE);
            return;
        }

        thumbnailView.setImageId(serviceInfo.getPic());
        thumbnailView.setServiceName(serviceInfo.getName());
        thumbnailView.setServicePrice(serviceInfo.getPrice());
        thumbnailView.setVisibility(View.VISIBLE);
        thumbnailView.setClickEventListener(new ServiceThumbnailClickEventListener() {
            @Override
            public void click(ToggleServiceThumbnailView view) {
                if (!view.isChecked()) {
                    view.setChecked(true);
                    selectedServices.add(serviceInfo);
                } else {
                    view.setChecked(false);
                    selectedServices.remove(serviceInfo);
                }


            }
        });
    }


    //----------------------------------------------
    //  Order Schedule Panel
    //----------------------------------------------
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
