package com.naild2d.android.activity.extend;

import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ebread on 2015/7/20.
 */
public class NailD2DTimerTask extends TimerTask {
    private Handler mHandler = null;

    public NailD2DTimerTask(Handler handler) {
        mHandler = handler;
    }

    public static Timer startTimer(NailD2DTimerMessageHandler handler, long delay, long period) {
        TimerTask timerTask = new NailD2DTimerTask(new NailD2DHandler(handler));
        Timer timer = new Timer(true);
        timer.schedule(timerTask, delay, period);
        return timer;
    }

    @Override
    public void run() {
        Message msg = new Message();
        mHandler.sendMessage(msg);
    }
}
