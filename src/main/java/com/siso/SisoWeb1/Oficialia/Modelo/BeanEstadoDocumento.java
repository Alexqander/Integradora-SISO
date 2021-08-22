package com.siso.SisoWeb1.Oficialia.Modelo;

public class BeanEstadoDocumento {
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public BeanEstadoDocumento(){

    }

    public BeanEstadoDocumento(int estado, String nombre) {
        this.estado = estado;
        this.nombre = nombre;
    }



}
