package com.example.u12.mydetailproduct.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicesFactory {

private static  final String API_BASE_PAHT="https://shoppingproducts.herokuapp.com/";
private Retrofit retrofit;


    public ServicesFactory() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

        retrofit= new Retrofit.Builder().baseUrl(API_BASE_PAHT).client(okHttpClient).addConverterFactory(getGsonConverter()).build();
    }

    private Converter.Factory getGsonConverter(){
        Gson gson= new GsonBuilder().setDateFormat("yyy-MM-dd").create();
        return GsonConverterFactory.create(gson);
    }


    public Object getInstanceServices(Class service){
        return  retrofit.create(service);
    }
}
