package com.example.u12.arquitecturamvp.presenters;

import com.example.u12.arquitecturamvp.helps.ValidarInternet;
import com.example.u12.arquitecturamvp.views.IBaseView;
import com.example.u12.arquitecturamvp.views.interfeces.IEdadView;

//IBaseView
public class BasePresenter <T extends IBaseView>{

    // las dos base se  comunican  por  la  interfaz
    private ValidarInternet validarInternet;
    private T view;

    //injecta  intancias al presentador
    public  void  inject(T view, ValidarInternet validarInternet){
        this.validarInternet=validarInternet;
        this.view=view;
    }

    public ValidarInternet getValidarInternet() {
        return validarInternet;
    }

    public T getView() {
        return view;
    }
}
