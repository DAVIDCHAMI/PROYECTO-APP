package com.example.u12.arquitecturamvp.models;

public class Contacto {


    private int id;
    private String name;
    private String phone;
    private String company;


    public Contacto() {
    }

    public Contacto(int id, String name, String phone, String company) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
