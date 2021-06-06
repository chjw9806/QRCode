package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StarbucksChoiceActivity extends AppCompatActivity {

    Button button,button2,button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        button = findViewById(R.id.btnEdiyaAmericano);
        button2 = findViewById(R.id.btnEdiyaCafelatte);
        button3 = findViewById(R.id.btnEdiyaDalgona);



       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("menu").push().setValue("아이스 아메리카노");
                Intent intent = new Intent(OrderActivity.this,StarbucksOrderActivity.class);
                startActivity(intent);
            }
        });
*/
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), StarbucksOrderActivity.class);
                intent1.putExtra("americano","아이스 카페 아메리카노");
                startActivity(intent1);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    Intent intent2 = new Intent(getApplicationContext(), StarbucksOrderActivity.class);
                    intent2.putExtra("cafelatte", "아이스 카페라떼");
                    startActivity(intent2);


                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(getApplicationContext(), StarbucksOrderActivity.class);
                intent3.putExtra("vanillalatte","아이스 바닐라 라떼");
                startActivity(intent3);


            }
        });


    }



}