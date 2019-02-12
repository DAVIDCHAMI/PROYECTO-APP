package com.example.u12.futbolactivo.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class FechasEquipo  implements Serializable {

    public String getFecEquipos() {
        return fecEquipos;
    }

    public void setFecEquipos(String fecEquipos)
    {
        this.fecEquipos = fecEquipos;
    }

    @SerializedName("strFilename")
    @Expose
    private String fecEquipos;

}
