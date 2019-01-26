package com.example.u12.arquitecturamvp.views.activitis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u12.arquitecturamvp.R;
import com.example.u12.arquitecturamvp.presenters.EdadPresenter;
import com.example.u12.arquitecturamvp.presenters.MainPresenter;
import com.example.u12.arquitecturamvp.views.BaseActivity;
import com.example.u12.arquitecturamvp.views.interfeces.IEdadView;
import com.example.u12.arquitecturamvp.views.interfeces.IMainView;

public class EdadActivity extends BaseActivity<EdadPresenter>  implements IEdadView {

    private EditText edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edad_activity);

        edad =findViewById(R.id.txtnacimiento);

        //contexto y
        setPresenter(new EdadPresenter());
       getPresenter().inject(this ,getValidarInternet());
    }

    public void calculo(View view) {
        getPresenter().calcularEdad(Integer.parseInt(edad.getText().toString()));
    }

    @Override
    public void tuEdad(int edad) {
        Toast.makeText(this,String.valueOf(edad),Toast.LENGTH_SHORT).show();
    }
}
