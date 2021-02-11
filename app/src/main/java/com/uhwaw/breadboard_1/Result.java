package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    Integer w=0;
    Double r, v,i,q;
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
        tvv.setText(" = " + v.toString() + " V");
        r = intent.getDoubleExtra("r",0);
        double r1 = RCheck(r);
        tvr.setText(" = "+ r1+ z +" Ω");
        btnReturn = (Button)findViewById(R.id.BtnReturn);

        i= (v / r)*1000;
        tvi.setText(" = "+i.toString()+"mA");
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

    public double RCheck(double r){

        double rr;
        rr = r;
        while(rr>=1000){
            w++;
            rr/=1000;
        }

        switch (w) {
            case 1: z="K";
                break;

            case 2: z="M";
                break;

            case 3: z="G";
                break;
        }

        return rr;
    }
}

