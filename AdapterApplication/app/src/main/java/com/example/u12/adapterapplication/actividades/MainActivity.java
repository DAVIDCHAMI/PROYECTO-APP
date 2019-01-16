package com.example.u12.adapterapplication.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.u12.adapterapplication.models.Product;
import com.example.u12.adapterapplication.R;
import com.example.u12.adapterapplication.adapters.AdapterProducts;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
    private AdapterProducts adapterProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.reciclerView);
        loadAdaptar();
    }


    private void loadAdaptar(){


        Product product =  new Product();
        product.setProduct("Empanada");
        product.setProductDescription("Deliciosas empanadas  a  1000");
        ArrayList<Product>  products =  new ArrayList<>();
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);
        products.add(product);





        adapterProducts = new AdapterProducts(products);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterProducts);

    }


}
