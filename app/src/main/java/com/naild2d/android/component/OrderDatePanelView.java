package com.naild2d.android.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/5/26.
 */
public class OrderDatePanelView extends LinearLayout {

    public OrderDatePanelView(Context context) {
        super(context);
    }

    public OrderDatePanelView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_order_date_panel,this);
    }

}
