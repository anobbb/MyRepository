package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private ListView lightList;
    //private List<Light> list;
    private LightAdapter lightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLarge = (ImageView)findViewById(R.id.imageLarge);

        lightList = (ListView)findViewById(R.id.lightList); // 초기화
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Light light = list.get(position); //position => index
               final Light light = (Light)lightAdapter.getItem(position); // Mainthread
               Thread thread = new Thread() {
                   @Override
                   public void run() {
                       final Bitmap bitmap = getBitmap(light.getImageLargeFileName());
                       imageLarge.post(new Runnable() {
                           @Override
                           public void run() {
                               imageLarge.setImageBitmap(bitmap);
                           }
                       });
                   }
               };
               thread.start();
            }
        });
        fillItems();
    }


    public void fillItems(){ // inplation + data[3] 세팅
        // HTTP 통신 코드
        Thread thread = new Thread(){
           @Override
            public void run(){
               Log.i("mylog", "run()");
               try{
                   URL url = new URL("http://192.168.0.41:8080/myandroid/lightList"); // localhost를 안 쓰는 이유: 폰에서 실행하므로 컴퓨터가 아닌 폰이 localhost로 잡히기 때문
                   HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 연결객체 얻기 (연결되는 것은 아님)
                   conn.connect(); // 연결

                   // Network Thread가 실행
                   if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) { // == 200 OK
                       // json 내용(본문 데이터)
                       InputStream is = conn.getInputStream();
                       Reader reader = new InputStreamReader(is);
                       BufferedReader br = new BufferedReader(reader);
                       String strJson = "";
                       while(true) {
                           String data = br.readLine(); // 한 행씩 읽기, 데이터 없을 땐 null 리턴
                           if(data == null) break; // 더 이상 읽을 데이터가 없을 때
                           strJson += data;
                       }
                       br.close(); reader.close(); is.close();
                       final List<Light> list = parseJson(strJson); // 지역변수가 익명객체 안에서 사용될 때는 final!!!
                       //Main Thread가 실행 (post 메소드), lightList 위젯은 Main Thread가 실행(view는 주로 MT, 어떠한 View가 와도 상관없음, MainThread가 만든 객체를 post함)
                       lightList.post(new Runnable() { // Runnable 객체 실행
                           @Override
                           public void run() {
                               lightAdapter = new LightAdapter(MainActivity.this); // MainActivity는 되도록이면 MainThread에서 실행, 화면을 구성하는 자원 사용
                               lightAdapter.setList(list); //setting
                               lightList.setAdapter(lightAdapter);
                               imageLarge.setImageBitmap(list.get(0).getImageLarge());
                           }
                       });
                   }

                   conn.disconnect(); // 연결끊기
               } catch (Exception e){
                   Log.i("mylog", e.getMessage()); // 인터넷 사용 동의(anbdroidManifest.xml)
               }
           }
        };
        thread.start();
    }

    public List<Light> parseJson(String strJson) {
        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson); // strJson이 [배열]이 아닌 {}로 시작되면 JsonObject로 파싱, [배열]이면 JSONArray로 파싱(해석)
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Light light = new Light();
                light.setImage(getBitmap(jsonObject.getString("image"))); // ex) light1.png
                if(i==0){
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                light.setImageFileName(jsonObject.getString("image"));
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                list.add(light);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }
        return list;
    }


    // 작업 스레드
    public Bitmap getBitmap(String  fileName) {
        Bitmap bitmap = null;
        try {
            URL url = new URL("http://192.168.0.41:8080/myandroid/getImage?fileName=" + fileName); // get방식
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is); // inputStream을 Bitmap으로 만들어주는 내장메소드
            }

            conn.disconnect();
        } catch (Exception e) {
            Log.i("mylog", e.getMessage());
        }
        return bitmap;
    }
}
