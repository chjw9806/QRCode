package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EdiyaChoiceActivity extends AppCompatActivity {

    Button americano, cafelatte, dalgona, vanilla, signature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ediya_choice);


        americano = findViewById(R.id.btnEdiyaAmericano);
        cafelatte = findViewById(R.id.btnEdiyaCafelatte);
        dalgona = findViewById(R.id.btnEdiyaDalgona);
        vanilla = findViewById(R.id.btnEdiyaVanilla);
        signature = findViewById(R.id.btnEdiyaSignature);



        americano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), EdiyaOrderActivity.class);
                intent1.putExtra("EdiyaAmericano","아메리카노");
                startActivity(intent1);


            }
        });
        cafelatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    Intent intent2 = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                    intent2.putExtra("EdiyaCafelatte", "아이스 카페라떼");
                    startActivity(intent2);


                }
            }
        });
        dalgona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                intent3.putExtra("EdiyaDalgonalatte","달고나 라떼");
                startActivity(intent3);


            }
        });
        vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                intent4.putExtra("EdiyaVanillalatte","바닐라 라떼");
                startActivity(intent4);


            }
        });
        signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent5 = new Intent(getApplicationContext(),  EdiyaOrderActivity.class);
                intent5.putExtra("EdiyaSignature","이디야 시그니처");
                startActivity(intent5);


            }
        });


    }


}