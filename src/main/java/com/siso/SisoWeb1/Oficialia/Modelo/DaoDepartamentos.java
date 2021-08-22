package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoDepartamentos {

    public List<BeanDepartamentos> findAll(){
        List<BeanDepartamentos> departmentList = new ArrayList<>();
        try (Connection con = ConnectionMysql.getConnection();

             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("select * from departamentos;");

        ){

            while (rs.next()){
                BeanDepartamentos unDepartment = new BeanDepartamentos();
                unDepartment.setId_departamento(rs.getInt("Id_Departamento"));
                unDepartment.setNombreDepto(rs.getString("NombreDepto"));
                unDepartment.setNumeroEdificio(rs.getInt("NumeroEdificio"));
                departmentList.add(unDepartment);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return departmentList;
    }



    public boolean GuardarDepartamento(BeanDepartamentos unDepartamento) {

        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("INSERT INTO departamentos (Id_Departamento, NombreDepto, NumeroEdificio) VALUES (?,?,? );")) {
                pstm.setInt(1, unDepartamento.getId_departamento());
                pstm.setString(2, unDepartamento.getNombreDepto());
                pstm.setInt(3, unDepartamento.getNumeroEdificio());
                return pstm.executeUpdate() == 1;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public BeanDepartamentos BuscarConId(int Id_Departamento){
        BeanDepartamentos unDepartamento = new BeanDepartamentos();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select * from departamentos where Id_Departamento = ?; ");) {

                pstm.setInt(1, Id_Departamento);
                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()){
                    unDepartamento.setId_departamento(resultado.getInt("Id_Departamento"));
                    unDepartamento.setNombreDepto(resultado.getString("NombreDepto"));
                    unDepartamento.setId_departamento(resultado.getInt("NumeroEdificio"));
                }



            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        return unDepartamento;
    }


    public boolean ModificarDepartamento (BeanDepartamentos departamentosModificado ){
        try (Connection connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = connection.prepareStatement( "update departamentos set NombreDepto = ?, NumeroEdificio = ?, where Id_Departamento" );) {
                pstm.setString(1,departamentosModificado.getNombreDepto());
                pstm.setInt(2,departamentosModificado.getNumeroEdificio());
                pstm.setInt(3,departamentosModificado.getId_departamento());
                return  pstm.executeUpdate()==1;
            }catch (SQLException ex){
               ex.printStackTrace();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;

    }
    public boolean deleteDepa (int id_dep ){
        try (Connection connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = connection.prepareStatement( "delete departamentos where Id_Departamento="+id_dep );) {
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
