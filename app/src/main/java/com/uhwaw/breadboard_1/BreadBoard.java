package com.uhwaw.breadboard_1;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Layout;
        import android.util.Log;
        import android.view.View;
        import android.view.ViewGroup;
        import android.webkit.WebView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.FrameLayout;
        import android.widget.TabHost;
        import android.view.MenuItem;
        import android.widget.TextView;
        import android.widget.Toast;

public class BreadBoard extends AppCompatActivity {
    Button btnCom, btnV, btnLine, btnR, btnL1, btnL2, btnVChoose,btngone;
    FrameLayout frame, frameV;
    EditText etV;
    TextView tvgone,tvgas,tvLV,tvLL;

    Integer R0 = 12344567 , L0,stt,regV,regL = 0;
    Integer as,es,count,ccount,starts,ends,lstarts,lends;
    Double v = 0.000001;
    String Name = " qwe";
    String qaz ,qaq,lqaz,lqaq, loc = "0", lloc = "0";
    String registerValue[] = {"0","0","0","0","0","0","0","0","0","0"};
    String registerLocation[] = {"0","0","0","0","0","0","0","0","0","0"};
    String lineValue[] =  {"0","0","0","0","0","0","0","0","0","0"};
    String lineLoc[] = {"0","0","0","0","0","0","0","0","0","0"};
    String registerV[] = {"0","0","0","0","0","0","0","0","0","0"};
    public int a = 0;
    public int end, bbarg =0,bbag =0;
    public int start= -1;
    public int temp;
    public int checkcheck=0;
    public double x;
    public int finishcheck = 0;
    public int ij;
    public int x_intright;
    public int x_intleft;
    public double x_right;
    public double x_left;
    public int mid;
    public double substract;
    public double result;
    public Integer btncolor[] = new Integer[4];
    public int tem, begin = 0, callValue;
    public double sumr = 0;
    public int jp = 0;
    public int tempbtn = 0;
    public int tempbtn1 = 0;
    public int paral;
    public int stop = 0;
    public int summparal;
    public int sumrparal;
    public int pp;
    public double summ = 0;
    public int sumend = 0;
    public int parallelcount = 0;
    public Integer btncolor1[] = new Integer[4];
    final Integer breadbtn[] = new Integer[300];
    public int tempparal;
    public int tem1;
    public int check = 0;
    public Button holeButton[] = new Button[300];
    public Integer linecolor[] = new Integer[300];
    public Integer linelocation[] = new Integer[300];
    public Integer regg[] = new Integer[300];
    public Integer reglocation[] = new Integer[300];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_board);
        setTitle("BreadBoard");

        btnCom = (Button) findViewById(R.id.BtnBreadComp);
//        btnLine = (Button) findViewById(R.id.BtnLine);
        btnR = (Button) findViewById(R.id.BtnRegister);
        btnL1 = (Button) findViewById(R.id.BtnL1);
        btnL2 = (Button) findViewById(R.id.BtnL2);
        btnV = (Button) findViewById(R.id.BtnVoltage);
        btnVChoose = (Button) findViewById(R.id.BtnVolChoose);
        etV = (EditText) findViewById(R.id.EtV);
        frameV = (FrameLayout) findViewById(R.id.FlVolt);
        frame = (FrameLayout) findViewById(R.id.FrameLayout);
        tvgas = (TextView) findViewById(R.id.tvgas);
        tvgone = (TextView) findViewById(R.id.tvgone);
        tvLV = (TextView)findViewById(R.id.tvLV);
        tvLL = (TextView)findViewById(R.id.tvLL);


        final Button holeButton[] = new Button[300];
        for (int i = 0; i < 300; i++) {
            breadbtn[i] = -1;
        }
        for (int i = 0; i < 300; i++) {
            linecolor[i] = 0;
            linelocation[i] = 0;
        }
        for (int i = 0; i < 300; i++) {
            regg[i] = 0;
            reglocation[i] = 0;
        }

        Integer btnname[] = {R.id.hole1_1, R.id.hole1_2, R.id.hole1_3, R.id.hole1_4, R.id.hole1_5, R.id.hole1_6, R.id.hole1_7, R.id.hole1_8, R.id.hole1_9, R.id.hole1_10, R.id.hole1_11, R.id.hole1_12,
                R.id.hole2_1, R.id.hole2_2, R.id.hole2_3, R.id.hole2_4, R.id.hole2_5, R.id.hole2_6, R.id.hole2_7, R.id.hole2_8, R.id.hole2_9, R.id.hole2_10, R.id.hole2_11, R.id.hole2_12,
                R.id.hole3_1, R.id.hole3_2, R.id.hole3_3, R.id.hole3_4, R.id.hole3_5, R.id.hole3_6, R.id.hole3_7, R.id.hole3_8, R.id.hole3_9, R.id.hole3_10, R.id.hole3_11, R.id.hole3_12,
                R.id.hole4_1, R.id.hole4_2, R.id.hole4_3, R.id.hole4_4, R.id.hole4_5, R.id.hole4_6, R.id.hole4_7, R.id.hole4_8, R.id.hole4_9, R.id.hole4_10, R.id.hole4_11, R.id.hole4_12,
                R.id.hole5_1, R.id.hole5_2, R.id.hole5_3, R.id.hole5_4, R.id.hole5_5, R.id.hole5_6, R.id.hole5_7, R.id.hole5_8, R.id.hole5_9, R.id.hole5_10, R.id.hole5_11, R.id.hole5_12,
                R.id.hole6_1, R.id.hole6_2, R.id.hole6_3, R.id.hole6_4, R.id.hole6_5, R.id.hole6_6, R.id.hole6_7, R.id.hole6_8, R.id.hole6_9, R.id.hole6_10, R.id.hole6_11, R.id.hole6_12,
                R.id.hole7_1, R.id.hole7_2, R.id.hole7_3, R.id.hole7_4, R.id.hole7_5, R.id.hole7_6, R.id.hole7_7, R.id.hole7_8, R.id.hole7_9, R.id.hole7_10, R.id.hole7_11, R.id.hole7_12,
                R.id.hole8_1, R.id.hole8_2, R.id.hole8_3, R.id.hole8_4, R.id.hole8_5, R.id.hole8_6, R.id.hole8_7, R.id.hole8_8, R.id.hole8_9, R.id.hole8_10, R.id.hole8_11, R.id.hole8_12,
                R.id.hole9_1, R.id.hole9_2, R.id.hole9_3, R.id.hole9_4, R.id.hole9_5, R.id.hole9_6, R.id.hole9_7, R.id.hole9_8, R.id.hole9_9, R.id.hole9_10, R.id.hole9_11, R.id.hole9_12,
                R.id.hole10_1, R.id.hole10_2, R.id.hole10_3, R.id.hole10_4, R.id.hole10_5, R.id.hole10_6, R.id.hole10_7, R.id.hole10_8, R.id.hole10_9, R.id.hole10_10, R.id.hole10_11, R.id.hole10_12,
                R.id.hole11_1, R.id.hole11_2, R.id.hole11_3, R.id.hole11_4, R.id.hole11_5, R.id.hole11_6, R.id.hole11_7, R.id.hole11_8, R.id.hole11_9, R.id.hole11_10, R.id.hole11_11, R.id.hole11_12,
                R.id.hole12_1, R.id.hole12_2, R.id.hole12_3, R.id.hole12_4, R.id.hole12_5, R.id.hole12_6, R.id.hole12_7, R.id.hole12_8, R.id.hole12_9, R.id.hole12_10, R.id.hole12_11, R.id.hole12_12,
                R.id.hole13_1, R.id.hole13_2, R.id.hole13_3, R.id.hole13_4, R.id.hole13_5, R.id.hole13_6, R.id.hole13_7, R.id.hole13_8, R.id.hole13_9, R.id.hole13_10, R.id.hole13_11, R.id.hole13_12,
                R.id.hole14_1, R.id.hole14_2, R.id.hole14_3, R.id.hole14_4, R.id.hole14_5, R.id.hole14_6, R.id.hole14_7, R.id.hole14_8, R.id.hole14_9, R.id.hole14_10, R.id.hole14_11, R.id.hole14_12,
                R.id.hole15_1, R.id.hole15_2, R.id.hole15_3, R.id.hole15_4, R.id.hole15_5, R.id.hole15_6, R.id.hole15_7, R.id.hole15_8, R.id.hole15_9, R.id.hole15_10, R.id.hole15_11, R.id.hole15_12,
                R.id.hole16_1, R.id.hole16_2, R.id.hole16_3, R.id.hole16_4, R.id.hole16_5, R.id.hole16_6, R.id.hole16_7, R.id.hole16_8, R.id.hole16_9, R.id.hole16_10, R.id.hole16_11, R.id.hole16_12,
                R.id.hole17_1, R.id.hole17_2, R.id.hole17_3, R.id.hole17_4, R.id.hole17_5, R.id.hole17_6, R.id.hole17_7, R.id.hole17_8, R.id.hole17_9, R.id.hole17_10, R.id.hole17_11, R.id.hole17_12,
                R.id.hole18_1, R.id.hole18_2, R.id.hole18_3, R.id.hole18_4, R.id.hole18_5, R.id.hole18_6, R.id.hole18_7, R.id.hole18_8, R.id.hole18_9, R.id.hole18_10, R.id.hole18_11, R.id.hole18_12,
                R.id.hole19_6, R.id.hole19_7};


        Intent intent = new Intent(getIntent());
        R0 = intent.getIntExtra("R0", 12344567);
        count = intent.getIntExtra("num",-1);
        ccount = intent.getIntExtra("ccount",0);
        String regValue= "", Location = "";

        if(R0 != 12344567){
            regValue = intent.getStringExtra("count");
            Location = intent.getStringExtra("loc");
            int qqrt = 0, qqre = 0;

            for (int i = count; i > 0; i--) {
                registerValue[i] = regValue.substring(qqrt,qqrt+4);
                regg [i] = Integer.valueOf(registerValue[i]);
                Log.d("SSABSSAB"+i, registerValue[i]);
                Log.d(" SSABSSABVVVVVVV"+i, Integer.toString(regg[i]));
                qqrt+=4;
            }

            for (int i = count; i > 0; i--) {
                registerLocation[i] = Location.substring(qqre,qqre+6);
                reglocation[i] = Integer.valueOf(registerLocation[i]);
                qqre+=6;
            }

        }
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
            savePreferences();
        }

        if (R0 != 12344567) {
            Toast.makeText(BreadBoard.this, "저항 시작점을 입력하세요", Toast.LENGTH_SHORT).show();
            if (begin == 0)
                frame.setVisibility(View.INVISIBLE);
        }
        Intent intent2 = new Intent(getIntent());
        L0 = intent2.getIntExtra("L0", 12344567);
        stt = intent2.getIntExtra("start", -1);

        if(L0 != 12344567)
            saveLinePreferences();

        if (L0 != 12344567) {
            Toast.makeText(BreadBoard.this, "선 시작점을 입력하세요", Toast.LENGTH_SHORT).show();
            if (begin == 0)
                frame.setVisibility(View.INVISIBLE);
        }
            if(L0 != 12344567) {
                regValue = intent.getStringExtra("count");
                Location = intent.getStringExtra("loc");
                int qqt = 0, qqe = 0;

                for (int i = count; i > 0; i--) {
                    lineValue[i] = regValue.substring(qqt, qqt + 1);
                    linecolor[i] = Integer.valueOf(lineValue[i]);
                    Log.d("SSABSSAB" + i, lineValue[i]);
                    Log.d(" SSABSSABVVVVVVV" + i, Integer.toString(linecolor[i]));
                    qqt += 1;
                }

                for (int i = count; i > 0; i--) {
                    lineLoc[i] = Location.substring(qqe, qqe + 6);
                    linelocation[i] = Integer.valueOf(lineLoc[i]);
                    qqe += 6;
                }

        }


        for (int i = 0; i < 216; i++) {
            final int index;

            index = i;


            holeButton[index] = (Button) findViewById(btnname[index]);
            if (index % 12 != 6 || index % 12 != 7) {
                holeButton[index].setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {

                        btnL1.setVisibility(View.INVISIBLE);
                        btnL2.setVisibility(View.INVISIBLE);
                        Location(index);
//                        btnLine.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                openLine();
//                            }
//                        });

                        btnR.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openRegister();
                            }
                        });
