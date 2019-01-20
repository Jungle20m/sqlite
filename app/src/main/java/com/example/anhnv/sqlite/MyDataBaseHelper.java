package com.example.anhnv.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "school";
    private static final int DATABASE_VERSION = 1;

    public MyDataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table
        db.execSQL(Student.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);

        onCreate(db);
    }

    public void insertStudent(Student std) {
        SQLiteDatabase db = this.getWritableDatabase();

        // using for stored data
        ContentValues values = new ContentValues();
        values.put(Student.KEY_NAME, std.getName());
        values.put(Student.KEY_ADDRESS, std.getAddress());

        // inserting data to table
        db.insert(Student.TABLE_NAME, null, values);
        db.close();
    }

    public Student getStudent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        // cursor such as pointer for access data
        Cursor cursor = db.query(Student.TABLE_NAME,
                 new String[]{Student.KEY_ID,Student.KEY_NAME,Student.KEY_ADDRESS},
                Student.KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Student std = new Student(
                cursor.getInt(cursor.getColumnIndex(Student.KEY_ID)),
                cursor.getString(cursor.getColumnIndex(Student.KEY_NAME)),
                cursor.getString(cursor.getColumnIndex(Student.KEY_ADDRESS)));

        db.close();

        return std;
    }
}
