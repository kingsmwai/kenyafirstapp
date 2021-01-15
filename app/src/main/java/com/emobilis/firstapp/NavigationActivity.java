package com.emobilis.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //declare drawer Layout and Toolbar
    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //views identification
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set the toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //load default fragment
        //check if empty first
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment_A()).commit();
            //set the checked item
            navigationView.setCheckedItem(R.id.nav_fragmentA);
        }

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_main:
                Intent intentMain = new Intent(NavigationActivity.this,MainActivity.class);
                startActivity(intentMain);
                break;
            case R.id.nav_second:
                Intent intentSecond = new Intent(NavigationActivity.this,SecondActivity.class);
                startActivity(intentSecond);
                break;
            case R.id.nav_fragmentA:
                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                         new Fragment_A()).commit();
                break;
            case R.id.nav_fragmentB:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_B()).commit();
                break;
            case R.id.nav_fragmentC:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_C()).commit();
                break;
            case R.id.nav_bottom:
                Intent intentBottom = new Intent(NavigationActivity.this, BottomNaviagtion.class);
                startActivity(intentBottom);
                break;

            case R.id.nav_tab:
                Intent intentTab = new Intent(NavigationActivity.this, TabActivity.class);
                startActivity(intentTab);
                break;


            default:
                Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    //dictate the back press

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            //takes user back to previous class
            super.onBackPressed();
        }
    }
}
