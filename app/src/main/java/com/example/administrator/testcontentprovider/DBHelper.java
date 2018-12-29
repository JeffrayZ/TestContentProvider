package com.example.administrator.testcontentprovider;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME = "test.db";

    /**
     * 数据库版本
     */
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) throws SQLException {
        //创建表格
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Profile.TABLE_NAME + "(" + Profile.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Profile.COLUMN_NAME + " VARCHAR NOT NULL," + Profile.COLUMN_PWD + " VARCHAR NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) throws SQLException {
        //删除并创建表格
        db.execSQL("DROP TABLE IF EXISTS " + Profile.TABLE_NAME + ";");
        onCreate(db);
    }
}
