package com.example.u12.arquitecturamvp.presenters;

import com.example.u12.arquitecturamvp.views.interfeces.IMainView;

public class MainPresenter  extends  BasePresenter<IMainView>{

    //opción 1
    public int sumCalculte(int one, int two) {
        return one + two;
    }


    //opción 2 asincronico
    public void Calculte(int on, int tw) {
        getView().showResult(on+tw);

    }

    //opción 3
    public void Calculte2(int n1, int n2) {
        getView().showToas(n1+n2);

    }
}
