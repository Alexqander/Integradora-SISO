package com.siso.SisoWeb1.Oficialia.Modelo;

public class BeanDepartamentos {

    private int idepa;
    private String nombreDepto;
    private int numeroEdificio;

    public BeanDepartamentos(){

    }

    public BeanDepartamentos(int idepa, String nombreDepto, int numeroEdificio) {
        this.idepa = idepa;
        this.nombreDepto = nombreDepto;
        this.numeroEdificio = numeroEdificio;
    }

    public int getIdepa() {
        return idepa;
    }

    public void setIdepa(int idepa) {
        this.idepa = idepa;
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
