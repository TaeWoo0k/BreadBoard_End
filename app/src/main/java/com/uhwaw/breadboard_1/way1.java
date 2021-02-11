package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class way1 extends AppCompatActivity {
Button btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way1);
        setTitle("사용 방법");

        btn2 = (Button)findViewById(R.id.btnback);
        btn3 = (Button)findViewById(R.id.btnnext);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this,way2.class);
        startActivity(intent);
    }
}
