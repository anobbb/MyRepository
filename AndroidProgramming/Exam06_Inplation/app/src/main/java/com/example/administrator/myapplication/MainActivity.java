package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemContainer = (LinearLayout)findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();

        fillItems();
    }

    public void fillItems(){ // inplation + data[3] 세팅
        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1, "인테리어 조명1", "거실등으로 사용하면 좋습니다. 검정색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light2, "인테리어 조명2", "개인등으로 사용하면 좋습니다. 흰색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light3, "인테리어 조명3", "샤워등으로 사용하면 좋습니다. 흑색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light4, "인테리어 조명4", "서재등으로 사용하면 좋습니다. 밤색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));
        list.add(new Light(R.drawable.light5, "인테리어 조명5", "현관등으로 사용하면 좋습니다. 빨간색 테두리와 조명의 조화가 심플하면서도 잘 어울립니다."));


        for(Light light : list) {
            //Inplation
            LinearLayout itemLayout = (LinearLayout)layoutInflater.inflate(R.layout.light_item, null);

            //Data setting
            ImageView lightImage = (ImageView)itemLayout.findViewById(R.id.lightImage);
            lightImage.setImageResource(light.getImage()); // light1사진의 참조번호 세팅

            TextView lightTitle = (TextView)itemLayout.findViewById(R.id.lighttitle);
            lightTitle.setText(light.getTitle());

            TextView lightContent = (TextView)itemLayout.findViewById(R.id.lightcontent);
            lightContent.setText(light.getContent());

            // itemContainer의 내부 객체로 추가
            itemContainer.addView(itemLayout);
        }
    }
}
