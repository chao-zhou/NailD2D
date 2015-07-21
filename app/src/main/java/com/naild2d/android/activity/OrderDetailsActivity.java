package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naild2d.android.R;
import com.naild2d.android.model.order.OrderItem;
import com.naild2d.android.model.order.OrderServiceInfo;

import java.util.ArrayList;


public class OrderDetailsActivity extends NailD2DListActivity<OrderItem> {

    @Override
    protected void fillItems(ArrayList items) {
        for (int i = 0; i != 3; ++i) {
            OrderItem info = new OrderItem();
            info.setId(i);
            info.setPrice(i * 10);

            OrderServiceInfo serviceInfo = new OrderServiceInfo();
            serviceInfo.setName("N" + i);

            info.setService(serviceInfo);

            items.add(info);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_order_details);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, OrderItem data) {

        ImageView thumbnailView = (ImageView) convertView.findViewById(R.id.item_thumbnail);
        TextView nameView = (TextView) convertView.findViewById(R.id.item_name);
        TextView descriptionView = (TextView) convertView.findViewById(R.id.item_description);
        TextView shopView = (TextView) convertView.findViewById(R.id.item_shop);
        TextView priceView = (TextView) convertView.findViewById(R.id.item_price);
        TextView countView = (TextView) convertView.findViewById(R.id.item_count);

        nameView.setText(data.getService().getName());
        priceView.setText(String.valueOf(data.getPrice()));
    }
}
