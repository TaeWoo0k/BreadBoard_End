package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int TextColor;
    Button btnBreadBoard,btnVIR,btnHow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 메뉴");
        btnBreadBoard = (Button)findViewById(R.id.BtnBreadBoard);
        btnVIR = (Button)findViewById(R.id.BtnVIR);
        btnHow = (Button)findViewById(R.id.BtnHow);
        btnBreadBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        btnVIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        btnHow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this,BreadBoard.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this,Gongsik.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this,way.class);
        startActivity(intent);

    }

}
