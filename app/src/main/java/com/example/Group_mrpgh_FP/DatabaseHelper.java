package com.example.Group_mrpgh_FP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private  static final String TAG = "DatabaseHelper";
    private  static final String TABLE_NAME = "people_table";
    private  static final String COL1 = "ID";
    private  static final String COL2 = "name";
    private  static final String COL3 = "email";
    private  static final String COL4 = "mobile";
    private  static final String COL5 = "imageId";



    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT, "+COL4 + " TEXT, " + COL5 + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(drop);
        onCreate(db);
    }

    public boolean addData(String name, String mail, String phone, int imgID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, mail);
        contentValues.put(COL4, phone);
        contentValues.put(COL5,imgID);
        Log.d(TAG, "addData: Adding " + name+mail+phone + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
