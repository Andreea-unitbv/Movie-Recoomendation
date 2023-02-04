package com.example.demo.database;

public class DB {
    private static DBConnection db=new DBConnection();

    public static DBConnection getDb(){
        return db;
    }

}
