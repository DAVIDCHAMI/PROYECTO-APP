package com.example.u12.mydetailproduct.Activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.u12.mydetailproduct.R;
import com.example.u12.mydetailproduct.helps.ValidarInternet;
import com.example.u12.mydetailproduct.models.DeleteResponse;
import com.example.u12.mydetailproduct.models.Product;
import com.example.u12.mydetailproduct.services.Repository;

import java.io.IOException;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private Product product;
    private TextView  txtnombre,txtdescripcion,txtcantidad,txtprecio,txtmarca;
    private Repository repository;


    private ValidarInternet validarInternet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        validarInternet = new ValidarInternet(this);
        getIntent().getSerializableExtra("product");
        repository = new Repository();


        product= (Product) getIntent().getSerializableExtra("product");
        txtnombre = findViewById(R.id.txtNombre1);
        txtdescripcion = findViewById(R.id.txtdescripcion1);
        txtcantidad = findViewById(R.id.txtcantidad1);
        txtprecio = findViewById(R.id.txtprecio1);
        txtmarca = findViewById(R.id.txtmarca1);


        txtnombre.setText(product.getProduct().toString());
        txtdescripcion.setText(product.getProductDescription().toString());
        txtcantidad.setText(Integer.toString(product.getQuantity()).toString());
        txtprecio.setText(Integer.toString(product.getPrice()).toString());
        txtmarca.setText(product.getBrand().toString());

        repository = new Repository();
        //validateInternet();
    }

    // valida  internet
    public void deleteProdutd(View vie){
        if(validarInternet.isConnected()){
            createTheradDeleteProduct();
        }else {

        }
    }

    //hilo
    private void createTheradDeleteProduct() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                deletProducts();
            }
        });
        thread.start();
    }



    private void createThereadGetProduct() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                deletProducts();
            }
        });
        thread.start();

    }

    //eliminar producto
    private void deletProducts() {
        try{
            repository.deleteProduct(product.getIdProducto());
            showMessage(getResources().getString(R.string.delete_product));
        } catch (IOException e) {
            showMessage(e.getMessage());

        }
    }


    private void  showMessage(final String mesaje){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DetailActivity.this,mesaje,Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    public void onClickRegresar(View view) {
       finish();
    }

    public void onClickEliminar(View view) {
        deleteProdutd(view);
    }
}
