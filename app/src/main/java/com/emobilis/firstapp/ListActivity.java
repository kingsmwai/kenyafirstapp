package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
   //declare the views
    ListView listView;
    //array of items to be populated to list
    String[] phones = {"Nokia","Motorola","Samsung","Techo","iPhone"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listPhones);

        //ref to ArrayAdapter class
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_item,phones);

        //set the listview to work with this adapter
        listView.setAdapter(arrayAdapter);

    }
}
