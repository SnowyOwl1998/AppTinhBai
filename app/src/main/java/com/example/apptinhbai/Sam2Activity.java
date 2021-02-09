package com.example.apptinhbai;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Sam2Activity extends AppCompatActivity {
    public EditText ed1, ed2;
    public TextView tv1, tv2, tutorialTV;
    public int score1, score2,
            total1 = 0, total2 = 0,
            preTotal1 = 0, preTotal2 = 0,
            postTotal1 = 0, postTotal2 = 0;
    public boolean isUndo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_sam2);

        ed1 = (EditText)findViewById(R.id.point1_ET_sam2);
        ed2 = (EditText)findViewById(R.id.point2_ET_sam2);

        tv1 = (TextView)findViewById(R.id.score1_TV_sam2);
        tv2 = (TextView)findViewById(R.id.score2_TV_sam2);
        tutorialTV = (TextView)findViewById(R.id.tutorial_sam2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            tutorialTV.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        tv1.setText(String.valueOf(0));
        tv2.setText(String.valueOf(0));

        findViewById(R.id.win1_btn_sam2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(1);
            }
        });

        findViewById(R.id.win2_btn_sam2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countScore(2);
            }
        });

        findViewById(R.id.back_btn_sam2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitConfirm();
            }
        });

        findViewById(R.id.undo_btn_sam2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                undoTask();
            }
        });

        findViewById(R.id.redo_btn_sam2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redoTask();
            }
        });
    }

    public void countScore(int number){
        if (ed1.getText().toString().matches("") ||
                ed2.getText().toString().matches("")){
            Toast.makeText(this, "Chưa nhập điểm số", Toast.LENGTH_SHORT).show();
        } else {
            preTotal1 = total1;
            preTotal2 = total2;
            score1 = Integer.parseInt(ed1.getText().toString());
            score2 = Integer.parseInt(ed2.getText().toString());
            if (number == 1) {
                total1 += score2;
                total2 -= score2;
            } else {
                total2 += score1;
                total1 -= score1;
            }

            tv1.setText(String.valueOf(total1));
            tv2.setText(String.valueOf(total2));

            colorSetTask();

            ed1.setText("");
            ed2.setText("");
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
        exitConfirm();
    }

    public void exitConfirm(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Thoát")
                .setMessage("Bạn có muốn thoát không? Tất cả dữ liệu sẽ được reset")
                .setPositiveButton("Có", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    }

                })
                .setNegativeButton("Không", null)
                .show();
    }

    public boolean undoTask(){
        if(isUndo){
            Toast.makeText(this, "Không thể Undo", Toast.LENGTH_SHORT).show();
        } else {
            postTotal1 = total1;
            postTotal2 = total2;
            total1 = preTotal1;
            total2 = preTotal2;
            tv1.setText(total1);
            tv2.setText(total2);
            colorSetTask();
            isUndo = true;
        }
        return isUndo;
    }

    public boolean redoTask(){
        if(!isUndo){
            Toast.makeText(this, "Không thể Redo", Toast.LENGTH_SHORT).show();
        } else {
            preTotal1 = total1;
            preTotal2 = total2;
            total1 = postTotal1;
            total2 = postTotal2;
            tv1.setText(total1);
            tv2.setText(total2);
            colorSetTask();
            isUndo = false;
        }
        return isUndo;
    }

    public void colorSetTask(){
        if(total1 < 0){
            tv1.setTextColor(Color.RED);
        } else tv1.setTextColor(Color.parseColor("#006900"));

        if(total2 < 0){
            tv2.setTextColor(Color.RED);
        } else tv2.setTextColor(Color.parseColor("#006900"));
    }
}
