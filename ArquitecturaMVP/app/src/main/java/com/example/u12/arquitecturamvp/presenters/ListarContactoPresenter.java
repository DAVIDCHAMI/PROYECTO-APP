package com.example.u12.arquitecturamvp.presenters;

import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.u12.arquitecturamvp.helps.Database;
import com.example.u12.arquitecturamvp.models.Contacto;
import com.example.u12.arquitecturamvp.views.interfeces.IListarContactos;

import java.util.ArrayList;


public class ListarContactoPresenter extends  BasePresenter<IListarContactos>{
     private Contacto contacto;

    public void  mostrarContactos() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                getContactsThreadList();
            }
        });
        t.start();
   }


    public void getContactsThreadList(){

              getView().showContacts( getContactsFromDb());


    }

    private ArrayList<Contacto>  getContactsFromDb(){
        try {
            ArrayList<Contacto> contactsList= Database.contactoDao.fetchAllContactos();
            // TODO
            for ( Contacto dto: contactsList) {
                Log.i("contacto name: ", dto.getName());
            }
            return contactsList;

        }catch (SQLiteException e){

            return new ArrayList<>();

        }

    }

}
