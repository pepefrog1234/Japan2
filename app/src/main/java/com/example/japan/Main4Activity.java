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
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity{
    Button back,clear,enter,front,next;
    TextView t,c,e,f,slow,avg,y,times;
    EditText search;
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference data=database.getReference("data");
    int change=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        search=findViewById(R.id.editTextTextPersonName);
        enter=findViewById(R.id.button11);
        t=findViewById(R.id.textView15);
        c=findViewById(R.id.textView17);
        e=findViewById(R.id.textView18);
        avg=findViewById(R.id.textView19);
        f=findViewById(R.id.textView20);
        slow=findViewById(R.id.textView21);
        y=findViewById(R.id.textView16);
        times=findViewById(R.id.textView24);
        next=findViewById(R.id.button12);
        front=findViewById(R.id.button13);
        back=findViewById(R.id.button9);
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
                change=0;
            }
        });
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                final int fin=(int)dataSnapshot.getChildrenCount();
                enter.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!("").equals(search.getText().toString()) && fin>=Integer.parseInt(search.getText().toString())){
                            change=Integer.parseInt(search.getText().toString());
                            t.setText("總答題數:"+dataSnapshot.child(String.valueOf(change)).child("total").getValue());
                            c.setText("總答對題數:"+dataSnapshot.child(String.valueOf(change)).child("correct").getValue());
                            e.setText("總答錯題數:"+dataSnapshot.child(String.valueOf(change)).child("error").getValue());
                            f.setText("最快反應時間:"+dataSnapshot.child(String.valueOf(change)).child("fast").getValue());
                            slow.setText("最慢反應時間:"+dataSnapshot.child(String.valueOf(change)).child("slow").getValue());
                            avg.setText("平均反應時間:"+dataSnapshot.child(String.valueOf(change)).child("avgtime").getValue());
                            y.setText("答對率:"+Math.rint(Double.parseDouble(String.valueOf(dataSnapshot.child(String.valueOf(change)).child("yy").getValue()))*100)/100+"%");
                            times.setText("第"+change+"次測驗");
                        }
                    }
                });
                next.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        change++;
                        if(change>fin) {
                            change--;
                        }
                        else {
                            t.setText("總答題數:" + dataSnapshot.child(String.valueOf(change)).child("total").getValue());
                            c.setText("總答對題數:" + dataSnapshot.child(String.valueOf(change)).child("correct").getValue());
                            e.setText("總答錯題數:" + dataSnapshot.child(String.valueOf(change)).child("error").getValue());
                            f.setText("最快反應時間:" + dataSnapshot.child(String.valueOf(change)).child("fast").getValue());
                            slow.setText("最慢反應時間:" + dataSnapshot.child(String.valueOf(change)).child("slow").getValue());
                            avg.setText("平均反應時間:" + dataSnapshot.child(String.valueOf(change)).child("avgtime").getValue());
                            y.setText("答對率:" + Math.rint(Double.parseDouble(String.valueOf(dataSnapshot.child(String.valueOf(change)).child("yy").getValue())) * 100) / 100 + "%");
                            times.setText("第" + change + "次測驗");
                        }
                    }
                });
                front.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        change--;
                        if(change<=0){
                            change++;
                        }
                        else {
                            t.setText("總答題數:" + dataSnapshot.child(String.valueOf(change)).child("total").getValue());
                            c.setText("總答對題數:" + dataSnapshot.child(String.valueOf(change)).child("correct").getValue());
                            e.setText("總答錯題數:" + dataSnapshot.child(String.valueOf(change)).child("error").getValue());
                            f.setText("最快反應時間:" + dataSnapshot.child(String.valueOf(change)).child("fast").getValue());
                            slow.setText("最慢反應時間:" + dataSnapshot.child(String.valueOf(change)).child("slow").getValue());
                            avg.setText("平均反應時間:" + dataSnapshot.child(String.valueOf(change)).child("avgtime").getValue());
                            y.setText("答對率:" + Math.rint(Double.parseDouble(String.valueOf(dataSnapshot.child(String.valueOf(change)).child("yy").getValue())) * 100) / 100 + "%");
                            times.setText("第" + change + "次測驗");
                        }
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}