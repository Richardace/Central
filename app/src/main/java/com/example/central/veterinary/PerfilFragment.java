package com.example.central.veterinary;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.central.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.central.administrator.MainActivity;
import com.example.central.veterinary.Modelo.Usuario;

public class PerfilFragment extends Fragment {

    Usuario user= new Usuario();
    TextView identificacion;
    TextView nombre;
    TextView apellido;
    TextView sexo;
    TextView telefono;
    TextView correo;
    String id_user;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.veterinary_fragment_perfil, container, false);
        MainActivityVeterinary activity = (MainActivityVeterinary) getActivity();
        id_user = activity.getDataFragment();
        identificacion=view.findViewById(R.id.identificacion_usuario);
        nombre=view.findViewById(R.id.nombre_usuario);
        apellido=view.findViewById(R.id.apellido_usuario);
        sexo=view.findViewById(R.id.sexo_usuario);
        telefono=view.findViewById(R.id.telefono_usuario);
        correo =view.findViewById(R.id.correo_usuario);
        //Cambiar los valores del TextView
        identificacion.setText(getData().getIdentificacion());
        nombre.setText(getData().getNombre());
        apellido.setText(getData().getApellido());
        sexo.setText(getData().getSexo());
        telefono.setText(getData().getTelefono());
        correo.setText(getData().getCorreo());
        return view;
    }

    public Usuario getData() {
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
                String id = jsonObject.optString("id");
                String documento = jsonObject.optString("documento");
                String nombre = jsonObject.optString("nombre");
                String apellido = jsonObject.optString("apellido");
                String sexo = jsonObject.optString("sexo");
                String telefono = jsonObject.optString("telefono");
                String correo = jsonObject.optString("correo");
                //String tipo_usuario = jsonObject.optString("tipo_usuario");

                if(id.equals(id_user)){
                    user.setIdentificacion(documento);
                    user.setNombre(nombre);
                    user.setApellido(apellido);
                    user.setSexo(sexo);
                    user.setTelefono(telefono);
                    user.setCorreo(correo);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }
}
