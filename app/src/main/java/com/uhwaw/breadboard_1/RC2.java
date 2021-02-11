package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RC2 extends AppCompatActivity {

    Button btnGold,btnSilver;
    Integer register3=99,b=0,count,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc2);
        btnGold = (Button)findViewById(R.id.RegisterGold);
        btnSilver = (Button)findViewById(R.id.RegisterSilver);
        setTitle("네번째 저항 선택");

        Intent intent = new Intent(getIntent());
        count = intent.getIntExtra("num", 0) ;
        location = intent.getIntExtra("loc", 0) ;
        b = getIntent().getIntExtra("register3",0);

        Button Buttongister[] = new Button[9];
        Integer ButtonID[] = {R.id.Register1,R.id.Register2,R.id.Register3,R.id.Register4,
                R.id.Register5,R.id.Register6,R.id.Register7,R.id.Register8,R.id.Register9};

        for(int i=0; i<Buttongister.length;i++){
            final int index;
            index = i;
            Buttongister[index] = (Button)findViewById(ButtonID[index]);

            Buttongister[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(),"금색과 은색중 선택하세요.",Toast.LENGTH_SHORT).show();

                    btnGold.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            register3 = 1;
                            openR1(b);
                        }
                    });
                    btnSilver.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            register3 = 2;
                            openR1(b);
                        }
                    });
                }

            });
        }
        btnGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 1;
                openR1(b);
            }
        });
        btnSilver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register3 = 2;
                openR1(b);
            }
        });

    }

    public void openR1(int a){
        Intent intent = new Intent(this,ChooseRegister.class);
        a+=register3;
        intent.putExtra("register",a);
        intent.putExtra("num",count);
        intent.putExtra("loc",location);
        startActivity(intent);

    }
}
