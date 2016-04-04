package com.nghianv.nghiachat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    EditText txtUserName;
    EditText txtPassword;

    Button btnLogin;
    boolean isLoggin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Intent i = new Intent(StartActivity.this, ChatActivity.class);

        txtUserName = (EditText)findViewById(R.id.txtUser);
        txtPassword = (EditText)findViewById(R.id.txtPassword);

        btnLogin = (Button)findViewById(R.id.bntLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                i.putExtra("id", id);
                i.putExtra("name", password);
                startActivity(i);
            }
        });

//        if(isLoggin){
//            startActivity(i);
//            finish();
//        }
//
//        txtUserName = (EditText)findViewById(R.id.txtUser);
//        txtPassword = (EditText)findViewById(R.id.txtPassword);
//        btnLogin = (Button)findViewById(R.id.bntLogin);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = txtUserName.getText().toString();
//                String password = txtPassword.getText().toString();
//                if(name.equals("nghia") || password.equals("abc")) {
//                    startActivity(i);
//                }
//            }
//        });



    }
}
