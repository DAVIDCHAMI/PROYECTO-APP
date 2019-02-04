package com.example.u12.arquitecturamvp.providers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.u12.arquitecturamvp.helps.Constantes;

public  abstract  class DbContenProvider {

    public SQLiteDatabase mDb;

    public DbContenProvider (SQLiteDatabase mDb){
        this.mDb=mDb;
    }



    protected  abstract <T> T cursorToEntity(Cursor cursor);

    //operaciones en base de datos
    //delete
    public int delete(String tableName, String selection, String [] selectionArgs){

        return  mDb.delete(tableName, selection, selectionArgs);
    }

    //inser a  una  tabla
    public long insert(String tableName, ContentValues values){

        return  mDb.insert(tableName, null, values);
    }

    //sobre  carga de  metodo  query
    public Cursor query(String tableName, String[] columnas, String selection, String [] selectionArgs, String sortOrder){

        return  mDb.query(tableName, columnas, selection, selectionArgs, null, null, sortOrder );
    }


    // sobre  carga d e metodo  con  limite
    public Cursor query(String tableName, String[] columnas, String selection, String [] selectionArgs, String sortOrder, String limit){

        return  mDb.query(tableName, columnas, selection, selectionArgs, null, null, sortOrder , limit);
    }


    // sobre  carga  con  limit, groupby, having
    public Cursor query(String tableName, String[] columnas, String selection, String [] selectionArgs, String groupBy, String having, String sortOrder, String limit){

        return  mDb.query(tableName, columnas, selection, selectionArgs, groupBy, having, sortOrder , limit);
    }

    // update
    public int update(String tableName, ContentValues values, String selection, String [] selectionArgs){
        return  mDb.update(tableName,values, selection, selectionArgs);
    }


}
