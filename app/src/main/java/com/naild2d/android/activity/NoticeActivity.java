package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.naild2d.android.R;
import com.naild2d.android.model.Notice;

import java.util.ArrayList;


public class NoticeActivity extends NailD2DXListActivity<Notice> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notice;
    }

    @Override
    protected void fillItems(ArrayList<Notice> items, String action) {
        for (int i = 0; i < 3; i++) {
            Notice notice = new Notice();
            notice.setDate("2015-01-01");
            notice.setTime("01:01:01");
            notice.setMessage("Message" + i);
            items.add(notice);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewById(R.layout.item_notice);
    }

    @Override
    public void bindData(int position, View convertView, ViewGroup parent, Notice data) {

    }
}
