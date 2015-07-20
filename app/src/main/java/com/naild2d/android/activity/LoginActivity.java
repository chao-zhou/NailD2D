package com.naild2d.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.naild2d.android.R;
import com.naild2d.android.service.AccountService;

public class LoginActivity extends NailD2DActivity {
    TextView txtName = null;
    TextView txtPassword = null;
    AccountService accountService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountService = new AccountService(this);

        txtName = (TextView) findViewById(R.id.txtName);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
    }

    public void login(View view) {
        String user = txtName.getText().toString();
        String pwd = txtPassword.getText().toString();

        if (accountService.login(user, pwd)) {
            Intent intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT);
    }

    public void switchActivity(View view) {
        Intent intent = null;
        String tag = view.getTag().toString();

        switch (tag) {
            case "register":
                intent = new Intent(this, RegisterUserActivity.class);
                break;
            case "forgetPassword":
                intent = new Intent(this, ForgetPasswordActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
