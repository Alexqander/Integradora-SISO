package com.siso.SisoWeb1.Oficialia.Modelo;

public class BeanDepartamentos {

    private int id_Departamento;
    private String nombreDepto;
    private int numeroEdificio;

    public BeanDepartamentos(){

    }

    public BeanDepartamentos(int id_departamento, String nombreDepto, int numeroEdificio) {
        this.id_Departamento = id_departamento;
        this.nombreDepto = nombreDepto;
        this.numeroEdificio = numeroEdificio;
    }

    public int getId_departamento() {
        return id_Departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_Departamento = id_departamento;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public int getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(int numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }
}
