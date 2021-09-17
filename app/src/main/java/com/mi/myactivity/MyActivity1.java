package com.mi.myactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity1 extends AppCompatActivity {

    private static final String TAG = "MyActivity1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my1);

        Log.e(TAG, "onCreate: Log");
    }
}
