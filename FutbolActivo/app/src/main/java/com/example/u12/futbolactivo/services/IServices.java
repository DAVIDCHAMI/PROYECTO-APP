package com.example.u12.futbolactivo.services;


import com.example.u12.futbolactivo.modelos.ContenedorEquipos;
import com.example.u12.futbolactivo.modelos.FechasEquipo;
import com.example.u12.futbolactivo.modelos.Fechaspadre;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface IServices {

    @GET("lookup_all_teams.php")
    Call<ContenedorEquipos> getEquipos(@Query("id") String id);


    @GET("eventsnext.php/{id}")
    Call<Fechaspadre> getfeEquipos(@Query("id")String idEquipo);
}
