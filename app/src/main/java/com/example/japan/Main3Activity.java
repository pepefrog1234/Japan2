package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("成績統計");
        Bundle bundle=getIntent().getExtras();
        float yy=bundle.getFloat("yy");
        int total=bundle.getInt("total");
        int correct=bundle.getInt("correct");
        int error=bundle.getInt("error");
        double fast=bundle.getDouble("fast");
        double slow=bundle.getDouble("slow");
        String avgtime=bundle.getString("avgtime");
        Float favgtime=Float.parseFloat(avgtime);
        TextView t=findViewById(R.id.textView7); //總題數
        TextView c=findViewById(R.id.textView6); //答對的題數
        TextView e=findViewById(R.id.textView8); //答錯的題數
        TextView f=findViewById(R.id.textView10); //最快反應時間
        TextView s=findViewById(R.id.textView11); //最慢反應時間
        TextView y=findViewById(R.id.textView14);
        TextView avg=findViewById(R.id.textView9);
        y.setText("答對率:"+yy);
        avg.setText("平均反應時間:"+favgtime);
        t.setText("總答題數:"+total);
        c.setText("總答對題數:"+correct);
        e.setText("總答錯題數:"+error);
        f.setText("最快反應時間:"+fast);
        s.setText("最慢反應時間:"+slow);
    }
}
