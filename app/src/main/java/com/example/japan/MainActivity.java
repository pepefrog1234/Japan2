package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("日文五十音訓練");
        button1=(Button)findViewById(R.id.button);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent=new Intent();
        intent.setClass(this,test.class);
        startActivity(intent);
    }


}
