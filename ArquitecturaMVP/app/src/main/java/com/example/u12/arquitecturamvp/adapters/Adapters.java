package com.example.u12.arquitecturamvp.adapters;


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

import com.example.u12.arquitecturamvp.R;
import com.example.u12.arquitecturamvp.models.Contacto;
import com.example.u12.arquitecturamvp.views.activitis.ListarContatosActivity;

import java.util.ArrayList;

public class Adapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Contacto> contactosArrayList;
    private Context context;
    ImageView imageView;

    public Adapters(ArrayList<Contacto> contactosArrayList) {
        this.contactosArrayList = contactosArrayList;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //define contexto del adaptador
        context=viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listacontactos ,viewGroup, false);


       return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        CustomViewHolder customViewHolder= (CustomViewHolder) viewHolder;
        final Contacto contacto =contactosArrayList.get(i);



        customViewHolder.txtnombre.setText(contacto.getName().toString());
        customViewHolder.txtxtelefono.setText(contacto.getPhone());
        customViewHolder.txtcompañia.setText(contacto.getCompany());
        customViewHolder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent(context, ListarContatosActivity.class);
                intent.putExtra("equipo", equipos);
               context. startActivity(intent);
*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactosArrayList.size();
    }


    private class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView txtnombre;
        private TextView txtxtelefono;
        private TextView txtcompañia;
        private CardView cardViewItem;


        public CustomViewHolder(View itemView) {
            super(itemView);

            txtnombre =itemView.findViewById(R.id.txtNombres);
            txtxtelefono = itemView.findViewById(R.id.textTelefono);
            txtcompañia = itemView.findViewById(R.id.textCompañia);
            cardViewItem = itemView.findViewById(R.id.cardviewItem);

        }

    }

}
