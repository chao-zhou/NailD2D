package com.naild2d.android.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ebread on 2015/6/29.
 */
public class SettingsStorageHelper extends SQLiteOpenHelper {

    private static final String DB_NO_EXIST = "DB_NO_EXIST";
    private static final String DB_NAME = "naild2d.db";
    private static final int VERSION = 1;

    private static SettingsStorageHelper instance = null;

    private SettingsStorageHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public static SettingsStorageHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SettingsStorageHelper(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Settings(Key VARCHAR(50) NOT NULL , Value VARCHAR(100) NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int save(String key, String value) {
        SQLiteDatabase db = getWritableDatabase();

        String existValue = load(key, DB_NO_EXIST);
        if (existValue == DB_NO_EXIST) {
            ContentValues cv = new ContentValues();
            cv.put("Key", key);
            cv.put("Value", value);
            return (int) db.insert("Settings", null, cv);
        }

        ContentValues cv = new ContentValues();
        cv.put("Value", value);
        String whereClause = "Key=?";
        String[] whereArgs = {key};
        return db.update("Settings", cv, whereClause, whereArgs);
    }

    public String load(String key) {
        return load(key, null);
    }

    public String load(String key, String defualtValue) {
        String sql = "SELECT Value FROM Settings WHERE Key=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{key});
        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex("Value"));
        }
        return defualtValue;
    }
}
