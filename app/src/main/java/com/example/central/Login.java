package com.example.central;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.central.administrator.MainActivity;
import com.example.central.customer.MainActivityCustomer;
import com.example.central.veterinary.MainActivityVeterinary;

public class Login extends AppCompatActivity {

    Button loginAdmin;
    Button loginVet;
    Button loginCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginAdmin = findViewById(R.id.btnLoginAdministrator);
        loginVet = findViewById(R.id.btnLoginVeterinario);
        loginCustomer = findViewById(R.id.btnLoginCliente);
        loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicioAdmin();
            }
        });
        loginVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicioVet();
            }
        });
        loginCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicioCustomer();
            }
        });
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
