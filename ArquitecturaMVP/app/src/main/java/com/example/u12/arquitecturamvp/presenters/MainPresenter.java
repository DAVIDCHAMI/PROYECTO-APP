package com.example.u12.arquitecturamvp.presenters;

import android.database.sqlite.SQLiteException;
import android.support.annotation.UiThread;
import android.text.Editable;
import android.util.Log;

import com.example.u12.arquitecturamvp.helps.Database;
import com.example.u12.arquitecturamvp.models.Contacto;
import com.example.u12.arquitecturamvp.views.interfeces.IMainView;

import java.util.ArrayList;

public class MainPresenter  extends  BasePresenter<IMainView>{

    //opción 1
    public int sumCalculte(int one, int two) {
        return one + two;
    }


    //opción 2 asincronico
    public void Calculte(int on, int tw) {
        getView().showResult(on+tw);

    }

    //opción 3
    public void Calculte2(String nombre, String telefono, String compañia) {
        createContactos(nombre,telefono,compañia);
        //getView().showToas(n1+n2);

    }


    private void createContactos(String nombre, String telefono, String compañia){
        Contacto contacto= new Contacto(0, nombre, telefono, compañia);


        createThreadContacto(contacto);
    }

    //hilo
  private void  createThreadContacto(final Contacto contacto){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                createContactoLocalDb(contacto);
            }
        });
        thread.start();
  }
///  quema los  datos
    private void createContactoLocalDb(Contacto contacto) {
        boolean isSaved =false;

        try {
             isSaved = Database.contactoDao.createContacto(contacto);
            getView().showMessageLocalContact(isSaved);

        }catch (Exception e){
            getView().showMessageLocalContact(isSaved);

        }
    }


    public void showContactList() {
        this.getContactsThreadList();

    }

    public void getContactsThreadList(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                getContactsFromDb();
            }
        });
        t.start();
    }

    private void  getContactsFromDb(){
        try {
            ArrayList<Contacto> contactsList= Database.contactoDao.fetchAllContactos();
            // TODO
            for ( Contacto dto: contactsList) {
                Log.i("contacto name: ", dto.getName());

            }
        }catch (SQLiteException e){

        }

    }


}
