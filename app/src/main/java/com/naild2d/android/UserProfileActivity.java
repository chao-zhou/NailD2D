package com.naild2d.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.naild2d.android.model.UserProfile;
import com.naild2d.android.service.AccountService;
import com.naild2d.android.service.ImageService;


public class UserProfileActivity extends NailD2DActivity {
    UserProfile profile;
    ImageView profileImageView;
    TextView txtNumber;
    AccountService accountService;
    ImageService imageService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        accountService = new AccountService(this);
        imageService = new ImageService(this);

        profile = UserProfile.getUserProfile();

        profileImageView = (ImageView) findViewById(R.id.user_profile_pic);
        txtNumber = (TextView) findViewById(R.id.user_profile_number);

        txtNumber.setText(profile.getPhone());
        Drawable drawable = getProfileDrawable();
        if (drawable != null) {
            profileImageView.setImageDrawable(drawable);
        }


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


    private Drawable getProfileDrawable() {
        Bitmap bitmap = getProfileBitmap();
        if (bitmap != null) {
            return new BitmapDrawable(getResources(), bitmap);
        }
        return null;
    }

    private Bitmap getProfileBitmap() {
        String picId = profile.getAvatar();
        byte[] b = imageService.getThumbnail(picId);
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
            return null;
        }

    }
}