//                        if (L0 == 1) {   //빨간선
//                            if (start == -1) {
//                                start = index;
//                                if (begin == 0) {
//                                    Toast.makeText(BreadBoard.this, "빨간선 끝점을 입력하세요", Toast.LENGTH_SHORT).show();
//                                    frame.setVisibility(View.INVISIBLE);
//                                }
//                                begin++;
//                            } else {
//                                end = index;
//                                if (start > end) {
//                                    temp = start;
//                                    start = end;
//                                    end = temp;
//                                }
//                                lstarts = start;
//
//                                if (end < 100)
//                                    lends = end + 900;
//                                else
//                                    lends = end;
//                                lloc = Integer.toString((lends * 1000) + lstarts);
//                                substract = (double) (end - start);
//                                if (substract % 12.00 == 0.00) {
//                                    holeButton[start].setBackgroundResource(R.drawable.holeup);
//                                    for (int i = start; i != end; i = i + 12) {
//
//                                        holeButton[i + 12].setBackgroundResource(R.drawable.redline1);
//
//                                    }
//                                    holeButton[end].setBackgroundResource(R.drawable.holedown);
//
//                                    if (end != 0)
//                                        frame.setVisibility(View.INVISIBLE);
//                                    start = -1;
//                                    end = 0;
//
//                                } else if (substract % 12.00 != 0.00) {
//
//                                    for (int aa = 0; aa <= 300; aa += 12) {
//                                        if ((start >= aa && start <= aa + 11) && (end >= aa && end <= aa + 11)) {
//
//                                            holeButton[start].setBackgroundResource(R.drawable.holestart);
//                                            for (int i = start; i != end; i++) {
//                                                if ((i + 1) % 12 == 5)
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.redlinecross);
//                                                else if ((i + 1) % 12 == 6)
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.redlinecross2);
//                                                else
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.redline);
//
//                                            }
//                                            holeButton[end].setBackgroundResource(R.drawable.holeend);
//
//                                            if (end != 0)
//                                                frame.setVisibility(View.INVISIBLE);
//                                            start = -1;
//                                            end = 0;
//                                        }
//                                        if ((start >= aa && start <= aa + 11) && (end < aa || end > aa + 11))
//                                            Toast.makeText(BreadBoard.this, "직선으로 연결하세요", Toast.LENGTH_SHORT).show();
//                                    }
//
//
//                                }
//
//                            }
//                        }   //빨간선
//                        if (L0 == 2) {   //검정선
//                            if (start == -1) {
//                                start = index;
//                                if (begin == 0) {
//                                    Toast.makeText(BreadBoard.this, "검정선 끝점을 입력하세요", Toast.LENGTH_SHORT).show();
//                                    frame.setVisibility(View.INVISIBLE);
//                                }
//                                begin++;
//                            } else {
//                                end = index;
//                                if (start > end) {
//                                    temp = start;
//                                    start = end;
//                                    end = temp;
//                                }lstarts = start;
//
//                                if (end < 100)
//                                    lends = end + 900;
//                                else
//                                    lends = end;
//                                lloc = Integer.toString((lends * 1000) + lstarts);
//
//                                substract = (double) (end - start);
//                                if (substract % 12.00 == 0.00) {
//                                    holeButton[start].setBackgroundResource(R.drawable.holeup_b);
//                                    for (int i = start; i != end; i = i + 12) {
//                                        holeButton[i + 12].setBackgroundResource(R.drawable.blackline1);
//
//                                    }
//                                    holeButton[end].setBackgroundResource(R.drawable.holedown_b);
//
//                                    if (end != 0)
//                                        frame.setVisibility(View.INVISIBLE);
//                                    start = -1;
//                                    end = 0;
//
//                                } else if (substract % 12.00 != 0.00) {
//                                    for (int aa = 0; aa <= 300; aa += 12) {
//                                        if ((start >= aa && start <= aa + 11) && (end >= aa && end <= aa + 11)) {
//
//                                            holeButton[start].setBackgroundResource(R.drawable.holeleft_b);
//                                            for (int i = start; i != end; i++) {
//                                                if ((i + 1) % 12 == 5)
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.blacklinecross);
//                                                else if ((i + 1) % 12 == 6)
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.blacklinecross2);
//                                                else
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.blackline);
//
//                                            }
//                                            holeButton[end].setBackgroundResource(R.drawable.holeright_b);
//
//                                            if (end != 0)
//                                                frame.setVisibility(View.INVISIBLE);
//                                            start = -1;
//                                            end = 0;
//
//                                        }
//                                        if ((start >= aa && start <= aa + 11) && (end < aa || end > aa + 11))
//                                            Toast.makeText(BreadBoard.this, "직선으로 연결하세요", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                            }
//                        }   //검정선
//                        if (L0 == 3) {   //파란선
//                            if (start == -1) {
//                                start = index;
//                                if (begin == 0) {
//                                    Toast.makeText(BreadBoard.this, "파란선 끝점을 입력하세요", Toast.LENGTH_SHORT).show();
//                                    frame.setVisibility(View.INVISIBLE);
//                                }
//                                begin++;
//                            } else {
//                                end = index;
//                                if (start > end) {
//                                    temp = start;
//                                    start = end;
//                                    end = temp;
//                                }
//                                lstarts = start;
//
//                                if (end < 100)
//                                    lends = end + 900;
//                                else
//                                    lends = end;
//                                lloc = Integer.toString((lends * 1000) + lstarts);
//
//                                substract = (double) (end - start);
//                                if (substract % 12.00 == 0.00) {
//                                    holeButton[start].setBackgroundResource(R.drawable.holeup_u);
//                                    for (int i = start; i != end; i = i + 12) {
//                                        holeButton[i + 12].setBackgroundResource(R.drawable.blueline1);
//
//                                    }
//                                    holeButton[end].setBackgroundResource(R.drawable.holedown_u);
//
//                                    if (end != 0)
//                                        frame.setVisibility(View.INVISIBLE);
//                                    start = -1;
//                                    end = 0;
//
//                                } else if (substract % 12.00 != 0.00) {
//                                    for (int aa = 0; aa <= 300; aa += 12) {
//                                        if ((start >= aa && start <= aa + 11) && (end >= aa && end <= aa + 11)) {
//
//                                            holeButton[start].setBackgroundResource(R.drawable.holeleft_u);
//                                            for (int i = start; i != end; i++) {
//                                                if ((i + 1) % 12 == 5)
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.bluelinecross);
//                                                else if ((i + 1) % 12 == 6)
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.bluelinecross2);
//                                                else
//                                                    holeButton[i + 1].setBackgroundResource(R.drawable.blueline);
//
//                                            }
//                                            holeButton[end].setBackgroundResource(R.drawable.holeright_u);
//
//                                            if (end != 0)
//                                                frame.setVisibility(View.INVISIBLE);
//                                            start = -1;
//                                            end = 0;
//                                        }
//                                        if ((start >= aa && start <= aa + 11) && (end < aa || end > aa + 11))
//                                            Toast.makeText(BreadBoard.this, "직선으로 연결하세요", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                            }
//                        }   //파랑선         //선
                        //선

                        if (R0 != 12344567) {
                            if (start == -1) {
                                start = index;
                                holeButton[index].setBackgroundResource(R.drawable.holechoose);

                                if (begin == 0) {
                                    Toast.makeText(BreadBoard.this, "저항 끝점을 입력하세요", Toast.LENGTH_SHORT).show();
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
                                breadbtn[start] = end;
                                breadbtn[end] = -RCheck(R0);

                                starts = start;


                                if (end < 100)
                                    ends = end + 900;
                                else
                                    ends = end;

                                loc = Integer.toString((ends * 1000) + starts);
                                substract = (double) (end - start);




                                if (substract % 12.00 == 0.00) {
                                    switch (end - start) {
                                        case 12: {
                                            Toast.makeText(BreadBoard.this, "4칸 이상을 사용하시오", Toast.LENGTH_SHORT).show();
                                            breadbtn[start] = -1;
                                            breadbtn[end] = -1;
                                            break;
                                        }
                                        case 24: {
                                            Toast.makeText(BreadBoard.this, "4칸 이상을 사용하시오", Toast.LENGTH_SHORT).show();
                                            breadbtn[start] = -1;
                                            breadbtn[end] = -1;
                                            break;
                                        }
                                        case 36: {
                                            int y = 0;
                                            for (int i = start; i <= end; i = i + 12) {
                                                if (btncolor[y] == 0)
                                                    holeButton[i].setBackgroundColor(Color.rgb(00, 00, 00));
                                                if (btncolor[y] == 1)
                                                    holeButton[i].setBackgroundColor(Color.rgb(74, 00, 00));
                                                if (btncolor[y] == 2)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                                if (btncolor[y] == 3)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                                if (btncolor[y] == 4)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                                if (btncolor[y] == 5)
                                                    holeButton[i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                                if (btncolor[y] == 6)
                                                    holeButton[i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                                if (btncolor[y] == 7)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                                if (btncolor[y] == 8)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                                if (btncolor[y] == 9)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                                if (btncolor[y] == 50)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                                if (btncolor[y] == 100)
                                                    holeButton[i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));
                                                y++;

                                            }
                                        }
                                        default: {

                                            mid = ((end / 12) - (start / 12)) / 2;
                                            int y = 0;
                                            for (int i = 0; i <= 36; i = i + 12) {
                                                if (btncolor[y] == 0)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(00, 00, 00));
                                                if (btncolor[y] == 1)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(74, 00, 00));
                                                if (btncolor[y] == 2)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                                if (btncolor[y] == 3)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                                if (btncolor[y] == 4)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                                if (btncolor[y] == 5)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                                if (btncolor[y] == 6)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                                if (btncolor[y] == 7)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                                if (btncolor[y] == 8)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                                if (btncolor[y] == 9)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                                if (btncolor[y] == 50)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                                if (btncolor[y] == 100)
                                                    holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));
                                                y++;


                                            }
                                            for (int i = 0; i < (mid - 1) * 12; i = i + 12) {
                                                if (i == 0) {
                                                    holeButton[start + i].setBackgroundResource(R.drawable.regupstart);
                                                } else {
                                                    holeButton[start + i].setBackgroundResource(R.drawable.reg);
                                                }

                                            }

                                            if ((start + (mid + 2) * 12) != end) {
                                                for (int i = (start + (mid + 3) * 12); i < end; i = i + 12) {
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
                                    }

                                } else if (substract % 12.00 != 0.00) {

                                    for (int aa = 0; aa <= 300; aa += 12) {
                                        if ((start >= aa && start <= aa + 11) && (end >= aa && end <= aa + 11)) {
                                            switch (end - start) {
                                                case 1: {
                                                    Toast.makeText(BreadBoard.this, "4칸 이상을 사용하시오", Toast.LENGTH_SHORT).show();
                                                    breadbtn[start] = -1;
                                                    breadbtn[end] = -1;
                                                    break;
                                                }
                                                case 2: {
                                                    Toast.makeText(BreadBoard.this, "4칸 이상을 사용하시오", Toast.LENGTH_SHORT).show();
                                                    breadbtn[start] = -1;
                                                    breadbtn[end] = -1;
                                                    break;
                                                }

                                                case 3: {
                                                    int y = 0;
                                                    for (int i = start; i <= end; i++) {
                                                        if (btncolor[y] == 0)
                                                            holeButton[i].setBackgroundColor(Color.rgb(00, 00, 00));
                                                        if (btncolor[y] == 1)
                                                            holeButton[i].setBackgroundColor(Color.rgb(74, 00, 00));
                                                        if (btncolor[y] == 2)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                                        if (btncolor[y] == 3)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                                        if (btncolor[y] == 4)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                                        if (btncolor[y] == 5)
                                                            holeButton[i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                                        if (btncolor[y] == 6)
                                                            holeButton[i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                                        if (btncolor[y] == 7)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                                        if (btncolor[y] == 8)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                                        if (btncolor[y] == 9)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                                        if (btncolor[y] == 50)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                                        if (btncolor[y] == 100)
                                                            holeButton[i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));

                                                        y++;

                                                    }

                                                }
                                                default: {

                                                    mid = (end - start) / 2;

                                                    for (int i = 0; i < 4; i++) {
                                                        if (btncolor[i] == 0)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(00, 00, 00));
                                                        if (btncolor[i] == 1)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(74, 00, 00));
                                                        if (btncolor[i] == 2)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                                        if (btncolor[i] == 3)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                                        if (btncolor[i] == 4)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                                        if (btncolor[i] == 5)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                                        if (btncolor[i] == 6)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                                        if (btncolor[i] == 7)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                                        if (btncolor[i] == 8)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                                        if (btncolor[i] == 9)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                                        if (btncolor[i] == 50)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                                        if (btncolor[i] == 100)
                                                            holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));

                                                    }

                                                    for (int i = 0; i < mid - 1; i++) {
                                                        if (i == 0) {
                                                            holeButton[start + i].setBackgroundResource(R.drawable.regstart);
                                                        }
                                                        else if( ((start + i)%12) == 5)
                                                            holeButton[start + i].setBackgroundResource(R.drawable.redlinebreadboardreg);
                                                        else if( ((start + i)%12) == 6)
                                                            holeButton[start + i].setBackgroundResource(R.drawable.bluelinebreadboardreg);
                                                        else {
                                                            holeButton[start + i].setBackgroundResource(R.drawable.reg1);
                                                        }
                                                    }
                                                    if ((start + mid + 2) != end) {
                                                        for (int i = (start + mid + 3); i < end; i++) {
                                                            if((i % 12) == 5)
                                                                holeButton[i].setBackgroundResource(R.drawable.redlinebreadboardreg);
                                                            else if((i % 12)  == 6)
                                                                holeButton[i].setBackgroundResource(R.drawable.bluelinebreadboardreg);
                                                            else
                                                                holeButton[i].setBackgroundResource(R.drawable.reg1);
                                                        }
                                                        holeButton[end].setBackgroundResource(R.drawable.regend);
                                                }
                                                }
                                            }
                                        }

                                        if ((start >= aa && start <= aa + 11) && (end < aa || end > aa + 11)) {
                                            holeButton[start].setBackgroundResource(R.drawable.hole1);
                                            Toast.makeText(BreadBoard.this, "직선으로 연결하세요", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                }
                                if (end != 0)
                                    frame.setVisibility(View.INVISIBLE);
                                a = 0;
                                start = -1;
                                end = 0;
                            }

                        }
                    }
                    //저항출력

                });
            }
        }
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameV.setVisibility(View.VISIBLE);
                btnVChoose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String vol;
                        double volt = 0;
                        vol = etV.getText().toString();
                        volt = Double.valueOf(vol).doubleValue();
                        volValue(volt);
                        v = volt;
                    }
                });
            }
        });

        btnCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check = 0;

                summparal = 0;
                sumrparal = 0;
                sumend = 0;
                pp = 0;
                paral = -1;
                tempparal = 0;
                tempbtn1 = 0;
                parallelcount = 0;
                int switch1;

                if (v != 0.000001) {

                    for (int ii = 0; ii < 300; ii++) {

                        if (regg[ii] != 0) {
                            start = reglocation[ii] % 1000;
                            if (reglocation[ii]/1000 > 899)
                                end = (reglocation[ii] / 1000) - 900;
                            else
                                end = reglocation[ii] / 1000;


                            breadbtn[start] = end;
                            breadbtn[end] = -RCheck(regg[ii]);
                        }
                    }

                    //breadbtn[87] = 215;
                    //breadbtn[215] = -2;
                    //breadbtn[216] = 223;
                    //breadbtn[223] = -2;



                    for (int q = 0; q < 300; q++) {
                        if (breadbtn[q] >= 0) {
                            if (pp == 0) {
                                for (int aa = 0; aa <= 300; aa += 12) {

                                    if (q >= aa && q <= aa + 4) {
                                        for (int w = aa; w <= aa + 4; w++) {
                                            if (breadbtn[w] >= 0 && w != q) {
                                                parallelcount++;


                                                paral = w;

                                                if (breadbtn[paral] > breadbtn[q]) {
                                                    switch1 = q;
                                                    q = paral;
                                                    paral = switch1;

                                                }
                                                tempparal = breadbtn[paral];
                                                System.out.println("123breadbtn[paral]" + breadbtn[paral] + "Bread[temp]" + breadbtn[tempparal]);
                                                pp = 1;
                                                System.out.println("parallel  " + parallelcount);


                                            }
                                        }
                                    }
                                }
                                for (int aa = 7; aa <= 300; aa += 12) {

                                    if (q >= aa && q <= aa + 4) {
                                        for (int w = aa; w <= aa + 4; w++) {
                                            if (breadbtn[w] >= 0 && w != q) {
                                                parallelcount++;


                                                paral = w;

                                                if (breadbtn[paral] > breadbtn[q]) {
                                                    switch1 = q;
                                                    q = paral;
                                                    paral = switch1;

                                                }
                                                tempparal = breadbtn[paral];
                                                System.out.println("123breadbtn[paral]" + breadbtn[paral] + "Bread[temp]" + breadbtn[tempparal]);
                                                pp = 1;
                                                System.out.println("parallel  " + parallelcount);


                                            }
                                        }
                                    }
                                }
                            }

                            if (parallelcount == 0 && checkcheck ==0) {
                                tempbtn = breadbtn[q];


                                System.out.println(q + "   " + breadbtn[q] + "   " + breadbtn[tempbtn] + "sum" + sumr);
                                for (int aa = 0; aa <= 300; aa += 12) {
                                    if (breadbtn[q] >= aa && breadbtn[q] <= aa + 4) {

                                        for (int j = aa; j <= aa + 4; j++) {
                                            if (breadbtn[j] >= 0 && j != q) {
                                                tempbtn1 = breadbtn[j];
                                                System.out.println(j + "      " + breadbtn[j] + " ada  " + breadbtn[tempbtn1]);
                                                if(breadbtn[tempbtn1] == -2)
                                                    breadbtn[tempbtn1] = 0;
                                                if(breadbtn[tempbtn]==-2)
                                                    breadbtn[tempbtn] = 0;

                                                if (check == 0) {
                                                    sumr = summ + (-breadbtn[tempbtn]) + (-breadbtn[tempbtn1]);
                                                } else {
                                                    sumr = summ + (-breadbtn[tempbtn1]);
                                                }
                                                breadbtn[tempbtn1] = -(int) (sumr);
                                                System.out.println(sumr);
                                                summ = sumr;
                                                breadbtn[q] = breadbtn[j];
                                                breadbtn[j] = -1;
                                                breadbtn[tempbtn] = -1;
                                                System.out.println("breadbtn[q]" + breadbtn[q] + "Bread[temp]" + breadbtn[tempbtn]);
                                                System.out.println("breadbtn[j]" + breadbtn[j] + "Bread[temp1]" + breadbtn[tempbtn1]);
                                                System.out.println(tempbtn1 + "");
                                                System.out.println("sumr" + sumr);
                                                check++;
                                            }

                                            if (check == 0) {
                                                sumr = -breadbtn[tempbtn];
                                            }

                                        }
                                    }


                                }
                                for (int aa = 7; aa <= 300; aa += 12) {
                                    if (breadbtn[q] >= aa && breadbtn[q] <= aa + 4) {

                                        for (int j = aa; j <= aa + 4; j++) {
                                            if (breadbtn[j] >= 0 && j != q) {
                                                tempbtn1 = breadbtn[j];
                                                System.out.println(j + "      " + breadbtn[j] + " ada  " + breadbtn[tempbtn1]);
                                                if(breadbtn[tempbtn1] == -2)
                                                    breadbtn[tempbtn1] = 0;
                                                if(breadbtn[tempbtn]==-2)
                                                    breadbtn[tempbtn] = 0;
                                                if (check == 0) {
                                                    sumr = summ + (-breadbtn[tempbtn]) + (-breadbtn[tempbtn1]);
                                                } else {
                                                    sumr = summ + (-breadbtn[tempbtn1]);
                                                }
                                                breadbtn[tempbtn1] = -(int) (sumr);
                                                System.out.println(sumr);
                                                summ = sumr;
                                                breadbtn[q] = breadbtn[j];
                                                breadbtn[j] = -1;
                                                breadbtn[tempbtn] = -1;
                                                System.out.println("breadbtn[q]" + breadbtn[q] + "Bread[temp]" + breadbtn[tempbtn]);
                                                System.out.println("breadbtn[j]" + breadbtn[j] + "Bread[temp1]" + breadbtn[tempbtn1]);
                                                System.out.println(tempbtn1 + "");
                                                System.out.println("sumr" + sumr);
                                                check++;
                                            }

                                            if (check == 0) {
                                                sumr = -breadbtn[tempbtn];
                                            }

                                        }
                                    }


                                }
                            }
                            if (parallelcount > 0 && checkcheck == 0) {
                                tempbtn = breadbtn[q];
                                for (int aa = 0; aa <= 300; aa += 12) {
                                    if (breadbtn[paral] >= aa && breadbtn[paral] <= aa + 4) {
                                        for (int j = aa; j <= aa + 4; j++) {
                                            if (breadbtn[j] >= 0 && stop == 0) {
                                                tempbtn1 = breadbtn[j];
                                                System.out.println(j + "      " + breadbtn[j] + " ada  " + breadbtn[tempbtn1]);
                                                System.out.println("1" + breadbtn[paral] + "1" + breadbtn[tempparal]);


                                                if (breadbtn[tempbtn1] != 0) {
                                                    if (check == 0) {
                                                        sumrparal = summparal + (-breadbtn[tempparal]) + (-breadbtn[tempbtn1]);
                                                    } else {
                                                        sumrparal = summparal + (-breadbtn[tempbtn1]);
                                                    }
                                                    breadbtn[tempbtn1] = -(sumrparal);
                                                    System.out.println(sumrparal);
                                                    summparal = sumrparal;
                                                    breadbtn[paral] = breadbtn[j];
                                                    breadbtn[j] = -1;
                                                    breadbtn[tempparal] = -1;
                                                    System.out.println("breadbtn[paral]" + breadbtn[paral] + "Bread[temp]" + breadbtn[tempparal]);
                                                    System.out.println("breadbtn[j]" + breadbtn[j] + "Bread[temp1]" + breadbtn[tempbtn1]);
                                                    System.out.println(breadbtn[j] + "");
                                                    System.out.println("sumrparal" + sumrparal);

                                                    System.out.println("breadbtn[q]" + breadbtn[q]);
                                                    check = 1;

                                                    for (int aaa = 0; aaa <= 300; aaa += 12) {

                                                        if ((breadbtn[paral] >= aaa && breadbtn[paral] <= aaa + 4) && (breadbtn[q] >= aaa && breadbtn[q] <= aaa + 4)) {
                                                            System.out.println("breadbtn[paral]" + breadbtn[paral] + "Bread[temp]" + breadbtn[tempparal]);
                                                            System.out.println("breadbtn[q]" + breadbtn[q] + "Bread[temp1]" + breadbtn[tempbtn]);
                                                            stop = 1;
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                        if (check == 0) {
                                            sumrparal = -breadbtn[tempparal];
                                            stop = 1;
                                        }


                                    }
                                }
                                for (int aa = 7; aa <= 300; aa += 12) {
                                    if (breadbtn[paral] >= aa && breadbtn[paral] <= aa + 4) {

                                        for (int j = aa; j <= aa + 4; j++) {
                                            if (breadbtn[j] >= 0 && stop == 0) {
                                                tempbtn1 = breadbtn[j];
                                                System.out.println(j + "      " + breadbtn[j] + " ada  " + breadbtn[tempbtn1]);
                                                System.out.println("1" + breadbtn[paral] + "1" + breadbtn[tempparal]);
                                                if (breadbtn[tempbtn1] == -2)
                                                    breadbtn[tempbtn1] = 0;
                                                if (breadbtn[tempparal] == -2)
                                                    breadbtn[tempparal] = 0;
                                                if (check == 0) {
                                                    sumrparal = summparal + (-breadbtn[tempparal]) + (-breadbtn[tempbtn1]);
                                                } else {
                                                    sumrparal = summparal + (-breadbtn[tempbtn1]);
                                                }
                                                breadbtn[tempbtn1] = -(sumrparal);
                                                System.out.println(sumrparal);
                                                summparal = sumrparal;
                                                breadbtn[paral] = breadbtn[j];
                                                breadbtn[j] = -1;
                                                breadbtn[tempparal] = -1;
                                                System.out.println("breadbtn[paral]" + breadbtn[paral] + "Bread[temp]" + breadbtn[tempparal]);
                                                System.out.println("breadbtn[j]" + breadbtn[j] + "Bread[temp1]" + breadbtn[tempbtn1]);
                                                System.out.println(breadbtn[j] + "");
                                                System.out.println("sumrparal" + sumrparal);

                                                System.out.println("breadbtn[q]" + breadbtn[q]);
                                                check = 1;

                                                for (int aaa = 7; aaa <= 300; aaa += 12) {

                                                    if ((breadbtn[paral] >= aaa && breadbtn[paral] <= aaa + 4) && (breadbtn[q] >= aaa && breadbtn[q] <= aaa + 4)) {
                                                        System.out.println("breadbtn[paral]" + breadbtn[paral] + "Bread[temp]" + breadbtn[tempparal]);
                                                        System.out.println("breadbtn[q]" + breadbtn[q] + "Bread[temp1]" + breadbtn[tempbtn]);
                                                        stop = 1;
                                                    }
                                                }

                                            }

                                        }
                                        if (check == 0) {
                                            sumrparal = -breadbtn[tempparal];
                                            stop = 1;
                                        }


                                    }

                            }
                                if (stop == 1) {
                                    int tempp = breadbtn[q];
                                    int temppp = breadbtn[paral];

                                    System.out.println("qq" + breadbtn[tempp]);
                                    sumr = ParallelSum(sumrparal, breadbtn[tempp]);
                                    summ = sumr;
                                    parallelcount = 0;
                                    System.out.println("parallsum" + sumr);

                                    breadbtn[tempp] = -(int) sumr;
                                    breadbtn[paral] = -1;
                                    breadbtn[temppp] = -1;
                                    breadbtn[tempbtn1] = -1;

                                    System.out.println("parallsum1" + breadbtn[tempp] + "paralaasd" + breadbtn[paral]);
                                    for (int aa = 0; aa <= 300; aa += 12) {
                                        if (breadbtn[q] >= aa && breadbtn[q] <= aa + 4) {
                                            for (int j = aa; j <= aa + 4; j++) {
                                                if (breadbtn[j] >= 0 && j != q) {
                                                    tempbtn1 = breadbtn[j];
                                                    System.out.println(j + "      " + breadbtn[j] + " ada11  " + breadbtn[tempbtn1]);

                                                    if(breadbtn[tempbtn1] == -2)
                                                        breadbtn[tempbtn1] = 0;

                                                    sumr = summ + (-breadbtn[tempbtn1]);

                                                    breadbtn[tempbtn1] = -(int) (sumr);
                                                    System.out.println(sumr);
                                                    summ = sumr;
                                                    breadbtn[q] = breadbtn[j];
                                                    breadbtn[j] = -1;
                                                    breadbtn[tempbtn] = -1;
                                                    System.out.println("breadbtn[q]" + breadbtn[q] + "Bread[temp]" + breadbtn[tempbtn]);
                                                    System.out.println("breadbtn[j]" + breadbtn[j] + "Bread[temp1]" + breadbtn[tempbtn1]);
                                                    System.out.println(tempbtn1 + "");
                                                    System.out.println("sumr" + sumr);

                                                }

                                            }
                                        }


                                    }
                                    for (int aa = 7; aa <= 300; aa += 12) {
                                        if (breadbtn[q] >= aa && breadbtn[q] <= aa + 4) {
                                            for (int j = aa; j <= aa + 4; j++) {
                                                if (breadbtn[j] >= 0 && j != q) {
                                                    tempbtn1 = breadbtn[j];
                                                    System.out.println(j + "      " + breadbtn[j] + " ada  " + breadbtn[tempbtn1]);
                                                    if(breadbtn[tempbtn1] == -2)
                                                        breadbtn[tempbtn1] = 0;
                                                    sumr = summ + (-breadbtn[tempbtn1]);

                                                    breadbtn[tempbtn1] = -(int) (sumr);
                                                    System.out.println(sumr);
                                                    summ = sumr;
                                                    breadbtn[q] = breadbtn[j];
                                                    breadbtn[j] = -1;
                                                    breadbtn[tempbtn] = -1;
                                                    System.out.println("breadbtn[q]" + breadbtn[q] + "Bread[temp]" + breadbtn[tempbtn]);
                                                    System.out.println("breadbtn[j]" + breadbtn[j] + "Bread[temp1]" + breadbtn[tempbtn1]);
                                                    System.out.println(tempbtn1 + "");
                                                    System.out.println("sumr" + sumr);

                                                }

                                            }
                                        }



                                    }


                                }


                            }
                            stop = 0;
                        }

                    }

                }

                if (v != 0.000001 && checkcheck == 0) {

                    for (int i = 0; i < 300; i++) {
                        if (breadbtn[i] > 0) {
                            for (int aa = 0; aa <= 300; aa += 12) {
                                if (i >= aa && i <= aa + 4) {
                                    if(i>=0 && i<=4){
                                        System.out.println("aaaaaaaa");
                                    }
                                    else{
                                        int rd;
                                        holeButton[0].setBackgroundResource(R.drawable.holeup);
                                        for( rd = 12; rd<i-12 ; rd = rd+12){
                                            holeButton[rd].setBackgroundResource(R.drawable.redline1);
                                        }
                                        holeButton[rd].setBackgroundResource(R.drawable.holedown);
                                    }

                                }
                            }
                            for (int aa = 7; aa <= 300; aa += 12) {
                                if (i >= aa && i <= aa + 4) {
                                    if (i>=7 && i<=11){
                                        holeButton[4].setBackgroundResource(R.drawable.holestart);
                                        holeButton[5].setBackgroundResource(R.drawable.redlinecross);
                                        holeButton[6].setBackgroundResource(R.drawable.redlinecross2);
                                        holeButton[7].setBackgroundResource(R.drawable.holeend);
                                    }
                                    else{
                                        holeButton[4].setBackgroundResource(R.drawable.holestart);
                                        holeButton[5].setBackgroundResource(R.drawable.redlinecross);
                                        holeButton[6].setBackgroundResource(R.drawable.redlinecross2);
                                        holeButton[7].setBackgroundResource(R.drawable.holeend);
                                        int rd;
                                        holeButton[11].setBackgroundResource(R.drawable.holeup);
                                        for( rd = 23; rd<i ; rd = rd+12){
                                            holeButton[rd].setBackgroundResource(R.drawable.redline1);
                                        }
                                        holeButton[rd].setBackgroundResource(R.drawable.holedown);
                                    }
                                }
                            }
                        }
                    }




                    for (int i = 0; i < 300; i++) {
                        if (breadbtn[i] > 0) {
                            for (int aa = 0; aa <= 300; aa += 12) {
                                if (breadbtn[i] >= aa && breadbtn[i] <= aa + 4) {
                                    if (breadbtn[i] >= 204 && breadbtn[i] <= 208) {
                                        holeButton[aa + 4].setBackgroundResource(R.drawable.holeleft_b);
                                        holeButton[aa + 5].setBackgroundResource(R.drawable.blacklinecross);
                                        holeButton[aa + 6].setBackgroundResource(R.drawable.blacklinecross2);
                                        holeButton[aa + 7].setBackgroundResource(R.drawable.holeright_b);
                                    } else {
                                        int finishtemp = breadbtn[i];
                                        int as;
                                        holeButton[aa + 4].setBackgroundResource(R.drawable.holeup_b);
                                        for (as = aa + 16; as < 204; as = as + 12) {
                                            holeButton[as].setBackgroundResource(R.drawable.blackline1);
                                        }
                                        holeButton[as].setBackgroundResource(R.drawable.blacklineee);
                                        holeButton[as + 1].setBackgroundResource(R.drawable.blacklinecross);
                                        holeButton[as + 2].setBackgroundResource(R.drawable.blacklinecross2);
                                        holeButton[as + 3].setBackgroundResource(R.drawable.holeright_b);
                                    }
                                }


                            }
                            for (int aa = 7; aa <= 300; aa += 12) {
                                if (breadbtn[i] >= aa && breadbtn[i] <= aa + 4) {
                                    if (breadbtn[i] >= 211 && breadbtn[i] <= 215) {

                                    } else {

                                        int as;
                                        holeButton[aa + 4].setBackgroundResource(R.drawable.holeup_b);
                                        for (as = aa + 16; as < 204; as = as + 12) {
                                            holeButton[as].setBackgroundResource(R.drawable.blackline1);
                                        }
                                        holeButton[as].setBackgroundResource(R.drawable.holedown_b);

                                    }
                                }


                            }
                        }
                    }
                    Toast.makeText(getApplicationContext(), "회로 확인 후 한번 더 확인버튼을 누르시오", Toast.LENGTH_LONG).show();
                    checkcheck = 1;
                }
                else if(v != 0.000001 && checkcheck == 1){
                    System.out.println(sumr + "susmsmsmsmsm");
                    openResult(v, sumr);
                    checkcheck = 0;
                    }
                else {
                    sumr = 0;
                    Toast.makeText(getApplicationContext(), "전압버튼을 눌러 전압을 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //저장된 선 출력
        //예시
        //linecolor[0] = 3;
        //linelocation[0] =72024;
        //linecolor[1] = 1;
        //linelocation[1] =8000;


//        for (int ii = 0; ii < 300; ii++) {
//
//            if (linecolor[ii] != 0) {
//                end = linelocation[ii] / 1000;
//                start = linelocation[ii] % 1000;
//                if (linecolor[ii] == 1) {
//                    substract = (double) (end - start);
//                    if (substract % 12.00 == 0.00) {
//                        holeButton[start].setBackgroundResource(R.drawable.holeup);
//                        for (int i = start; i != end; i = i + 12) {
//
//                            holeButton[i + 12].setBackgroundResource(R.drawable.redline1);
//
//                        }
//                        holeButton[end].setBackgroundResource(R.drawable.holedown);
//                        start = -1;
//                        end = 0;
//
//                    } else if (substract % 12.00 != 0.00) {
//
//                        for (int aa = 0; aa <= 300; aa += 12) {
//                            if ((start >= aa && start <= aa + 11) && (end >= aa && end <= aa + 11)) {
//
//                                holeButton[start].setBackgroundResource(R.drawable.holestart);
//                                for (int i = start; i != end; i++) {
//                                    if ((i + 1) % 12 == 5)
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.redlinecross);
//                                    else if ((i + 1) % 12 == 6)
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.redlinecross2);
//                                    else
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.redline);
//
//                                }
//                                holeButton[end].setBackgroundResource(R.drawable.holeend);
//
//
//                                start = -1;
//                                end = 0;
//                            }
//
//                        }
//
//                    }
//                }
//
//                if (linecolor[ii] == 2) {
//                    if (substract % 12.00 == 0.00) {
//                        holeButton[start].setBackgroundResource(R.drawable.holeup_b);
//                        for (int i = start; i != end; i = i + 12) {
//                            holeButton[i + 12].setBackgroundResource(R.drawable.blackline1);
//
//                        }
//                        holeButton[end].setBackgroundResource(R.drawable.holedown_b);
//
//                        if (end != 0)
//                            frame.setVisibility(View.INVISIBLE);
//                        start = -1;
//                        end = 0;
//
//                    } else if (substract % 12.00 != 0.00) {
//                        for (int aa = 0; aa <= 300; aa += 12) {
//                            if ((start >= aa && start <= aa + 11) && (end >= aa && end <= aa + 11)) {
//
//                                holeButton[start].setBackgroundResource(R.drawable.holeleft_b);
//                                for (int i = start; i != end; i++) {
//                                    if ((i + 1) % 12 == 5)
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.blacklinecross);
//                                    else if ((i + 1) % 12 == 6)
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.blacklinecross2);
//                                    else
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.blackline);
//
//                                }
//                                holeButton[end].setBackgroundResource(R.drawable.holeright_b);
//
//                                if (end != 0)
//                                    frame.setVisibility(View.INVISIBLE);
//                                start = -1;
//                                end = 0;
//                            }
//                        }
//
//                    }
//
//                }
//                if (linecolor[ii] == 3) {
//                    if (substract % 12.00 == 0.00) {
//                        holeButton[start].setBackgroundResource(R.drawable.holeup_u);
//                        for (int i = start; i != end; i = i + 12) {
//                            holeButton[i + 12].setBackgroundResource(R.drawable.blueline1);
//
//                        }
//                        holeButton[end].setBackgroundResource(R.drawable.holedown_u);
//
//                        if (end != 0)
//                            frame.setVisibility(View.INVISIBLE);
//                        start = -1;
//                        end = 0;
//
//                    } else if (substract % 12.00 != 0.00) {
//                        for (int aa = 0; aa <= 300; aa += 12) {
//                            if ((start >= aa && start <= aa + 11) && (end >= aa && end <= aa + 11)) {
//
//                                holeButton[start].setBackgroundResource(R.drawable.holeleft_u);
//                                for (int i = start; i != end; i++) {
//                                    if ((i + 1) % 12 == 5)
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.bluelinecross);
//                                    else if ((i + 1) % 12 == 6)
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.bluelinecross2);
//                                    else
//                                        holeButton[i + 1].setBackgroundResource(R.drawable.blueline);
//
//                                }
//                                holeButton[end].setBackgroundResource(R.drawable.holeright_u);
//
//                                if (end != 0)
//                                    frame.setVisibility(View.INVISIBLE);
//                                start = -1;
//                                end = 0;
//                            }
//
//                        }
//                    }
//
//                }
//
//            }
//
//        }   //선 출력

