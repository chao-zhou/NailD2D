package com.naild2d.android.adapters;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chaozhou on 4/20/2015.
 */
public interface MyAdapterViewBinder<T> {
    public View getView(int position, View convertView, ViewGroup parent);
    public void bindData(int position, View convertView, ViewGroup parent, T data);
}
