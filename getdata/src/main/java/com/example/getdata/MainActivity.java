package com.example.getdata;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri3 = Uri.parse("content://com.wang.provider.myprovider/tablename");
        Cursor cursor = getContentResolver().query(uri3, null, null, null, null);
        cursor.moveToFirst();
        do {
            String name2 = cursor.getString(cursor.getColumnIndex("username"));
            String pwd = cursor.getString(cursor.getColumnIndex("password"));
            Log.e("微聊。。。。", "onClick: " + name2 + ":::::" + pwd);

        } while (cursor.moveToNext());
        cursor.close();
    }
}
