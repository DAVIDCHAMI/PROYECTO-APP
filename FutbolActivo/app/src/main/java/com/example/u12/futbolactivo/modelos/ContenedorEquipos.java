package com.example.u12.futbolactivo.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ContenedorEquipos implements Serializable {

    @SerializedName("teams")
    @Expose
    private ArrayList<Equipos> teams;

    public ArrayList<Equipos> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Equipos> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "ContenedorEquipos{" +
                "teams=" + teams +
                '}';
    }
}
