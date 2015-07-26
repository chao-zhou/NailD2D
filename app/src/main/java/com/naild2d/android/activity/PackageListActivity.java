package com.naild2d.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naild2d.android.R;
import com.naild2d.android.activity.extend.NailD2DAsyncHandler;
import com.naild2d.android.component.MyImageView;
import com.naild2d.android.model.PackageInfo;
import com.naild2d.android.service.PackageService;

import java.util.ArrayList;


/**
 * Created by ebread on 2015/3/29.
 */
public class PackageListActivity extends NailD2DXListActivity<PackageInfo> {

    public static final String TEMP_KEY_PKG_DETAILS = "package_details";


    private static final int PAGE_SIZE = 10;
    private static final long MIN_LOCATION_REFRESH_TIME = 5 * 1000;
    private static final float MIN_LOCATION_REFRESH_DISTANT = 1000;

    private static final double TEST_LAT = 40.070671;
    private static final double TEST_LON = 116.410316;

    private int pageIndex = 0;
    private PackageService packageService = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packagelist);

        packageService = new PackageService(this);
    }

    @Override
    protected void fillItems(final ArrayList<PackageInfo> items, String action) {

        switch (action) {
            case FILL_ITEMS_ACTION_CREATE:
                items.clear();
                pageIndex = 0;
                break;
            case FILL_ITEMS_ACTION_REFRESH:
                items.clear();
                pageIndex = 0;
                break;
            case FILL_ITEMS_ACTION_MORE:
                pageIndex += 1;
                break;
        }

        getPackageListInfo(items);
    }

    private void getPackageListInfo(final ArrayList<PackageInfo> items) {
        doInBackground(new NailD2DAsyncHandler() {
            @Override
            public Object doAsync(Object... params) {
                PackageInfo[] packageInfoArray
                        = packageService.getPackageInfo(TEST_LAT, TEST_LON, PAGE_SIZE, pageIndex);
                return packageInfoArray;
            }

            @Override
            public void asyncSuccess(Object result) {
                if (result == null) return;

                PackageInfo[] packageInfoArray = (PackageInfo[]) result;
                for (PackageInfo info : packageInfoArray) {
                    items.add(info);
                }

                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.item_packge, null);
    }

    @Override
    public void bindData(final int position, View convertView, ViewGroup parent, PackageInfo data) {
        if (data == null)
            return;

        MyImageView thumbNail = (MyImageView) convertView.findViewById(R.id.item_thumbnail);
        TextView titleView = (TextView) convertView.findViewById(R.id.pkg_item_title);
        TextView aboutView = (TextView) convertView.findViewById(R.id.pkg_item_about);
        TextView shopView = (TextView) convertView.findViewById(R.id.pkg_item_shop);
        TextView priceView = (TextView) convertView.findViewById(R.id.pkg_item_yuan_value);

        thumbNail.setImageId(data.getThumbnail());
        titleView.setText(data.getTitle());
        aboutView.setText(data.getAbout());
        shopView.setText(data.getShop());

        String price = String.format("% 3d", (int) data.getPrice());
        priceView.setText(price);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageListActivity.this.switchToDetail(position);
            }
        });
    }


    private void switchToDetail(int position) {
        setTempData(TEMP_KEY_PKG_DETAILS, items.get(position));
        Intent intent = new Intent(this, PackageDetailActivity.class);
        startActivity(intent);
    }
}
