package com.example.central.veterinary.Modelo;

public class Citas {
    String id_cita;
    String id_mascota;
    String id_cliente;
    String fecha;
    String hora;
    String estado;
    String imagen_estado;

    public Citas( String id_cita,  String id_mascota,  String id_cliente, String fecha, String hora, String estado, String imagen_estado) {
        this.id_cita = id_cita;
        this.id_mascota = id_mascota;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.imagen_estado = imagen_estado;
    }

    public Citas() {
    }

    public  String getId_cita() {
        return "Numero de Cita: " + id_cita;
    }

    public void setId_cita( String id_cita) {
        this.id_cita = id_cita;
    }

    public  String getId_mascota() {
        return "Id Mascota: "+id_mascota;
    }

    public void setId_mascota( String id_mascota) {
        this.id_mascota = id_mascota;
    }

    public  String getId_cliente() {
        return "Id Cliente: "+id_cliente;
    }

    public void setId_cliente( String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getImagen_estado() {
        return imagen_estado;
    }

    public void setImagen_estado(String imagen_estado) {
        this.imagen_estado = imagen_estado;
    }

}
