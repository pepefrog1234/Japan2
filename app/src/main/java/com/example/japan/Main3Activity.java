package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private Button exit;
    private Button replay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        exit=(Button)findViewById(R.id.button3);
        replay=(Button)findViewById(R.id.button8);
        exit.setOnClickListener(fexit);
        replay.setOnClickListener(freplay);

        setTitle("成績統計");
        Bundle bundle=getIntent().getExtras();
        String yy=bundle.getString("yy");
        String avgtime=bundle.getString("avgtime");
        Float fyy =Float.parseFloat(yy);
        Float favgtime=Float.parseFloat(avgtime);
        TextView y=findViewById(R.id.textView14);
        TextView avg=findViewById(R.id.textView5);
        y.setText("答對率:"+fyy);
        avg.setText("平均反應時間:"+favgtime);
    }
    private Button.OnClickListener fexit;
    private Button.OnClickListener freplay;
    {
        fexit = new Button.OnClickListener() { //自訂函式
            @Override
            public void onClick(View v) {//按下去按鈕執行程式的地方
                Intent intent=new Intent();
                intent.setClass(Main3Activity.this,MainActivity.class);
                startActivity(intent);

            }
        };
        {
            freplay = new Button.OnClickListener() { //自訂函式
                @Override
                public void onClick(View v) {//按下去按鈕執行程式的地方
                    Intent intent=new Intent();
                    intent.setClass(Main3Activity.this,Main2Activity.class);
                    startActivity(intent);
                }
            };
        }
    }
}
