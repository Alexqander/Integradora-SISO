package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAux {

    public List<BeanDocumentos>findAll(int folio){
        List<BeanDocumentos>auxList = new ArrayList<>();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select folio, asunto from documentos where empleado = ? and estado='Asignado'; ");) {
                pstm.setInt(1,folio);
                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()){
                    BeanDocumentos auxDoc = new BeanDocumentos(
                            resultado.getInt("folio"),
                            resultado.getString("asunto")
                    );
                    auxList.add(auxDoc);
                    System.out.println(auxDoc);
                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        System.out.println(auxList);
        return auxList;

    }

    public List<BeanDocumentos> findDp(String departamento) {
        List<BeanDocumentos>rpList = new ArrayList<>();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select folio, asunto,departamento from documentos where departamento = ? and estado ='Enviado'; ");) {
               pstm.setString(1,departamento);
                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()){
                    BeanDocumentos rpDoc = new BeanDocumentos(
                            resultado.getInt("folio"),
                            resultado.getString("asunto")
                    );
                    rpList.add(rpDoc);
                    System.out.println(rpDoc);
                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        System.out.println(rpList);
        return rpList;

    }
    public List<BeanEmpleados> findAux(String cargo ,String depto) {
        List<BeanEmpleados>auxList = new ArrayList<>();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select Nombre, id_Empleado,Depto  from empleados where Cargo= ? and Depto=? ; ");) {
                pstm.setString(1,cargo);
                pstm.setString(2,depto);
                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()){
                    BeanEmpleados auxi = new BeanEmpleados(
                            resultado.getInt("id_Empleado"),
                            resultado.getString("Depto"),
                            resultado.getString("Nombre")
                    );
                    auxList.add(auxi);
                    System.out.println(auxi);
                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        System.out.println(auxList);
        return auxList;

    }

    //METODO PARA ASIGNAR UN DOCUMENTO
    public boolean asignar(BeanDocumentos docAsig) {
        try (Connection connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = connection.prepareStatement( "update documentos set empleado = ? ,estado =? WHERE folio=?;" );) {
                pstm.setInt(1,docAsig.getEmpleado());
                pstm.setString(2,docAsig.getEstadoOficio());
                pstm.setInt(3,docAsig.getFolio());
                return  pstm.executeUpdate()==1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    //METDODO PARA RESPONDER
    public boolean responder(BeanDocumentos docRes) {
        try (Connection connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = connection.prepareStatement( "update documentos set estado =? WHERE folio=?;" );) {
                pstm.setString(1,docRes.getEstadoOficio());
                pstm.setInt(2,docRes.getFolio());
                return  pstm.executeUpdate()==1;
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }



}
