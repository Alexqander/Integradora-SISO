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
