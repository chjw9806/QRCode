package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CafeListActivity extends AppCompatActivity {

    View starbucks, ediya, twosome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_list);

        starbucks = findViewById(R.id.starbuckscard);
        ediya = findViewById(R.id.ediyacard);
        twosome = findViewById(R.id.twosomecard);

        starbucks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StarbucksChoiceActivity.class);
                startActivity(intent);
            }
        });

        ediya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EdiyaChoiceActivity.class);
                startActivity(intent);
            }
        });
        twosome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TwosomeChoiceActivity.class);
                startActivity(intent);
            }
        });


    }


}