package com.example.api1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class api6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api6);


        Button mise_btn2 = (Button) findViewById(R.id.mise_btn) ;
        mise_btn2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view)  {
                Intent intent=new Intent(api6.this,api7.class);
                api6.this.startActivity(intent);
            }
        });
        Button chomise_btn2 = (Button) findViewById(R.id.chomise_btn) ;
        chomise_btn2.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view)  {
                Intent intent=new Intent(api6.this,api7_1.class);
                api6.this.startActivity(intent);
            }
        });


        Button tbo_btn2 = (Button) findViewById(R.id.tbo_btn) ;
        tbo_btn2.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view)  {

                Intent intent=new Intent(api6.this, api8_1.class);
                api6.this.startActivity(intent);
            }
        });


        Button weather_btn2 = (Button) findViewById(R.id.weather_btn) ;
        weather_btn2.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view)  {

                Intent intent=new Intent(api6.this,api9.class);
                api6.this.startActivity(intent);
            }
        });
    }


}