//        저항 출력
//        reglocation[0] = 16012;
//        regg[0] = 1021;

        if (count != -1) {
            registerValue[count] = getPreferences();
            lineValue[ccount] = getLinePreferences();

            registerLocation[count] = getPreferences1();
            lineLoc[ccount] = getLinePreferences();

            qaz = getPreferences1();
            tvgas.setText(tvgas.getText() + registerValue[count]);
            qaq = getPreferences2();
            tvgone.setText(tvgone.getText() + registerLocation[count]);

            lqaz = getLinePreferences1();
            tvLV.setText(tvLV.getText() + lineValue[ccount]);
            lqaq = getLinePreferences2();
            tvLL.setText(tvgone.getText() + lineLoc[ccount]);

        }

            for (int ii = 0; ii < 300; ii++) {

                if (regg[ii] != 0) {
                    start = reglocation[ii] % 1000;
                    if((reglocation[ii]/1000) >899)
                        end = reglocation[ii] / 1000 - 900;
                    else
                        end = reglocation[ii] / 1000;



                    substract = (double) (end - start);
                    tem1 = regg[ii] / 1000;
                    btncolor1[0] = tem1;
                    tem1 = regg[ii] % 1000;
                    btncolor1[1] = tem1 / 100;
                    tem1 = regg[ii] % 100;
                    btncolor1[2] = tem1 / 10;
                    btncolor1[3] = tem1 % 10;
                    if (btncolor1[3] == 1)
                        btncolor1[3] = 50;
                    else
                        btncolor1[3] = 100;

                    if (substract % 12.00 == 0.00) {
                        switch (end - start) {
                            case 36: {
                                int y = 0;
                                for (int i = start; i <= end; i = i + 12) {
                                    if (btncolor1[y] == 0)
                                        holeButton[i].setBackgroundColor(Color.rgb(00, 00, 00));
                                    if (btncolor1[y] == 1)
                                        holeButton[i].setBackgroundColor(Color.rgb(74, 00, 00));
                                    if (btncolor1[y] == 2)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                    if (btncolor1[y] == 3)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                    if (btncolor1[y] == 4)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                    if (btncolor1[y] == 5)
                                        holeButton[i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                    if (btncolor1[y] == 6)
                                        holeButton[i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                    if (btncolor1[y] == 7)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                    if (btncolor1[y] == 8)
                                        holeButton[i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                    if (btncolor1[y] == 9)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                    if (btncolor1[y] == 50)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                    if (btncolor1[y] == 100)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));
                                    y++;

                                }
                            }
                            default: {

                                mid = ((end / 12) - (start / 12)) / 2;
                                int y = 0;
                                for (int i = 0; i <= 36; i = i + 12) {
                                    if (btncolor1[y] == 0)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(00, 00, 00));
                                    if (btncolor1[y] == 1)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(74, 00, 00));
                                    if (btncolor1[y] == 2)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                    if (btncolor1[y] == 3)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                    if (btncolor1[y] == 4)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                    if (btncolor1[y] == 5)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                    if (btncolor1[y] == 6)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                    if (btncolor1[y] == 7)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                    if (btncolor1[y] == 8)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                    if (btncolor1[y] == 9)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                    if (btncolor1[y] == 50)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                    if (btncolor1[y] == 100)
                                        holeButton[start + (mid - 1) * 12 + i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));
                                    y++;

                                }
                                for (int i = 0; i < (mid - 1) * 12; i = i + 12) {
                                    if (i == 0) {
                                        holeButton[start + i].setBackgroundResource(R.drawable.regupstart);
                                    } else
                                        holeButton[start + i].setBackgroundResource(R.drawable.reg);

                                }

                                if ((start + (mid + 2) * 12) != end) {
                                    for (int i = (start + (mid + 3) * 12); i < end; i = i + 12) {
                                        holeButton[i].setBackgroundResource(R.drawable.reg);
                                    }
                                    holeButton[end].setBackgroundResource(R.drawable.regdownend);
                                }
                            }
                            a = 0;
                            start = -1;
                            end = 0;
                        }

                    } else if (substract % 12.00 != 0.00) {
                        switch (end - start) {
                            case 3: {
                                int y = 0;
                                for (int i = start; i <= end; i++) {
                                    if (btncolor1[y] == 0)
                                        holeButton[i].setBackgroundColor(Color.rgb(00, 00, 00));
                                    if (btncolor1[y] == 1)
                                        holeButton[i].setBackgroundColor(Color.rgb(74, 00, 00));
                                    if (btncolor1[y] == 2)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                    if (btncolor1[y] == 3)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                    if (btncolor1[y] == 4)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                    if (btncolor1[y] == 5)
                                        holeButton[i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                    if (btncolor1[y] == 6)
                                        holeButton[i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                    if (btncolor1[y] == 7)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                    if (btncolor1[y] == 8)
                                        holeButton[i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                    if (btncolor1[y] == 9)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                    if (btncolor1[y] == 50)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                    if (btncolor1[y] == 100)
                                        holeButton[i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));

                                    y++;

                                }

                            }
                            default: {

                                mid = (end - start) / 2;

                                for (int i = 0; i < 4; i++) {
                                    if (btncolor1[i] == 0)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(00, 00, 00));
                                    if (btncolor1[i] == 1)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(74, 00, 00));
                                    if (btncolor1[i] == 2)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 00, 00));
                                    if (btncolor1[i] == 3)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0x6f, 00));
                                    if (btncolor1[i] == 4)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0xf2, 20));
                                    if (btncolor1[i] == 5)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(57, 0xde, 31));
                                    if (btncolor1[i] == 6)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(00, 88, 0xff));
                                    if (btncolor1[i] == 7)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xb7, 00, 0xff));
                                    if (btncolor1[i] == 8)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0x8c, 0x8b, 0x8b));
                                    if (btncolor1[i] == 9)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
                                    if (btncolor1[i] == 50)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xff, 0xd5, 0x49));
                                    if (btncolor1[i] == 100)
                                        holeButton[start + mid - 1 + i].setBackgroundColor(Color.rgb(0xd6, 0xd4, 0xd1));

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
                    }
                    a = 0;
                    start = -1;
                    end = 0;
                }
            }
        }


    public void LineColor(Button btnl1, Button btnl2, int line) {

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

    public void Line(int width, int height) {
        ViewGroup.LayoutParams params = btnL1.getLayoutParams();
        params.width = btnL1.getWidth() * width;
        btnL1.setLayoutParams(params);
//
//       ViewGroup.LayoutParams params1 = btnL2.getLayoutParams();
//       params1.height = (btnL2.getHeight()*height);
//       btnL2.setLayoutParams(params1);


    }

//    public void openLine() {
//        Intent intent = new Intent(this, ChooseLine.class);
//        intent.putExtra("ccount",ccount);
//        if(L0!= 12344567)
//        intent.putExtra("LV",Integer.toString(L0));
//        intent.putExtra("LL",lloc);
//        startActivity(intent);
//    }//ChooseLine.xml 로 가는 함수

    public void openRegister(){
        Intent intent = new Intent(this,ChooseRegister.class);
        intent.putExtra("num",count);
        intent.putExtra("tvgas",tvgas.getText().toString());
        intent.putExtra("loc",loc);
        Log.d("Location",loc);
        startActivity(intent);
    }//ChooseRegister.xml로 가는 함수

    public void Location(int index) {
        int x = 0, y = 0, a = 0;

        for (int i = 0; i < 216; i++) {

            if(x == 5)
                a = 1;
            if(x == 6)
                a = 2;

            if (x > 11) {
                x = 0;
                y += 1;
            }
            x += 1;

            if (index == i && x <= 5) {
                frame.setX(53 + (50 * (x - 1)));
                frame.setY(110 + (52 * y));
            }
            if (index == i && x > 5) {

                frame.setX(200 + (50 * (x - a - 1)));
                frame.setY(110 + (52 * y));
                a=0;
            }
            frame.setVisibility(View.VISIBLE);
        }
    }  //구멍 버튼을 눌렀을때 그 위치로 말풍선이 오게하는 매소드

    public void volValue(double v) {
        btnV.setText(Double.toString(v) + "V");
        frameV.setVisibility(View.INVISIBLE);

    }       //전압버튼에 숫자 표시

    public void openResult(double v, double r) {
        Intent intent1 = new Intent(this, Result.class);
        intent1.putExtra("v", v);
        intent1.putExtra("r", r);
        startActivity(intent1);
    }


    public void Point(int start) {
        int point = 0;
        if (start != 12344567) {
            Toast.makeText(getApplicationContext(), "시작점을 입력하세요", Toast.LENGTH_SHORT).show();
            frame.setVisibility(View.INVISIBLE);
            point = 1;
        }
        if (point == 1) {
            Toast.makeText(getApplicationContext(), "끝점을 입력하세요", Toast.LENGTH_SHORT).show();
            point = 0;
        }
    }

    public int RCheck(int r) {
        int ten = 1, a1, a2, a3, a4, a;
        a1 = r / 1000;
        r %= 1000;
        a2 = r / 100;
        r %= 100;
        a3 = r / 10;
        a4 = r % 10;

        for (int i = 0; i < a3; i++)
            ten *= 10;

        a = ((a1 * 10) + a2) * ten;

        return a;
    }

    public int RDivid(int r) {

        int rrcount = 0;
        while (r < 10) {
            r = r / 10;
            rrcount++;
        }
        a = r * 1000 + rrcount * 10 + 2;
        System.out.println("!!!!!!!!!!!!!!!!!!!" + a);
        return -a;
    }


    public double ParallelSum(int x, int y) {

        double rr = 0.0;

        x = x;
        y = -y;

        rr = (double) (x * y) / (x + y);

        return rr;
    }

    public void savePreferences() {
        SharedPreferences sf = getSharedPreferences(Name, 0);
        SharedPreferences.Editor editor = sf.edit();
        String str = Integer.toString(R0);
        String qwe = tvgas.getText().toString();
        String qre = tvgone.getText().toString();


        editor.putString("name", str);
        editor.putString("gas", qwe);
        editor.putString("gone",qre);
        editor.commit();
    }

    public void saveLinePreferences() {
        SharedPreferences sf = getSharedPreferences("Line", 0);
        SharedPreferences.Editor editor = sf.edit();
        String str = Integer.toString(L0);
        Log.d("L0",Integer.toString(L0));
        String qwe = tvLV.getText().toString();
        String qre = tvLL.getText().toString();


        editor.putString("name1", str);
        editor.putString("lineV", qwe);
        editor.putString("lineL",qre);
        editor.commit();
    }

    //저장했던 이름 불러오기
    public String getLinePreferences(){
        SharedPreferences sf = getSharedPreferences("Line",0);
        return sf.getString("name1","");
    }
    public String getLinePreferences1(){
        SharedPreferences sf = getSharedPreferences("Line",0);
        return sf.getString("lineV","");
    }

    public String getLinePreferences2(){
        SharedPreferences sf = getSharedPreferences("Line",0);
        return sf.getString("lineL","");
    }

    public String getPreferences(){
        SharedPreferences sf = getSharedPreferences(Name,0);
        return sf.getString("name","");
    }
    public String getPreferences1(){
        SharedPreferences sf = getSharedPreferences(Name,0);
        return sf.getString("gas","");
    }

    public String getPreferences2(){
        SharedPreferences sf = getSharedPreferences(Name,0);
        return sf.getString("gone","");
    }



    //앱 종료시
    public void onStop() {
        super.onStop();
        if(R0!=12344567)
            savePreferences();

        if (L0 != 12344567)
            saveLinePreferences();
    }


}