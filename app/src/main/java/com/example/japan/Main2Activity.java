package com.example.japan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.Toast;
import java.util.ArrayList;
import java.text.DecimalFormat;
//github push test
public class Main2Activity extends AppCompatActivity {
    private Button a;//宣告變數
    private Button b;//宣告變數
    private Button c;//宣告變數
    private Button d;
    private TextView Q;
    private TextView sum;
    private TextView yy;
    private TextView ms;
    private TextView avgtime;
    private TextView t;
    int random,total=0,yes=0,no=0;
    double fast=1000,slow=0,sum1=0.0;
    ArrayList list=new ArrayList();
    DecimalFormat df=new DecimalFormat("######0.00");
    String[][] x = {{"あ ", "a"}, {"い", "i"}, {"う", "u"}, {"え", "e"}, {"お", "o"},{"か","ka"},
            {"き ","ki"},{"く","ku"},{"け","ke"},{"こ","ko"},{"さ","sa"},{"し","shi"},
            {"す","su"},{"せ","se"},{"そ","so"},{"た","ta"},{"ち","chi"},{"つ","tsu"},
            {"て","te"},{"と","to"},{"な","na"},{"に","ni"},{"ぬ","nu"},{"ね","ne"},{"の ","no"},
            {"は","ha"},{"ひ","hi"},{"ふ","fu"},{"へ","he"},{"ほ","ho"},{"ま","ma"},{"み","mi"},
            {"む","mu"},{"め","me"},{"も","mo"}, {"や","ya"},{"ゆ","yu"},{"よ","yo"},{"ら","ra"},
            {"り","ri"},{"る","ru"},{"れ","re"},{"ろ","ro"},{"わ","wa"},{"を","wo"},{"ん","n"}};
    int aa, bb, cc, dd,q;
    double k=0.0,times=0.0;
    boolean end=false,one=true,flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Q = (TextView) findViewById(R.id.textView);
        sum=(TextView) findViewById(R.id.textView2);
        yy=(TextView) findViewById(R.id.textView3);//答對率
        ms=(TextView)findViewById(R.id.textView4);//反應時間
        avgtime=(TextView)findViewById(R.id.textView12);//平均反應時間
        a = (Button) findViewById(R.id.button4); //取得介面按鈕元件(輸入元件id)
        b = (Button) findViewById(R.id.button5);//取得介面文字輸入框元件(輸入元件id)
        c = (Button) findViewById(R.id.button6);//取得介面顯示文字元件(輸入元件id)
        d = (Button) findViewById(R.id.button7);

