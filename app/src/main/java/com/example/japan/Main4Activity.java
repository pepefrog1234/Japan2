package com.example.japan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity{
    Button back,clear,next,front;
    TextView t,c,e,f,slow,avg,y,test;
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference data=database.getReference("data");
    int dat=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t=findViewById(R.id.textView15);
        c=findViewById(R.id.textView17);
        e=findViewById(R.id.textView18);
        avg=findViewById(R.id.textView19);
        f=findViewById(R.id.textView20);
        slow=findViewById(R.id.textView21);
        y=findViewById(R.id.textView16);
        test=findViewById(R.id.textView22);
        next=findViewById(R.id.next);
        front=findViewById(R.id.front);
        back=findViewById(R.id.button9);
        next.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                dat++;
                /*if(dat>fin){
                    dat--;
                }*/
            }
        });
        front.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                dat--;
                if(dat<1){
                    dat++;
                }
            }
        });
        test.setText("test:"+dat);
        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Main4Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        clear=findViewById(R.id.button10);
        clear.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                data.removeValue();
            }
        });
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                final int fin=(int)dataSnapshot.getChildrenCount();
                next.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dat++;
                        if(dat>fin){
                            dat--;
                        }
                    }
                });
                front.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dat--;
                        if(dat<1){
                            dat++;
                        }
                    }
                });
                t.setText("總答題數:"+dataSnapshot.child(String.valueOf(dat)).child("total").getValue());
                c.setText("總答對題數:"+dataSnapshot.child(String.valueOf(dat)).child("correct").getValue());
                e.setText("總答錯題數:"+dataSnapshot.child(String.valueOf(dat)).child("error").getValue());
                f.setText("最快反應時間:"+dataSnapshot.child(String.valueOf(dat)).child("fast").getValue());
                slow.setText("最慢反應時間:"+dataSnapshot.child(String.valueOf(dat)).child("slow").getValue());
                avg.setText("平均反應時間:"+dataSnapshot.child(String.valueOf(dat)).child("avgtime").getValue());
                y.setText("答對率:"+dataSnapshot.child(String.valueOf(dat)).child("yy").getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}