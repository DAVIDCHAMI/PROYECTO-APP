package com.example.u12.camaraandgaleria;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List<String> arrayPhotos;

    private Context context;

    public void setPhotos(ArrayList<String> arrayPhotos){
        this.arrayPhotos=arrayPhotos;
    }


    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflar  vista
          View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo,viewGroup, false);
          this.context=viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder viewHolder, int position) {
        String photo =arrayPhotos.get(position);
       // Picasso.get().load(photo).into(viewHolder.itemPhot);
        Glide.with(context).load(photo).into(viewHolder.itemPhot);


    }

    @Override
    public int getItemCount() {
        return arrayPhotos.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
            private ImageView itemPhot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemPhot = itemView.findViewById(R.id.item_photo);

        }
    }
}
