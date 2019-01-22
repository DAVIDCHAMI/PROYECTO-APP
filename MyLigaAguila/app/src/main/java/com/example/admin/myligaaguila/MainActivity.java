package com.example.admin.myligaaguila;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Equipos> listaDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaDatos  =  new ArrayList<Equipos>();
        recycler=findViewById(R.id.reciclerView);

        recycler.setLayoutManager(new LinearLayoutManager(this ,LinearLayout.VERTICAL,false));

llenarEquipos();


        AdapterDatos adapterDatos = new AdapterDatos(listaDatos);

        recycler.setAdapter(adapterDatos);


    }

    private void llenarEquipos() {

        listaDatos.add(new Equipos("INDEPENDIENTE MEDELLIN","El equipo del  pueblo",R.drawable.med));
        listaDatos.add(new Equipos("INDEPENDIENTE  SANTA FE","equipo tradicional de bogota",R.drawable.sant));
        listaDatos.add(new Equipos("JUNIOR","junior el papa de nacional",R.drawable.jun));
        listaDatos.add(new Equipos("DEPORTIVO CALI","equipo tradicional de cali",R.drawable.cal));
        listaDatos.add(new Equipos("AMERICA","equipo de la categoria B",R.drawable.ameri));
        listaDatos.add(new Equipos("MILLONARIOS","equipo tradicinal de bogota",R.drawable.mill));
        listaDatos.add(new Equipos("NACIONAL","pablito te  la compro, hijo del MEDELLIN",R.drawable.nac));

    }
}
