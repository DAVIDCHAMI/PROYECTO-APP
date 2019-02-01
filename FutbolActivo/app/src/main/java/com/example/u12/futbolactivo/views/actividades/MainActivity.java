package com.example.u12.futbolactivo.views.actividades;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.u12.futbolactivo.R;
import com.example.u12.futbolactivo.modelos.ContenedorEquipos;
import com.example.u12.futbolactivo.modelos.Equipos;
import com.example.u12.futbolactivo.presenters.EquiposPresenter;
import com.example.u12.futbolactivo.views.BaseActivity;
import com.example.u12.futbolactivo.views.interfeces.IEquiposView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<EquiposPresenter> implements IEquiposView {

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(MainActivity.this);

        dialog.setTitle("HOLA");
        dialog.setMessage("ESPERA UN MOMENTO");

        dialog.show();

        //contexto y
        setPresenter(new EquiposPresenter());
        getPresenter().inject(this ,getValidarInternet());
        getPresenter().getLeague();






    }



    @Override
    public void showLeague(ContenedorEquipos equipos) {
       int tam= equipos.getTeams().size();
        Toast.makeText(this,tam,Toast.LENGTH_SHORT).show();
    }

}
