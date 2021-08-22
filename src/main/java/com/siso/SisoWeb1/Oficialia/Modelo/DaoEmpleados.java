package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpleados {

    public List<BeanEmpleados> findAll(){
        List<BeanEmpleados> empleadosList = new ArrayList<>();
        try (Connection con = ConnectionMysql.getConnection();

             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("select * from empleados;");

        ){
            while (rs.next()){
                BeanEmpleados unEmpleado = new BeanEmpleados();
                unEmpleado.setId(rs.getInt("id"));
                unEmpleado.setId_Empleado(rs.getInt("id_empleado"));
                unEmpleado.setNombre(rs.getString("Nombre"));
                unEmpleado.setApellido_paterno(rs.getString("Apellido_Paterno"));
                unEmpleado.setApellido_materno(rs.getString("Apellido_Materno"));
                unEmpleado.setEmail(rs.getString("Email"));
                unEmpleado.setId_cargo(rs.getString("Depto"));
                unEmpleado.setId_cargo(rs.getString("Cargo"));
                System.out.println(unEmpleado);
                empleadosList.add(unEmpleado);

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return empleadosList;
    }

    public boolean saveEmpleado(BeanEmpleados unempleado) {

        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("INSERT INTO empleados (id,id_Empleado, Cargo, Depto,Contraseña,Nombre,Apellido_Paterno,Apellido_Materno,Email ) VALUES (?,?,?,?,?,?,?,?,? );")) {
                pstm.setInt(1,unempleado.getId());
                pstm.setInt(2,unempleado.getId_Empleado());
                pstm.setString(3,unempleado.getId_cargo());
                pstm.setString(4,unempleado.getId_depto());
                pstm.setString(5,unempleado.getContraseña());
                pstm.setString(6,unempleado.getNombre());
                pstm.setString(7,unempleado.getApellido_paterno());
                pstm.setString(8,unempleado.getApellido_paterno());
                pstm.setString(9,unempleado.getEmail());
                return pstm.executeUpdate() == 1;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
    public BeanEmpleados BuscarConId(int Id_Empleado){
        BeanEmpleados unempleado = new BeanEmpleados();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select * from empleados where id = ?; ");) {
                pstm.setInt(1, Id_Empleado );
                ResultSet resultado = pstm.executeQuery();

                while (resultado.next()){
                    unempleado.setId(resultado.getInt("id"));
                    unempleado.setId_Empleado(resultado.getInt("id_Empleado"));
                    unempleado.setId_cargo(resultado.getString("Cargo"));
                    unempleado.setContraseña(resultado.getString("Contraseña"));
                    unempleado.setId_depto(resultado.getString("Depto"));
                    unempleado.setNombre(resultado.getString("Nombre"));
                    unempleado.setApellido_paterno(resultado.getString("Apellido_Paterno"));
                    unempleado.setApellido_materno(resultado.getString("Apellido_Materno"));
                    unempleado.setId_depto(resultado.getString("Email"));
                }
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        return unempleado;
    }

    public boolean modificarUsuario (BeanEmpleados empleadoModificar ){
        try (Connection connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = connection.prepareStatement("update empleados set id_Empleado = ?, Cargo = ?, Depto = ? , Contraseña = ?, Nombre = ?, Apellido_Paterno=?,  Apellido_Materno=?,Email= ? where id=?" );) {
                pstm.setInt(1,empleadoModificar.getId_Empleado());
                pstm.setString(2,empleadoModificar.getId_cargo());
                pstm.setString(3,empleadoModificar.getId_depto());
                pstm.setString(4,empleadoModificar.getContraseña());
                pstm.setString(5,empleadoModificar.getNombre());
                pstm.setString(6,empleadoModificar.getApellido_paterno());
                pstm.setString(7,empleadoModificar.getApellido_materno());
                pstm.setString(8,empleadoModificar.getEmail());
                pstm.setInt(9,empleadoModificar.getId());
                return  pstm.executeUpdate()==1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean deleteUser (int id_empl ){
        try (Connection connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM empleados WHERE (id =?);" );) {
                pstm.setInt(1,id_empl);
               pstm.executeUpdate();
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;
    }





}
