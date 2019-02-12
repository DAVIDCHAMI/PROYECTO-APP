package com.example.u12.adapterapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FechasEquipo {
    public String getFecEquipos() {
        return fecEquipos;
    }

    public void setFecEquipos(String fecEquipos) {
        this.fecEquipos = fecEquipos;
    }

    @SerializedName("strFilename")
    @Expose
    private String fecEquipos;

}
