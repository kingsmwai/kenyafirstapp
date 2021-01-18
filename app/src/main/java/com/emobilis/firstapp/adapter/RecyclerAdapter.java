package com.emobilis.firstapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.emobilis.firstapp.CardDescription;
import com.emobilis.firstapp.R;
import com.emobilis.firstapp.model.RecycerModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    //declare arraylist
    private ArrayList<RecycerModel> recycerModels;
    Context context;

    //creating the RecycerViewHolder subclass
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView imageView;
        RelativeLayout relativeLayout;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
            relativeLayout = itemView.findViewById(R.id.relaRecycler);
        }
    }

    //constructor
    public RecyclerAdapter(Context context,ArrayList<RecycerModel> recycerModelArrayList){
        this.recycerModels = recycerModelArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycled_item, parent, false);
        RecyclerViewHolder evh = new RecyclerViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, final int position) {
        //create the position ref
        final RecycerModel recycerModel =  recycerModels.get(position);
        //bind
        holder.text.setText(recycerModel.getText());
//        holder.imageView.setImageResource(recycerModel.getImage());
        Glide.with(context)
                .load(recycerModel.getImage())
                .into(holder.imageView);

        //here set on click listener
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CardDescription.class);
                intent.putExtra("text",recycerModels.get(position).getText());
                intent.putExtra("image",recycerModels.get(position).getImage());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return recycerModels.size();
    }
}
