package com.example.u12.adapterapplication.repositorys;



import com.example.u12.adapterapplication.services.IServices;
import com.example.u12.adapterapplication.services.ServicesFactory;
import com.example.u12.adapterapplication.models.Product;

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
}
