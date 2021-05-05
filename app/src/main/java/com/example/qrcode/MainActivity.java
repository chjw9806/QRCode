package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;


public class MainActivity extends AppCompatActivity {
    //private Button createQRBtn;
    private Button scanQRBtn, btnOrder, btnLogin, btnList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //createQRBtn = (Button) findViewById(R.id.createQR);
        scanQRBtn = (Button) findViewById(R.id.scanQR);
        btnOrder = findViewById(R.id.btnOrder);
        btnList = findViewById(R.id.btnList);
        btnLogin = findViewById(R.id.btnLogin);



        /*createQRBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CreateQR.class);
                startActivity(intent);
            }
        });*/

        scanQRBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ScanQR.class);
                startActivity(intent);
            }
        });

       btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, LoginActivity.class);
               startActivity(intent);
           }
       });
       btnList.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, ListActivity.class);
               startActivity(intent);
           }
       });
    }
}