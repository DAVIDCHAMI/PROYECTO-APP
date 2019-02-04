package com.example.u12.arquitecturamvp.helps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.u12.arquitecturamvp.dao.ContactoDao;

import java.sql.SQLException;

public class Database {

    private final Context context;
    private  DatabaseHelper dbHelper;

// DAOS QUE  NECESITA  MI APLICATION

    public static ContactoDao contactoDao;


    public Database(Context context) {
        this.context = context;
    }


    public Database open() {
        try {
            // abrir base de  datos
            dbHelper = new DatabaseHelper(context);
            SQLiteDatabase sdb= dbHelper.getWritableDatabase();

            contactoDao = new ContactoDao(sdb);

            return this;

        }catch (SQLiteException ex){
            throw ex;
        }
    }


    public void close(){
        dbHelper.close();
    }
}
