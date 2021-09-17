package com.mi.activitytest;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        //Log.e("ThirdActivity", "Task id is:" + getTaskId());

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁活动管理器中的所有活动
                ActivityCollector.finishAll();

                //杀掉当前进程
                android.os.Process.killProcess(Process.myPid());
            }
        });
    }
}
