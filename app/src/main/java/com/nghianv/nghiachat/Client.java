package com.nghianv.nghiachat;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashSet;

/**
 * Created by NguyenNghia on 4/2/2016.
 */
public class Client {
    private final String TAG = Client.class.getSimpleName();
    private Socket mSocketClient;
    private BufferedReader in;
    private BufferedWriter out;
    private boolean mRunning;
    private OnRecievedMessage listener;
    private String serverMessage;
    private String id;
    private String name;


    public interface OnRecievedMessage{
        public void onRecieved(String message);
    }

    public void setOnRecievedMessage(OnRecievedMessage listener){
        this.listener = listener;
    }

    public Client(String id, String name){
        this.id = id;
        this.name = name;
    }

    public void startClient(){
        try {
            mSocketClient = new Socket(Config.HOST_IP, Config.HOST_PORT);
            Log.i(TAG, mSocketClient.getPort() + "--:--" + mSocketClient.getInetAddress() + ", " + mSocketClient.getLocalPort() + "," + mSocketClient.getLocalAddress() + "," + mSocketClient.getLocalSocketAddress());
            in = new BufferedReader(new InputStreamReader(mSocketClient.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(mSocketClient.getOutputStream()));
            sendMessage(id);
            sendMessage(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mRunning = true;
        try {
            while(mRunning) {
                if ((serverMessage = in.readLine()) != null && listener != null) {
                    listener.onRecieved(serverMessage);
                    serverMessage = null;
                }
            }

            in.close();
            out.close();
            mSocketClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeClient(){
        mRunning = false;
        if(mSocketClient != null){
            try {
                out.close();
                out.close();
                mSocketClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void sendMessage(String message) {
        if (out != null) {
            try {
                out.write(message);
                out.newLine();
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
