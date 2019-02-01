package com.example.u12.futbolactivo.services;



import com.example.u12.futbolactivo.modelos.ContenedorEquipos;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;


public class Repository {

    private IServices iServices;

    public Repository() {
        ServicesFactory servicesFactory =  new ServicesFactory();

        iServices= (IServices) servicesFactory.getInstanceServices(IServices.class);
    }

    public ContenedorEquipos getEquipos() throws IOException{


        try {

            Call<ContenedorEquipos> call = iServices.getEquipos("4335");
            Response<ContenedorEquipos> response =call.execute();
            if(response.errorBody() != null){
                throw defultError();
            }else {
                return response.body();
            }
        }catch (IOException e){
            throw  defultError();
        }
    }

    private IOException defultError() {
        return  new IOException("ha ocurrido un error");

    }
}
