package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class api9 extends AppCompatActivity {


   static  int i;
    TextView[] text_view=new TextView[10];
    String[] str=new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api9);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try {
            System.out.println(geonggi1());
        } catch (IOException e) {
            e.printStackTrace();
        }
        text_view[0]=findViewById(R.id.seohae);
        text_view[1]=findViewById(R.id.gangwon);
        text_view[2]= findViewById(R.id.chungbuk);
        text_view[3]= findViewById(R.id.chungnam);
        text_view[4]= findViewById(R.id.jeonbuk);
        text_view[5]=findViewById(R.id.jeonbnam);
        text_view[6]=findViewById(R.id.geongbuk);
        text_view[7]= findViewById(R.id.geongnam);
        text_view[8]= findViewById(R.id.jeju);




        try {
           for(i=0;i<9;i++) {
               geonggi2();
           }

        } catch (Exception e) {
            e.printStackTrace();
        }


        for(int i=0;i<text_view.length-1;i++) {
    text_view[i].setTag(str[i]);
}


for(int i=0;i<str.length-1;i++) {
    text_view[i].setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            Intent register__intent = new Intent(api9.this, api9_1.class);
            api9.this.startActivity(register__intent);

            api9_1.city_var = (String) view.getTag();
            System.out.println("api9_1.city_var \t"+api9_1.city_var);
        }
    });
}
    }



    public String geonggi1 () throws IOException {
        str[0]="11B10101";
        str[1]="11D10101";
        str[2]="11C10301";
        str[3]="11C20401";
        str[4]="11F10201";
        str[5]="11F20501";
        str[6]="11H10701";
        str[7]="11H20201";
        str[8]="11G00201";

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst"
                + "?serviceKey=PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D"
                + "&numOfRows=10"
                + "&pageNo=1"
                + "&dataType=JSON"
                + "&regId="+str[i]
        );
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line + "\n");
        }
        System.out.println(rd);
        rd.close();
        conn.disconnect();

        return sb.toString();
    }

    public String geonggi2() throws Exception {

        String json6_1 = new String();
        long json6_4;

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(geonggi1());
        JSONObject json1 = (JSONObject) jsonObject.get("response");
        JSONObject json2 = (JSONObject) json1.get("body");
        JSONObject json3 = (JSONObject) json2.get("items");
        JSONArray json4 = (JSONArray) json3.get("item");

            JSONObject json5 = (JSONObject) json4.get(0);
            json6_1 = (String) json5.get("wf");
            json6_4 = (long) json5.get("numEf");





        System.out.println("\n"+str[i]);
        System.out.println(json6_1);
        System.out.println("numef"+json6_4);
            if (json6_1.contains("맑음"))
            {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.sunny2);

            } else if (json6_1.contains("구름많음")) {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.cloud3);

            } else if (json6_1.contains("흐림")) {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.blur2);


            } else if (json6_1.contains("비")) {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.rain2);

            } else if (json6_1.contains("눈")) {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.snow2);

            } else if (json6_1.contains("소나기")) {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.strongrain);

            } else if (json6_1.contains("번개")) {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.light);

            } else if (json6_1.contains("우박")) {
                text_view[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.woobak);

            }




//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


        return json6_1.toString();
    }
}














