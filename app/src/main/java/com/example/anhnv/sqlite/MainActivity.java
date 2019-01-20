package com.example.anhnv.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDataBaseHelper dbHelper = new MyDataBaseHelper(this);

        Student std = new Student(1,"Nguyen Van A", "Ha Noi");
        dbHelper.insertStudent(std);
        dbHelper.insertStudent(std);

        Student student = dbHelper.getStudent(1);

        System.out.println("id: " + student.getId());
        System.out.println("name: " + student.getName());
        System.out.println("address: " + student.getAddress());


    }
}
