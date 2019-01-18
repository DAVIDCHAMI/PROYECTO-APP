package com.example.u12.mydetailproduct.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.u12.mydetailproduct.R;
import com.example.u12.mydetailproduct.models.Product;

public class DetailActivity extends AppCompatActivity {

    private Product product;
    private TextView  txtnombre,txtdescripcion,txtcantidad,txtprecio,txtmarca;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getIntent().getSerializableExtra("product");

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

    }

    public void onClickRegresar(View view) {

       finish();
    }
}
