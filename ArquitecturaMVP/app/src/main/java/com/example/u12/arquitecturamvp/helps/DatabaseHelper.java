package com.example.u12.arquitecturamvp.helps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.u12.arquitecturamvp.schemes.IContactosScheme;

public class DatabaseHelper extends SQLiteOpenHelper {

    //constructor
    public DatabaseHelper(Context context){
        super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //crea tablas desde  la  interfaz
        db.execSQL(IContactosScheme.CONTACTOS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //modificar la creación de  tabla "consultas para  modificar bd o esquema bd"
        db.execSQL(" DROP TABLE IF EXISTS " + IContactosScheme.CONTACTOS_TABLE);

    }






}
