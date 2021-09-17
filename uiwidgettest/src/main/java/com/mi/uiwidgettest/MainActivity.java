package com.mi.uiwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private EditText et;
    private ImageView iv;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick1");
            }
        });*/

        et = findViewById(R.id.et);
        iv = findViewById(R.id.iv);
        pb = findViewById(R.id.pb);

        btn.setOnClickListener(this);
    }

    /**
     * 单击事件的另一种写法：实现View.OnClickListener接口，实现onClick方法
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                //Log.e(TAG, "onClick2");

                //String inputText = et.getText().toString();
                //Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show();

                //iv.setImageResource(R.drawable.taj);

                //改变进度条的状态
                /*if (pb.getVisibility() == View.GONE) {
                    pb.setVisibility(View.VISIBLE);
                } else {
                    pb.setVisibility(View.GONE);
                }*/

                /*int progress = pb.getProgress();
                progress = progress + 10;
                pb.setProgress(progress);*/

                //弹出一个对话框，置顶于所有界面元素之上
                /*AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("You can find a good house!");
                dialog.setCancelable(false);
                dialog.setPositiveButton("SURE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Look forward to that day!", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Is it wrong?", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();*/

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}