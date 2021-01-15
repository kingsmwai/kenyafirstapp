package com.emobilis.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.emobilis.firstapp.adapter.RecyclerAdapter;
import com.emobilis.firstapp.model.RecycerModel;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    //declare an array list
    ArrayList<RecycerModel> recycerModels;
    //recyclerview
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        createList();
        buildRecyclerView();
    }

    private void createList(){

        //add data to my recyclerview
        recycerModels = new ArrayList<>();
        recycerModels.add(new RecycerModel(R.drawable.ic_forward_10_black_24dp,"Product one"));
        recycerModels.add(new RecycerModel(R.drawable.ic_format_bold_black_24dp,"Product two"));
        recycerModels.add(new RecycerModel(R.drawable.ic_mic_none_black_24dp,"Product three"));
        recycerModels.add(new RecycerModel(R.drawable.ic_multiline_chart_black_24dp,"Product four"));
        recycerModels.add(new RecycerModel(R.drawable.ic_my_location_black_24dp,"Product five"));
    }

    private void buildRecyclerView() {
        //view identification
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this); //linear vertical orientation
        //populate adapter
        mAdapter = new RecyclerAdapter(recycerModels);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}