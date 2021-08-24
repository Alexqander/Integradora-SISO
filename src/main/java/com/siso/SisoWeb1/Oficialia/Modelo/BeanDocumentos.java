package com.siso.SisoWeb1.Oficialia.Modelo;

import java.io.InputStream;
import java.util.Date;

public class BeanDocumentos {

    private int folio;
    private String asunto;
    private String departamento;
    private int empleado;
    private String estadoOficio;
    private Date fechaIngreso;
    private Date fecfaRespuesta;
    private InputStream archivo;

    public BeanDocumentos(){

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

    public BeanDocumentos(int folio, String asunto, String departamento, int empleado, String estadoOficio, Date fechaIngreso, Date fecfaRespuesta) {
        this.folio = folio;
        this.asunto = asunto;
        this.departamento = departamento;
        this.empleado = empleado;
        this.estadoOficio = estadoOficio;
        this.fechaIngreso = fechaIngreso;
        this.fecfaRespuesta = fecfaRespuesta;
    }

    public BeanDocumentos(int folio, String asunto, String departamento, int empleado, String estadoOficio, Date fechaIngreso, Date fecfaRespuesta, InputStream archivo) {
        this.folio = folio;
        this.asunto = asunto;
        this.departamento = departamento;
        this.empleado = empleado;
        this.estadoOficio = estadoOficio;
        this.fechaIngreso = fechaIngreso;
        this.fecfaRespuesta = fecfaRespuesta;
        this.archivo = archivo;
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

    public InputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(InputStream archivo) {
        this.archivo = archivo;
    }
}
