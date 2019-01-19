package com.example.u12.mydetailproduct.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("_id")
    @Expose
    private String idProducto;

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("username")
    @Expose
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("photo")
    @Expose
    private String photo;



    @SerializedName("token")
    @Expose
    private String token;


    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getProduct() {
        return name;
    }

    public void setProduct(String product) {
        this.name = product;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
