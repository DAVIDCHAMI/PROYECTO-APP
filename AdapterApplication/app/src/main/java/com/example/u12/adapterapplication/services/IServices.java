package com.example.u12.adapterapplication.services;

import com.example.u12.adapterapplication.models.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IServices {

    @GET("products")
    Call <ArrayList<Product>> getProducts();


     @POST("products")
    Call<Product> saveProduct(@Body Product product);
}
