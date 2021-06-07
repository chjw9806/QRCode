package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EdiyaChoiceActivity extends AppCompatActivity {

    Button americano, cafelatte, dalgona, vanilla, signature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ediya_choice);
        getSupportActionBar().setTitle("메뉴판");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFCD853F));

        americano = findViewById(R.id.btnEdiyaAmericano);
        cafelatte = findViewById(R.id.btnEdiyaCafelatte);
        dalgona = findViewById(R.id.btnEdiyaDalgona);
        vanilla = findViewById(R.id.btnEdiyaVanilla);
        signature = findViewById(R.id.btnEdiyaSignature);



        americano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EdiyaOrderActivity.class);
                intent.putExtra("EdiyaAmericano","이디야 아메리카노");
                startActivity(intent);


            }
        });
        cafelatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    Intent intent = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                    intent.putExtra("EdiyaCafelatte", "이디야 카페라떼");
                    startActivity(intent);


                }
            }
        });
        dalgona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                intent.putExtra("EdiyaDalgonalatte","이디야 달고나 라떼");
                startActivity(intent);


            }
        });
        vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                intent.putExtra("EdiyaVanillalatte","이디야 바닐라 라떼");
                startActivity(intent);


            }
        });
        signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                intent.putExtra("EdiyaSignature","이디야 시그니처");
                startActivity(intent);


            }
        });


    }


}