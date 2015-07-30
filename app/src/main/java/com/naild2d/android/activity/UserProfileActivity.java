package com.naild2d.android.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.naild2d.android.R;
import com.naild2d.android.component.MyImageView;
import com.naild2d.android.model.UserProfile;
import com.naild2d.android.service.AccountService;
import com.naild2d.android.service.ImageService;


public class UserProfileActivity extends NailD2DActivity {
    UserProfile profile;
    MyImageView profileImageView;
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

        profileImageView = (MyImageView) findViewById(R.id.user_profile_pic);
        txtNumber = (TextView) findViewById(R.id.user_profile_number);

        txtNumber.setText(profile.getPhone());
        profileImageView.setImageId(profile.getAvatar());

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
