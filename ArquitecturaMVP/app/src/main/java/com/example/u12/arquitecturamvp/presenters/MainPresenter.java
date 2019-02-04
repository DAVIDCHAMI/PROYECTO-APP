package com.example.u12.arquitecturamvp.presenters;

import android.support.annotation.UiThread;
import android.util.Log;

import com.example.u12.arquitecturamvp.helps.Database;
import com.example.u12.arquitecturamvp.models.Contacto;
import com.example.u12.arquitecturamvp.views.interfeces.IMainView;

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
    public void Calculte2(int n1, int n2) {
        createContactos();
        getView().showToas(n1+n2);

    }


    private void createContactos(){
        Contacto contacto= new Contacto(0, "MAQUINA", "123456789", "MATRIX");

        Contacto contacto2 = new Contacto(0, "JOSEFA", "98765432", "MATRIX");






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
        try {
            boolean isSaved = Database.contactoDao.createContacto(contacto);
            int  msg = isSaved ? 1 : 0;
            Log.i("Contacto creado", "" + msg);
           // getView().showToas(1);
           // getView().showToasMessage(msg);
        }catch (Exception e){

        }
    }




}
