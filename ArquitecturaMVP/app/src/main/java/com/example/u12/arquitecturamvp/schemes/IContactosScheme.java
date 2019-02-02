package com.example.u12.arquitecturamvp.schemes;

public interface IContactosScheme {

    // nombre  tabla
    String CONTACTOS_TABLE="contactos";

    //columnas de la  tabla
    String COLUMN_ID="id";
    String COLUMN_NAME="name";
    String COLUMN_PHONE="phone";
    String COLUMN_COMPANY="company";


    //sentencia para  crear  tabla
    String CONTACTOS_TABLE_CREATE= " CREATE TABLE IF NOT EXISTS " + CONTACTOS_TABLE + " ( " +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            COLUMN_NAME + " TEXT NOT NULL, " +
            COLUMN_PHONE + " TEXT, " +
            COLUMN_COMPANY + " TEXT " + " ); ";




    // ARREGLO CON ESOS CAMPOS PARA SIMPLIFICAR  LAS  CONSULTAS

    String [] CONTACTOS_COLUMNS= new String[]{
            COLUMN_ID,COLUMN_NAME,COLUMN_PHONE,COLUMN_COMPANY

    };


}


