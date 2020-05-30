package com.example.central.veterinary;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.central.R;
import com.example.central.veterinary.Modelo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {

    MascotasAdapter mascotasAdapter;
    RecyclerView recyclerViewMascotas;

    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.veterinary_fragment_mascotas, container, false);
        recyclerViewMascotas = view.findViewById(R.id.recyclerviewMascotas);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMascotas.setLayoutManager(linearLayout);
        mascotasAdapter = new MascotasAdapter(getActivity(),cargarDatos(),R.layout.cardview);
        recyclerViewMascotas.setAdapter(mascotasAdapter);
        return view;
    }
    public ArrayList<Mascota> cargarDatos(){
        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota("Candy","Raza: Labrador","Edad: 5","Sexo: Hembra","Luis Portilla","https://images.unsplash.com/photo-1558788353-f76d92427f16?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=378&q=80"));
        listaMascotas.add(new Mascota("Oreo","Raza: Labrador","Edad: 3","Sexo: Hembra","Richard Alexander","https://images.unsplash.com/photo-1502673530728-f79b4cab31b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"));
        listaMascotas.add(new Mascota("Tonny","Raza: Bengala","Edad: 4","Sexo: Hembra","Karen Acevedo","https://images.unsplash.com/photo-1548681528-6a5c45b66b42?ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"));
        return listaMascotas;
    }
}
