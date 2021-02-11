package com.uhwaw.breadboard_1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.sql.Struct;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class ChooseRegister extends AppCompatActivity {

    Button btnR1, btnR2, btnR3, btnR4, btnCom, btnCho, btnEd;
    EditText etRegister, etNum, etLoc;
    TextView tvP;
    Integer b, x, R0, R1, R2, R3, R4, w = 0, register, e = 0, rgst, count;
    Double q = 99999.4;
    String a, z = " ", qaz, qaq, Name = "file", Name1 = "Loc";
    String registerLocation[] = {"0","0","0","0","0","0","0","0","0","0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_register);
        setTitle("저항 선택");

        btnR1 = (Button) findViewById(R.id.BtnR1);
        btnR2 = (Button) findViewById(R.id.BtnR2);
        btnR3 = (Button) findViewById(R.id.BtnR3);
        btnR4 = (Button) findViewById(R.id.BtnR4);
        btnCom = (Button) findViewById(R.id.BtnRegComplete);
        btnCho = (Button) findViewById(R.id.btCh);
        btnEd = (Button) findViewById(R.id.btned);
        tvP = (TextView) findViewById(R.id.TVper);
        etRegister = (EditText) findViewById(R.id.Edit_register);
        etNum = (EditText) findViewById(R.id.etNum);
        etLoc = (EditText) findViewById(R.id.etLoc);
        a = etRegister.getText().toString();

        btnCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String qwe = etRegister.getText().toString();
                tvP.setText(qwe.toString());
                etRegister.setVisibility(View.GONE);
                tvP.setVisibility(View.VISIBLE);
                rgst = Integer.valueOf(qwe);

                RChe(rgst);
                RCheck(R1, R2, R3);


                Color(R1, btnR1);
                Color(R2, btnR2);
                Color(R3, btnR3);
                Color(50, btnR4);
            }
        });

        btnEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvP.setText("");
                tvP.setVisibility(View.GONE);
                etRegister.setVisibility(View.VISIBLE);
            }
        });


        btnR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterColor(q);
            }
        });

        btnR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterColor(q);
            }
        });

        btnR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterColor(q);
            }
        });

        btnR4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterColor(q);
            }
        });

        Intent intent1 = new Intent(getIntent());
        register = intent1.getIntExtra("register", 0);

        count = intent1.getIntExtra("num", 0);
        qaz = intent1.getStringExtra("tvgas");
        qaq = intent1.getStringExtra("loc");


        R0 = register;
        R1 = (register / 1000);
        register -= (R1 * 1000);
        R2 = (register / 100);
        register -= (R2 * 100);
        R3 = (register / 10);
        register -= (R3 * 10);

        if (register == 1)
            R4 = 50;
        else
            R4 = 100;


        q = RCheck(R1, R2, R3);
        etRegister.setText(q.toString() + z);
        if (q != 0) {
            etRegister.setVisibility(View.GONE);
            tvP.setVisibility(View.VISIBLE);
            tvP.setGravity(Gravity.RIGHT);

            if (q % 1.0 == 0) {
                e = q.intValue();
                tvP.setText(e.toString() + z + " ± " + (R4 / 10) + "%");
            } else
                tvP.setText(q.toString() + z + " ± " + (R4 / 10) + "%");

        }
        Color(R1, btnR1);
        Color(R2, btnR2);
        Color(R3, btnR3);
        Color(R4, btnR4);

        btnCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreadBoard(R0);
            }
        });

        String str = getPreferences();

        if (qaz != null)
            etNum.setText(qaz + str);
        else
            etNum.setText(str);

        String strLoc = getLocPreferences();
        String temp;

        if(strLoc.length() ==5) {
            temp = strLoc.substring(0,3) + "0" + strLoc.substring(3,5) ;
            Log.d("temp",temp);
            strLoc = temp;
        }

        if (qaq != null) {
            etLoc.setText(qaq + strLoc);
        }

        else
            etLoc.setText(strLoc);


        if (count == -1) {
            etNum.setText("");
            etLoc.setText("");
        }
        Log.d("count", Integer.toString(count));
    }



    //저장했던 이름 불러오기
    public String getPreferences(){
        SharedPreferences sf = getSharedPreferences(Name,0);
        return sf.getString("name","");
    }
    public String getLocPreferences(){
        SharedPreferences sf1 = getSharedPreferences(Name1,0);
        return sf1.getString("loc","");
    }

    //이름 저장하기
    public void savePreferences() {
        SharedPreferences sf = getSharedPreferences(Name, 0);
        SharedPreferences.Editor editor = sf.edit();
        String str = etNum.getText().toString();
        editor.putString("name", str);

        SharedPreferences sf1 = getSharedPreferences(Name1,0);
        SharedPreferences.Editor editor1 = sf1.edit();
        String strLoc = etLoc.getText().toString();
        editor1.putString("loc",strLoc);

        Log.d("locationSavePreferences",strLoc);

        editor.commit();
        editor1.commit();
    }


    //앱 종료시
    public void onStop() {
        super.onStop();
        savePreferences();
    }

    public double RCheck(int a1,int a2,int a3){
        int ten=1,count = 0;
        double cal, a;

        for(int i = 0; i<a3; i++)
            ten*=10;

        a=((a1*10)+a2)*ten;

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
    } //저항값 계산

    public void RChe(int num){
        int ten=num,a1,a2,a3,count=0;
        double cal, a;

        while(ten<99&&ten>9) {
            ten /= 10;
            count+=1;
        }
        a3 = count;
        a2 = ten % 10;
        a1 = ten / 10;

        R1 = a1;
        R2 = a2;
        R3 = a3;

    } //저항값 역계산

    public void openRegisterColor(double x){
        Intent intent = new Intent(this, RegisterColor.class);
        intent.putExtra("x",x);
        intent.putExtra("num",count+1);
        startActivity(intent);
    }

    public void openBreadBoard(int x){
        Intent intent = new Intent(getApplicationContext(),BreadBoard.class);
        intent.putExtra("R0",x);
        intent.putExtra("num",count);
        intent.putExtra("count",etNum.getText().toString());
        intent.putExtra("loc",etLoc.getText().toString());
        startActivity(intent);
    }


    public void Color(int r ,Button btn){
        if(r == 0)
            btn.setBackgroundColor(Color.rgb(00,00,00));
        if(r == 1)
            btn.setBackgroundColor(Color.rgb(74,00,00));
        if(r == 2)
            btn.setBackgroundColor(Color.rgb(0xff,00,00));
        if(r == 3)
            btn.setBackgroundColor(Color.rgb(0xff,0x6f,00));
        if(r == 4)
            btn.setBackgroundColor(Color.rgb(0xff,0xf2,20));
        if(r == 5)
            btn.setBackgroundColor(Color.rgb(57,0xde,31));
        if(r == 6)
            btn.setBackgroundColor(Color.rgb(00,88,0xff));
        if(r == 7)
            btn.setBackgroundColor(Color.rgb(0xb7,00,0xff));
        if(r == 8)
            btn.setBackgroundColor(Color.rgb(0x8c,0x8b,0x8b));
        if(r == 9)
            btn.setBackgroundColor(Color.rgb(0xff,0xff,0xff));
        if(r == 50)
            btn.setBackgroundColor(Color.rgb(0xff,0xd5,0x49));
        if(r == 100)
            btn.setBackgroundColor(Color.rgb(0xd6,0xd4,0xd1));
    }
}
