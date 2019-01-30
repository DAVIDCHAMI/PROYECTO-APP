package com.example.u12.futbolactivo.presenters;


import com.example.u12.futbolactivo.helpers.ValidarInternet;
import com.example.u12.futbolactivo.views.IBaseView;

//IBaseView
public class BasePresenter<T extends IBaseView>{

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
