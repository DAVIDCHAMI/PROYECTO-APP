package com.example.u12.mapas.repositorys;



import com.example.u12.mapas.model.Cinema;
import com.example.u12.mapas.services.IServices;
import com.example.u12.mapas.services.ServicesFactory;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class Repository {

    private IServices iServices;

    public Repository() {
        ServicesFactory servicesFactory =  new ServicesFactory();

        iServices= (IServices) servicesFactory.getInstanceServices(IServices.class);
    }

    public ArrayList<Cinema> getCinesPeliculas() throws IOException{

        try {

            Call<ArrayList<Cinema>> call = iServices.getCinesP();
            Response<ArrayList<Cinema>> response =call.execute();
            if(response.errorBody() != null){
                throw defultError();
            }else {
                return response.body();
            }
        }catch (IOException e){
            throw  defultError();
        }

    }

    private IOException defultError()
    {
        return  new IOException("ha ocurrido un error");
    }


}
