package com.example.u12.futbolactivo.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Equipos implements Serializable {


    @SerializedName("strWebsite")
    @Expose
    private String website;


    @SerializedName("strFacebook")
    @Expose
    private String facebook;

    @SerializedName("strInstagram")
    @Expose
    private String instagram;

    @SerializedName("idTeam")
    @Expose
    private String idEquipo;

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

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

    @SerializedName("strDescriptionES")
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


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
