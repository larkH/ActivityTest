package com.mi.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class MyActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my3);

        //注册动态广播接受者
        UpdateIpSelectCity updateIpSelectCity = new UpdateIpSelectCity();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
        registerReceiver(updateIpSelectCity, intentFilter);
    }

    /**
     * 静态发送广播给接受者
     *
     * @param view
     */
    public void sendAction1(View view) {
        Intent intent = new Intent();
        intent.setAction(ActionUtils.ACTION_FLAG);//ActionUtils.ACTION_FLAG标记与注册时保持一致

        //解决静态广播接受不到的问题
        //方法一
        //intent.setPackage("com.mi.myactivity");

        //方法二
        if (Build.VERSION.SDK_INT >= 26) {
            ComponentName componentName = new ComponentName(getApplicationContext(), "com.mi.myactivity.CustomReceiver");
            intent.setComponent(componentName);
        }

        sendBroadcast(intent);
    }

    /**
     * 发送给动态广播接受者
     *
     * @param view
     */
    public void sendAction2(View view) {
        Intent intent = new Intent();
        intent.setAction(ActionUtils.ACTION_EQUES_UPDATE_IP);
        sendBroadcast(intent);
    }
}