package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChooseLine extends AppCompatActivity {

    Button btnBlack, btnRed, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("선 선택");

        setContentView(R.layout.activity_choose_line);
        btnBlack = (Button) findViewById(R.id.BtnBlackLine);
        btnRed = (Button) findViewById(R.id.BtnRedLine);
        btnBlue = (Button) findViewById(R.id.BtnBlueLine);

//        if (etHeight != null && etWidth != null) {
            final int width,heght;
            btnRed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity(1);
                }
            });

            btnBlack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity(2);
                }
            });

            btnBlue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity(3);
                }
            });
//        }



//            Toast.makeText(getApplicationContext(),"너비와 높이를 입력하세요.",Toast.LENGTH_SHORT).show();
//
    }

    public void openActivity(int color) {
        Intent intent = new Intent(this, BreadBoard.class);
        intent.putExtra("L0",color);
        startActivity(intent);
    }
}