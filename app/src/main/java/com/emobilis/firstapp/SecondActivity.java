package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView sharedText;
    //variables to hold shared info
    String name,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharedText = findViewById(R.id.sharedText);

        sharedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Text was clicked", Toast.LENGTH_SHORT).show();
            }
        });

         //getting shared data
         Intent intent = getIntent();
         name = intent.getStringExtra("name_from_text");
         message = intent.getStringExtra("message_from_user");

        Toast.makeText(this, "Name is " + name + " Message set " + message, Toast.LENGTH_LONG).show();

         //set the text to views
        sharedText.setText(message + " " + name);



    }

    public void exit(View v){
        //exit app
        finishAffinity();
    }
}
