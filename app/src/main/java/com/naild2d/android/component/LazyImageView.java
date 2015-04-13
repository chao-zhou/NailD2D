package com.naild2d.android.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ebread on 2015/4/13.
 */
public class LazyImageView extends ImageView {
    public LazyImageView(Context context) {
        super(context);
    }

    public LazyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setRemoteImage(String imageId){
        return;
    }
}
