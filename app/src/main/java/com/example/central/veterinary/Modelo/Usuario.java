package com.example.central.veterinary.Modelo;

public class Usuario {
    String identificacion;
    String nombre;
    String apellido;
    String sexo;
    String correo;
    String telefono;

    public Usuario(String identificacion, String nombre, String apellido, String sexo, String correo, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Usuario() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
