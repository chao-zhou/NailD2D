package com.naild2d.android.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.naild2d.android.R;

/**
 * Created by ebread on 2015/7/14.
 */
public class EvaluationView extends LinearLayout implements View.OnClickListener {

    private int value = 0;

    public EvaluationView(Context context) {
        super(context);
    }

    public EvaluationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.component_evaluation, null);
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = linearLayout.getChildAt(0);
            linearLayout.removeView(childView);
            childView.setOnClickListener(this);
            this.addView(childView);
        }
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
        updateView();
    }

    private void updateView() {
        for (int i = 0; i < getChildCount(); i++) {
            ToggleImageView view = (ToggleImageView) getChildAt(i);
            view.setIsOn(i < value);
        }
    }

    @Override
    public void onClick(View view) {
        String tag = view.getTag().toString();
        setValue(Integer.valueOf(tag));
    }
}
