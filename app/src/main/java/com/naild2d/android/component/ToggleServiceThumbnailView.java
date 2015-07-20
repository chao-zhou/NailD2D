package com.naild2d.android.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/7/13.
 */
public class ToggleServiceThumbnailView extends RelativeLayout {

    private ImageView imageThumbnail = null;
    private ImageView imageMask = null;
    private Button topButton = null;
    private boolean isChecked = false;
    private ServiceThumbnailClickEventListener clickEventListener = null;


    public ToggleServiceThumbnailView(Context context) {
        super(context);
    }


    public ToggleServiceThumbnailView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.component_toggle_service_thumbnail, this);

        imageThumbnail = (ImageView) findViewById(R.id.item_thumbnail);
        imageMask = (ImageView) findViewById(R.id.item_mask);
        topButton = (Button) findViewById(R.id.item_top_button);
        topButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isChecked) {
                    FireClickEvent();
                } else {
                    isChecked = false;
                    updateMask();
                }
            }
        });
        updateMask();
    }

    private void FireClickEvent() {
        if (clickEventListener != null)
            clickEventListener.click(this);
    }

    public void setImageThumbnail(Drawable thumbnail) {
        imageThumbnail.setImageDrawable(thumbnail);
    }

    public void setClickEventListener(ServiceThumbnailClickEventListener clickEventListener) {
        this.clickEventListener = clickEventListener;
    }

    private void updateMask() {
        if (isChecked) {
            imageMask.setBackgroundColor(Color.BLUE);
            return;
        }

        imageMask.setBackgroundResource(android.R.color.transparent);
    }

}
