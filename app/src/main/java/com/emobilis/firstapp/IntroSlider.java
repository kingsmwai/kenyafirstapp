package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroSlider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);

        //check if frame layout is populated if not we load default fragment
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SliderA()).commit();
        }

    }

    public void skip(View v){
        //go to main app screen
        Intent intent = new Intent(IntroSlider.this,NavigationActivity.class);
        startActivity(intent);
    }

    public void next(View v){
          getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SliderB()).commit();
    }
}
