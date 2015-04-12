package com.naild2d.android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naild2d.android.R;

/**
 * TODO: document your custom view class.
 */
public class PriceTextView extends LinearLayout {
    private TextView priceTextView;
    private String priceText = "0.00";

    public PriceTextView(Context context) {
        super(context);
        init(null);
    }

    public PriceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_price_textview,this);

        priceTextView = (TextView)findViewById(R.id.component_price_textview_price);

        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if(attrs == null)
            return;

        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PriceTextView);
        priceText = a.getString( R.styleable.PriceTextView_price);
        priceTextView.setText(priceText);
        a.recycle();
    }
}
