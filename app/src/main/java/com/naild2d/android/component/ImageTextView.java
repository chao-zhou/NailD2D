package com.naild2d.android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/4/12.
 */
public class ImageTextView extends LinearLayout {
    private TextView textView;
    private ImageView imageView;

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_image_text_view,this);

        textView = (TextView)findViewById(R.id.component_image_text_view_text);
        imageView = (ImageView)findViewById(R.id.component_image_text_view_image);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.ImageTextView);

        String text = array.getString(R.styleable.ImageTextView_text);
        float textSize = array.getFloat(R.styleable.ImageTextView_textSize,22);
        int textColor = array.getColor(R.styleable.ImageTextView_textColor,Color.BLACK);
        Drawable image = array.getDrawable(R.styleable.ImageTextView_image);

        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);

        imageView.setImageDrawable(image);

    }


    public void setImageDrawable(Drawable image){
        imageView.setImageDrawable(image);
        invalidate();
        requestLayout();
    }

    public void setImageResource(int resId){
        imageView.setImageResource(resId);
        invalidate();
        requestLayout();
    }

    public void setText(String text){
        textView.setText(text);
        invalidate();
        requestLayout();
    }
}
