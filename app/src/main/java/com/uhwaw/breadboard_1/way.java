package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class way extends AppCompatActivity {
    Button btnmain1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way);
        setTitle("사용 방법");
        btnmain1 = (Button)findViewById(R.id.btnback);
        btn1 = (Button)findViewById(R.id.btnnext);

        btnmain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

    }
    public void openActivity() {
        Intent intent = new Intent(this, way1.class);
        startActivity(intent);
    }


}
