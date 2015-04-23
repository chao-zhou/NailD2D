package com.naild2d.android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naild2d.android.R;

/**
 * TODO: document your custom view class.
 */
public class PriceTextView extends LinearLayout {
    private TextView priceTextView;
    private String priceText = "0.00";
    private ImageView imageView;

    public PriceTextView(Context context) {
        super(context);
        init(null);
    }

    public PriceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_price_textview,this);
        priceTextView = (TextView)findViewById(R.id.component_price_textview_price);
        imageView = (ImageView)findViewById(R.id.component_price_textView_yuan);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if(attrs == null)
            return;

        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PriceTextView);
        priceText = a.getString( R.styleable.PriceTextView_price);
        priceTextView.setText(priceText);

        final TypedArray b = getContext().obtainStyledAttributes(attrs, R.styleable.ImageTextView);
        float size = b.getInteger(R.styleable.ImageTextView_textSize,16);
        priceTextView.setTextSize(size);

        a.recycle();
    }

    public void setPrice(String price){
        priceTextView.setText(price);
        invalidate();
        requestLayout();
    }
}
