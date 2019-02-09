package com.example.u12.arquitecturamvp.views.activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.u12.arquitecturamvp.R;
import com.example.u12.arquitecturamvp.presenters.MainPresenter;
import com.example.u12.arquitecturamvp.views.BaseActivity;
import com.example.u12.arquitecturamvp.views.IBaseView;
import com.example.u12.arquitecturamvp.views.interfeces.IMainView;

public class MainActivity extends BaseActivity <MainPresenter> implements IMainView {

    private EditText txtnombre, txttelefono, txtcompañia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //componentes  mapeados
        setComponentes();
        //contexto y
        setPresenter(new MainPresenter());
        getPresenter().inject(this, getValidarInternet());
    }

    private void setComponentes() {
        txtnombre=findViewById(R.id.txtnombre);
        txttelefono =findViewById(R.id.txtTelefono);
        txtcompañia = findViewById(R.id.txtCompañia);
    }


    public void Calcular(View view) {
        /*
        //1 llamar al basepresenter para mandarle  los datos el hijo puede ver esos datos
    int resultado= getPresenter().sumCalculte(Integer.parseInt(numOne.getText().toString()),
                Integer.parseInt(numTwo.getText().toString()));
        Toast.makeText(this,String.valueOf(resultado),Toast.LENGTH_SHORT).show();

        // opción dos
        getPresenter().Calculte(Integer.parseInt(numOne.getText().toString()),
                Integer.parseInt(numTwo.getText().toString()));

                */
        // opción 3
      getPresenter().Calculte2(txtnombre.getText().toString(),txttelefono.getText().toString(),txtcompañia.getText().toString());



    }

    //opción dos
    @Override
    public void showResult(int result) {
        Toast.makeText(this,String.valueOf(result),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageLocalContact(final boolean success) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String msg =success ? "Contacto Creado" : "Contacto no creado";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT ).show();
            }
        });


    }


    public void ShowContact(View view) {
        getPresenter().showContactList();

    }

    public void ShowContact2(View view) {
        Intent intent = new Intent(MainActivity.this, ListarContatosActivity.class);
        startActivity(intent);
    }
}
