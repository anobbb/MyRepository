package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // ------------------------------------------------------시작될 때 (화면생성)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate: 처음 화면이 시작될 때 화면에서 사용되는 객체 생성 및 초기화
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ContentView 객체에 (layout - 식별번호 사용(R클래스 이용))필드값으로 채워서 화면의 내용으로 하겠다는 의미, R=res layout(정적필드)-res의 layout, activity_main: 식별번호
        // setContentView: xml의 태그들을 객체화 하여(인풀레이션) 화면 구성하는 메소드
        // 클래스 하나 당 xml 하나
        // 컴파일하면 default 생성자 생김
        // 사용자가 아이콘 클릭-> 해당되는 main 클래스 찾아감-> MainActivity 객체 생성-> onCreate 메소드 호출
        // 생성부터 소멸까지 자동으로 호출되는 메소드: 객체의 life cycle 메소드라고 함
        // on: ~할 때
        // life cycle method: onCreate, onDestroy
        Log.i("mylog", "onCreate()"); // info 레벨의 메세지 출력, ("log를 찾기 위한 태그이름", "메세지");
    }

    @Override
    protected void onStart() {
        // onStart: 객체 생성 후 서비스 실행 코드
        // 음악 시작
        super.onStart();
        Log.i("mylog", "onStart()");
    }

    @Override
    protected void onResume() {
        // onResume: 사용자가 당장 어떤 것을 사용할 때 실행하기 위한 코드, 어떤 내용을 사용할 수 있는 상태가 됨, 사용자가 사용하기 직전에 실행
        // 잠깐 멈춰두었던 음악을 (다시)재생
        super.onResume();
        Log.i("mylog", "onResume()");
    }


    // ------------------------------------------------------끝날 때 (화면파괴)
    @Override
    protected void onPause() {
        // onPause: 사용자가 어떤 행위를 했을 때 일시적으로 멈추는 것 (화면을 당장 사용할 수 없는 상태)
        // 음악 듣다가 잠깐 다른일을 해야하는 경우의 음악 일시정지
        super.onPause();
        Log.i("mylog", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 음악 정지
        Log.i("mylog", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mylog", "onDestroy()");
    }

    public void onClickBtnSecond(View view){
        Log.i("mylog", "onClickBtnSecond()");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void onClickBtnThird(View view){
        Log.i("mylog", "onClickBtnThird()");
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

}
