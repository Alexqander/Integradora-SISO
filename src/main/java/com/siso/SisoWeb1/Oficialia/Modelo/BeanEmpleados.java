package com.siso.SisoWeb1.Oficialia.Modelo;

public class BeanEmpleados {
    private int id_Empleado ;
    private int id_cargo ;
    private int id_depto ;
    private String contraseña;
    private String Nombre  ;
    private String Apellido_paterno  ;
    private String Apellido_materno  ;
    private String Email;

    public BeanEmpleados(){

    }

    public BeanEmpleados(int id_Empleado, int id_cargo, int id_depto, String contraseña, String nombre, String apellido_paterno, String apellido_materno, String email) {
        this.id_Empleado = id_Empleado;
        this.id_cargo = id_cargo;
        this.id_depto = id_depto;
        this.contraseña = contraseña;
        Nombre = nombre;
        Apellido_paterno = apellido_paterno;
        Apellido_materno = apellido_materno;
        Email = email;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_depto() {
        return id_depto;
    }

    public void setId_depto(int id_depto) {
        this.id_depto = id_depto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido_paterno() {
        return Apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        Apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return Apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        Apellido_materno = apellido_materno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

