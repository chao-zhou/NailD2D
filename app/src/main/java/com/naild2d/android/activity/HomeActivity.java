package com.naild2d.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.naild2d.android.R;
import com.naild2d.android.model.UserProfile;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToPackageList(View view) {
        startActivity(new Intent(this, PackageListActivity.class));
    }


    public void switchToUserProfile(View view) {
        Intent intent;
        if (UserProfile.getUserProfile() == null) {
            intent = new Intent(this, LoginActivity.class);
        } else {
            intent = new Intent(this, UserProfileActivity.class);
        }
        startActivity(intent);
    }
}
