package com.siso.SisoWeb1.Oficialia.Modelo;

import java.io.InputStream;
import java.util.Date;

public class BeanDocumentos {

    private int folio;
    private int id_empleado;
    private Date fechaIngreso;
    private Date fecfaRespuesta;
    private int estadoOficio;
    private String departamento;

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFecfaRespuesta() {
        return fecfaRespuesta;
    }

    public void setFecfaRespuesta(Date fecfaRespuesta) {
        this.fecfaRespuesta = fecfaRespuesta;
    }

    public int getEstadoOficio() {
        return estadoOficio;
    }

    public void setEstadoOficio(int estadoOficio) {
        this.estadoOficio = estadoOficio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public InputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(InputStream archivo) {
        this.archivo = archivo;
    }

    private InputStream archivo;

    public BeanDocumentos(){

    }

    public BeanDocumentos(int folio, int id_empleado, Date fechaIngreso, Date fecfaRespuesta, int estadoOficio, String departamento, InputStream archivo) {
        this.folio = folio;
        this.id_empleado = id_empleado;
        this.fechaIngreso = fechaIngreso;
        this.fecfaRespuesta = fecfaRespuesta;
        this.estadoOficio = estadoOficio;
        this.departamento = departamento;
        this.archivo = archivo;
    }



}
