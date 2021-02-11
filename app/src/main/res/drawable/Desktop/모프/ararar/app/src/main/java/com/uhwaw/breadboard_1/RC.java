package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RC extends AppCompatActivity {

    Button btnR0,btnR1,btnR2,btnR3,btnR4,btnR5,btnR6,btnR7,btnR8,btnR9;
    Integer register3=99,b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc);
        setTitle("두번째 저항 선택");

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

        Intent intnet = new Intent(getIntent());
        b = getIntent().getIntExtra("register1",0);


        btnR0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 0;
                openR1(b);
            }
        });
        btnR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 1;
                openR1(b);
            }
        });
        btnR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 2;
                openR1(b);
            }
        });
        btnR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 3;
                openR1(b);
            }
        });
        btnR4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 4;
                openR1(b);
            }
        });
        btnR5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 5;
                openR1(b);

            }
        });
        btnR6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 6;
                openR1(b);
            }
        });
        btnR7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 7;
                openR1(b);
            }
        });
        btnR8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 8;
                openR1(b);
            }
        });
        btnR9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 9;
                openR1(b);
            }
        });
    }


    public void openR1(int a) {
        Intent intent = new Intent(this, RC1.class);
        a += (register3 * 100);
        intent.putExtra("register2", a);
        startActivity(intent);
    }
}
