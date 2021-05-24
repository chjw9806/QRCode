package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class OrderActivity extends AppCompatActivity {

    Button button,button2,button3;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);




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
                UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                    @Override
                    public Unit invoke(User user, Throwable throwable) {
                        if (user != null) {
                            databaseReference.child("menu").child(user.getKakaoAccount().getProfile().getNickname()).push().setValue("아이스 카페 아메리카노");
                            Intent intent = new Intent(getApplicationContext(), StarbucksOrderActivity.class);
                            startActivity(intent);

                        }else{

                        }
                        return null;
                    }
                });
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                    @Override
                    public Unit invoke(User user, Throwable throwable) {
                        if (user != null) {
                            databaseReference.child("menu").child(user.getKakaoAccount().getProfile().getNickname()).push().setValue("아이스 카페 라떼");
                            Intent intent = new Intent(getApplicationContext(), StarbucksOrderActivity.class);
                            startActivity(intent);

                        }else{

                        }
                        return null;
                    }
                });
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                    @Override
                    public Unit invoke(User user, Throwable throwable) {
                        if (user != null) {
                            databaseReference.child("menu").child(user.getKakaoAccount().getProfile().getNickname()).push().setValue("아이스 바닐라 라떼");
                            Intent intent = new Intent(getApplicationContext(), StarbucksOrderActivity.class);
                            startActivity(intent);

                        }else{

                        }
                        return null;
                    }
                });
            }
        });


    }



}