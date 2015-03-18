package com.naild2d.android.storage;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by chaozhou on 3/12/2015.
 */
public class SDStorageHelper {

   public File newFile(String fileName, byte[]buffer) {
        File file=new File(Environment.getExternalStorageDirectory(), fileName);

        if (file.exists()) {
            file.delete();
        }

        try {
            FileOutputStream fos=new FileOutputStream(file.getPath());
            fos.write(buffer);
            fos.close();
            return file;
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public byte[] readFile(String fileName){
        File file=new File(Environment.getExternalStorageDirectory(), fileName);

        if (!file.exists()) {
            return null;
        }

        try {
            FileInputStream fis=new FileInputStream(file.getPath());
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            return buffer;
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
