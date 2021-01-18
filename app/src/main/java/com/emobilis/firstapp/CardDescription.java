package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class CardDescription extends AppCompatActivity {
    String text,image;
    TextView textProduct;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_description);

        textProduct = findViewById(R.id.textProduct);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        text = intent.getStringExtra("text");
        image = intent.getStringExtra("image");
        //to handle image use Bundle
//        Bundle bundle = getIntent().getExtras();
//
//        if(bundle != null){
//            image = bundle.getString("image");
//        } else {
//            Toast.makeText(this, "No Image Found", Toast.LENGTH_SHORT).show();
//        }


        Toast.makeText(this, "Text and image " + text + " " + image, Toast.LENGTH_SHORT).show();

        //set data
        textProduct.setText(text);
        //use glide to set text to imageView
        Glide.with(this)
                .load(image)
                .placeholder(R.drawable.ic_format_bold_black_24dp)
                .into(imageView);
    }
}
