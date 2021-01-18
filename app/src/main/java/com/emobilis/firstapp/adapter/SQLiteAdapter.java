package com.emobilis.firstapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emobilis.firstapp.GroceryContract;
import com.emobilis.firstapp.R;

public class SQLiteAdapter extends RecyclerView.Adapter<SQLiteAdapter.SQLiteViewHolder> {

    Context mContext;
    Cursor cursor;


    //constructor
    public SQLiteAdapter(Context context,Cursor cursor){
        this.mContext = context;
        this.cursor = cursor;
    }

    //view holder
    public class SQLiteViewHolder extends RecyclerView.ViewHolder{
        //declare the view inside the recycled item
        TextView name , amount ;

        public SQLiteViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.textview_amount_item);
            name = itemView.findViewById(R.id.textview_name_item);
        }
    }
    @NonNull
    @Override
    public SQLiteAdapter.SQLiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.grocery_item, parent, false);
        return new SQLiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SQLiteAdapter.SQLiteViewHolder holder, int position) {
        //check for changes in Cursor
        if (!cursor.moveToPosition(position)){
            return;
        }

        //bind the data from sqlite db table to the recycled item view
        //store data in variables
        String name = cursor.getString(cursor.getColumnIndex(GroceryContract.GroceryContractEntry.COLUMN_NAME));
        int amount  = cursor.getInt(cursor.getColumnIndex(GroceryContract.GroceryContractEntry.COLUMN_AMOUNT));

        //set data to views
        holder.name.setText(name);
        holder.amount.setText(String.valueOf(amount));

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    //swap cursor
    //is to show the data change on an event
    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        if (newCursor != null) {
            //method notifies the recyclerview of a change in data
            notifyDataSetChanged();
        }
    }
}
