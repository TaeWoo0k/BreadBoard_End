package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class way2 extends AppCompatActivity {
    Button btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way2);
        setTitle("사용 방법");

        btn3 = (Button)findViewById(R.id.btnback);
        btn4 = (Button)findViewById(R.id.btnnext);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this,way3.class);
        startActivity(intent);
    }
}

