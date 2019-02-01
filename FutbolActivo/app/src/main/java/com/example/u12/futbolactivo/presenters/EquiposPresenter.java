package com.example.u12.futbolactivo.presenters;

import android.widget.Toast;

import com.example.u12.futbolactivo.modelos.ContenedorEquipos;
import com.example.u12.futbolactivo.modelos.Equipos;
import com.example.u12.futbolactivo.services.Repository;
import com.example.u12.futbolactivo.views.interfeces.IEquiposView;

import java.io.IOException;
import java.util.ArrayList;

public class EquiposPresenter extends BasePresenter<IEquiposView> {
    private Repository repository;



    public void getLeague() {

        repository = new Repository();

        createThereadGetProduct();


    }

    private void createThereadGetProduct() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getEquipos();
            }
        });
        thread.start();

    }

    private void getEquipos() {

        try {
            ContenedorEquipos equipos = repository.getEquipos();
            // ya regreso
            getView().showLeague(equipos);


        } catch ( IOException e) {
e.getMessage();

        }

    }

}
