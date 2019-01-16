package com.example.u12.adapterapplication.actividades;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u12.adapterapplication.R;
import com.example.u12.adapterapplication.helper.ValidarInternet;
import com.example.u12.adapterapplication.models.Product;
import com.example.u12.adapterapplication.repositorys.Repository;

import java.io.IOException;

public class CreateProductActivity extends AppCompatActivity implements TextWatcher {

    private EditText txtnombre;
    private EditText txtdescripcion;
    private EditText txtprecio;
    private EditText txtcantidad;
    private EditText txtmarca;
    private Button btnenviar;
    private ValidarInternet validateInternet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        validateInternet = new ValidarInternet(this);
        loadView();
        loadEvents();
    }


    private void loadView() {
        txtnombre = findViewById(R.id.txtnombre);
        txtnombre.addTextChangedListener(this);
        txtdescripcion = findViewById(R.id.txtdescripcion);
        txtdescripcion.addTextChangedListener(this);
        txtprecio = findViewById(R.id.txtprecio);
        txtprecio.addTextChangedListener(this);
        txtcantidad = findViewById(R.id.txtcantidad);
        txtcantidad.addTextChangedListener(this);
        txtmarca = findViewById(R.id.txtmarca);
        txtmarca.addTextChangedListener(this);
        btnenviar = findViewById(R.id.btnenviar);
    }

    public void loadEvents() {
        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setProduct(txtnombre.getText().toString());
                product.setProductDescription(txtdescripcion.getText().toString());
                product.setPrice(Integer.parseInt(txtprecio.getText().toString()));
                product.setQuantity(Integer.parseInt(txtcantidad.getText().toString()));
                product.setBrand(txtmarca.getText().toString());

                if (validateInternet.isConnected()) {
                    createThreadCreateProduct(product);
                } else {
                    //valida  si  hay  internet o no si  no  hay muestra  ventana emergente
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(CreateProductActivity.this);
                    alertDialog.setTitle(R.string.title_validate_internet);
                    alertDialog.setMessage(R.string.message_validate_internet);
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // validateInternet();
                            dialog.dismiss();

                        }
                    });
                    alertDialog.show();
                }


            }
        });
    }


    private void createThreadCreateProduct(final Product product) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                createProduct(product);
            }
        });
        thread.start();
    }

    private void createProduct(Product product) {
        Repository repository = new Repository();
        try {
            repository.saveProducts(product);
            finish();
        } catch (final IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(CreateProductActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (txtnombre.getText().toString().isEmpty() || txtdescripcion.getText().toString().isEmpty() ||
                txtprecio.getText().toString().isEmpty() || txtcantidad.getText().toString().isEmpty() ||
                txtmarca.getText().toString().isEmpty()) {
            btnenviar.setEnabled(false);
            btnenviar.setBackgroundResource(R.color.colorPrimary);
        } else {
            btnenviar.setEnabled(true);
            btnenviar.setBackgroundResource(R.color.colorWhite);
        }


    }
}
