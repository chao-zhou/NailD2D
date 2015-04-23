package com.naild2d.android.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by chaozhou on 4/20/2015.
 */
public class MyAdapter<T> extends BaseAdapter {

    protected List<T> myDataList = null;
    protected MyAdapterViewBinder<T> myBinder;

    public MyAdapter(List<T> dataList,MyAdapterViewBinder<T> binder){
        myDataList = dataList;
        myBinder = binder;
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = myBinder.getView(position,convertView,parent);
        myBinder.bindData(position,convertView,parent,myDataList.get(position));
        return convertView;
    }
}
