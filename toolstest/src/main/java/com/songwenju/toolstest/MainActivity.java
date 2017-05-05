package com.songwenju.toolstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.songwenju.androidtools.util.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.i(this,"MainActivity.onCreate.");
    }
}
