package com.songwenju.androidtoolslibrary.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * SqliteUtils
 */
public class SqliteUtils {

    private static volatile SqliteUtils instance;

    private SQLiteDatabase db;

    private SqliteUtils(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public static SqliteUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (SqliteUtils.class) {
                if (instance == null) {
                    instance = new SqliteUtils(context);
                }
            }
        }
        return instance;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
