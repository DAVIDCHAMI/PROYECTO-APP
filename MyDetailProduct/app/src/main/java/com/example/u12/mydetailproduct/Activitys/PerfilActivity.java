package com.example.u12.mydetailproduct.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.u12.mydetailproduct.R;
import com.example.u12.mydetailproduct.helps.ValidarInternet;
import com.example.u12.mydetailproduct.models.Product;
import com.example.u12.mydetailproduct.models.Users;
import com.squareup.picasso.Picasso;

public class PerfilActivity extends AppCompatActivity {

    private Users usuario;
    ImageView imgPoto;
    TextView txtnombrep,txtusuariop,txtcorreop;
ValidarInternet validarInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        validarInternet = new ValidarInternet(this);
        getIntent().getSerializableExtra("usuario");

        // metodo  para  recibir objeto serializable con datos
        usuario= (Users) getIntent().getSerializableExtra("usuario");
        imgPoto =findViewById(R.id.imgPerfil);
        txtnombrep =findViewById(R.id.txtNombrep);
        txtusuariop =findViewById(R.id.txtusuariop);
        txtcorreop = findViewById(R.id.txtEmailp);

// metodo para manejar  imagen que  llega  como url
        Picasso.get().load(usuario.getPhoto()).into(imgPoto);
         //imgPoto.setImageAlpha(Integer.parseInt(usuario.getPhoto()));
        txtnombrep.setText(usuario.getName().toString());
        txtusuariop.setText(usuario.getUsername().toString());
        txtcorreop.setText(usuario.getEmail().toString());

    }


// metodo que redirecciona a la vista de MainActivity
    public void onClickEmp(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
