package com.example.central.veterinary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.central.R;
import com.example.central.veterinary.Modelo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder>{

    private Context context;
    private ArrayList<Mascota> mascotas;
    private int recurso;

    public MascotasAdapter(Context context, ArrayList<Mascota> mascotas, int recurso) {
        this.context = context;
        this.mascotas = mascotas;
        this.recurso = recurso;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview,parent,false);
        return new MascotasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        holder.nombreMascota.setText(mascotas.get(position).getNombre());
        holder.razaMascota.setText(mascotas.get(position).getRaza());
        holder.sexoMascota.setText(mascotas.get(position).getSexo());
        holder.duenioMascota.setText(mascotas.get(position).getDuenio());
        holder.edadMascota.setText(mascotas.get(position).getEdad());
        Picasso.get().load(mascotas.get(position).getImagen()).into(holder.imagenMascota);
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    static class MascotasViewHolder extends RecyclerView.ViewHolder{

        TextView nombreMascota;
        TextView razaMascota;
        TextView sexoMascota;
        TextView duenioMascota;
        TextView edadMascota;
        ImageView imagenMascota;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreMascota = itemView.findViewById(R.id.nombreMascota);
            razaMascota = itemView.findViewById(R.id.razaMascota);
            sexoMascota = itemView.findViewById(R.id.sexoMascota);
            edadMascota = itemView.findViewById(R.id.edadMascota);
            duenioMascota = itemView.findViewById(R.id.duenioMascota);
            imagenMascota = itemView.findViewById(R.id.imagenMascota);
        }
    }
}
