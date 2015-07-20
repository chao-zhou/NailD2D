package com.naild2d.android.activity.extend;

import android.os.Handler;
import android.os.Message;

public class NailD2DHandler extends Handler {

    private NailD2DTimerMessageHandler mListener = null;

    public NailD2DHandler(NailD2DTimerMessageHandler listener) {
        mListener = listener;
    }

    @Override
    public void handleMessage(Message msg) {
        mListener.handleTimeMessage(msg);
    }
}
