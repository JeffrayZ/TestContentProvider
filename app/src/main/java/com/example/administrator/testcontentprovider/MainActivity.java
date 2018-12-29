package com.example.administrator.testcontentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SimpleCursorAdapter adapter = null;
    private Cursor mCursor = null;
    private ContentResolver mContentResolver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

    }

    private void initData() {
        mContentResolver = getContentResolver();
        for (int i = 0; i < 100; i++) {
            ContentValues values = new ContentValues();
            values.put(Profile.COLUMN_NAME, "Wang " + i);
            values.put(Profile.COLUMN_PWD, "pwd " + i);
            mContentResolver.insert(Profile.CONTENT_URI, values);
        }
    }

}
