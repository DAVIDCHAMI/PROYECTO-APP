package com.example.u12.futbolactivo.views.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.u12.futbolactivo.R;
import com.example.u12.futbolactivo.adapters.Adapters;
import com.example.u12.futbolactivo.helpers.ValidarInternet;
import com.example.u12.futbolactivo.modelos.ContenedorEquipos;
import com.example.u12.futbolactivo.modelos.Equipos;

import java.util.ArrayList;

public class MainRecicler extends AppCompatActivity {
    RecyclerView recycler;
   // private Equipos equipos;
   ContenedorEquipos equipos;
    private Adapters adapters;

    ValidarInternet validarInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recicler);
        recycler = findViewById(R.id.reciclerView);

        validarInternet = new ValidarInternet(this);
        getIntent().getSerializableExtra("equi");

        equipos = (ContenedorEquipos) getIntent().getSerializableExtra("equi");

        equipos.getTeams().size();

        adapters = new Adapters(equipos.getTeams());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adapters);
    }





}
