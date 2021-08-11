package com.example.api1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class api8_2 extends AppCompatActivity {

    static StringBuilder json6_1bd=new StringBuilder();
    static StringBuilder json6_2bd=new StringBuilder();
    static StringBuilder json6_1_1bd=new StringBuilder();
    static StringBuilder json6_2_2bd=new StringBuilder();


    static String json6_11r = new String();
    static String json6_12r = new String();
    static String json6_21r = new String();
    static String json6_22r = new String();

    static String json6_1_1r = new String();
    static String json6_1_2r = new String();
    static String json6_2_1r = new String();
    static String json6_2_2r = new String();

    public static String city_var;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api82);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        TextView tbo_text1 = (TextView) findViewById(R.id.tbo_text_id1);
        TextView tbo_text2 = (TextView) findViewById(R.id.tbo_text_id2);
        TextView tbo_text11 = (TextView) findViewById(R.id.tbo_text_id11);

        String[] city_var_sp = city_var.split(" ");
        System.out.println("city_var_sp[0]"+city_var_sp[0]);
        System.out.println("city_var_sp[1]"+city_var_sp[1]);

        try {
            apitest2_2();
            System.out.println(city_var+"8-2city_var의값");
                 if(json6_12r.contains(city_var_sp[0])||
                    json6_22r.contains(city_var_sp[0])||
                    json6_12r.contains(city_var_sp[1])||
                    json6_22r.contains(city_var_sp[1])){
                tbo_text1.setText("예비특보"+"\n"+json6_12r+"\n"+json6_22r+"\n"+city_var+"만출력");
                     tbo_text1.setTextColor(Color.parseColor("#000000"));
                     tbo_text1.setTextSize(15);
                System.out.println("json6_12="+json6_12r);

                System.out.println("json6_22="+json6_22r);
            }
            else{
                tbo_text1.setText("예비 특보없음");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            apitest2_2();
            System.out.println(city_var+"8-2city_var의값");
            if(json6_11r.contains(city_var_sp[0])||
                    json6_21r.contains(city_var_sp[0])||
                    json6_11r.contains(city_var_sp[1])||
                    json6_21r.contains(city_var_sp[1])){
                tbo_text11.setText("현재특보"+"\n"+json6_11r+"\n"+json6_21r+"\n"+city_var+"만출력");
                tbo_text11.setTextColor(Color.parseColor("#000000"));
                tbo_text11.setTextSize(15);

                System.out.println("json6_11="+json6_11r);
                System.out.println("json6_21="+json6_21r);
            }
            else{
                tbo_text11.setText("현재 특보없음");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            apitest2_4();
                 if(json6_1_1r.contains(city_var_sp[0])||json6_1_2r.contains(city_var_sp[0])||
                    json6_2_1r.contains(city_var_sp[0])||json6_2_2r.contains(city_var_sp[0])||
                    json6_1_1r.contains(city_var_sp[1])||json6_1_2r.contains(city_var_sp[1])||
                    json6_2_1r.contains(city_var_sp[1])||json6_2_2r.contains(city_var_sp[1])){
                tbo_text2.setText("최근에 발표된 특보"+"\n"+json6_1_1r+"\n"+json6_1_2r+"\n"+json6_2_1r+"\n"+json6_2_2r+"\n"+city_var+"만출력");
                     tbo_text2.setTextColor(Color.parseColor("#000000"));
                     tbo_text2.setTextSize(15);
                System.out.println("json6_1_1="+json6_1_1r);
                System.out.println("json6_1_2="+json6_1_2r);
                System.out.println("json6_2_1="+json6_2_1r);
                System.out.println("json6_2_2="+json6_2_2r);
            }
            else{
                tbo_text2.setText("최근 발표된 특보없음");
            }
        } catch (Exception e) {
            e.printStackTrace();
            tbo_text2.setText("최근 발표된 특보없음");
        }

    }



    public static String apitest2_1()throws IOException {


        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/WthrWrnInfoService/getPwnStatus" //getWthrBrkNews getPwnStatus getWthrPwn   getWthrWrnMsg
                /*url*/        		+ "?serviceKey=PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D"
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

          String json6_11 = new String();
          String json6_12 = new String();
          String json6_21 = new String();
          String json6_22 = new String();

        StringBuilder lastadd=new StringBuilder();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(apitest2_1());
        JSONObject json1 = (JSONObject)jsonObject.get("response");
        JSONObject json2 = (JSONObject)json1.get("body");
        JSONObject json3 = (JSONObject)json2.get("items");
        JSONArray json4 = (JSONArray)json3.get("item");
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    try {
    JSONObject json5_0 = (JSONObject) json4.get(0);
    json6_11 = (String) json5_0.get("t6");
    json6_12 = (String) json5_0.get("t7");
    JSONObject json5_1 = (JSONObject) json4.get(1);
    json6_21 = (String) json5_1.get("t6");
    json6_22 = (String) json5_1.get("t7");

    }catch(IndexOutOfBoundsException e){
    JSONObject json5_0 = (JSONObject) json4.get(0);
    json6_11 = (String) json5_0.get("t6");
    json6_12 = (String) json5_0.get("t7");
    }

        json6_11r=json6_11.replace("o 없음","");
        json6_12r=json6_12.replace("o 없음","");
        json6_21r=json6_21.replace("o 없음","");
        json6_22r=json6_22.replace("o 없음","");

        System.out.println("apitest2_1"+apitest2_1());
        return lastadd.toString();

    }



    public static String apitest2_3()throws IOException {

        Calendar cal_today = Calendar.getInstance();
        Calendar cal_dayago = Calendar.getInstance();

        DateFormat df = new SimpleDateFormat("yyyyMMdd");


        cal_dayago.add(Calendar.DATE, -4);

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/WthrWrnInfoService/getWthrPwn" //getWthrBrkNews getPwnStatus getWthrPwn   getWthrWrnMsg
                + "?serviceKey=PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D"
                + "&numOfRows=10"
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

         String json6_1_1 = new String();
         String json6_1_2 = new String();
         String json6_2_1 = new String();
         String json6_2_2 = new String();


        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(apitest2_3());
        JSONObject json1 = (JSONObject)jsonObject.get("response");
        JSONObject json2 = (JSONObject)json1.get("body");
        JSONObject json3 = (JSONObject)json2.get("items");
        JSONArray json4 = (JSONArray)json3.get("item");
        JSONObject json5_0 = (JSONObject)json4.get(0);
        JSONObject json5_1 = (JSONObject)json4.get(1);
            json6_1_1 = (String)json5_0.get("pwn");
            json6_1_2 = (String)json5_0.get("rem");
            json6_2_1 = (String)json5_1.get("pwn");
            json6_2_2 = (String)json5_1.get("rem");

         json6_1_1r=json6_1_1.replace("o 없음","");
         json6_1_2r=json6_1_2.replace("o 없음","");
         json6_2_1r=json6_2_1.replace("o 없음","");
         json6_2_2r=json6_2_2.replace("o 없음","");




        System.out.println("apitest2_3"+apitest2_3());
        return json6_1_1;

    }





}










