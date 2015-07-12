package com.naild2d.android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.naild2d.android.component.PriceTextView;
import com.naild2d.android.model.ServiceInfo;

import java.util.ArrayList;


public class PendingOrderListActivity extends NailD2DListActivity<ServiceInfo> {

    private TextView txtAddress = null;
    private TextView txtTime = null;
    private TextView txtComment = null;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_pending_order_list;
    }

    @Override
    protected boolean IsAutoAdjustListHeight() {
        return true;
    }

    ;

    @Override
    protected void fillItems(ArrayList<ServiceInfo> items) {
        for (int i = 0; i != 3; ++i) {
            ServiceInfo info = new ServiceInfo();
            info.setId(i);
            info.setPrice(i * 10);
            info.setName("N" + i);
            items.add(info);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txtAddress = (TextView) findViewById(R.id.address);
        txtTime = (TextView) findViewById(R.id.time);
        txtComment = (TextView) findViewById(R.id.comment);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.item_pending_order_list, null);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, ServiceInfo data) {

        ImageView thumbNail = (ImageView) convertView.findViewById(R.id.item_thumbnail);
        TextView nameView = (TextView) convertView.findViewById(R.id.item_name);
        PriceTextView priceView = (PriceTextView) convertView.findViewById(R.id.item_price);

        nameView.setText(data.getName());
        priceView.setPrice(String.valueOf(data.getPrice()));

    }

    public void submit(View view) {

    }

    public void switchActivity(View view) {
        String tag = view.getTag().toString();
        Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();
    }
}

