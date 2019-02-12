package com.example.u12.futbolactivo.presenters;

import android.util.Log;

import com.example.u12.futbolactivo.modelos.Equipos;
import com.example.u12.futbolactivo.modelos.Fechaspadre;
import com.example.u12.futbolactivo.services.Repository;
import com.example.u12.futbolactivo.views.interfeces.IEquiposView;
import com.example.u12.futbolactivo.views.interfeces.IFechasEquipos;

import java.io.IOException;

public class FechasPresenter extends BasePresenter<IFechasEquipos> {

    private Repository repository;
    private Equipos equipos;

    public void fechaspartidos(String equipos) {

        repository = new Repository();
        createThereadGetFechas(equipos);
    }

    private void createThereadGetFechas(final String equipos) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getFechas(equipos);
            }
        });
        thread.start();
    }

    private void getFechas(String equipos) {
        try {
            Fechaspadre fechaE = repository.getFEquipos(equipos);
            getView().ListFechas(fechaE);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
