package com.nghianv.nghiachat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.os.*;

import com.nghianv.nghiachat.adapter.ChatAdapter;
import com.nghianv.nghiachat.model.MessageChat;

public class ChatActivity extends AppCompatActivity {


    private final String TAG = "ChatActivity";
    ListView lvChat;
    Button btnSend;
    EditText txtMessage;
    List<MessageChat> messageChats = new ArrayList<>();
    ChatAdapter adapter;

    private static Handler handlerUpdateUI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent i = getIntent();
        final String id = i.getStringExtra("id");
        final String name = i.getStringExtra("name");

        handlerUpdateUI = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                adapter.notifyDataSetChanged();
            }
        };

        final Client client = new Client(id, name);
        client.setOnRecievedMessage(new Client.OnRecievedMessage() {
            @Override
            public void onRecieved(String message) {
                messageChats.add(new MessageChat(message, false));
                handlerUpdateUI.sendEmptyMessage(0);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                client.startClient();
            }
        });
        thread.start();

        txtMessage = (EditText)findViewById(R.id.txtMessage);
        btnSend = (Button)findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = txtMessage.getText().toString();
                client.sendMessage(message);
                messageChats.add(new MessageChat(message, true));
                handlerUpdateUI.sendEmptyMessage(0);
                txtMessage.setText("");
            }
        });

        lvChat = (ListView)findViewById(R.id.lvChat);
        adapter = new ChatAdapter(this, messageChats);
        lvChat.setAdapter(adapter);
    }
}
