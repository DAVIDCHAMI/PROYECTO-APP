package com.example.u12.futbolactivo.views.interfeces;

import com.example.u12.futbolactivo.modelos.Equipos;
import com.example.u12.futbolactivo.views.IBaseView;

import java.util.ArrayList;

public interface IEquiposView extends IBaseView {
    void showLeague(ArrayList<Equipos> equipos);
}
