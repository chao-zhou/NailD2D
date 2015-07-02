package com.naild2d.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.naild2d.android.model.UserProfile;
import com.naild2d.android.service.AccountService;


public class UserProfileActivity extends NailD2DActivity {
    UserProfile profile;
    ImageView profileImageView;
    TextView txtNumber;
    AccountService accountService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        accountService = new AccountService(this);
        profile = UserProfile.getUserProfile();

        profileImageView = (ImageView) findViewById(R.id.user_profile_pic);
        txtNumber = (TextView) findViewById(R.id.user_profile_number);

        txtNumber.setText(profile.getPhone());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
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

    public void logout(View view) {
        if (accountService.logout()) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void switchActivity(View view) {
        Toast.makeText(this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
    }
}
