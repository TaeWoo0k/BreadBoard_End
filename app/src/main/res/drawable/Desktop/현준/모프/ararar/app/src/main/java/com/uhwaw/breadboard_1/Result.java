package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    Integer r,w=0;
    Double v,i,q;
    TextView tvr,tvi,tvv;
    Button btnReturn;
    String z=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("결과");
        tvr = (TextView)findViewById(R.id.tvR);
        tvi = (TextView)findViewById(R.id.tvI);
        tvv = (TextView)findViewById(R.id.tvV);

        Intent intent = getIntent();
        v = intent.getDoubleExtra("v",0);
        tvv.setText("전압 = " + v.toString() + " V");
        r = intent.getIntExtra("r",0);
        Double r1 = RCheck(r);
        tvr.setText("저항 = "+ r1.toString()+ z +" Ω");
        btnReturn = (Button)findViewById(R.id.BtnReturn);

        i = v / q;
        tvi.setText("전류 = "+i.toString()+" A");
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public double RCheck(int r){
        int ten=1,a1,a2,a3,a4;
        double cal, a;

        a1 = r / 1000;
        r %= 1000;
        a2 = r / 100;
        r %= 100;
        a3 = r / 10;
        a4 = r % 10;

        for(int i = 0; i<a3; i++)
            ten*=10;

        a=((a1*10)+a2)*ten;
        q=a;

        while(a>=1000){
            w++;
            a/=1000;
        }

        switch (w) {
            case 1: z="K";
                break;

            case 2: z="M";
                break;

            case 3: z="G";
                break;
        }
        cal=a;

        return cal;
    }
}

