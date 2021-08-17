package com.siso.SisoWeb1.Oficialia.Modelo;

public class BeanDepartamentos {

    private int Id_Departamento;
    private String NombreDepto;
    private int NumeroEdificio;

    public BeanDepartamentos(){

    }

    public BeanDepartamentos(int id_departamento, String nombreDepto, int numeroEdificio) {
        this.Id_Departamento = id_departamento;
        this.NombreDepto = nombreDepto;
        this.NumeroEdificio = numeroEdificio;
    }

    public int getId_departamento() {
        return Id_Departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.Id_Departamento = id_departamento;
    }

    public String getNombreDepto() {
        return NombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.NombreDepto = nombreDepto;
    }

    public int getNumeroEdificio() {
        return NumeroEdificio;
    }

    public void setNumeroEdificio(int numeroEdificio) {
        this.NumeroEdificio = numeroEdificio;
    }
}
