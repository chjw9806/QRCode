package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class StarbucksOrderActivity extends AppCompatActivity {

    Button drinkOrderbtn;
    EditText orderEdit;

    private String DrinkName;
    private String DrinkDetails;
    private String Nickname;

    long mNow = System.currentTimeMillis();
    Date mReDate = new Date(mNow);
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String OrderTime = mFormat.format(mReDate);

    String Americano;
    String Cafelatte;
    String Vanillalatte;
    static int i =0;
    public static int j = 0;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("sample");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starbucks_order);

        Intent intent1 = getIntent();
        Intent intent2 = getIntent();
        Intent intent3 = getIntent();

        Americano = intent1.getStringExtra("americano");
        Cafelatte = intent2.getStringExtra("cafelatte");
        Vanillalatte = intent3.getStringExtra("vanillalatte");


        drinkOrderbtn = (Button)findViewById(R.id.drinkOrderbtn);
        orderEdit = (EditText)findViewById(R.id.orderEdit);



       if(Americano!=null) {
           DrinkName = Americano;
       }else if(Cafelatte!=null){
           DrinkName = Cafelatte;}
       else if(Vanillalatte!= null) {
           DrinkName = Vanillalatte;
       }else{return;}



        drinkOrderbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                i++;

                UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {

                    @Override
                    public Unit invoke(User user, Throwable throwable) {
                        DrinkDetails = orderEdit.getText().toString();

                        String nickname = user.getKakaoAccount().getProfile().getNickname();


                         Menu menu = new Menu(nickname,DrinkName,DrinkDetails,OrderTime);

                        databaseReference.child("menu").child("'"+nickname+"'").child(i+"번째 주문").setValue(menu);
                        databaseReference.child("menu").child("POS").child("STARBUCKS").child(nickname+"고객의"+j+"번째 주문").setValue(menu);

                        return null;

                    }

                });



            }
        });
    }
}