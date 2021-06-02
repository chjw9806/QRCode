package com.example.qrcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

import static java.security.AccessController.getContext;

public class ListActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Menu> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    static  int i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();




        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override

            public Unit invoke(User user, Throwable throwable) {

                database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동
                databaseReference = database.getReference("sample").child("menu").child(user.getKakaoAccount().getProfile().getNickname());
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // firebase 데이터베이스의 데이터를 받아오는 곳
                        // 기존 배열리스트 존재하지 않게 초기화
                          arrayList.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List 추출
                            Menu menu = snapshot.getValue(Menu.class);
                            // 만들어뒀던 User 객체에 데이터를 담는다.
                            arrayList.add(menu); // 담은 데이터를 배열리스트에 넣고 리사이클러뷰로 보낼준비
                        }
                        adapter.notifyDataSetChanged();  // 리스트 저장 및 새로고침
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) { // 데이터베이스 가져오던 중 에러 발생시
                        Log.e("ListActivity", String.valueOf(databaseError.toException()));
                    }
                });
                return null;

            }

        });

        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);


    }


}


              /* rootRef.addValueEventListener(new ValueEventListener() {
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
