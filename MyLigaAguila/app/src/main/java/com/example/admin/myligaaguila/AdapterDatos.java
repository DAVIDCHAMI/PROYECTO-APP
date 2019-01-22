package com.example.admin.myligaaguila;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDatos   extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<Equipos>  listaDatos;


    public AdapterDatos(ArrayList<Equipos> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_equipos,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
      viewHolderDatos.txtnombre.setText(listaDatos.get(i).getNombre());
      viewHolderDatos.txtdescripcion.setText(listaDatos.get(i).getDescripcion());
      viewHolderDatos.imgequipos.setImageResource(listaDatos.get(i).getImg());



    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtnombre,txtdescripcion;
        ImageView imgequipos;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtnombre=itemView.findViewById(R.id.txtnombre);
            txtdescripcion=itemView.findViewById(R.id.txtdescripcion);
            imgequipos=itemView.findViewById(R.id.imgequipo);
        }


    }
}
