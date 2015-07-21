package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.naild2d.android.R;

import java.util.ArrayList;

public class MyOrderListActivity extends NailD2DXListActivity<Object> {

    @Override
    protected void fillItems(ArrayList<Object> items, String action) {
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_my_order_list);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, Object data) {

    }
}
