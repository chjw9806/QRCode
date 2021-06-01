package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomMenuActivity extends AppCompatActivity {
    public View cardview;
    public ImageView imageView1;

    int[] images = new int[] {
            R.drawable.c1,R.drawable.c2,R.drawable.c3
    };
    int[] randomMenus= new int[]{};
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_menu);



        cardview = findViewById(R.id.cardView2);

       imageView1 =findViewById(R.id.imageView7);




        int imageId = (int)(Math.random()*images.length);
        imageView1.setImageResource(images[imageId]);

        }

    }












