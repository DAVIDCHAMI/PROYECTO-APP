package com.example.u12.mapas.services;


import com.example.u12.mapas.model.Cinema;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IServices {

    @GET("cinemas")
    Call<ArrayList<Cinema>> getCinesP();


    /*
    @GET("cinemas")
    Call <ArrayList<Cines>> getCinesPeliculas();

*/

}
