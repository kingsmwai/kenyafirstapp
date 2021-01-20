package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.emobilis.firstapp.adapter.MyListAdapter;

public class CustomListView extends AppCompatActivity {

    //declare the view
    ListView listView;

    //declare my list items in arrays
    String[] mainTitle = {
           "Mobile Handsets",
           "Furniture",
           "Kitchen Wear",
            "ELectronics",
    };

    //declare subtitles
    String[] subTitle = {
            "All phone brands available",
            "Get the best deals for Beds",
            "Get latest Fridge designs and more",
            "SmartTVS, Watches, Accessories"
    };

    //declare images
    Integer[] img = {
            R.drawable.ic_phone_in_talk_black_24dp,
            R.drawable.ic_email_black_24dp,
            R.drawable.ic_forward_10_black_24dp,
            R.drawable.ic_my_location_black_24dp
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        MyListAdapter adapter = new MyListAdapter(this,mainTitle,subTitle,img);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        //OnItemClickedListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    //do sth
                    Toast.makeText(CustomListView.this, "Mobile Handsets clicked", Toast.LENGTH_SHORT).show();
                } else if (position == 1){
                    Intent intent = new Intent(CustomListView.this,NavigationActivity.class);
                    startActivity(intent);
                } else if (position == 2){
                    callMethod();
                } else if (position == 3){
                    Log.d("CustomListView","item 3 clicked");
                }
            }
        });
    }

    private void callMethod(){
        Toast.makeText(this, "method called", Toast.LENGTH_SHORT).show();
    }
}
