package com.naild2d.android.component;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/7/13.
 */
public class ToggleServiceThumbnailView extends RelativeLayout {

    private MyImageView imageThumbnail = null;
    private ImageView imageMask = null;
    private Button topButton = null;

    private ImageTextView serviceNameView = null;
    private TextView servicePriceView = null;

    private boolean isChecked = false;
    private ServiceThumbnailClickEventListener clickEventListener = null;


    public ToggleServiceThumbnailView(Context context) {
        super(context);
    }


    public ToggleServiceThumbnailView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.component_toggle_service_thumbnail, this);

        imageThumbnail = (MyImageView) findViewById(R.id.item_service_thumbnail);
        imageMask = (ImageView) findViewById(R.id.item_service_mask);
        serviceNameView = (ImageTextView) findViewById(R.id.item_service_name);
        servicePriceView = (TextView) findViewById(R.id.item_service_price);


        topButton = (Button) findViewById(R.id.item_service_top_button);
        topButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    FireClickEvent();
            }
        });
        updateMask();
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
        updateMask();
    }

    public void setImageId(int id) {
        imageThumbnail.setImageId(id);
    }

    public void setServiceName(String name) {
        serviceNameView.setText(name);
    }

    public void setServicePrice(double price) {
        servicePriceView.setText(String.valueOf(price));
    }


    public void setClickEventListener(ServiceThumbnailClickEventListener clickEventListener) {
        this.clickEventListener = clickEventListener;
    }


    private void FireClickEvent() {
        if (clickEventListener != null)
            clickEventListener.click(this);
    }


    private void updateMask() {
        if (isChecked) {
            imageMask.setBackgroundColor(Color.BLUE);
            return;
        }

        imageMask.setBackgroundResource(android.R.color.transparent);
    }

}
