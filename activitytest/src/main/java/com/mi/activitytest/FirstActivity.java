package com.mi.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends BaseActivity {

    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        //获取按钮对象
        Button btn = findViewById(R.id.btn1);
        //给按钮设置单机事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast：一种提醒方式(提示弹框)
                Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
            }
        });

        //Log.e(TAG, this.toString());
        //Log.e(TAG, "Task id is: " + getTaskId());

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁Activity
                //finish();

                //跳转到SecondActivity活动
                //显式Intent
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //隐式Intent
                //Intent intent = new Intent("com.mi.activitytest.ACTION_START");
                //intent.addCategory("com.mi.activitytest.MY_CATEGORY");

                //跳转到百度
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));

                //跳转到通话
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));

                //传递数据给SecondActivity
                //String data = "Hello SecondActivity";
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //intent.putExtra("extra_data", data);
                //startActivity(intent);

                //使用startActivityForResult()启动SecondActivity，这个方法期望在活动销毁的时候能够返回一个结果给上一个活动
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivityForResult(intent, 1);

                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);

                //启动活动的最佳写法
                SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    /**
     * 在活动中创建菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 定义菜单响应事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 获取SecondActivity返回的数据
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.e(TAG, "onActivityResult: " + returnData);
                }
                break;
            default:
                break;
        }
    }
}
