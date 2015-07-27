package com.naild2d.android.component;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/5/26.
 */
public class OrderDateItemView extends RelativeLayout {

    private final static String STATUS_IS_AVAILABLE = "可预约";
    private final static String STATUS_NOT_AVAILABLE = "已约满";
    private final static String STATUS_IS_BOOKED = "预约";

    private TextView mDateTextView;
    private TextView mStatusTextView;

    private String dateValue = "00:00";
    private boolean isAvailable = true;
    private boolean isBooked = false;

    public OrderDateItemView(Context context) {
        super(context);
    }

    public OrderDateItemView(Context context, AttributeSet attrs) throws Exception {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_order_date_item, this);

        mDateTextView = (TextView) findViewById(R.id.order_date_item_date);
        mDateTextView.setText(dateValue);

        mStatusTextView = (TextView) findViewById(R.id.order_date_item_status);
        //mStatusTextView.setText(getStatusText());
    }

    public String getDateValue() {
        return dateValue;
    }

    public void setDateValue(String dateValue) {
        this.dateValue = dateValue;
        mDateTextView.setText(dateValue);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
        mStatusTextView.setText(getStatusText());
        this.setBackgroundColor(Color.rgb(127, 127, 127));
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
        mStatusTextView.setText(getStatusText());
        this.setBackgroundColor(Color.rgb(127, 127, 127));
    }

    private String getStatusText() {
        if (isBooked) {
            return STATUS_IS_BOOKED;
        }

        return isAvailable ? STATUS_IS_AVAILABLE : STATUS_NOT_AVAILABLE;
    }
}
