package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout frame1;
    private LinearLayout frame2;
    private LinearLayout frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame1 = (LinearLayout)findViewById(R.id.frame1);
        frame2 = (LinearLayout)findViewById(R.id.frame2);
        frame3 = (LinearLayout)findViewById(R.id.frame3);
    }

    public void onClickFrame1(View view){ // 클릭한 객체가 매개값으로 들어옴(View 타입)
        frame1.setVisibility(View.VISIBLE);
        frame2.setVisibility(View.INVISIBLE);
        frame3.setVisibility(View.INVISIBLE);
    }

    public void onClickFrame2(View view){
        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.VISIBLE);
        frame3.setVisibility(View.INVISIBLE);
    }

    public void onClickFrame3(View view){
        frame1.setVisibility(View.INVISIBLE);
        frame2.setVisibility(View.INVISIBLE);
        frame3.setVisibility(View.VISIBLE);
    }
}
