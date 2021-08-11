package com.example.api1;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class api9_1 extends AppCompatActivity {


 public static String city_var;

    ImageView[] viewlist = new ImageView[10];
    TextView[] gangsu = new TextView[10];
    TextView[] day_text = new TextView[10];
    ImageView[] umbrella = new ImageView[10];
    TextView[] tem_text = new TextView[10];
    String[] json6_7 = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api91);


        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Date day_now = new Date(System.currentTimeMillis());
        SimpleDateFormat hour_now = new SimpleDateFormat("HH");
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        Calendar cal = Calendar.getInstance();
        Date day = cal.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("E요일", Locale.KOREAN);


        //24시부터 ~5시 (폰시계)
        if((Integer.parseInt(hour_now.format(day_now))>=0&&Integer.parseInt(hour_now.format(day_now))<5)){

            try {

                geonggi2();

                day_text[1].setText("오늘"+" 오전");
                day_text[2].setText("오늘"+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[3].setText(sdf1.format(day)+" 오전");
                day_text[4].setText(sdf1.format(day)+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[5].setText(sdf1.format(day)+" 오전");
                day_text[6].setText(sdf1.format(day)+" 오후");

                tem_text[0].setText("" ); tem_text[0].append("/" + json6_7[0] + "℃");
                tem_text[1].setText(colortext(json6_7[1]+"℃"+"/"+json6_7[2]+"℃"));
                tem_text[2].setText(colortext(json6_7[1]+"℃"+"/"+json6_7[2]+"℃"));
                tem_text[3].setText(colortext(json6_7[3]+"℃"+"/"+json6_7[4]+"℃"));
                tem_text[4].setText(colortext(json6_7[3]+"℃"+"/"+json6_7[4]+"℃"));
                tem_text[5].setText(colortext(json6_7[5]+"℃"+"/"+json6_7[6]+"℃"));
                tem_text[6].setText(colortext(json6_7[5]+"℃"+"/"+json6_7[6]+"℃"));



                int[] arr1=new int[10];arr1[1]=30;arr1[2]=160;arr1[3]=290;arr1[4]=30;arr1[5]=160;arr1[6]=290;
                int[] arr2=new int[10];arr2[1]=200;arr2[2]=200;arr2[3]=200;arr2[4]=480;arr2[5]=480;arr2[6]=480;
                int[] arr3=new int[10];arr3[1]=10;arr3[2]=140;arr3[3]=270;arr3[4]=10;arr3[5]=140;arr3[6]=270;
                int[] arr4=new int[10];arr4[1]=40;arr4[2]=40;arr4[3]=40;arr4[4]=320;arr4[5]=320;arr4[6]=320;
                int[] arr5=new int[10];arr5[1]=160;arr5[2]=160;arr5[3]=160;arr5[4]=440;arr5[5]=440;arr5[6]=440;
                int[] arr6=new int[10];arr6[1]=140;arr6[2]=140;arr6[3]=140; arr6[4]=420;arr6[5]=420;arr6[6]=420;
                int[] arr7=new int[10];arr7[1]=40;arr7[2]=170;arr7[3]=300;arr7[4]=40;arr7[5]=170;arr7[6]=300;
                int[] arr8=new int[10];arr8[1]=170;arr8[2]=170;arr8[3]=170;arr8[4]=450;arr8[5]=450;arr8[6]=450;

                for(int i=0;i<7;i++){
                    day_text[i].setTranslationX(dptopixel(arr1[i]));
                    day_text[i].setTranslationY(dptopixel(arr2[i]));

                    viewlist[i].setTranslationX(dptopixel(arr3[i]));
                    viewlist[i].setTranslationY(dptopixel(arr4[i]));

                    umbrella[i].setTranslationX(dptopixel(arr3[i]));
                    umbrella[i].setTranslationY(dptopixel(arr5[i]));

                    tem_text[i].setTranslationX(dptopixel(arr3[i]));
                    tem_text[i].setTranslationY(dptopixel(arr6[i]));

                    gangsu[i].setTranslationX(dptopixel(arr7[i]));
                    gangsu[i].setTranslationY(dptopixel(arr8[i]));
                }


                day_text[0].setVisibility(View.GONE);
                umbrella[0].setVisibility(View.GONE);
                tem_text[0].setVisibility(View.GONE);
                viewlist[0].setVisibility(View.GONE);
                gangsu[0].setVisibility(View.GONE);

/*
                day_text[1].setTranslationX(dptopixel(30));
                day_text[2].setTranslationX(dptopixel(160));
                day_text[3].setTranslationX(dptopixel(290));
                day_text[4].setTranslationX(dptopixel(30));
                day_text[5].setTranslationX(dptopixel(160));
                day_text[6].setTranslationX(dptopixel(290));

                day_text[1].setTranslationY(dptopixel(200));
                day_text[2].setTranslationY(dptopixel(200));
                day_text[3].setTranslationY(dptopixel(200));
                day_text[4].setTranslationY(dptopixel(480));
                day_text[5].setTranslationY(dptopixel(480));
                day_text[6].setTranslationY(dptopixel(480));

                viewlist[1].setTranslationX(dptopixel(10));
                viewlist[2].setTranslationX(dptopixel(140));
                viewlist[3].setTranslationX(dptopixel(270));
                viewlist[4].setTranslationX(dptopixel(10));
                viewlist[5].setTranslationX(dptopixel(140));
                viewlist[6].setTranslationX(dptopixel(270));

                viewlist[1].setTranslationY(dptopixel(40));
                viewlist[2].setTranslationY(dptopixel(40));
                viewlist[3].setTranslationY(dptopixel(40));
                viewlist[4].setTranslationY(dptopixel(320));
                viewlist[5].setTranslationY(dptopixel(320));
                viewlist[6].setTranslationY(dptopixel(320));

                umbrella[1].setTranslationX(dptopixel(10));
                umbrella[2].setTranslationX(dptopixel(140));
                umbrella[3].setTranslationX(dptopixel(270));
                umbrella[4].setTranslationX(dptopixel(10));
                umbrella[5].setTranslationX(dptopixel(140));
                umbrella[6].setTranslationX(dptopixel(270));

                umbrella[1].setTranslationY(dptopixel(160));
                umbrella[2].setTranslationY(dptopixel(160));
                umbrella[3].setTranslationY(dptopixel(160));
                umbrella[4].setTranslationY(dptopixel(440));
                umbrella[5].setTranslationY(dptopixel(440));
                umbrella[6].setTranslationY(dptopixel(440));

                tem_text[1].setTranslationX(dptopixel(10));
                tem_text[2].setTranslationX(dptopixel(140));
                tem_text[3].setTranslationX(dptopixel(270));
                tem_text[4].setTranslationX(dptopixel(10));
                tem_text[5].setTranslationX(dptopixel(140));
                tem_text[6].setTranslationX(dptopixel(270));

                tem_text[1].setTranslationY(dptopixel(140));
                tem_text[2].setTranslationY(dptopixel(140));
                tem_text[3].setTranslationY(dptopixel(140));
                tem_text[4].setTranslationY(dptopixel(420));
                tem_text[5].setTranslationY(dptopixel(420));
                tem_text[6].setTranslationY(dptopixel(420));

                gangsu[1].setTranslationX(dptopixel(40));
                gangsu[2].setTranslationX(dptopixel(170));
                gangsu[3].setTranslationX(dptopixel(300));
                gangsu[4].setTranslationX(dptopixel(40));
                gangsu[5].setTranslationX(dptopixel(170));
                gangsu[6].setTranslationX(dptopixel(300));

                gangsu[1].setTranslationY(dptopixel(170));
                gangsu[2].setTranslationY(dptopixel(170));
                gangsu[3].setTranslationY(dptopixel(170));
                gangsu[4].setTranslationY(dptopixel(450));
                gangsu[5].setTranslationY(dptopixel(450));
                gangsu[6].setTranslationY(dptopixel(450));
*/

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //5시부터 ~11시 (폰시계)
        if(Integer.parseInt(hour_now.format(day_now))>=5&&(Integer.parseInt(hour_now.format(day_now))<11)){

            try {
                geonggi2();

                day_text[0].setText("오늘"+" 오전");
                day_text[1].setText("오늘"+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[2].setText(sdf1.format(day)+" 오전");
                day_text[3].setText(sdf1.format(day)+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[4].setText(sdf1.format(day)+" 오전");
                day_text[5].setText(sdf1.format(day)+" 오후");


                day_text[6].setVisibility(View.GONE);
                umbrella[6].setVisibility(View.GONE);
                tem_text[6].setVisibility(View.GONE);
                viewlist[6].setVisibility(View.GONE);
                gangsu[6].setVisibility(View.GONE);

                try {
                  tem_text[0].setText("" ); tem_text[0].append(colortext2("/" + json6_7[1] + "℃"));
                  tem_text[1].setText("" ); tem_text[1].append(colortext2("/" + json6_7[1] + "℃"));
                  tem_text[2].setText(colortext(json6_7[2] + "℃" + "/" + json6_7[3] + "℃"));
                  tem_text[3].setText(colortext(json6_7[2] + "℃" + "/" + json6_7[3] + "℃"));
                  tem_text[4].setText(colortext(json6_7[4] + "℃" + "/" + json6_7[5] + "℃"));
                  tem_text[5].setText(colortext(json6_7[4] + "℃" + "/" + json6_7[5] + "℃"));
                }

                catch (IndexOutOfBoundsException e){
               System.out.println("IndexOutOfBoundsException오류날시"+e);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //11시부터 ~ 17시 (폰시계)
        if(Integer.parseInt(hour_now.format(day_now))>=11&&(Integer.parseInt(hour_now.format(day_now))<17)){

            try {
                geonggi2();

                day_text[0].setText("오늘"+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[1].setText(sdf1.format(day)+" 오전");
                day_text[2].setText(sdf1.format(day)+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[3].setText(sdf1.format(day)+" 오전");
                day_text[4].setText(sdf1.format(day)+" 오후");

                tem_text[0].setText("" ); tem_text[0].append(colortext2("/" + json6_7[0] + "℃"));
                tem_text[1].setText(colortext(json6_7[1]+"℃"+"/"+json6_7[2]+"℃"));
                tem_text[2].setText(colortext(json6_7[1]+"℃"+"/"+json6_7[2]+"℃"));
                tem_text[3].setText(colortext(json6_7[3]+"℃"+"/"+json6_7[4]+"℃"));
                tem_text[4].setText(colortext(json6_7[3]+"℃"+"/"+json6_7[4]+"℃"));




                day_text[5].setVisibility(View.GONE);
                day_text[6].setVisibility(View.GONE);
                umbrella[5].setVisibility(View.GONE);
                umbrella[6].setVisibility(View.GONE);
                tem_text[5].setVisibility(View.GONE);
                tem_text[6].setVisibility(View.GONE);
                viewlist[5].setVisibility(View.GONE);
                viewlist[6].setVisibility(View.GONE);
                gangsu[5].setVisibility(View.GONE);
                gangsu[6].setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //17시부터 ~24시 (폰시계)
        if((Integer.parseInt(hour_now.format(day_now))>=17&&Integer.parseInt(hour_now.format(day_now))<24)){

            try {

                geonggi2();

                day_text[0].setText("오늘"+" 저녁");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[1].setText(sdf1.format(day)+" 오전");
                day_text[2].setText(sdf1.format(day)+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[3].setText(sdf1.format(day)+" 오전");
                day_text[4].setText(sdf1.format(day)+" 오후");
                cal.add(Calendar.DATE, +1);
                day = cal.getTime();
                day_text[5].setText(sdf1.format(day)+" 오전");
                day_text[6].setText(sdf1.format(day)+" 오후");

                tem_text[0].setText("" );
                tem_text[1].setText(colortext(json6_7[1]+"℃"+"/"+json6_7[2]+"℃"));
                tem_text[2].setText(colortext(json6_7[1]+"℃"+"/"+json6_7[2]+"℃"));
                tem_text[3].setText(colortext(json6_7[3]+"℃"+"/"+json6_7[4]+"℃"));
                tem_text[4].setText(colortext(json6_7[3]+"℃"+"/"+json6_7[4]+"℃"));
                tem_text[5].setText(colortext(json6_7[5]+"℃"+"/"+json6_7[6]+"℃"));
                tem_text[6].setText(colortext(json6_7[5]+"℃"+"/"+json6_7[6]+"℃"));


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        TextView area_view=findViewById(R.id.area);

        String[] citycode=new String[10];
        citycode[0]="11B10101";
        citycode[1]="11D10101";
        citycode[2]="11C10301";
        citycode[3]="11C20401";
        citycode[4]="11F10201";
        citycode[5]="11F20501";
        citycode[6]="11H10701";
        citycode[7]="11H20201";
        citycode[8]="11G00201";
        String str[]=new String[10];
        str[0]="경기도";
        str[1]="강원도";
        str[2]="충청북도";
        str[3]="충청남도";
        str[4]="전라북도";
        str[5]="전라남도";
        str[6]="경상북도";
        str[7]="경상남도";
        str[8]="제주도";
        for (int i = 0; i <str.length-1; i++) {
            if (city_var==citycode[i]) {
                area_view.setText(str[i]+"의 날씨");
                area_view.setTextColor(Color.parseColor("#009900"));
                
                area_view.setTextSize(Dimension.SP, 19);
                System.out.println("api8_1.str[i]"+api8_1.str[i]);
            }
        }

    }

    public SpannableStringBuilder colortext(String str) {
        final SpannableStringBuilder asd = new SpannableStringBuilder(str);
        asd.setSpan(new ForegroundColorSpan(Color.parseColor("#00FFFF")), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        asd.setSpan(new ForegroundColorSpan(Color.parseColor("#003300")), 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        asd.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 4, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return asd;
    }

    public SpannableStringBuilder colortext2(String str) {
        final SpannableStringBuilder asd = new SpannableStringBuilder(str);
        asd.setSpan(new ForegroundColorSpan(Color.parseColor("#003300")), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        asd.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), 1, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return asd;
    }

    public float dptopixel(float dp){
        Resources resources = this.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }





    public static String geonggi1 () throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst"
                + "?serviceKey=PbdWCcIn6LRk08D3FLzAppI0n2oD9OdYt%2FH6KDygxtCanRyBXpbMAoPVl%2B5pTNtYA86i4pHwT7D8%2Bbz%2FPj0PGw%3D%3D"
                + "&numOfRows=10"
                + "&pageNo=1"
                + "&dataType=JSON"
                + "&regId="+city_var
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


        viewlist[0]=findViewById(R.id.today_img);
        viewlist[1]=findViewById(R.id.tom__img);
        viewlist[2]= findViewById(R.id.day3_img);
        viewlist[3]= findViewById(R.id.day4_img);
        viewlist[4]= findViewById(R.id.day5_img);
        viewlist[5]= findViewById(R.id.day6_img);
        viewlist[6]= findViewById(R.id.day7_img);

        gangsu[0]=findViewById(R.id.today_gangsu);
        gangsu[1]=findViewById(R.id.tomo_gangsu);
        gangsu[2]= findViewById(R.id.day3_gangsu);
        gangsu[3]= findViewById(R.id.day4_gangsu);
        gangsu[4]= findViewById(R.id.day5_gangsu);
        gangsu[5]=findViewById(R.id.day6_gangsu);
        gangsu[6]=findViewById(R.id.day7_gangsu);

        day_text[0]=findViewById(R.id.today);
        day_text[1]=findViewById(R.id.tommorow);
        day_text[2]= findViewById(R.id.day3);
        day_text[3]= findViewById(R.id.day4);
        day_text[4]= findViewById(R.id.day5);
        day_text[5]=findViewById(R.id.day6);
        day_text[6]=findViewById(R.id.day7);

        umbrella[0]=findViewById(R.id.today_umb);
        umbrella[1]=findViewById(R.id.tomo_umb);
        umbrella[2]= findViewById(R.id.day3_umb);
        umbrella[3]= findViewById(R.id.day4_umb);
        umbrella[4]= findViewById(R.id.day5_umb);
        umbrella[5]= findViewById(R.id.day6_umb);
        umbrella[6]= findViewById(R.id.day7_umb);

        tem_text[0]=findViewById(R.id.tem1);
        tem_text[1]=findViewById(R.id.tem2);
        tem_text[2]=findViewById(R.id.tem3);
        tem_text[3]=findViewById(R.id.tem4);
        tem_text[4]=findViewById(R.id.tem5);
        tem_text[5]=findViewById(R.id.tem6);
        tem_text[6]=findViewById(R.id.tem7);





        String json6_1 = new String();
        String json6_3 = new String();
        String json6_6 = new String();
        long json6_4;
        long json6_2;
        long json6_5;
        String json6_5_str = new String();
        StringBuilder json6_2bd = new StringBuilder();


        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(geonggi1());
        JSONObject json1 = (JSONObject) jsonObject.get("response");
        JSONObject json2 = (JSONObject) json1.get("body");
        JSONObject json3 = (JSONObject) json2.get("items");
        JSONArray json4 = (JSONArray) json3.get("item");


        for (int i = 0; i < json4.size(); i++) {
            JSONObject json5 = (JSONObject) json4.get(i);
            json6_1 = (String) json5.get("wf");
            json6_2 = (long) json5.get("announceTime");
            json6_3 = (String) json5.get("regId");
            json6_4 = (long) json5.get("numEf");
            json6_5=(long) json5.get("rnSt");
            json6_6 = (String) json5.get("ta");
            String json6_4str = new String();
            String i_str = new String();
            json6_2bd.append(json6_1+"\t"+json6_2+"\t"+json6_3 +"\t" + json6_4+"\t"+json6_5+"\n");
            json6_5_str=String.valueOf(json6_5);
            json6_4str = String.valueOf(json6_4);
            i_str = String.valueOf(i);

            gangsu[i].setText(json6_5_str+"%");
            json6_7[i]=json6_6;




            if (json6_1.contains("맑음")&&json6_4str.contains(i_str))
            {
                viewlist[i].setImageResource(R.drawable.sunny2);
            }
            else if  (json6_1.contains("구름많음")&&json6_4str.contains(i_str)){
                viewlist[i].setImageResource(R.drawable.cloud3);
            }
            else if  (json6_1.contains("흐림")&&json6_4str.contains(i_str)){
                viewlist[i].setImageResource(R.drawable.blur2);
            }
            else if  (json6_1.contains("비")&&json6_4str.contains(i_str)){
                viewlist[i].setImageResource(R.drawable.rain2);
            }
            else if  (json6_1.contains("눈")&&json6_4str.contains(i_str)){
                viewlist[i].setImageResource(R.drawable.snow2);
            }
            else if  (json6_1.contains("소나기")&&json6_4str.contains(i_str)){
                viewlist[i].setImageResource(R.drawable.strongrain);
            }
            else if  (json6_1.contains("번개")&&json6_4str.contains(i_str)){
                viewlist[i].setImageResource(R.drawable.light);
            }
            else if  (json6_1.contains("우박")&&json6_4str.contains(i_str)){
                viewlist[i].setImageResource(R.drawable.woobak);
            }
        }
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        System.out.println( geonggi1());
        return json6_2bd.toString();
    }
}
