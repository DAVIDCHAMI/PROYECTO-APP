package com.example.u12.mydetailproduct.services;

import com.example.u12.mydetailproduct.models.DeleteResponse;
import com.example.u12.mydetailproduct.models.Product;
import com.example.u12.mydetailproduct.models.Users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IServices {


//////////////login

    @GET("user/auth")
    Call<Users> logIn(@Query("email") String user, @Query("password") String password);

    //////// metodos de detail /////////////////////////////
    @GET("products")
    Call <ArrayList<Product>> getProducts();

//metodo de product
     @POST("products")
    Call<Product> saveProduct(@Body Product product);

    @DELETE("products/{id}")
    Call<DeleteResponse> deleteProduct(@Path("id") String id);


    ////metodo  uque  realiza la consulta para el  auto  login
    @GET("user")
    Call<Users> loginWithToke(@Header("Authorization") String token);
}
