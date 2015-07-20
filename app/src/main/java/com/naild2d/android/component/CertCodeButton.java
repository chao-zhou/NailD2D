package com.naild2d.android.component;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.naild2d.android.R;
import com.naild2d.android.activity.extend.NailD2DAsyncHandler;
import com.naild2d.android.activity.extend.NailD2DAsyncTask;
import com.naild2d.android.service.AccountService;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ebread on 2015/7/7.
 */
public class CertCodeButton extends Button implements View.OnClickListener {

    public final static int DEFAULT_SLEEP_SECONDS = 60;

    private AccountService accountService = null;
    private String phoneNumber = "";
    private String text = "";
    private Handler handler = null;
    private Timer timer = null;
    private int seconds = 0;

    public CertCodeButton(Context context) {
        super(context);
        init(context);
    }

    public CertCodeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @Override
    public void onClick(View v) {
        NailD2DAsyncTask.doInBackground(new NailD2DAsyncHandler() {
            CertCodeButton button = CertCodeButton.this;

            @Override
            public Object doAsync(Object... params) {
                return button.sendCertCodeRequest();
            }

            @Override
            public void asyncSuccess(Object result) {
                Boolean success = (Boolean) result;
                if (success) {
                    button.setText(String.valueOf(DEFAULT_SLEEP_SECONDS));
                    button.sleep(DEFAULT_SLEEP_SECONDS);
                    return;
                }
                Toast.makeText(button.getContext(), "Cannot get cert code.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private void init(Context context) {

        accountService = new AccountService(context);

        text = context.getString(R.string.cert_code_button_text);
        timer = new Timer(true);
        handler = new MyHandler();

        this.setText(text);
        this.setOnClickListener(this);
    }

    private boolean sendCertCodeRequest() {
        try {
            return accountService.getCertCode(phoneNumber);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private void sleep(int seconds) {
        if (seconds <= 0)
            return;

        this.seconds = seconds;
        CertCodeButton.this.setEnabled(false);
        startTimer();

    }

    private void startTimer() {
        TimerTask timerTask = new MyTimerTask(handler);
        timer = new Timer(true);
        timer.schedule(timerTask, 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
    }


    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            CertCodeButton button = CertCodeButton.this;
            if (seconds > 0) {
                seconds--;
                button.setText(String.valueOf(seconds));
            } else {
                button.setText(text);
                button.setEnabled(true);
                button.stopTimer();
            }
            super.handleMessage(msg);
        }
    }

    class MyTimerTask extends TimerTask {
        Handler handler = null;

        public MyTimerTask(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            Message msg = new Message();
            handler.sendMessage(msg);
        }
    }
}
