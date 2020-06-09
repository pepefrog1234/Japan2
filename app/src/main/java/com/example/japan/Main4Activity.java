package com.example.japan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
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

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    Button back;
    TextView t,c,e,f,slow,avg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference data=database.getReference("data");

        t=findViewById(R.id.textView15);
        c=findViewById(R.id.textView17);
        e=findViewById(R.id.textView18);
        avg=findViewById(R.id.textView19);
        f=findViewById(R.id.textView20);
        slow=findViewById(R.id.textView21);
        back=findViewById(R.id.button9);
        back.setOnClickListener(this);

        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t.setText("總答題數:"+dataSnapshot.child("total").getValue());
                c.setText("總答對題數:"+dataSnapshot.child("correct").getValue());
                e.setText("總答錯題數:"+dataSnapshot.child("error").getValue());
                f.setText("最快反應時間:"+dataSnapshot.child("fast").getValue());
                slow.setText("最慢反應時間:"+dataSnapshot.child("slow").getValue());
                avg.setText("平均反應時間"+dataSnapshot.child("avgtime").getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    @Override
    public void onClick(View v){
        Intent intent=new Intent();
        intent.setClass(Main4Activity.this,MainActivity.class);
        startActivity(intent);
    }
}