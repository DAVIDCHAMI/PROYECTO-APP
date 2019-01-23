package com.example.u12.mydetailproduct.services;


import com.example.u12.mydetailproduct.models.DeleteResponse;
import com.example.u12.mydetailproduct.models.Product;
import com.example.u12.mydetailproduct.models.Users;

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

   ///////////////////////////////////////parte Login///////////////////////////////////////7




    public Users logIn(String user, String password) throws IOException {
        try {

            Call<Users> call = iServices.logIn(user, password);
            Response<Users> response =call.execute();
            if(response.errorBody() != null){
                throw defultError();
            }else {
                return response.body();
            }
        }catch (IOException e){
            throw  defultError();
        }


    }








    ///////// parte del  detail
    public ArrayList<Product> getProducts() throws IOException{

        try {

            Call<ArrayList<Product>> call = iServices.getProducts();
            Response<ArrayList<Product>> response =call.execute();
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

    // metodo  para consumir servico de guardar producto
    public Product saveProducts(Product product)  throws  IOException{

        try {
            Call<Product> call = iServices.saveProduct(product);
            Response<Product> response =call.execute();
            if(response.errorBody()  != null){
                throw  defultError();
            }else {
                return  response.body();
            }
        }catch (IOException e){
            throw  defultError();
        }




    }

// metodo para consumir  servicio d e eliminar
    public Boolean deleteProduct(String id)  throws  IOException{
        Call<DeleteResponse> call =iServices.deleteProduct(id);
      try {
          Response<DeleteResponse> response =call.execute();
          if(response.errorBody()  != null){
              throw  defultError();
          }else {
              return  response.body().isStatus();
          }
      }catch (IOException e){
          throw  defultError();
        }



    }


    // metodo  para  realizar auto login
    public Users loginWithToke(String token) throws  IOException{

        try {
            String bearerToken ="bearer:"+token;
            Call<Users> call =iServices.loginWithToke(bearerToken);
            Response<Users> response =call.execute();
            if(response.errorBody()  != null){
                throw  defultError();
            }else {
                return  response.body();
            }
        }catch (IOException e){
            throw  defultError();
        }

    }


    /////////////////////////////////////////////////////////////////////////////////
}
