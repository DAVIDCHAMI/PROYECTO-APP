package com.example.u12.arquitecturamvp.views.activitis;

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

    private EditText numOne, numTwo;


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
        numOne=findViewById(R.id.txtnum1);
        numTwo =findViewById(R.id.txtnum2);
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
        getPresenter().Calculte2(Integer.parseInt(numOne.getText().toString()),
                Integer.parseInt(numTwo.getText().toString()));


    }

    //opción dos
    @Override
    public void showResult(int result) {
        Toast.makeText(this,String.valueOf(result),Toast.LENGTH_SHORT).show();
    }



}
