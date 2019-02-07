package com.example.u12.futbolactivo.views.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.u12.futbolactivo.R;
import com.example.u12.futbolactivo.helpers.ValidarInternet;
import com.example.u12.futbolactivo.modelos.Equipos;
import com.example.u12.futbolactivo.services.Repository;
import com.squareup.picasso.Picasso;

public class DescripcionEquipoActivity extends AppCompatActivity {

    private Equipos equipos;
    private TextView   txtnombreEquipo,txtaño,txtdescription;
    private ImageView imgEquipo;
    private Repository repository;
    private ValidarInternet validarInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_equipo);
        validarInternet = new ValidarInternet(this);
        repository = new Repository();


        equipos= (Equipos) getIntent().getSerializableExtra("equipo");

        imgEquipo =findViewById(R.id.imgEquipo);
        txtnombreEquipo= findViewById(R.id.txtnombreEquipo);
        txtaño= findViewById(R.id.txtaño);
        txtdescription = findViewById(R.id.txtdescription);


        Picasso.get().load(equipos.getCamisaEquipo()).into(imgEquipo);
        txtnombreEquipo.setText(equipos.getNombreEquipo());
        txtaño.setText(equipos.getAño());
        txtdescription.setText(equipos.getDescription());

    }

    public void regresar(View view) {
        finish();

    }
}
