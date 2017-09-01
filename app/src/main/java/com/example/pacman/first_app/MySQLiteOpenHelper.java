package com.example.pacman.first_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 123 on 8/31/2017.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    public final static String DATABASE_NAME="Mydatabase";
    public static final int VERSION_NO=1;
    public static final String  QUERY_STRING="CREATE TABLE user(pname varchar,pno varchar)";
    //public static final String TABLE_NAME="USER";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(QUERY_STRING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertRow(String name,String number)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("pname",name);
        contentValues.put("pno",number);
        SQLiteDatabase database=getWritableDatabase();
        long n=database.insert("user",null,contentValues);


        return n>0;

    }
    public ArrayList<person> fetchlist()
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM USER",null);
        ArrayList<person> plist=new ArrayList<person>();
        while (cursor.moveToNext())
        {
            plist.add(new person(R.drawable.android,cursor.getString(cursor.getColumnIndex("pname")),cursor.getString(cursor.getColumnIndex("pno"))));

        }
        return plist;
    }


}

