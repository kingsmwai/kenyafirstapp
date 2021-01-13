package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaring my views
    Button btnClick;
    TextView txtName;
    EditText userInput;
    //declare a variable to store info to be shared
    String name,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identify views based off ids in xml
        btnClick = findViewById(R.id.btnClick);
        txtName = findViewById(R.id.myName);
        userInput = findViewById(R.id.userInput);

        //set on click listener to button
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });



    }

    //creating method to transistion from one screen to another
    private void goToSecondActivity(){
        //capturing text
        //capturing text from textview
        name = txtName.getText().toString().trim();
        //from edittext
        message = userInput.getText().toString().trim();
        //to transition
        Intent intentSecond = new Intent(MainActivity.this,SecondActivity.class);
        intentSecond.putExtra("name_from_text",name);
        intentSecond.putExtra("message_from_user",message);
        //use the startActivity method to launch our intent
        startActivity(intentSecond);
    }
}
