package com.example.patientapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static String Dbname="PatientApp.db";
    static String Tablename="Patient";
    static String col1="id";
    static String col2="Pcode";
    static String col3="Pname";
    static String col4="Address";
    static String col5="Mobile";
    static String col6="Drname";

    public DbHelper(Context context) {
        super(context, Dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+Tablename+"("+col1+" integer primary key autoincrement," +
                ""+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+" text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query=" drop table if exists "+Tablename;
        onCreate(db);

    }
    public boolean insertPatient(String Pcode,String Pname,String Address,String Mobile,String Drname)
    {
      SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,Pcode);
        content.put(col3,Pname);
        content.put(col4,Address);
        content.put(col5,Mobile);
        content.put(col6,Drname);
        long status=db.insert(Tablename,null,content);
        if (status==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor searchPatient(String pmob)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+Tablename+" where "+col5+"="+"'"+pmob+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }

}
