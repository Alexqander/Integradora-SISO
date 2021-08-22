package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCargos {

    public BeanCargos BuscarConId(int Id_Cargo){
        BeanCargos unCargo = new BeanCargos();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select * from cargos where Id_Cargos = ?; ");) {

                pstm.setInt(1, Id_Cargo);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()){
                    unCargo.setId_cargo(rs.getInt("Id_Cargo"));
                    unCargo.setNombre(rs.getString("Nombre"));
                }



            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        return unCargo;
    }


    public List<BeanCargos> findAll() {
        List<BeanCargos> cargosList = new ArrayList<>();
        try (Connection con = ConnectionMysql.getConnection();

             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("select * from cargos;");

        ){

            while (rs.next()){
                BeanCargos unCargo = new BeanCargos();
                unCargo.setId_cargo(rs.getInt("Id_Cargo"));
                unCargo.setNombre(rs.getString("Nombre"));
                cargosList.add(unCargo);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return cargosList;

    }
}
