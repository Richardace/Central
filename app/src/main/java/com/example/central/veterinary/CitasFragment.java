package com.example.central.veterinary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.central.R;
import com.example.central.veterinary.Modelo.Citas;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CitasFragment extends Fragment {

    CitasAdapter citasAdapter;
    RecyclerView recyclerViewCitas;

    public CitasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.veterinary_fragment_citas, container, false);
        recyclerViewCitas = view.findViewById(R.id.recyclerviewCitas);
        LinearLayoutManager linearlayout = new LinearLayoutManager(getContext());
        linearlayout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCitas.setLayoutManager(linearlayout);
        citasAdapter = new CitasAdapter(getActivity(),cargarDatos(),R.layout.veterinary_cardview_citas);
        recyclerViewCitas.setAdapter(citasAdapter);
        return view;
    }

    public ArrayList<Citas> cargarDatos(){
        ArrayList<Citas> listaCitas = new ArrayList<>();
        listaCitas.add(new Citas("1","2","3","30/05/2020","10:00 AM - 12:00 AM","Cancelado","https://cdn1.iconfinder.com/data/icons/basic-ui-elements-color/700/010_x-512.png"));
        listaCitas.add(new Citas("4","5","6","02/12/2020","04:00 PM - 06:00 PM","Cancelado","https://cdn1.iconfinder.com/data/icons/basic-ui-elements-color/700/010_x-512.png"));
        //listaCitas.add(new Citas("Oreo","Raza: Labrador","Edad: 3","Sexo: Hembra","Richard Alexander","https://images.unsplash.com/photo-1502673530728-f79b4cab31b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"));
        //listaCitas.add(new Citas("Tonny","Raza: Bengala","Edad: 4","Sexo: Hembra","Karen Acevedo","https://images.unsplash.com/photo-1548681528-6a5c45b66b42?ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"));
        return listaCitas;
    }
}
