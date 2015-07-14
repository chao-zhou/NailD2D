package com.naild2d.android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.naild2d.android.R;
import com.naild2d.android.service.AccountService;


public class RegisterUserActivity extends NailD2DActivity {

    private AccountService accountService = null;
    private EditText txtNumber = null;
    private EditText txtCertCode = null;
    private EditText txtPassword = null;
    private EditText txtRefUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        txtNumber = (EditText) findViewById(R.id.txtNumber);
        txtCertCode = (EditText) findViewById(R.id.txtCertCode);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtRefUser = (EditText) findViewById(R.id.txtRefUser);

        accountService = new AccountService(this);
    }

    public void submit(View view) {
        try {
            String phone = txtNumber.getText().toString();
            String code = txtCertCode.getText().toString();
            String pwd = txtPassword.getText().toString();
            String ref = txtRefUser.getText().toString();

            if (accountService.register(phone, pwd, code, ref)) {
                return;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        showMessage("Register failed.");
    }

}
