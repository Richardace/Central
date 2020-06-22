package com.example.central.veterinary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.central.R;
import com.example.central.veterinary.Modelo.Citas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CitasFragment extends Fragment {

    CitasAdapter citasAdapter;
    RecyclerView recyclerViewCitas;
    ArrayList<Citas> listaCitas = new ArrayList<>();

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
        citasAdapter = new CitasAdapter(getActivity(),getCitas(),R.layout.veterinary_cardview_citas);
        recyclerViewCitas.setAdapter(citasAdapter);
        return view;
    }

    public ArrayList<Citas> getCitas() {
        getData();
        return listaCitas;
    }

    public void getData() {
        String sql = "http://54.85.80.55/api/users";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            StringBuffer response = new StringBuffer();
            String json = "";

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            json = response.toString();
            JSONArray jsonArr = null;
            jsonArr = new JSONArray(json);

            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObject = jsonArr.getJSONObject(i);
                listaCitas.add(new Citas("1","2","3","30/05/2020","10:00 AM - 12:00 AM","Cancelado","https://img.icons8.com/cotton/2x/cancel.png"));
                Log.d("Salida", jsonObject.optString("documento"));
                Log.d("Salida", "perro");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos(){

        //listaCitas.add(new Citas("1","2","3","30/05/2020","10:00 AM - 12:00 AM","Cancelado","https://img.icons8.com/cotton/2x/cancel.png"));
        //listaCitas.add(new Citas("4","5","6","02/12/2020","04:00 PM - 06:00 PM","Atendido","https://img.icons8.com/cotton/2x/checkmark.png"));
        //listaCitas.add(new Citas("7","8","9","04/08/2020","08:00 AM - 10:00 AM","Cancelado","https://img.icons8.com/cotton/2x/cancel.png"));
        //return listaCitas;
    }
}