        load();
        one=false;
        a.setOnClickListener(runa);//當button被按下後跑run的函式
        b.setOnClickListener(runb);
        c.setOnClickListener(runc);
        d.setOnClickListener(rund);
        Timer timer=new Timer();
        timer.schedule(time,0,10);
    }
    public TimerTask time = new TimerTask() {
        @Override
        public void run() {
            Message message=new Message();
            message.what=1;
            handler.sendMessage(message);
        }
    };
    private  Handler handler=new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    ms.setText("反應時間:"+Math.rint((times+=0.01)*100)/100);
                    break;
            }
        }
    };
    private CountDownTimer countDownTimer=new CountDownTimer(30000,1000){

        @Override
        public void onTick(long millisUntilFinished) {
            t=findViewById(R.id.textView13);
            t.setText("倒數計時:"+(millisUntilFinished/1000));
        }

        @Override
        public void onFinish() {
            for(int i=0;i<list.size();i++){
                fast=Math.min((Double) list.get(i),fast);
                slow=Math.max((Double) list.get(i),slow);
            }
            Intent intent=new Intent();
            intent.setClass(Main2Activity.this,Main3Activity.class);
            Bundle bundle=new Bundle();
            bundle.putFloat("yy", (float) (Math.rint(k*100)/100));
            bundle.putInt("total",total);
            bundle.putInt("correct",yes);
            bundle.putInt("error",no);
            bundle.putDouble("fast",(Math.rint(fast*100)/100));
            bundle.putDouble("slow",(Math.rint(slow*100)/100));
            bundle.putString("avgtime",df.format(sum1));
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }.start();
    public void load(){//載入題目
        times=0;
        end=false;
        Random r = new Random();
        random=r.nextInt(4);//選項順序
        q = r.nextInt(x.length);//第幾題
        Q.setText(x[q][0]);
        if (random == 0) {//a為正解
            a.setText(x[q][1]);//按鈕
            while (true) {
                bb = r.nextInt(x.length);
                cc = r.nextInt(x.length);
                dd = r.nextInt(x.length);
                if (bb != q && cc != q && dd != q&&bb!=cc&&cc!=dd&&bb!=dd) {
                    b.setText(x[bb][1]);
                    c.setText(x[cc][1]);
                    d.setText(x[dd][1]);
                    break;
                }
            }
        }
        if (random == 1) {//b為正解
            b.setText(x[q][1]);
            while (true) {
                aa = r.nextInt(x.length);
                cc = r.nextInt(x.length);
                dd = r.nextInt(x.length);
                if (aa != q && cc != q && dd != q&&aa!=cc&&cc!=dd&&aa!=dd) {
                    a.setText(x[aa][1]);
                    c.setText(x[cc][1]);
                    d.setText(x[dd][1]);
                    break;
                }
            }
        }
        if (random == 2) {//c為正解
            c.setText(x[q][1]);
            while (true) {
                bb = r.nextInt(x.length);
                aa = r.nextInt(x.length);
                dd = r.nextInt(x.length);
                if (bb != q && aa != q && dd != q&&bb!=aa&&aa!=dd&&bb!=dd&&aa!=cc) {
                    b.setText(x[bb][1]);
                    a.setText(x[aa][1]);
                    d.setText(x[dd][1]);
                    break;
                }
            }
        }
        if (random == 3) {//d為正解
            d.setText(x[q][1]);
            while (true) {
                bb = r.nextInt(x.length);
                cc = r.nextInt(x.length);
                aa = r.nextInt(x.length);
                if (bb != q && cc != q && aa != q&&bb!=cc&&cc!=aa&&bb!=aa) {
                    b.setText(x[bb][1]);
                    c.setText(x[cc][1]);
                    a.setText(x[aa][1]);
                    break;
                }
            }
        }
    }

    public void yesorno(int q,String a){
        if(x[q][1]==a){
            //sum.setText(x[q][0]+" "+a+" "+random);
            list.add(times);
            yes++;
            total++;
            sum1 += times;
            sum1/=yes;
            k= ((double) yes/(double) total)*100;
            avgtime.setText("平均反應時間："+df.format(sum1)+"秒");
            yy.setText("答對率："+Math.rint(k*100)/100+"%");
        }
        else {
            total++;
            no++;
            k= ((double) yes/(double) total)*100;
            //
            Toast.makeText(this, "答錯了正確答案是"+x[q][1], Toast.LENGTH_LONG).show();
            yy.setText("答對率："+Math.rint(k*100)/100+"%");
        }
    }

    private Button.OnClickListener runa;
    private Button.OnClickListener runb;
    private Button.OnClickListener runc;
    private Button.OnClickListener rund;

    {
        runa = new Button.OnClickListener() { //自訂函式
            @Override
            public void onClick(View v) {//按下去按鈕執行程式的地方
                yesorno(q,String.valueOf(a.getText()));
                end=true;
                load();

            }
        };
    }
    {
        runb = new Button.OnClickListener() { //自訂函式
            @Override
            public void onClick(View v) {//按下去按鈕執行程式的地方
                yesorno(q,String.valueOf(b.getText()));
                load();

            }
        };
    }

    {
        runc = new Button.OnClickListener() { //自訂函式
            @Override
            public void onClick(View v) {//按下去按鈕執行程式的地方
                yesorno(q, String.valueOf(c.getText()));
                load();
            }
        };
    }
    {
        rund = new Button.OnClickListener() { //自訂函式
            @Override
            public void onClick(View v) {//按下去按鈕執行程式的地方
                yesorno(q,String.valueOf(d.getText()));
                load();

            }
        };


    }
}
