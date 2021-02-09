package com.example.apptinhbai;

import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sam5Activity extends AppCompatActivity {
    public EditText ed1, ed2, ed3, ed4, ed5;
    public TextView tv1, tv2, tv3, tv4, tv5, tutorialTV;
    public int score1, score2, score3, score4, score5, total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0;
    public int preTotal1, preTotal2, preTotal3, preTotal4, preTotal5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_sam5);

        ed1 = (EditText)findViewById(R.id.point1_ET_sam5);
        ed2 = (EditText)findViewById(R.id.point2_ET_sam5);
        ed3 = (EditText)findViewById(R.id.point3_ET_sam5);
        ed4 = (EditText)findViewById(R.id.point4_ET_sam5);
        ed5 = (EditText)findViewById(R.id.point5_ET_sam5);

        tv1 = (TextView)findViewById(R.id.score1_TV_sam5);
        tv2 = (TextView)findViewById(R.id.score2_TV_sam5);
        tv3 = (TextView)findViewById(R.id.score3_TV_sam5);
        tv4 = (TextView)findViewById(R.id.score4_TV_sam5);
        tv5 = (TextView)findViewById(R.id.score5_TV_sam5);
        tutorialTV = (TextView)findViewById(R.id.tutorial_sam5);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tutorialTV.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        tv1.setText(String.valueOf(0));
        tv2.setText(String.valueOf(0));
        tv3.setText(String.valueOf(0));
        tv4.setText(String.valueOf(0));
        tv5.setText(String.valueOf(0));

        findViewById(R.id.win1_btn_sam5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(1);
            }
        });

        findViewById(R.id.win2_btn_sam5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(2);
            }
        });

        findViewById(R.id.win3_btn_sam5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(3);
            }
        });

        findViewById(R.id.win4_btn_sam5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(4);
            }
        });

        findViewById(R.id.win5_btn_sam5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(5);
            }
        });

        findViewById(R.id.back_btn_sam5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void countScore(int number){
        if (ed1.getText().toString().matches("") ||
                ed2.getText().toString().matches("") ||
                ed3.getText().toString().matches("") ||
                ed4.getText().toString().matches("") ||
                ed5.getText().toString().matches("")){
            Toast.makeText(this, "Chưa nhập điểm số", Toast.LENGTH_SHORT).show();
        } else {
            preTotal1 = total1;
            preTotal2 = total2;
            preTotal3 = total3;
            preTotal4 = total4;
            preTotal5 = total5;
            score1 = Integer.parseInt(ed1.getText().toString());
            score2 = Integer.parseInt(ed2.getText().toString());
            score3 = Integer.parseInt(ed3.getText().toString());
            score4 = Integer.parseInt(ed4.getText().toString());
            score5 = Integer.parseInt(ed5.getText().toString());
            if (number == 1) {
                total1 += score2 + score3 + score4 +score5;
                total2 -= score2;
                total3 -= score3;
                total4 -= score4;
                total5 -= score5;
            } else if (number == 2) {
                total2 += score1 + score3 + score4 + score5;
                total1 -= score1;
                total3 -= score3;
                total4 -= score4;
                total5 -= score5;
            } else if (number == 3) {
                total3 += score2 + score1 + score4 + score5;
                total2 -= score2;
                total1 -= score1;
                total4 -= score4;
                total5 -= score5;
            } else if (number == 4){
                total4 += score2 + score3 + score1 + score5;
                total2 -= score2;
                total3 -= score3;
                total1 -= score1;
                total5 -= score5;
            } else {
                total5 += score2 + score3 + score1 + score4;
                total2 -= score2;
                total3 -= score3;
                total1 -= score1;
                total4 -= score4;
            }

            tv1.setText(String.valueOf(total1));
            tv2.setText(String.valueOf(total2));
            tv3.setText(String.valueOf(total3));
            tv4.setText(String.valueOf(total4));
            tv5.setText(String.valueOf(total5));

            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {

    }
}