package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private Button button2;
    private ListView lightList;
    private List<Light> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLarge = (ImageView)findViewById(R.id.imageLarge);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class); // 메인화면을 secondActivity로 이동하는 의도 요청
                startActivity(intent);
            }
        }); // onClickListener은 필드

        lightList = (ListView)findViewById(R.id.lightList); // 초기화
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Light light = list.get(position); //position => index
                imageLarge.setImageResource(light.getImageLarge());
            }
        });
        fillItems();
    }
    public void fillItems(){ // inplation + data[3] 세팅
        list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검정색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명2", "개인등으로 사용하면 좋습니다. 흰색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명3", "샤워등으로 사용하면 좋습니다. 흑색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명4", "서재등으로 사용하면 좋습니다. 밤색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명5", "현관등으로 사용하면 좋습니다. 빨간색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light1, R.drawable.light1_large, "인테리어 조명6", "거실등으로 사용하면 좋습니다. 검정색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light2, R.drawable.light2_large, "인테리어 조명7", "개인등으로 사용하면 좋습니다. 흰색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light3, R.drawable.light3_large, "인테리어 조명8", "샤워등으로 사용하면 좋습니다. 흑색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light4, R.drawable.light4_large, "인테리어 조명9", "서재등으로 사용하면 좋습니다. 밤색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light5, R.drawable.light5_large, "인테리어 조명10", "현관등으로 사용하면 좋습니다. 빨간색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));

        LightAdapter lightAdapter = new LightAdapter(this); // this = MainActivity, activity = context
        lightAdapter.setList(list); // data 주입

        lightList.setAdapter(lightAdapter);
    }

    public void onClickButton1(View view){ // view타입의 모든 객체(여기서는 button1)
        Intent intent = new Intent(this, SecondActivity.class); // 메인화면을 secondActivity로 이동하는 의도 요청
        startActivity(intent);
    }
}
