package com.example.central;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.central.administrator.MainActivity;
import com.example.central.customer.MainActivityCustomer;
import com.example.central.veterinary.MainActivityVeterinary;
import com.example.central.veterinary.Modelo.Mascota;
import com.google.android.material.textfield.TextInputEditText;

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

public class Login extends AppCompatActivity {

    Button sesion;
    TextInputEditText usuario;
    TextInputEditText clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = findViewById(R.id.textUsuario);
        clave = findViewById(R.id.textClave);
        sesion = findViewById(R.id.btInicioSesion);
        sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(usuario.getText().toString(), clave.getText().toString());
            }
        });
    }

    public void login(String usuario, String clave) {
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
                String documento = jsonObject.optString("documento");
                String tipo_usuario = jsonObject.optString("tipo_usuario");
                String password = jsonObject.optString("password");

                if(documento.equals(usuario) && password.equals(clave)){
                    Toast.makeText(Login.this, "Bienvenido",
                            Toast.LENGTH_SHORT).show();
                    switch (tipo_usuario) {
                        case "1" : inicioAdmin();break;
                        case "2" : inicioVet();break;
                        case "3" : inicioCustomer();break;
                    }
                }

            }
            Toast.makeText(Login.this, "Datos Incorrectos",
                    Toast.LENGTH_SHORT).show();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void inicioAdmin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void inicioVet(){
        Intent intent = new Intent(this, MainActivityVeterinary.class);
        startActivity(intent);
    }
    public void inicioCustomer(){
        Intent intent = new Intent(this, MainActivityCustomer.class);
        startActivity(intent);
    }
}
