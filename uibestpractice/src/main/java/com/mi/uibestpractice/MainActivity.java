package com.mi.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText et;
    private Button btn;
    private RecyclerView rv;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsg();
        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);
        rv = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        rv.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = et.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);//当有新消息时，刷新RecyclerView中的显示
                    rv.scrollToPosition(msgList.size() - 1);//将RecyclerView中显示的数据定位到最后一行
                    et.setText("");//清空输入框中的内容
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello guy!", Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("Hello, Who is that?", Msg.TYPE_SENT);
        Msg msg3 = new Msg("This is Stephen. Nice talking to you.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);
    }
}