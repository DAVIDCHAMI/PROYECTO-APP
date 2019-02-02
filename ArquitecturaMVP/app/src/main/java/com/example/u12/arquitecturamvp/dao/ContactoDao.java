package com.example.u12.arquitecturamvp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.u12.arquitecturamvp.models.Contacto;
import com.example.u12.arquitecturamvp.providers.DbContenProvider;
import com.example.u12.arquitecturamvp.schemes.IContactosScheme;

import java.util.ArrayList;

public class ContactoDao extends DbContenProvider implements IContactosScheme, IContactoDao {


    private Cursor cursor;
    private ContentValues values;
    private final static  String TAG="ContactoDao";

    public ContactoDao(SQLiteDatabase db) {
        super(db);
    }

    // cambiamos  plantilla por  contacto
    @Override
    protected Contacto cursorToEntity(Cursor cursor) {
        Contacto contacto =  new Contacto();

        if(cursor.getColumnIndex(COLUMN_ID) != -1){
            int idIndex = cursor.getColumnIndexOrThrow(COLUMN_ID);
            contacto.setId(cursor.getInt(idIndex));
        }

        if(cursor.getColumnIndex(COLUMN_NAME) != -1){
          int idIndex = cursor.getColumnIndexOrThrow(COLUMN_NAME);
            contacto.setName(cursor.getString(idIndex));
        }

        if(cursor.getColumnIndex(COLUMN_PHONE) != -1){
            int idIndex = cursor.getColumnIndexOrThrow(COLUMN_PHONE);
            contacto.setPhone(cursor.getString(idIndex));
        }

        if(cursor.getColumnIndex(COLUMN_COMPANY) != -1){
            int idIndex = cursor.getColumnIndexOrThrow(COLUMN_COMPANY);
            contacto.setCompany(cursor.getString(idIndex));
        }

        return contacto;
    }

    // consulta de  contactos
    @Override
    public ArrayList<Contacto> fetchAllContactos() {
        ArrayList<Contacto> contactosList= new ArrayList<>();

        //realizar  consulta
        cursor = query(CONTACTOS_TABLE, CONTACTOS_COLUMNS, null, null ,COLUMN_NAME);

        if(cursor != null){
            cursor .moveToFirst();
            /// recorrer posicónes del cursor
            while(!cursor.isAfterLast()){
                Contacto contacto= cursorToEntity(cursor);
                contactosList.add(contacto);
                cursor.moveToNext();
            }
        }
        return contactosList;
    }


// crear contacto
    @Override
    public Boolean createContacto(Contacto contacto) {
        // se  tiene el set d e los  valores
        setContentValueContacto(contacto);
        try {
            // valida  se devuelve  mayor  a cero inserto  bien si no inserto  mal
            return insert(CONTACTOS_TABLE, getContentValues()) >= 0 ;


        }catch (SQLiteException ex){
            Log.e(TAG, ex.getMessage());
            return  false;

        }


    }

    private ContentValues getContentValues() {
        return values;
    }

    private void setContentValueContacto(Contacto contacto) {

        values= new ContentValues();
        //mapear  atributos
        //values.put(COLUMN_ID, contacto.getId());
        values.put(COLUMN_NAME, contacto.getName());
        values.put(COLUMN_PHONE, contacto.getPhone());
        values.put(COLUMN_COMPANY, contacto.getCompany());

    }
}
