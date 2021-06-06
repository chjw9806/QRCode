package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class EdiyaOrderActivity extends AppCompatActivity {
    Button drinkOrderbtn;
    EditText orderEdit;

    private String DrinkName;
    private String DrinkDetails;
    private String Nickname;

    long mNow = System.currentTimeMillis();
    Date mReDate = new Date(mNow);
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String OrderTime = mFormat.format(mReDate);

    String eAmericano;
    String eCafelatte;
    String eDalgona;
    String eVanillalatte;
    String eSignature;
    static int i =0;
    public static int k = 0;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("sample");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ediya_order);

        Intent intent1 = getIntent();
        Intent intent2 = getIntent();
        Intent intent3 = getIntent();
        Intent intent4 = getIntent();
        Intent intent5 = getIntent();

        eAmericano = intent1.getStringExtra("EdiyaAmericano");
        eCafelatte = intent2.getStringExtra("EdiyaCafelatte");
       eDalgona = intent3.getStringExtra("EdiyaDalgonalatte");
        eVanillalatte = intent3.getStringExtra("EdiyaVanillalatte");
        eSignature = intent3.getStringExtra("EdiyaSignature");


        drinkOrderbtn = (Button)findViewById(R.id.drinkOrderbtn);
        orderEdit = (EditText)findViewById(R.id.orderEdit);



        if(eAmericano!=null) {
            DrinkName = eAmericano;
        }else if(eCafelatte!=null){
            DrinkName = eCafelatte;}
        else if(eDalgona!= null) {
            DrinkName = eDalgona;
        }else if(eVanillalatte!= null) {
            DrinkName = eVanillalatte;
        }
        else if( eSignature!= null) {
            DrinkName =  eSignature;
        }
        else{return;}



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
                        databaseReference.child("menu").child("POS").child("EDIYA").child(nickname+"고객의"+i+"번째 주문").setValue(menu);

                        return null;

                    }

                });



            }
        });
    }
}