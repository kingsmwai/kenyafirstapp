package com.emobilis.firstapp.adapter;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.emobilis.firstapp.R;

public class MyListAdapter extends ArrayAdapter<String> {

    //declare
    private final Activity context;
    private final String[] mainTitle;
    private final String[] subTitle;
    private final Integer[] img;

    public MyListAdapter(Activity context,String[] mainTitle,String[] subTitle,Integer[]img){
        super(context, R.layout.cust_list_item,mainTitle);

        //match the data
        this.context = context;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.img = img;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.cust_list_item,null,true);

        //view identification
        TextView textview = rowview.findViewById(R.id.title);
        TextView subText = rowview.findViewById(R.id.subTitle);
        ImageView imageView = rowview.findViewById(R.id.icon);

        //set the data to be displayed
        textview.setText(mainTitle[position]);
        imageView.setImageResource(img[position]);
        subText.setText(subTitle[position]);

        return rowview;
    }
}
