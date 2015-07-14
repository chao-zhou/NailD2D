package com.naild2d.android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/7/14.
 */
public class ToggleImageView extends ImageView implements View.OnClickListener {

    private boolean isOn = false;
    private Drawable onDrawable = null;
    private Drawable offDrawable = null;

    public ToggleImageView(Context context) {
        super(context);
    }

    public ToggleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ToggleImageView);
        onDrawable = array.getDrawable(R.styleable.ToggleImageView_onSrc);
        offDrawable = array.getDrawable(R.styleable.ToggleImageView_offSrc);

        updateDrawable();

        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        isOn = !isOn;
        updateDrawable();
    }

    public boolean isOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
        updateDrawable();
    }

    public Drawable getOffDrawable() {
        return offDrawable;
    }

    public void setOffDrawable(Drawable offDrawable) {
        this.offDrawable = offDrawable;
        updateDrawable();
    }

    public Drawable getOnDrawable() {
        return onDrawable;
    }

    public void setOnDrawable(Drawable onDrawable) {
        this.onDrawable = onDrawable;
        updateDrawable();
    }

    private void updateDrawable() {
        if (isOn) {
            this.setImageDrawable(onDrawable);
            return;
        }

        this.setImageDrawable(offDrawable);
    }


}
