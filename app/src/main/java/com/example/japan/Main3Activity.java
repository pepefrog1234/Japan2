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
        String yy=bundle.getString("yy");
        String avgtime=bundle.getString("avgtime");
        Float fyy =Float.parseFloat(yy);
        Float favgtime=Float.parseFloat(avgtime);
        TextView y=findViewById(R.id.textView14);
        TextView avg=findViewById(R.id.textView5);
        y.setText("答對率:"+fyy);
        avg.setText("平均反應時間:"+favgtime);
    }
}
