package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StarbucksChoiceActivity extends AppCompatActivity {
    Button americano, cafemoca, dolce, vanilla,toffenut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setTitle("메뉴판");

        americano = findViewById(R.id.btnStarAme);
        vanilla = findViewById(R.id.btnStarVanilla);
        cafemoca = findViewById(R.id.btnStarCafemoca);
        dolce = findViewById(R.id.btnStarDolce);
       toffenut = findViewById(R.id.btnStarToffenut);



        americano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StarbucksOrderActivity.class);
                intent.putExtra("StarbucksAmericano","스타벅스 아메리카노");
                startActivity(intent);


            }
        });
        vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    Intent intent = new Intent(getApplicationContext(),  StarbucksOrderActivity.class);
                    intent.putExtra("StarbucksVanillaLatte", "스타벅스 바닐라라떼");
                    startActivity(intent);


                }
            }
        });
        cafemoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  StarbucksOrderActivity.class);
                intent.putExtra("StarbucksCafemoca","스타벅스 카페모카");
                startActivity(intent);


            }
        });
        dolce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  StarbucksOrderActivity.class);
                intent.putExtra("StarbucksDolceLatte","스타벅스 돌페라떼");
                startActivity(intent);


            }
        });
        toffenut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),  StarbucksOrderActivity.class);
                intent.putExtra("Starbucks ToffenutLatte","스타벅스 토피넛라떼");
                startActivity(intent);


            }
        });


    }



}