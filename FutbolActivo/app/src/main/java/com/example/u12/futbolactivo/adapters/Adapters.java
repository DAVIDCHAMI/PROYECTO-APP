package com.example.u12.futbolactivo.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.u12.futbolactivo.R;
import com.example.u12.futbolactivo.modelos.Equipos;

import java.util.ArrayList;

public class Adapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Equipos> equiposArrayList;
    private Context context;

    public Adapters(ArrayList<Equipos> equiposArrayList) {
        this.equiposArrayList = equiposArrayList;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //define contexto del adaptador
        context=viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_main ,viewGroup, false);


       return null ;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
