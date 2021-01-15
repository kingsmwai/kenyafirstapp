package com.emobilis.firstapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emobilis.firstapp.R;
import com.emobilis.firstapp.model.RecycerModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    //declare arraylist
    private ArrayList<RecycerModel> recycerModels;

    //creating the RecycerViewHolder subclass
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView imageView;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }

    //constructor
    public RecyclerAdapter(ArrayList<RecycerModel> recycerModelArrayList){
        this.recycerModels = recycerModelArrayList;
    }
    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycled_item, parent, false);
        RecyclerViewHolder evh = new RecyclerViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        //create the position ref
        RecycerModel recycerModel =  recycerModels.get(position);
        //bind
        holder.text.setText(recycerModel.getText());
        holder.imageView.setImageResource(recycerModel.getImage());

    }

    @Override
    public int getItemCount() {
        return recycerModels.size();
    }
}
