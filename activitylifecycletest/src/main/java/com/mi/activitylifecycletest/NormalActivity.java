package com.mi.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NormalActivity extends AppCompatActivity {

    private static final String TAG = "NormalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_layout);

        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("data");
        String bundleData = data.getString("key");
        Log.e(TAG, "bundleData: " + bundleData);

        TextView tv = findViewById(R.id.tv);
        tv.setText(tv.getText() + "\n" + bundleData);
    }
}