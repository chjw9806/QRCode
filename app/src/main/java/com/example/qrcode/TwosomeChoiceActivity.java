package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwosomeChoiceActivity extends AppCompatActivity {

    Button americano, cafemoca, caramel, coldbrew, signature, dalgona, tonic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twosome_choice);
        getSupportActionBar().setTitle("메뉴판");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFCD853F));

        americano = findViewById(R.id.btnTwoAmericano);
        cafemoca = findViewById(R.id.btnTwoCafemoca);
        dalgona = findViewById(R.id.btnTwoDalgona);
        caramel = findViewById(R.id.btnTwoCaramel);
        signature = findViewById(R.id.btnTwoSignature);
        coldbrew = findViewById(R.id.btnTwoColdbrew);
        tonic = findViewById(R.id.btnTwoTonic);



        americano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  TwosomeOrderActivity.class);
                intent.putExtra("TwosomeAmericano","투썸 아메리카노");
                startActivity(intent);


            }
        });
        cafemoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    Intent intent = new Intent(getApplicationContext(),   TwosomeOrderActivity.class);
                    intent.putExtra("TwosomeCafemoca", "투썸 아이스 카페라떼");
                    startActivity(intent);


                }
            }
        });
        dalgona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),   TwosomeOrderActivity.class);
                intent.putExtra("TwosomeDalgonalatte","투썸 달고나 라떼");
                startActivity(intent);


            }
        });
        coldbrew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),   TwosomeOrderActivity.class);
                intent.putExtra("TwosomeColdbrew","투썸 콜드브루");
                startActivity(intent);


            }
        });
        signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),   TwosomeOrderActivity.class);
                intent.putExtra("TwosomeSignature","투썸 시그니처");
                startActivity(intent);


            }
        });
       caramel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  TwosomeOrderActivity.class);
                intent.putExtra("TwosomeCaramel","투썸 캬라멜 마끼아또");
                startActivity(intent);


            }
        });
       tonic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TwosomeOrderActivity.class);
                intent.putExtra("TwosomeColdbrewtonic","투썸 콜드브루토닉");
                startActivity(intent);


            }
        });

    }

}