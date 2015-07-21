package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naild2d.android.R;
import com.naild2d.android.activity.extend.NailD2DAsyncHandler;
import com.naild2d.android.model.PackageInfo;
import com.naild2d.android.service.PackageService;

import java.util.ArrayList;


/**
 * Created by ebread on 2015/3/29.
 */
public class PackageListActivity extends NailD2DXListActivity<PackageInfo> {

    private PackageService packageService = null;

    @Override
    protected void fillItems(ArrayList<PackageInfo> items, String action) {

        items.add(new PackageInfo());

        doInBackground(new NailD2DAsyncHandler() {
            @Override
            public Object doAsync(Object... params) {
                return null;
            }

            @Override
            public void asyncSuccess(Object result) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packagelist);

        packageService = new PackageService(this);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.item_packge, null);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, PackageInfo data) {
        if (data == null)
            return;

        ImageView thumbNail = (ImageView) convertView.findViewById(R.id.item_thumbnail);
        TextView titleView = (TextView) convertView.findViewById(R.id.pkg_item_title);
        TextView aboutView = (TextView) convertView.findViewById(R.id.pkg_item_about);
        TextView shopView = (TextView) convertView.findViewById(R.id.pkg_item_shop);

//        titleView.setText(data.getTitle());
//        aboutView.setText(data.getAbout());
//        shopView.setText(data.getShop());
    }
}
