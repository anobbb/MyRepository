package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

                AsyncTask<Void, Void, Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(Void... params) {
                        return getBitmap(light.getImageLargeFileName());
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        imageLarge.setImageBitmap(bitmap);
                    }
                };
                asyncTask.execute();
            }
        });
        testAsyncTask();
        fillItems();
    }


    public void testAsyncTask() { // inplation + data[3] 세팅
        Log.i("mylog", "1: " + Thread.currentThread().getName());
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() { // void: 리턴타입, Void: 하나의 참조타입, 일반적인 형태의 void를 지정

            // AsyncTask < [1] asyncTask를 실행할 때(execute) 매개값의 타입을 결정할 수 있고 doInBackground에 매개변수 타입을 결정 ,
            //              [2] 작업이 어느 정도 진행됐는지 알려줄 필요가 있음, onProgressUpdate 매개값의 타입 결정
            //              [3] Void, doInBackground의 리턴타입이자 onPostExecute의 매개타입 >

            @Override
            protected String doInBackground(String... params) { // 작업thread가 실행, Void ->onPostExecute의 aVoid로 전달
                Log.i("mylog", "2: " + Thread.currentThread().getName());
                Log.i("mylog", params[0]);
                // publishProgress(); // 작업스레드가 현재 어떤 상태인지 메인스레드에게 제출 -> onProgressUpdate가 실행됨
                Log.i("mylog", params[1]);
                Log.i("mylog", params[2]);

                for (int i = 1; i < 100; i++) {
                    if (i == 1) {
                        publishProgress(1);
                    } else if (i == 50) {
                        publishProgress(50);
                    } else if (i == 100) {
                        publishProgress(100);
                    }
                }
                return "작업스레드결과";
            }

            @Override
            protected void onProgressUpdate(Integer... values) { // 프로그램 작동 중간중간에 넣어줄 이슈를 결정 (작업진행 정도를 막대그래프나 퍼센트 보여주는 것 등등), main스레드 -> UI변경코드 가능
                Log.i("mylog", "3: " + Thread.currentThread().getName());
                Log.i("mylog", "작업진행정도: " + values[0]);
            }

            @Override
            protected void onPostExecute(String aVoid) { // 어떤 것을 실행한 후 // main이 실행, 작업스레드에서 못하는 UI변경코드 넣으면 됨
                Log.i("mylog", "4: " + Thread.currentThread().getName());
                Log.i("mylog", aVoid);
            }
        };
        asyncTask.execute("실행매개값1", "실행매개값2", "실행매개값3");
    }

    public void fillItems(){
        AsyncTask<Void, Void, List<Light>> asyncTask = new AsyncTask<Void, Void, List<Light>>() {
            @Override
            protected List<Light> doInBackground(Void... params) {
                List<Light> list = null;
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
                        while (true) {
                            String data = br.readLine(); // 한 행씩 읽기, 데이터 없을 땐 null 리턴
                            if (data == null) break; // 더 이상 읽을 데이터가 없을 때
                            strJson += data;
                        }
                        br.close();
                        reader.close();
                        is.close();
                        list = parseJson(strJson); // 지역변수가 익명객체 안에서 사용될 때는 final!!!
                    }
                    conn.disconnect();
                } catch (Exception e){
                    Log.i("mylog", e.getMessage());
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Light> lights) {
                lightAdapter = new LightAdapter(MainActivity.this); // MainActivity는 되도록이면 MainThread에서 실행, 화면을 구성하는 자원 사용
                lightAdapter.setList(lights); //setting
                lightList.setAdapter(lightAdapter);
                imageLarge.setImageBitmap(lights.get(0).getImageLarge());
            }
        };
        asyncTask.execute();
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
