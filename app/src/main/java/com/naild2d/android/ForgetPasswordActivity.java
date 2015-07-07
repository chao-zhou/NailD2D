package com.naild2d.android;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.naild2d.android.service.AccountService;


public class ForgetPasswordActivity extends NailD2DActivity {
    private AccountService accountService = null;
    private EditText txtNumber = null;
    private EditText txtPassword = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        txtNumber = (EditText) findViewById(R.id.txtNumber);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        accountService = new AccountService(this);
    }

    public void next(View view) {

    }
}
