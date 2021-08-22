package com.siso.SisoWeb1.Oficialia.Modelo;

public class BeanUsuarios {

    private int iduser;
    private int id_empleadoU;
    private String username;
    private String password;
    private String rol;
    private String nombre;

    public BeanUsuarios(){

    }

    public BeanUsuarios(int iduser, int id_empleadoU, String username, String password, String rol, String nombre) {
        this.iduser = iduser;
        this.id_empleadoU = id_empleadoU;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.nombre = nombre;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getId_empleadoU() {
        return id_empleadoU;
    }

    public void setId_empleadoU(int id_empleadoU) {
        this.id_empleadoU = id_empleadoU;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
