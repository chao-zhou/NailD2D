package com.naild2d.android.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.naild2d.android.service.ImageService;

/**
 * Created by ebread on 2015/7/22.
 */
public class MyImageView extends ImageView {

    private int imageId;
    private ImageService imageService = null;
    private ImageAsyncTask asyncTask = null;

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        imageService = new ImageService(context);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int id) {
        if (imageId == id)
            return;

        imageId = id;
        refresh();
    }

    public void refresh() {
        asyncTask = new ImageAsyncTask();
        asyncTask.execute(imageId);
    }

    class ImageAsyncTask extends AsyncTask<Integer, Integer, Bitmap> {

        @Override
        protected Bitmap doInBackground(Integer... params) {
            byte[] b = imageService.getThumbnail(String.valueOf(params[0]));
            if (b.length != 0) {
                return BitmapFactory.decodeByteArray(b, 0, b.length);
            } else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                Drawable drawable = new BitmapDrawable(getResources(), bitmap);
                setImageDrawable(drawable);
            }
        }
    }
}
