package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    //reference to handler class
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //new instance of the handler class
        handler = new Handler();
        //postDelayed to set timing logic
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                    after time is up
                Intent intent = new Intent(SplashScreen.this,IntroSlider.class);
                startActivity(intent);
                //killing activity process
                finish();
            }
        },3000); //time is in seconds
    }
}
