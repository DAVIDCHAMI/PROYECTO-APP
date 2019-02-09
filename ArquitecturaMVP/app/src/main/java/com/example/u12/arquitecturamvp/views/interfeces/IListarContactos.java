package com.example.u12.arquitecturamvp.views.interfeces;

import com.example.u12.arquitecturamvp.models.Contacto;
import com.example.u12.arquitecturamvp.views.IBaseView;

import java.util.ArrayList;

public interface IListarContactos extends IBaseView {


    void showContacts(ArrayList<Contacto> contactsFromDb);
}
