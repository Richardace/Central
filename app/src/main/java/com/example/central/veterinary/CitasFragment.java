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
        listaCitas.add(new Citas("1","2","3","30/05/2020","10:00 AM - 12:00 AM","Cancelado","https://img.icons8.com/cotton/2x/cancel.png"));
        listaCitas.add(new Citas("4","5","6","02/12/2020","04:00 PM - 06:00 PM","Atendido","https://img.icons8.com/cotton/2x/checkmark.png"));
        listaCitas.add(new Citas("7","8","9","04/08/2020","08:00 AM - 10:00 AM","Cancelado","https://img.icons8.com/cotton/2x/cancel.png"));
        return listaCitas;
    }
}
