package com.emobilis.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNaviagtion extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_naviagtion);

        //view identification
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        //loading a default fragment
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            new Fragment_B()).commit();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_fragmentA:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_A()).commit();
                break;
            case R.id.nav_toast:
                Toast.makeText(this, "Bottom Navigation Works", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_main:
                Intent intentMain = new Intent(BottomNaviagtion.this,MainActivity.class);
                startActivity(intentMain);
                break;
        }
        return true;
    }
}
