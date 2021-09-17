package com.mi.myactivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);
    }

    /**
     * 启动服务
     *
     * @param view
     */
    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    /**
     * 停止服务
     *
     * @param view
     */
    public void stopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    //Activity连接BindService的桥梁
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /**
     * 绑定服务
     *
     * @param view
     */
    public void bindService(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    /**
     * 解绑服务
     *
     * @param view
     */
    public void unBindService(View view) {
        unbindService(connection);
    }

    /**
     * Activity销毁时再解绑服务
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
