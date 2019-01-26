package com.example.u12.arquitecturamvp.helps;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.u12.arquitecturamvp.models.Users;
import com.google.gson.Gson;

public class CustomSharedPreferences {

    private SharedPreferences sharedPreferences;

    public CustomSharedPreferences(Context context) {
        sharedPreferences=context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
    }

    // metodo  que  obtine cualquier  strind
    public  String  getString(String key){
        if (sharedPreferences.contains(key)) {
            return sharedPreferences.getString(key, null);
        }
        return null;
    }

    //agregar cualquier string
    public  void addString(String key, String  value){
        if(value != null && key != null){
            addValue(key, value);
        }
    }



    //guardar objeto users
    public void saveUser(String key, Users users){
        Gson gson=new Gson();
        String jsonUser =gson.toJson(users);
        addValue(key, jsonUser);
    }

    //llamar  objeto user
    public Users getUser(String key){
        Gson gson= new Gson();
        String jsonUser= sharedPreferences.getString(key, null);
        Users users=gson.fromJson(jsonUser, Users.class);
        return  users;
    }







    private void addValue(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }



    public void deleteValue(String key){
        sharedPreferences.edit().remove(key).apply();

    }

}
