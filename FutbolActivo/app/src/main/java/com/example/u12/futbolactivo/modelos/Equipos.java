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


    @SerializedName("strTeamBadge")
    @Expose
    private String escudoEquipo;

    @SerializedName("intFormedYear")
    @Expose
    private String año;

    @SerializedName("strStadiumDescription")
    @Expose
    private String description;

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getCamisaEquipo() {
        return camisaEquipo;
    }

    public void setCamisaEquipo(String camisaEquipo) {
        this.camisaEquipo = camisaEquipo;
    }

    public String getEscudoEquipo() {
        return escudoEquipo;
    }

    public void setEscudoEquipo(String escudoEquipo) {
        this.escudoEquipo = escudoEquipo;
    }
}
