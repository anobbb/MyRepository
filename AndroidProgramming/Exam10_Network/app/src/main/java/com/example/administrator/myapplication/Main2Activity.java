package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        fillItems();
    }

    public void fillItems(){
        Thread thread = new Thread(){
            @Override
            public void run(){
                Log.i("mylog", "run()");
                try{
                    URL url = new URL("http://192.168.0.41:8080/myandroid/lightList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();

                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream is = conn.getInputStream();
                        Reader reader = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(reader);
                        String strJson = "";
                        while(true){
                            String data = br.readLine();
                            if(data == null) break;
                            strJson += data;
                        }
                        br.close(); reader.close(); is.close();
                        final List<Light> list = parseJson(strJson);
                    } // if

                    conn.disconnect();
                } catch (Exception e){

                }

            } // run

        }; // thread
        thread.start();
    } // fillItems


    public List<Light> parseJson(String strJson){
        List<Light> list = new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(strJson);
            for(int i=0; i<jsonArray.length(); i++){

            }
        }catch (Exception e){
            Log.i("mylog", e.getMessage());
        }
        return list;
    }
}
// "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",