package com.example.u12.futbolactivo.services;


import com.example.u12.futbolactivo.modelos.ContenedorEquipos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface IServices {

    @GET("lookup_all_teams.php")
    Call<ContenedorEquipos> getEquipos(@Query("id") String id);


}
