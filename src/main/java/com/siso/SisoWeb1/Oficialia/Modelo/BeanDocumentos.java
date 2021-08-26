package com.siso.SisoWeb1.Oficialia.Modelo;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

public class BeanDocumentos {

    private int folio;
    private String asunto;
    private String departamento;
    private int empleado;
    private String estadoOficio;
    private InputStream archivo;
    private String nombreArchivo;
    private Blob archivo1;



    public BeanDocumentos(){

    }


    public BeanDocumentos(int folio, String asunto, String departamento, String nombreArchivo, InputStream archivo) {
        this.folio = folio;
        this.asunto = asunto;
        this.departamento = departamento;
        this.nombreArchivo = nombreArchivo;
        this.archivo = archivo;
    }

    public BeanDocumentos(int folio, int empleado, String estadoOficio) {
        this.folio = folio;
        this.empleado = empleado;
        this.estadoOficio =estadoOficio;
    }

    public BeanDocumentos(int folio, String asunto) {
        this.folio = folio;
        this.asunto = asunto;
    }


    public BeanDocumentos(int folio, String asunto, String departamento, int empleado, InputStream archivo) {
        this.folio = folio;
        this.asunto = asunto;
        this.departamento = departamento;
        this.empleado = empleado;
        this.archivo = archivo;
    }

    public BeanDocumentos(int folio, String asunto, String departamento, int empleado) {
        this.folio = folio;
        this.asunto = asunto;
        this.departamento = departamento;
        this.empleado = empleado;
    }

    public BeanDocumentos(int folio, String asunto, String departamento) {
        this.folio = folio;
        this.asunto = asunto;
        this.departamento = departamento;
    }




    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public String getEstadoOficio() {
        return estadoOficio;
    }

    public void setEstadoOficio(String estadoOficio) {
        this.estadoOficio = estadoOficio;
    }

    public InputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(InputStream archivo) {
        this.archivo = archivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Blob getArchivo1() {
        return archivo1;
    }

    public void setArchivo1(Blob archivo1) {
        this.archivo1 = archivo1;
    }
}
