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

public class Sam4Activity extends AppCompatActivity {
    public EditText ed1, ed2, ed3, ed4;
    public TextView tv1, tv2, tv3, tv4, tutorialTV;
    public int score1, score2, score3, score4, total1 = 0, total2 = 0, total3 = 0, total4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_sam4);

        ed1 = (EditText)findViewById(R.id.point1_ET_sam4);
        ed2 = (EditText)findViewById(R.id.point2_ET_sam4);
        ed3 = (EditText)findViewById(R.id.point3_ET_sam4);
        ed4 = (EditText)findViewById(R.id.point4_ET_sam4);

        tv1 = (TextView)findViewById(R.id.score1_TV_sam4);
        tv2 = (TextView)findViewById(R.id.score2_TV_sam4);
        tv3 = (TextView)findViewById(R.id.score3_TV_sam4);
        tv4 = (TextView)findViewById(R.id.score4_TV_sam4);
        tutorialTV = (TextView)findViewById(R.id.tutorial_sam4);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tutorialTV.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        tv1.setText(String.valueOf(0));
        tv2.setText(String.valueOf(0));
        tv3.setText(String.valueOf(0));
        tv4.setText(String.valueOf(0));

        findViewById(R.id.win1_btn_sam4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(1);
            }
        });

        findViewById(R.id.win2_btn_sam4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(2);
            }
        });

        findViewById(R.id.win3_btn_sam4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(3);
            }
        });

        findViewById(R.id.win4_btn_sam4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(4);
            }
        });

        findViewById(R.id.back_btn_sam4).setOnClickListener(new View.OnClickListener() {
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
                ed4.getText().toString().matches("")){
            Toast.makeText(this, "Chưa nhập điểm số", Toast.LENGTH_SHORT).show();
        } else {
            score1 = Integer.parseInt(ed1.getText().toString());
            score2 = Integer.parseInt(ed2.getText().toString());
            score3 = Integer.parseInt(ed3.getText().toString());
            score4 = Integer.parseInt(ed4.getText().toString());
            if (number == 1) {
                total1 += score2 + score3 + score4;
                total2 -= score2;
                total3 -= score3;
                total4 -= score4;
            } else if (number == 2) {
                total2 += score1 + score3 + score4;
                total1 -= score1;
                total3 -= score3;
                total4 -= score4;
            } else if (number == 3) {
                total3 += score2 + score1 + score4;
                total2 -= score2;
                total1 -= score1;
                total4 -= score4;
            } else {
                total4 += score2 + score3 + score1;
                total2 -= score2;
                total3 -= score3;
                total1 -= score1;
            }

            tv1.setText(String.valueOf(total1));
            tv2.setText(String.valueOf(total2));
            tv3.setText(String.valueOf(total3));
            tv4.setText(String.valueOf(total4));

            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
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
