package com.naild2d.android.service;

import android.graphics.Bitmap;

/**
 * Created by chao_zhou on 15/1/26.
 */
public interface PicService extends Service {

    public Bitmap[] getAdvs();

    public Bitmap getImage();

    public Bitmap getThumbnail();

}
