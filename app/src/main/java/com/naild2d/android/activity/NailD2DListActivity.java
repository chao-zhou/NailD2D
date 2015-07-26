package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.naild2d.android.R;
import com.naild2d.android.adapters.MyAdapter;
import com.naild2d.android.adapters.MyAdapterViewBinder;

import java.util.ArrayList;

/**
 * Created by ebread on 2015/7/12.
 */
public abstract class NailD2DListActivity<T> extends NailD2DActivity
        implements MyAdapterViewBinder<T> {

    protected ListView mListView;
    protected MyAdapter<T> myAdapter = null;
    protected ArrayList<T> items = new ArrayList<>();

    public static void setListViewHeightBasedOnChildren(ListView listView, int attHeight) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)) + attHeight;
        listView.setLayoutParams(params);
    }


    protected abstract void fillItems(ArrayList<T> items);

    protected boolean IsAutoAdjustListHeight() {
        return false;
    }

    protected int getListViewId() {
        return R.id.list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mListView = (ListView) findViewById(getListViewId());

        myAdapter = new MyAdapter<>(items, this);
        mListView.setAdapter(myAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        fillItems(items);
        if (IsAutoAdjustListHeight()) {
            setListViewHeightBasedOnChildren(mListView, 0);
        }
    }

    protected void refreshListView() {
        myAdapter.notifyDataSetChanged();
        if (IsAutoAdjustListHeight()) {
            setListViewHeightBasedOnChildren(mListView, 0);
        }
    }
}
