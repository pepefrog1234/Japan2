package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference data=database.getReference("data");
        data.child("total").setValue(0);
        data.child("correct").setValue(0);
        data.child("error").setValue(0);
        data.child("fast").setValue(0);
        data.child("slow").setValue(0);
        data.child("avgtime").setValue(0);
    }
}