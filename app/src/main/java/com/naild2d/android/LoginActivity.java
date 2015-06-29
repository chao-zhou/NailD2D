package com.naild2d.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.naild2d.android.service.AccountService;

public class LoginActivity extends Activity {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {
        String user = txtName.getText().toString();
        String pwd = txtPassword.getText().toString();

        if (accountService.login(user, pwd)) {
            Intent intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
            return;
        }

        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT);
    }
}
