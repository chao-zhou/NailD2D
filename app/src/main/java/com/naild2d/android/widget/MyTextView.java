package com.naild2d.android.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);

        setDefaultFontFamily();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setDefaultFontFamily();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setDefaultFontFamily();
    }

    private void setDefaultFontFamily(){
        Typeface tf = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/font name.ttf");
        this.setTypeface(tf);
    }
}
