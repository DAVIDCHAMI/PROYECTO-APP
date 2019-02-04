package com.example.u12.arquitecturamvp.views;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.u12.arquitecturamvp.helps.ValidarInternet;
import com.example.u12.arquitecturamvp.presenters.BasePresenter;

// conectar BaseActivity y basepresenter g"generico" reflection
public class BaseActivity<T extends BasePresenter> extends AppCompatActivity  implements  IBaseView{

    private ValidarInternet validarInternet;

    //variable presenter
    private  T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

              validarInternet = new ValidarInternet(this);
    }

    public ValidarInternet getValidarInternet() {
        return validarInternet;
    }

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToas(int resultado) {
        Toast.makeText(this,String.valueOf(resultado),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToasMessage(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    /*
    @Override
    public void showAlertDialo(int resultado) {

    }
    */


}
