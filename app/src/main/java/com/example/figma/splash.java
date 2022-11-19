package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {
    public static int splash_time=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences(otp_page.prefs_name,0);
                boolean hasLoggined=sharedPreferences.getBoolean("hasLoggined",false);
                if(hasLoggined){
                    Intent intent=new Intent(splash.this,details_page.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent=new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        },splash_time);
    }
}