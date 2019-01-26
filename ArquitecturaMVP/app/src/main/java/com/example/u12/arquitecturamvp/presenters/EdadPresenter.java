package com.example.u12.arquitecturamvp.presenters;

import com.example.u12.arquitecturamvp.views.interfeces.IEdadView;


public class EdadPresenter  extends  BasePresenter<IEdadView> {

    public void calcularEdad(int año) {
        getView().tuEdad(2019 -año);

    }
}
