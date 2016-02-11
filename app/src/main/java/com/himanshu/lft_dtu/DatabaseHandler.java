package com.himanshu.lft_dtu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Himanshu on 1/31/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_PRODUCTS = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "studentname";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMWENT " + COLUMN_NAME + " TEXT " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }


    public void add_student(Student student){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }


    public void delete_student(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_NAME + "=\"" + name +"\";");
    }


    public String DataToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM" + TABLE_PRODUCTS +" WHERE 1";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex("studentname"))!=null){
                dbString += cursor.getString(cursor.getColumnIndex("studentname"));
                dbString+="\n";
            }
        }

        db.close();
        return dbString;
    }

}
