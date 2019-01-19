package com.example.u12.myautenticacion.services;



import java.util.ArrayList;


public interface IServices {

    @GET("products")
    Call <ArrayList<Product>> getProducts();


     @POST("products")
    Call<Product> saveProduct(@Body Product product);

    @DELETE("products/{id}")
    Call<DeleteResponse> deleteProduct(@Path("id") String id);
}
