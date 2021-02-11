package com.uhwaw.breadboard_1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class BreadBoard extends AppCompatActivity {

    Button btnCom, btnV, btnLine, btnR, btnL1, btnL2, btnVChoose;
    FrameLayout frame, frameV;
    EditText etV;
    TextView tvR, tvL;
    Integer R0 = 0, L0,stt;

    Double v = 0.000001;
    public int a = 0;
    public int end;
    public int start= -1;
    public int temp;
    public double x;
    public int x_intright;
    public int x_intleft;
    public double x_right;
    public double x_left;
    public int mid;
    public double substract;
    public double result;
    public Integer btncolor[] = new Integer[4];
    public int tem, begin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_board);
        setTitle("BreadBoard");

        btnCom = (Button) findViewById(R.id.BtnBreadComp);
        btnLine = (Button) findViewById(R.id.BtnLine);
        btnR = (Button) findViewById(R.id.BtnRegister);
        btnL1 = (Button) findViewById(R.id.BtnL1);
        btnL2 = (Button) findViewById(R.id.BtnL2);
        btnV = (Button) findViewById(R.id.BtnVoltage);
        btnVChoose = (Button) findViewById(R.id.BtnVolChoose);
        etV = (EditText) findViewById(R.id.EtV);
        frameV = (FrameLayout) findViewById(R.id.FlVolt);
        frame = (FrameLayout) findViewById(R.id.FrameLayout);
        tvR = (TextView) findViewById(R.id.TextRegister);
        tvL = (TextView) findViewById(R.id.TextLine);

        final Button holeButton[] = new Button[30];

        Integer btnname[] = {R.id.hole1_1, R.id.hole1_2, R.id.hole1_3, R.id.hole1_4, R.id.hole1_5,
                R.id.hole2_1, R.id.hole2_2, R.id.hole2_3, R.id.hole2_4, R.id.hole2_5,
                R.id.hole3_1, R.id.hole3_2, R.id.hole3_3, R.id.hole3_4, R.id.hole3_5,
                R.id.hole4_1, R.id.hole4_2, R.id.hole4_3, R.id.hole4_4, R.id.hole4_5,
                R.id.hole5_1, R.id.hole5_2, R.id.hole5_3, R.id.hole5_4, R.id.hole5_5,
                R.id.hole6_1, R.id.hole6_2, R.id.hole6_3, R.id.hole6_4, R.id.hole6_5};

        Intent intent = new Intent(getIntent());
        R0 = intent.getIntExtra("R0", 12344567);

        tem = R0 / 1000;
        btncolor[0] = tem;
        tem = R0 % 1000;
        btncolor[1] = tem / 100;
        tem = R0 % 100;
        btncolor[2] = tem / 10;
        btncolor[3] = tem % 10;
        if (btncolor[3] == 1)
            btncolor[3] = 50;
        else
            btncolor[3] = 100;

        if (R0 != 12344567) {
            Toast.makeText(BreadBoard.this, "시작점을 입력하세요", Toast.LENGTH_SHORT).show();
            if(begin ==0)
                frame.setVisibility(View.INVISIBLE);
        }
        Intent intent2 = new Intent(getIntent());
        L0 = intent2.getIntExtra("L0", 12344567);
        stt = intent2.getIntExtra("start", -1);
        tvL.setText(stt.toString());
        tvR.setText(v.toString());


        for (int i = 0; i < 30; i++) {
            final int index;

            index = i;
            holeButton[index] = (Button) findViewById(btnname[index]);

                holeButton[index].setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {


                        btnL1.setVisibility(View.INVISIBLE);
                        btnL2.setVisibility(View.INVISIBLE);
                        Location(index);
                        btnLine.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openLine();
                            }
                        });

                        btnR.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openRegister();
                            }
                        });

                        if(L0 == 1) {   //빨간선
                            if (start == -1) {
                                start = index;
                            } else {
                                end = index;
                                if (start > end) {
                                    temp = start;
                                    start = end;
                                    end = temp;
                                }
                                substract = (double) (start - end);
                                if (substract % 5.00 == 0.00) {
                                    holeButton[start].setBackgroundResource(R.drawable.holeup);
                                    for (int i = start; i != end; i = i + 5) {
                                        holeButton[i + 5].setBackgroundResource(R.drawable.redline1);

                                    }
                                    holeButton[end].setBackgroundResource(R.drawable.holedown);

                                    if(end!=0)
                                        frame.setVisibility(View.INVISIBLE);
                                    start = -1;
                                    end = 0;

                                }
                                else if (substract % 5.00 != 0.00) {
                                    holeButton[start].setBackgroundResource(R.drawable.holestart);
                                    for (int i = start; i != end; i++) {
                                        holeButton[i + 1].setBackgroundResource(R.drawable.redline);

                                    }
                                    holeButton[end].setBackgroundResource(R.drawable.holeend);

                                    if(end!=0)
                                        frame.setVisibility(View.INVISIBLE);
                                    start = -1;
                                    end = 0;
                                }

                            }
                        }   //빨간선
                        if(L0 == 2) {   //검정선
                            if (start == -1) {
                                start = index;
                            } else {
                                end = index;
                                if (start > end) {
                                    temp = start;
                                    start = end;
                                    end = temp;
                                }
                                substract = (double) (start - end);
                                if (substract % 5.00 == 0.00) {
                                    holeButton[start].setBackgroundResource(R.drawable.holeup_b);
                                    for (int i = start; i != end; i = i + 5) {
                                        holeButton[i + 5].setBackgroundResource(R.drawable.blackline1);

                                    }
                                    holeButton[end].setBackgroundResource(R.drawable.holedown_b);

                                    if(end!=0)
                                        frame.setVisibility(View.INVISIBLE);
                                    start = -1;
                                    end = 0;

                                }
                                else if (substract % 5.00 != 0.00) {
                                    holeButton[start].setBackgroundResource(R.drawable.holeleft_b);
                                    for (int i = start; i != end; i++) {
                                        holeButton[i + 1].setBackgroundResource(R.drawable.blackline);

                                    }
                                    holeButton[end].setBackgroundResource(R.drawable.holeright_b);

                                    if(end!=0)
                                        frame.setVisibility(View.INVISIBLE);
                                    start = -1;
                                    end = 0;
                                }

                            }
                        }   //검정선
                        if(L0 == 3) {
                            if (start == -1) {
                                start = index;
                            } else {
                                end = index;
                                if (start > end) {
                                    temp = start;
                                    start = end;
                                    end = temp;
                                }
                                substract = (double) (start - end);
                                if (substract % 5.00 == 0.00) {
                                    holeButton[start].setBackgroundResource(R.drawable.holeup_u);
                                    for (int i = start; i != end; i = i + 5) {
                                        holeButton[i + 5].setBackgroundResource(R.drawable.blueline1);

                                    }
                                    holeButton[end].setBackgroundResource(R.drawable.holedown_u);

                                    if (end != 0)
                                        frame.setVisibility(View.INVISIBLE);
                                    start = -1;
                                    end = 0;

                                } else if (substract % 5.00 != 0.00) {
                                    holeButton[start].setBackgroundResource(R.drawable.holeleft_u);
                                    for (int i = start; i != end; i++) {
                                        holeButton[i + 1].setBackgroundResource(R.drawable.blueline);

                                    }
                                    holeButton[end].setBackgroundResource(R.drawable.holeright_u);

                                    if (end != 0)
                                        frame.setVisibility(View.INVISIBLE);
                                    start = -1;
                                    end = 0;
                                }

                            }
                        }   //파랑선

                        if(R0!=12344567) {
                            if (start == -1) {
                                start = index;
                                if (begin == 0) {
                                    Toast.makeText(BreadBoard.this, "끝점을 입력하세요", Toast.LENGTH_SHORT).show();
                                    frame.setVisibility(View.INVISIBLE);
                                }
                                begin++;
                            } else {
                                end = index;
                                if (start > end) {
                                    temp = start;
                                    start = end;
                                    end = temp;
                                }
                                    substract = (double) (start - end);
                                    if (substract % 5.00 == 0.00) {

                                        if ((end - start) == 15) {
                                            int y = 0;
                                            for (int i = start; i <= end; i = i + 5) {
                                                Color(btncolor[y], holeButton[i]);
                                                y++;
                                            }
                                        } else {

                                            mid = ((end / 5) - (start / 5)) / 2;
                                            int y = 0;
                                            for (int i = 0; i <= 15; i = i + 5) {
                                                Color(btncolor[y], holeButton[start + (mid - 1) * 5 + i]);
                                                y++;
                                            }
                                            for (int i = 0; i < (mid - 1) * 5; i = i + 5) {
                                                if (i == 0) {
                                                    holeButton[start + i].setBackgroundResource(R.drawable.regupstart);
                                                } else
                                                    holeButton[start + i].setBackgroundResource(R.drawable.reg);

                                            }

                                            if ((start + (mid + 2) * 5) != end) {
                                                for (int i = (start + (mid + 3) * 5); i < end; i = i + 5) {
                                                    holeButton[i].setBackgroundResource(R.drawable.reg);
                                                }
                                                holeButton[end].setBackgroundResource(R.drawable.regdownend);
                                            }
                                        }
                                        if (end != 0)
                                            frame.setVisibility(View.INVISIBLE);

                                        a = 0;
                                        start = -1;
                                        end = 0;

                                    } else if (substract % 5.00 != 0.00) {
                                        if ((end - start) == 3) {
                                            int y = 0;
                                            for (int i = start; i <= end; i++) {
                                                Color(btncolor[y], holeButton[i]);
                                                y++;
                                            }

                                        } else {

                                            mid = (end - start) / 2;

                                            for (int i = 0; i < 4; i++) {

                                                Color(btncolor[i], holeButton[start + mid - 1 + i]);
                                            }

                                            for (int i = 0; i < mid - 1; i++) {
                                                if (i == 0) {
                                                    holeButton[start + i].setBackgroundResource(R.drawable.regstart);
                                                } else {
                                                    holeButton[start + i].setBackgroundResource(R.drawable.reg1);
                                                }
                                            }
                                            if ((start + mid + 2) != end) {
                                                for (int i = (start + mid + 3); i < end; i++) {
                                                    holeButton[i].setBackgroundResource(R.drawable.reg1);
                                                }
                                                holeButton[end].setBackgroundResource(R.drawable.regend);
                                            }
                                        }
                                    }
                                    if (end != 0)
                                        frame.setVisibility(View.INVISIBLE);
                                    a = 0;
                                    start = -1;
                                    end = 0;
                                }
                        }//저항출력
                    }
                });
        }
            btnV.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            frameV.setVisibility(View.VISIBLE);
                            btnVChoose.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String vol ;
                                    double volt=0;
                                    vol = etV.getText().toString();
                                    volt= Double.valueOf(vol).doubleValue();
                                    volValue(volt);
                                    v=volt;
                                }
                            });
                        }
                    });

            btnCom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (v != 0.000001)
                        openResult(v,R0);
                    else
                        Toast.makeText(getApplicationContext(), "전압버튼을 눌러 전압을 입력하세요", Toast.LENGTH_SHORT).show();
                }
            });

                }





        public void LineColor(Button btnl1,Button btnl2, int line){

                 if (line == 1)  //빨간선
                 {
                     btnl1.setBackgroundColor(Color.rgb(0xf7, 03, 03));
                     btnl2.setBackgroundColor(Color.rgb(0xf7, 03, 03));
                     btnl1.setVisibility(View.VISIBLE);
                     btnl2.setVisibility(View.VISIBLE);
                     btnL1.setWidth(3000);
                }

                if (line == 2)  //검정선
                {
                    btnl1.setBackgroundColor(Color.rgb(00, 00, 00));
                    btnl2.setBackgroundColor(Color.rgb(00, 00, 00));
                    btnl1.setVisibility(View.VISIBLE);
                    btnl2.setVisibility(View.VISIBLE);
                }
                if (line == 3)   //파란선
                {
                    btnl1.setBackgroundColor(Color.rgb(03, 28, 0xf7));
                    btnl2.setBackgroundColor(Color.rgb(03, 28, 0xf7));
                    btnl1.setVisibility(View.VISIBLE);
                    btnl2.setVisibility(View.VISIBLE);
                }
        }//선 색에따라 색 변경 함수

    public void Line(int width , int height){
       ViewGroup.LayoutParams params = btnL1.getLayoutParams();
       params.width=btnL1.getWidth()*width;
       btnL1.setLayoutParams(params);
//
//       ViewGroup.LayoutParams params1 = btnL2.getLayoutParams();
//       params1.height = (btnL2.getHeight()*height);
//       btnL2.setLayoutParams(params1);



    }

    public void openLine(){
        Intent intent = new Intent(this,ChooseLine.class);
        intent.putExtra("start",start);
        startActivity(intent);
    }//ChooseLine.xml 로 가는 함수

    public void openRegister(){
        Intent intent = new Intent(this,ChooseRegister.class);
        intent.putExtra("start",start);
        startActivity(intent);
    }//ChooseRegister.xml로 가는 함수

    public void Location(int index){
        int x=0,y=0;

        for(int i = 0 ; i<30; i++) {

                if (x > 4) {
                    x = 0;
                    y += 1;
                }
                x += 1;

            if (index == i){
                frame.setX(15+(50*(x-1)));
                frame.setY(190+(50*y));
            }
            frame.setVisibility(View.VISIBLE);
        }
    }   //구멍 버튼을 눌렀을때 그 위치로 말풍선이 오게하는 매소드

    public void volValue (double v){
        btnV.setText(Double.toString(v)+"V");
        frameV.setVisibility(View.INVISIBLE);

    }       //전압버튼에 숫자 표시

    public void openResult(double v,int r) {
        Intent intent1 = new Intent(this, Result.class);
        intent1.putExtra("v", v);
        intent1.putExtra("r",r);
        startActivity(intent1);
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
    }//저항띠 색 설정
    public void Point(int start){
        int point=0;
        if(start != 12344567) {
            Toast.makeText(getApplicationContext(), "시작점을 입력하세요", Toast.LENGTH_SHORT).show();
            frame.setVisibility(View.INVISIBLE);
            point = 1;
        }
        if(point == 1) {
            Toast.makeText(getApplicationContext(), "끝점을 입력하세요", Toast.LENGTH_SHORT).show();
            point = 0;
        }
    }
}
