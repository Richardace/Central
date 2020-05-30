package com.example.central.veterinary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.central.R;
import com.example.central.veterinary.Modelo.Citas;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CitasAdapter extends RecyclerView.Adapter<CitasAdapter.CitasViewHolder>{

    private Context context;
    private ArrayList<Citas> citas;
    private int recurso;

    public CitasAdapter(Context context, ArrayList<Citas> citas, int recurso) {
        this.context = context;
        this.citas = citas;
        this.recurso = recurso;
    }

    @NonNull
    @Override
    public CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.veterinary_cardview_citas,parent,false);
        return new CitasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitasViewHolder holder, int position) {
        holder.id_cita.setText(citas.get(position).getId_cita());
        holder.id_cliente.setText(citas.get(position).getId_cliente());
        holder.id_mascota.setText(citas.get(position).getId_mascota());
        holder.hora.setText(citas.get(position).getHora());
        holder.fecha.setText(citas.get(position).getFecha());
        //Picasso.get().load(mascotas.get(position).getImagen()).into(holder.imagenMascota);
    }

    @Override
    public int getItemCount() {
        return citas.size();
    }

    static class CitasViewHolder extends RecyclerView.ViewHolder{
        TextView id_mascota;
        TextView id_cita;
        TextView id_cliente;
        TextView fecha;
        TextView hora;
        public CitasViewHolder(@NonNull View itemView) {
            super(itemView);
            id_cita = itemView.findViewById(R.id.idCita);
            id_mascota = itemView.findViewById(R.id.idMascota);
            id_cliente = itemView.findViewById(R.id.idCliente);
            fecha = itemView.findViewById(R.id.idFecha);
            hora = itemView.findViewById(R.id.idHora);
        }
    }
}
