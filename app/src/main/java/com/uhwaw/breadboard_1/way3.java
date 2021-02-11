package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class way3 extends AppCompatActivity {
    Button btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way3);
        setTitle("사용 방법");

        btn4 = (Button)findViewById(R.id.btnback);
        btn5 = (Button)findViewById(R.id.btnnext);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this,way4.class);
        startActivity(intent);
    }

}
