package com.example.u12.futbolactivo.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Fechaspadre implements Serializable {
    @SerializedName("events")
    @Expose
    private ArrayList<FechasEquipo> evento;

    public ArrayList<FechasEquipo> getEvento() {

        return evento;
    }

    public void setEvento(ArrayList<FechasEquipo> evento) {
        this.evento = evento;
    }


}
