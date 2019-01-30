package com.example.u12.futbolactivo.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Equipos implements Serializable {

    @SerializedName("idTeam")
    @Expose
    private int idEquipo;


    @SerializedName("strTeam")
    @Expose
    private String nombreEquipo;

    @SerializedName("strLeague")
    @Expose
    private String nombreLiga;


    @SerializedName("strTeamJersey")
    @Expose
    private String camisaEquipo;


    @SerializedName("strTeamLogo")
    @Expose
    private String escudoEquipo;




}
