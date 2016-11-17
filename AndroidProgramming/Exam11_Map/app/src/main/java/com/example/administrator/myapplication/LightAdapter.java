package com.example.administrator.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LightAdapter extends BaseAdapter{
    private List<Light> list;
    // setter 주입
    public void setList(List<Light> list) {
        this.list = list;
    }

    private MainActivity mainActivity;
    private Context context;
    private LayoutInflater layoutInflater;

    // mainActivity의 기능을 사용하기 위한 생성자 주입
    // 생성자 주입의 단점[public LightAdapter(MainActivity mainActivity)]: mainActivity에서만 사용 가능
    /*public LightAdapter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        layoutInflater = mainActivity.getLayoutInflater();
    }*/

    // LightAdapter는 범용적으로 사용 불가능 -> 해결: Context생성하여 매개변수로 받아서 어떤 Activity든 사용가능
    // Context = Activity
    // Activity는 Context를 구현하고 있음
    public LightAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { //항목 수 리턴 (= List의 Light 수)
        return list.size();
    }

    @Override
    public Object getItem(int position) { // position: List<Light>의 인덱스 번호, 0이 들어오면 list의 0번째 객체를 리턴
        return list.get(position);
    }

    @Override
    public long getItemId(int position) { // id가 없는 데이터도 있을 수 있음(Light에서는 식별할만한 번호가 없기 때문) -> position: list상의 인덱스, 객체 안의 데이터 중에서 식별할 수 있는 값, ex: Board의 bno
        return position;
    }

    // *********** 중요
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 해당위치의 데이터를 보여주기 위해 아이템 객체를 만들어서 리턴, position: list상의 순번, convertView: xml을 통해 inplation한 것, viewgroup: ListView
        if(convertView == null){
            //inplation
            convertView = layoutInflater.inflate(R.layout.light_item, null);
        }
        // data setting
        Light light = list.get(position);

        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightImage);
        lightImage.setImageBitmap(light.getImage());

        TextView lightTitle = (TextView) convertView.findViewById(R.id.lighttitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView) convertView.findViewById(R.id.lightcontent);
        lightContent.setText(light.getContent());

        return convertView;
    }
}
