package com.emobilis.firstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GrocerySchema extends SQLiteOpenHelper {

    //declare the database name and version
    public static final String DATABASE_NAME = "grocerylist.db";
    public static final int DATABASE_VERSION = 1;

    //constructor
    public GrocerySchema(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //here in the onCreate we create  the tables to the SQLite DB
    @Override
    public void onCreate(SQLiteDatabase db) {
        //varable to hold SQLite statements
        final String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
                GroceryContract.GroceryContractEntry.TABLE_NAME + " (" +
                GroceryContract.GroceryContractEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GroceryContract.GroceryContractEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                GroceryContract.GroceryContractEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                GroceryContract.GroceryContractEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        //execute the SQL command
        db.execSQL(SQL_CREATE_GROCERYLIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if table exists drop / delete table if instructed
        db.execSQL("DROP TABLE IF EXISTS " + GroceryContract.GroceryContractEntry.TABLE_NAME);
        //re run onCreate
        onCreate(db);

    }
}
