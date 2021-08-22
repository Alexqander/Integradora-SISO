package com.siso.SisoWeb1.Oficialia.Modelo;

public class BeanEmpleados {
    private int id;
    private int id_Empleado ;
    private String id_cargo ;
    private String id_depto ;
    private String contraseña;
    private String nombre  ;
    private String apellido_paterno  ;
    private String apellido_materno  ;
    private String email;

    public BeanEmpleados(){

    }

    public BeanEmpleados(int id, int id_Empleado, String id_cargo, String id_depto, String contraseña, String nombre, String apellido_paterno, String apellido_materno, String email) {
        this.id = id;
        this.id_Empleado = id_Empleado;
        this.id_cargo = id_cargo;
        this.id_depto = id_depto;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getId_depto() {
        return id_depto;
    }

    public void setId_depto(String id_depto) {
        this.id_depto = id_depto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

