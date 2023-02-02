package com.example.demo.database;

public class DB {
    private static DBConnection db=new DBConnection();

    static DBConnection getDb(){
        return db;
    }

}
