package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterColor extends AppCompatActivity {
    Integer register = 100,b=0,register1,register2,register3,register4;
    Integer a[] = new Integer[10];

    Button btnR0,btnR1,btnR2,btnR3,btnR4, btnR5, btnR6,btnR7, btnR8,btnR9,btnRGold,btnRSilver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_color);
        setTitle("첫번째 저항 선택");

        btnR0 = (Button)findViewById(R.id.Register0);
        btnR1 = (Button)findViewById(R.id.Register1);
        btnR2 = (Button)findViewById(R.id.Register2);
        btnR3 = (Button)findViewById(R.id.Register3);
        btnR4 = (Button)findViewById(R.id.Register4);
        btnR5 = (Button)findViewById(R.id.Register5);
        btnR6 = (Button)findViewById(R.id.Register6);
        btnR7 = (Button)findViewById(R.id.Register7);
        btnR8 = (Button)findViewById(R.id.Register8);
        btnR9 = (Button)findViewById(R.id.Register9);
        btnRGold = (Button)findViewById(R.id.RegisterGold);
        btnRSilver = (Button)findViewById(R.id.RegisterSilver);

        btnR0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 0;
                openR1(b);
            }
        });
        btnR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 1;
                openR1(b);
            }
        });
        btnR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 2;
                openR1(b);
            }
        });
        btnR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 3;
                openR1(b);
            }
        });
        btnR4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 4;
                openR1(b);
            }
        });
        btnR5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 5;
                openR1(b);

            }
        });
        btnR6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 6;
                openR1(b);
            }
        });
        btnR7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 7;
                openR1(b);
            }
        });
        btnR8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 8;
                openR1(b);
            }
        });
        btnR9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register = 9;
                openR1(b);
            }
        });

    }
    public void openR1(int x){
        Intent intent1 = new Intent(this, RC.class);
        x += (register*1000);
        intent1.putExtra("register1",x);
        startActivity(intent1);
    }

}
