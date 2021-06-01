package com.example.qrcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class ListActivity extends AppCompatActivity {
View  list;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               Menu menu = snapshot.getValue(Menu.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

  /*  public void clickSave(View view){
        String data= et.getText().toString();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();

        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                String nickname = user.getKakaoAccount().getProfile().getNickname();
                String menu = null;

                Menu menu1 = new Menu(nickname,menu);

                DatabaseReference MenuRef = rootRef;


                MenuRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer= new StringBuffer();
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Menu menu1 = snapshot.getValue(Menu.class);
                            String nickname = menu1.getNickname();
                            String menu = menu1.getMenu();

                            buffer.append(nickname+"\n");
                        }
                        tv.setText(buffer);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



                return null;
            }
        });
    }*/
}