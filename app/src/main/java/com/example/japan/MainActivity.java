package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("日文五十音訓練");
        button1=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(runb);

    }

    @Override
    public void onClick(View v){
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
    private Button.OnClickListener runb;

    {
        runb = new Button.OnClickListener() { //自訂函式
            @Override
            public void onClick(View v) {//按下去按鈕執行程式的地方
                Intent intent2=new Intent();
                intent2.setClass(MainActivity.this,Main4Activity.class);
                startActivity(intent2);
            }
        };

    }
}


