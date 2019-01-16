package com.example.u12.adapterapplication.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.u12.adapterapplication.actividades.CreateProductActivity;
import com.example.u12.adapterapplication.helper.ValidarInternet;
import com.example.u12.adapterapplication.models.Product;
import com.example.u12.adapterapplication.R;
import com.example.u12.adapterapplication.repositorys.Repository;
import com.example.u12.adapterapplication.adapters.AdapterProducts;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.u12.adapterapplication.R.id.btnbotons;


/**
 * A simple {@link Fragment} subclass.
 */
public class OFragment extends Fragment {
private RecyclerView recyclerView;
private Repository repository;
private Button buttonCreateProduc;

    public OFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        repository = new Repository();
        View view = inflater.inflate(R.layout.fragment_o, container, false);
        recyclerView= view.findViewById(R.id.reciclerView_fragment_o);
        buttonCreateProduc = view.findViewById(R.id.btnbotons);
        buttonCreateProduc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(getActivity(),CreateProductActivity.class);
        startActivity(intent);
    }
});


        createThereadGetProduct();
        return view;
}

private void validateInternet(){
    ValidarInternet validarInternet = new ValidarInternet(getContext());
    if(validarInternet.isConnected()){
        createThereadGetProduct();
    }else {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle(R.string.title_validate_internet);
        alertDialog.setMessage(R.string.message_validate_internet);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton(R.string.text_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                validateInternet();
                dialog.dismiss();

            }
        });
    }
}

    private void getProducts() {
        
        try {
            ArrayList<Product> products=repository.getProducts();
            loadAdapter(products);
        }catch (final IOException e){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            
        }
    }


    private void loadAdapter(final ArrayList<Product> products){


        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AdapterProducts adapterProducts = new AdapterProducts(products);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterProducts);
            }
        });

    }

    private void createThereadGetProduct(){

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                getProducts();
            }
        });
        thread.start();

    }

    @Override
    public void onResume() {
        super.onResume();
        validateInternet();
    }
}
