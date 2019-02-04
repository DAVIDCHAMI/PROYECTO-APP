package com.example.u12.arquitecturamvp.dao;

import com.example.u12.arquitecturamvp.models.Contacto;

import java.util.ArrayList;

public interface IContactoDao {

    public ArrayList<Contacto> fetchAllContactos();

    public Boolean createContacto(Contacto contacto);


}
