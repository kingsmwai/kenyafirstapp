package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifecycleActivity extends AppCompatActivity {
     //declare the tag variable
    private static final String TAG = "LifecycleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG,"onCreate is running");
    }

    @Override
    protected void onStart() {
//        logic
        Log.d(TAG,"on start is running");
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.d(TAG,"onResume is running");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause is running");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop is running");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy is running");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG,"onbackpressed is running");
        super.onBackPressed();
    }
}
