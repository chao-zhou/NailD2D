package com.naild2d.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naild2d.android.model.PackageInfo;

import java.util.ArrayList;


/**
 * Created by ebread on 2015/3/29.
 */
public class PackageListActivity extends NailD2DXListActivity<PackageInfo> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_packagelist;
    }

    @Override
    protected void fillItems(ArrayList<PackageInfo> items, String action) {
        for (int i = 0; i != 20; ++i) {
            PackageInfo pinfo = new PackageInfo();
            pinfo.setId(i);
            pinfo.setPrice(i * 10);
            pinfo.setTitle("T" + i);
            pinfo.setAbout("A" + i);
            pinfo.setShop("S" + i);

            items.add(pinfo);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        titleView.setText(data.getTitle());
        aboutView.setText(data.getAbout());
        shopView.setText(data.getShop());
    }
}
