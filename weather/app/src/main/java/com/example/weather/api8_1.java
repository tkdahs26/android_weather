package com.example.weather;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class api8_1 extends AppCompatActivity {


    static int[] count =new int[10];
     static int i=0;
     static int a;
    TextView[] city_view=new TextView[10];
    static String str[]=new String[10];
    static String str2[]=new String[10];

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api81);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        city_view[0] = findViewById(R.id.geonggi);
        city_view[1] = findViewById(R.id.gangwon);
        city_view[2] = findViewById(R.id.chungbuk);
        city_view[3] = findViewById(R.id.chungnam);
        city_view[4] = findViewById(R.id.jeonbuk);
        city_view[5] = findViewById(R.id.jeonbnam);
        city_view[6] = findViewById(R.id.geongbuk);
        city_view[7] = findViewById(R.id.geongnam);
        city_view[8] = findViewById(R.id.jeju);
        city_view[9] = findViewById(R.id.seohae);

        city_view[0].setTag("경기 경기도");
        city_view[1].setTag("강원 강원도");
        city_view[2].setTag("충북 충청북도");
        city_view[3].setTag("충남 충청남도");
        city_view[4].setTag("전북 전라북도");
        city_view[5].setTag("전남 전라남도");
        city_view[6].setTag("경북 경상북도");
        city_view[7].setTag("경남 경상남도");
        city_view[8].setTag("제주 제주도");
        city_view[9].setTag("서해 흑산도");

        str[0]="경기";
        str[1]="강원";
        str[2]="충북";
        str[3]="충남";
        str[4]="전북";
        str[5]="전남";
        str[6]="경북";
        str[7]="경남";
        str[8]="제주";
        str[9]="서해";

        str2[0]="서울";
        str2[1]="강원도";
        str2[2]="충청북도";
        str2[3]="충청남도";
        str2[4]="전라북도";
        str2[5]="전라남도";
        str2[6]="경상북도";
        str2[7]="경상남도";
        str2[8]="제주도";
        str2[9]="5도";



        try {apitest2_2();
                apitest2_4();
            for (i = 0; i < city_view.length; i++) {
                city_view[i].setText(Integer.toString(count[i]));
            }
        }

        catch (Exception exception) {
            exception.printStackTrace();
            try {
                apitest2_2();
                for (i = 0; i < city_view.length; i++) {
                    city_view[i].setText(Integer.toString(count[i]));   }} catch (Exception e) {e.printStackTrace();}



            Toast.makeText(this,
                    exception+"에러 apitest2_4만 카운트됨",
                    Toast.LENGTH_LONG)
                    .show();
        }


        for (i = 0; i < city_view.length; i++) {
            city_view[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent register__intent = new Intent(api8_1.this, api8_2.class);
                    api8_1.this.startActivity(register__intent);



                    System.out.println("view.getTag="+view.getTag());
                    api8_2.city_var = (String) view.getTag();
                }
            });
        }
    }


        public static String apitest2_1()throws IOException {



            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/WthrWrnInfoService/getPwnStatus"
                            		+ "?serviceKey=PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D"
                    + "&numOfRows=10"
                    + "&pageNo=1"
                    +"&dataType=json"
            );
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("Response code: " + conn.getResponseCode());
            BufferedReader rd;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line+"\n");
            }

            rd.close();
            conn.disconnect();
            return  sb.toString();
        }

        public static String apitest2_2() throws Exception   {
            String json6_1 = new String();
            String json6_2 = new String();
            StringBuilder json6_1bd=new StringBuilder();
            StringBuilder json6_2bd=new StringBuilder();


            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(apitest2_1());
            JSONObject json1 = (JSONObject)jsonObject.get("response");
            JSONObject json2 = (JSONObject)json1.get("body");
            JSONObject json3 = (JSONObject)json2.get("items");
            JSONArray json4 = (JSONArray)json3.get("item");

            for(int i=0; i<json4.size(); i++) {
                JSONObject json5 = (JSONObject) json4.get(i);

                json6_1 = (String) json5.get("t6");
                json6_2 = (String) json5.get("t7");

                 json6_1bd.append(json6_1);
                 json6_2bd.append(json6_2);


            }

            for(int i=0; i< str.length; i++) {
                if (json6_1bd.toString().contains(str[i])||
                        json6_1bd.toString().contains(str2[i])) {
                    count[i] = +1;
                    System.out.println("현재특보+");
                }
            }

            for(int i=0; i< str.length; i++) {
                if (json6_2bd.toString().contains(str[i])
                        ||json6_2bd.toString().contains(str2[i])) {
                    count[i] = +1;
                    System.out.println("예비특보+");
                }
            }
            System.out.println(apitest2_1());




            return "리턴";

        }






    public static String apitest2_3()throws IOException {

        Calendar cal_today = Calendar.getInstance();
        Calendar cal_dayago = Calendar.getInstance();

        DateFormat df = new SimpleDateFormat("yyyyMMdd");



        cal_dayago.add(Calendar.DATE, -4);

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/WthrWrnInfoService/getWthrPwn" //getWthrBrkNews getPwnStatus getWthrPwn   getWthrWrnMsg
                + "?serviceKey=PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D"
                + "&numOfRows=5"
                + "&pageNo=1"
                +"&dataType=json"
                +"&stnId=108"
                +"&fromTmFc="+df.format(cal_dayago.getTime())
                +"&toTmFc="+df.format(cal_today.getTime())
        );


        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line+"\n");
        }
        rd.close();
        conn.disconnect();
        return  sb.toString();
    }

    public static String apitest2_4() throws Exception   {

        String json6_1=new String();
        String json6_2=new String();
        StringBuilder json6_1bd=new StringBuilder();
        StringBuilder json6_2bd=new StringBuilder();


        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(apitest2_3());
        JSONObject json1 = (JSONObject)jsonObject.get("response");
        JSONObject json2 = (JSONObject)json1.get("body");
        JSONObject json3 = (JSONObject)json2.get("items");
        JSONArray json4 = (JSONArray)json3.get("item");

        for(int i=0; i<json4.size(); i++) {
            JSONObject json5 = (JSONObject) json4.get(i);

            json6_1 = (String) json5.get("pwn");
            json6_2 = (String) json5.get("rem");
            json6_1bd.append(json6_1);
            json6_2bd.append(json6_2);
        }

        for(int i=0; i< 9; i++) {
            if (json6_1bd.toString().contains(str[i])||json6_2bd.toString().contains(str[i])||
                    json6_1bd.toString().contains(str2[i])||json6_2bd.toString().contains(str2[i])) {
                count[i] = +1;
                System.out.println("과거특보+");
            }
        }

        System.out.println(apitest2_3());




        return json6_1;

    }








}




