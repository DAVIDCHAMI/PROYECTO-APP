package com.example.u12.arquitecturamvp.views.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.u12.arquitecturamvp.R;
import com.example.u12.arquitecturamvp.adapters.Adapters;
import com.example.u12.arquitecturamvp.models.Contacto;
import com.example.u12.arquitecturamvp.presenters.ListarContactoPresenter;
import com.example.u12.arquitecturamvp.views.BaseActivity;
import com.example.u12.arquitecturamvp.views.interfeces.IListarContactos;

import java.util.ArrayList;

public class ListarContatosActivity extends BaseActivity<ListarContactoPresenter> implements IListarContactos {

    RecyclerView recycler;
  private   Contacto contacto;
    private Adapters adapters;
  private ListarContactoPresenter listarContactoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contatos);

        recycler = findViewById(R.id.reciclerView);
        setPresenter(new  ListarContactoPresenter());
        getPresenter().inject(this, getValidarInternet());

        getcontactos();




    }

    public void getcontactos(){
      getPresenter().mostrarContactos();
    }


    @Override
    public void showContacts(ArrayList<Contacto> contactsFromDb) {
        adapters = new Adapters(contactsFromDb);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adapters);
    }
}
