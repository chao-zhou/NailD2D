package com.naild2d.android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/5/26.
 */
public class ServiceThumbnailView extends RelativeLayout {

    public ImageTextView nameView;
    public TextView priceView;
    public ImageView thumbnailView;

    public ServiceThumbnailView(Context context) {
        super(context);
    }

    public ServiceThumbnailView(Context context, AttributeSet attrs) throws Exception {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_service_thumbnail, this);

        nameView = (ImageTextView) findViewById(R.id.item_service_name);
        priceView = (TextView) findViewById(R.id.item_service_price);
        thumbnailView = (ImageView) findViewById(R.id.item_service_thumbnail);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ServiceThumbnailView);

        String name = array.getString(R.styleable.ServiceThumbnailView_name);
        String price = array.getString(R.styleable.ServiceThumbnailView_integer_price);
        Drawable thumbnail = array.getDrawable(R.styleable.ServiceThumbnailView_thumbnail);


        nameView.setText(name);
        priceView.setText(price);
        thumbnailView.setImageDrawable(thumbnail);

        array.recycle();
    }

}
