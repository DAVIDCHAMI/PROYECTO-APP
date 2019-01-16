package com.example.u12.mydetailproduct.helps;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ValidarInternet {

    public ValidarInternet(Context context){
        this.context=context;
    }

    private Context context;

    public Boolean isConnected(){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //dar permisos de internet en el manager
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return  networkInfo !=null && networkInfo.isConnected();

    }
}
