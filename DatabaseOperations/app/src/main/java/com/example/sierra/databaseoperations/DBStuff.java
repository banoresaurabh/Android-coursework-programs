package com.example.sierra.databaseoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sierra on 20/4/17.
 */
public class DBStuff extends SQLiteOpenHelper {
    public static final String DB_NAME = "saurabh";
    public static final String TABLE_NAME = "stud";
    public static final String COL_ROLL = "roll";
    public static final String COL_FNAME = "fname";
    public static final String COL_LNAME = "lname";



    public DBStuff(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (roll INTEGER PRIMARY KEY, fname TEXT, lname TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insert(int roll, String fname, String lname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ROLL,roll);
        values.put(COL_FNAME,fname);
        values.put(COL_LNAME,lname);
        if(db.insert(TABLE_NAME,null,values) == -1) return false;
        return true;
    }

    public Cursor select(int roll){
        String rs = Integer.toString(roll);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+TABLE_NAME+" where roll = "+roll,null);
        return res;
    }

    public void update(int roll,String fname,String lname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ROLL,roll);
        values.put(COL_FNAME,fname);
        values.put(COL_LNAME,lname);

        db.update(TABLE_NAME,values,COL_ROLL+" = ?",new String[] {String.valueOf(roll) });
    }

    public boolean delete(int roll){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,COL_ROLL +" = " + roll,null) > 0;
    }
}
