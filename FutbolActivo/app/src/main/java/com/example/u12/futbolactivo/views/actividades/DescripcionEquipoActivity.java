package com.example.u12.futbolactivo.views.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.u12.futbolactivo.R;
import com.example.u12.futbolactivo.helpers.ValidarInternet;
import com.example.u12.futbolactivo.modelos.ContenedorEquipos;
import com.example.u12.futbolactivo.modelos.Equipos;
import com.example.u12.futbolactivo.modelos.FechasEquipo;
import com.example.u12.futbolactivo.modelos.Fechaspadre;
import com.example.u12.futbolactivo.presenters.FechasPresenter;
import com.example.u12.futbolactivo.services.Repository;
import com.example.u12.futbolactivo.views.BaseActivity;
import com.example.u12.futbolactivo.views.interfeces.IFechasEquipos;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

public class DescripcionEquipoActivity extends BaseActivity<FechasPresenter> implements IFechasEquipos {

    private FechasEquipo fechasEquipo;
    private Equipos equipos;
    private TextView txtnombreEquipo, txtaño, txtdescription, txtfecha1, txtfecha2, txtfecha3, txtfecha4, txtfecha5;
    private ImageView imgEquipo;
    private Repository repository;
    private ValidarInternet validarInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_equipo);
        validarInternet = new ValidarInternet(this);

        repository = new Repository();
        equipos = (Equipos) getIntent().getSerializableExtra("equipo");

        imgEquipo = findViewById(R.id.imgEquipo);
        txtnombreEquipo = findViewById(R.id.txtnombreEquipo);
        txtaño = findViewById(R.id.txtaño);
        txtdescription = findViewById(R.id.txtdescription);
        txtfecha1 = findViewById(R.id.txtfecha1);
        txtfecha2 = findViewById(R.id.txtfecha2);
        txtfecha3 = findViewById(R.id.txtfecha3);
        txtfecha4 = findViewById(R.id.txtfecha4);
        txtfecha5 = findViewById(R.id.txtfecha5);

        Picasso.get().load(equipos.getCamisaEquipo()).into(imgEquipo);
        txtnombreEquipo.setText(equipos.getNombreEquipo());
        txtaño.setText(equipos.getAño());
        txtdescription.setText(equipos.getDescription());

        setPresenter(new FechasPresenter());
        getPresenter().inject(this, getValidarInternet());
        getPresenter().fechaspartidos(equipos.getIdEquipo());
    }


    public void regresar(View view) {
        finish();
    }

    @Override
    public void ListFechas(Fechaspadre fechaE) {
        String f1 = fechaE.getEvento().get(0).getFecEquipos();
        String f2 = fechaE.getEvento().get(1).getFecEquipos();
        String f3 = fechaE.getEvento().get(2).getFecEquipos();
        String f4 = fechaE.getEvento().get(3).getFecEquipos();
        String f5 = fechaE.getEvento().get(4).getFecEquipos();


        txtfecha1.setText(f1);
        txtfecha2.setText(f2);
        txtfecha3.setText(f3);
        txtfecha4.setText(f4);
        txtfecha5.setText(f5);
    }
}
