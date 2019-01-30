package com.example.u12.futbolactivo.services;


import com.example.u12.futbolactivo.modelos.Equipos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface IServices {

    @GET("lookup_all_teams.php{id}")
    Call<ArrayList<Equipos>> getEquipos(@Query("id") String id);


}
