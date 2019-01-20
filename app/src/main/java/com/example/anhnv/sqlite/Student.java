package com.example.anhnv.sqlite;

public class Student {

    public static final String TABLE_NAME = "student";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";

    public static final String CREATE_TABLE = "CREATE TABLE "
                + TABLE_NAME
                + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_ADDRESS + " TEXT"
                + ")";

    private int id;
    private String name;
    private String address;

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
