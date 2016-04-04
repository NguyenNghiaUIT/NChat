package com.nghianv.nghiachat;

import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nghianv.nghiachat.adapter.ChatViewPagerAdapter;
import com.nghianv.nghiachat.model.Post;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private final String TAG ="MainActivity";
    private ViewPager vpChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ChatViewPagerAdapter adapter = new ChatViewPagerAdapter(getSupportFragmentManager());
        vpChat = (ViewPager)findViewById(R.id.vpChat);
        if(adapter != null)
            vpChat.setAdapter(adapter);

    }
}
