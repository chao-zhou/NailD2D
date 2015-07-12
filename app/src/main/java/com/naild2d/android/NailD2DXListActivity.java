package com.naild2d.android;

import android.os.Bundle;

import com.naild2d.android.adapters.MyAdapter;
import com.naild2d.android.adapters.MyAdapterViewBinder;
import com.naild2d.android.component.xlistview.XListView;

import java.util.ArrayList;

/**
 * Created by ebread on 2015/7/12.
 */
public abstract class NailD2DXListActivity<T> extends NailD2DActivity
        implements XListView.IXListViewListener, MyAdapterViewBinder<T> {

    protected final String FILL_ITEMS_ACTION_CREATE = "CREATE";
    protected final String FILL_ITEMS_ACTION_REFRESH = "REFRESH";
    protected final String FILL_ITEMS_ACTION_MORE = "MORE";


    protected XListView mListView;
    protected MyAdapter<T> myAdapter = null;
    protected ArrayList<T> items = new ArrayList<>();

    protected abstract int getLayoutId();

    protected abstract void fillItems(ArrayList<T> items, String action);

    protected int getListViewId() {
        return R.id.list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mListView = (XListView) findViewById(getListViewId());
        mListView.setPullLoadEnable(true);
        mListView.setXListViewListener(this);

        myAdapter = new MyAdapter<>(items, this);
        mListView.setAdapter(myAdapter);

        fillItems(items, FILL_ITEMS_ACTION_CREATE);

    }

    @Override
    public void onRefresh() {

        fillItems(items, FILL_ITEMS_ACTION_REFRESH);

        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime("Just Now");
    }

    @Override
    public void onLoadMore() {

        fillItems(items, FILL_ITEMS_ACTION_MORE);

        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime("Just Now");
    }
}
