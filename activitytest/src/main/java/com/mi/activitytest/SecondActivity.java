package com.mi.activitytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    public static void actionStart(Context context, String param1, String param2){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", param1);
        intent.putExtra("param2", param2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //接收FirstActivity发送的数据
        //Intent intent = getIntent();
        //String data = intent.getStringExtra("extra_data");
        //Log.e(TAG, "onCreate: " + data);

        //Log.e(TAG, "Task id is: " + getTaskId());
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据给FirstActivity
                //Intent intent1 = new Intent();
                //intent1.putExtra("data_return", "Hello FirstActivity");
                //setResult(RESULT_OK, intent1);
                //finish();

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String param1 = intent.getStringExtra("param1");
        String param2 = intent.getStringExtra("param2");
        Log.e(TAG, "data is " + param1 + " and " + param2);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
