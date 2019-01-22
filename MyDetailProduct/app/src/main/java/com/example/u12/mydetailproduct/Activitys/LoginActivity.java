package com.example.u12.mydetailproduct.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u12.mydetailproduct.R;
import com.example.u12.mydetailproduct.helps.ValidarInternet;
import com.example.u12.mydetailproduct.models.Product;
import com.example.u12.mydetailproduct.models.Users;
import com.example.u12.mydetailproduct.services.Repository;
import com.example.u12.mydetailproduct.viewsinterface.IMainActivity;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity implements IMainActivity, TextWatcher {

    private EditText  txtUser,txtpasswor;
    private Button btnlogin;
    ValidarInternet validarInternet;
    Repository repository;
    private IMainActivity iMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        validarInternet = new ValidarInternet(this);
        txtUser = findViewById(R.id.txtuser);
        //metodo para activar  los escuchadores de los  campos saber si estan llenos  o  vacios
        txtUser.addTextChangedListener(this);
        txtpasswor = findViewById(R.id.txtpassword);
        txtpasswor.addTextChangedListener(this);
        btnlogin = findViewById(R.id.btnlogin);
        repository =  new Repository();

    }


    public void onClickL(View view) {
        if(validarInternet.isConnected()){
            createThereadLogin();
    }else {

        }
}

    private void createThereadLogin( ) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                logInRepository();
                                    }
        });
        thread.start();
    }

    private void logInRepository() {

        try {
         Users user=   repository.logIn(txtUser.getText().toString(),txtpasswor.getText().toString());
            showMessage(user.getName());
          //metodo para cambiar de actividad enviando  un objeto completo
            Intent intent = new Intent(this, PerfilActivity.class);
            intent.putExtra("usuario", user);
            startActivity(intent);

        } catch (IOException e) {
     showMessage(e.getMessage());
        }
    }


    private void  showMessage(final String mesaje){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,mesaje,Toast.LENGTH_LONG).show();
                //finish();
            }
        });

    }

    @Override
    public void intentToDetailActivity(Product product) {

    }

    @Override
    public void intentToPerfilActivity(Users usuario) {
        Intent intent = new Intent(this, PerfilActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    //metodo para  validar los  campos llenos
    @Override
    public void afterTextChanged(Editable s) {
        if (txtUser.getText().toString().isEmpty() || txtpasswor.getText().toString().isEmpty() ){
            btnlogin.setEnabled(false);
            btnlogin.setBackgroundResource(R.color.colorPrimary);
        } else {
            btnlogin.setEnabled(true);
            btnlogin.setBackgroundResource(R.color.colorWhite);
        }

    }
}
