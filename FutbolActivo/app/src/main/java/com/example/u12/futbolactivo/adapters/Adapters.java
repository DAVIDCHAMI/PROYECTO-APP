package com.example.u12.futbolactivo.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.u12.futbolactivo.R;
import com.example.u12.futbolactivo.modelos.Equipos;
import com.example.u12.futbolactivo.views.actividades.DescripcionEquipoActivity;
import com.squareup.picasso.Picasso;

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


       return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        CustomViewHolder customViewHolder= (CustomViewHolder) viewHolder;
        final Equipos equipos =equiposArrayList.get(i);

        equipos.getAño();

        Picasso.get().load(equipos.getEscudoEquipo()).into(customViewHolder.imageView);
        customViewHolder.textViewName.setText(equipos.getNombreEquipo());
        customViewHolder.textViewDescription.setText(equipos.getNombreLiga());
        customViewHolder.cardViewItem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescripcionEquipoActivity.class);
                intent.putExtra("equipo", equipos);
               context. startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return equiposArrayList.size();
    }


    private class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private ImageView imageView;
        private TextView textViewDescription;
        private CardView cardViewItem;


        public CustomViewHolder(View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.imageViewProduct);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            cardViewItem = itemView.findViewById(R.id.cardviewItem);

        }
    }
}
