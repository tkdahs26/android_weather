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
import java.net.URLEncoder;

public class api7 extends AppCompatActivity {










    static int i;
    String[] city=new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api7);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        } //인터넷 연결시 필요

        TextView[] city_view=new TextView[10];
        city_view[0]= (TextView) findViewById(R.id.seohae);
        city_view[1]= (TextView) findViewById(R.id.gangwon);
        city_view[2]= (TextView) findViewById(R.id.chungbuk);
        city_view[3]= (TextView) findViewById(R.id.chungnam);
        city_view[4]= (TextView) findViewById(R.id.jeonbuk);
        city_view[5]=(TextView) findViewById(R.id.jeonbnam);
        city_view[6]=(TextView) findViewById(R.id.geongbuk);
        city_view[7]=(TextView) findViewById(R.id.geongnam);
        city_view[8]=(TextView)findViewById(R.id.jeju);
        try {
            for(i=0; i<city_view.length-1;i++) {
                    city_view[i].setText(geonggi2());
                    changecolor(city_view[i]);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public TextView changecolor(TextView text)  {
        int text_int=0;
        if(!text.getText().toString().equals("-")) {
            text_int = Integer.parseInt(text.getText().toString());
        }
        if(text_int<=30) {
            text.setTextColor(Color.parseColor("#66FFCC"));
        }
        else if(30<=text_int&&text_int<=80) {

            text.setTextColor(Color.parseColor("#00CC00"));
        }
        else if(80<=text_int&&text_int<=150) {

            text.setTextColor(Color.parseColor("#FF6600"));
        }
        else if(150<=text_int) {

            text.setTextColor(Color.parseColor("#FF0000"));
        }


        return text;
    }


    public String geonggi1()throws IOException {

        city[0]="경기";
        city[1]="강원";
        city[2]="충북";
        city[3]="충남";
        city[4]="전북";
        city[5]="전남";
        city[6]="경북";
        city[7]="경남";
        city[8]="제주";

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") +"="+ "PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8")      +"=" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8")      +"=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8")      +"=" + URLEncoder.encode("100", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8")      +"=" + URLEncoder.encode(city[i],"UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("ver","UTF-8")      +"=" + URLEncoder.encode("1.0", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
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
        return sb.toString();

    }

    public String geonggi2() throws Exception   {

        String json5_2 = new String();
        String json5_0 = new String();
        String json5_3 = new String();
        String json5_1 = new String();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(geonggi1());
        JSONObject json1 = (JSONObject)jsonObject.get("response");
        JSONObject json2 = (JSONObject)json1.get("body");
        JSONArray json3 = (JSONArray)json2.get("items");

        for(int i=0; i<json3.size(); i++){
            JSONObject json4 = (JSONObject)json3.get(i);
            json5_0 = (String)json4.get("dataTime");
            json5_1 = (String)json4.get("sidoName");
            json5_2 = (String)json4.get("pm10Value");
            json5_3 = (String)json4.get("pm25Value");

        }
        return json5_2;


    }










}





/*요청
serviceKey인증키

 응답
numOfRows한 페이지 결과 수
pageNo페이지 번호
totalCount데이터 총 개수
resultCode응답메시지 코드
resultMsg응답메시지 내용?
dataType데이터 타입
title제목
stnId지점코드
tmSeq발표번호(월별)
tmFc발표시각 년월일시분*/



