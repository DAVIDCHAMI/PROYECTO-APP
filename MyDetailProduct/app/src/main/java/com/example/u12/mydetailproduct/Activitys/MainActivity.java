package com.example.u12.mydetailproduct.Activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.u12.mydetailproduct.R;
import com.example.u12.mydetailproduct.adapters.AdapterProducts;
import com.example.u12.mydetailproduct.helps.ValidarInternet;
import com.example.u12.mydetailproduct.models.Product;
import com.example.u12.mydetailproduct.services.Repository;
import com.example.u12.mydetailproduct.viewsinterface.IMainActivity;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private RecyclerView recyclerView;
    private Repository repository;
    private AdapterProducts adapterProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.reciclerView);
        repository = new Repository();
        validateInternet();
    }


    private void validateInternet() {
        ValidarInternet validarInternet = new ValidarInternet(this);
        if (validarInternet.isConnected()) {
            createThereadGetProduct();
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
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

    // trae la  lista  de  los  productos que expone el servicio
    private void getProducts() {

        try {
            ArrayList<Product> products = repository.getProducts();
            loadAdapter(products);
        } catch (final IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }


    private void loadAdapter(final ArrayList<Product> products) {

// realiza  una petición para  que  el  proceso que  controla  la  interfaz  grafica  realice cambios
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AdapterProducts adapterProducts = new AdapterProducts(products, MainActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterProducts);
            }
        });

    }

    private void createThereadGetProduct() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getProducts();
            }
        });
        thread.start();

    }


    @Override
    public void intentToDetailActivity(Product product) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("product", product);
        startActivity(intent);
    }
}
