package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowToast (View view){
        // method chaining
        Toast
            .makeText(this, "나는 토스트입니다", Toast.LENGTH_SHORT)
            .show();
        // (activity, 문자열, 보여줄 시간)
        /*
        정적 메소드
        Toast toast = Toast
            .makeText(this, "나는 토스트입니다", Toast.LENGTH_SHORT);
            toast.show();
         */
    }

    public void onClickShowMessageDialog(View view){
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setMessage("와버렸어 기다렸던 날이 와버렸어\n뭐라고 말 좀 해봐요\n되돌릴 수는 없겠죠")
                .setPositiveButton("확인", null)
                .show();
    }

    public void onClickShowYesNoDialog(View view){
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setMessage("픽스픽슈?")
                .setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                            .makeText(MainActivity.this, "아니오를 선택", Toast.LENGTH_SHORT)
                            .show();
                    }
                }) // Positive: 오른쪽
                .setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast
                            .makeText(MainActivity.this, "예를 선택", Toast.LENGTH_SHORT)
                            .show();
                    }
                }) // Negative: 왼쪽
                .show();
    }

    public void onClickShowCustomDialog(View view){
        View content = getLayoutInflater().inflate(R.layout.light_dialog, null);
        Button btnOk = (Button) content.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast
                        .makeText(MainActivity.this, "예를 선택", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setView(content)
                .show();
    }
}
