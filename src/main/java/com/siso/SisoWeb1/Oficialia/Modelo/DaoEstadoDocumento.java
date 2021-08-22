package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoEstadoDocumento {

    public BeanEstadoDocumento BuscarConId(int Estado){
        BeanEstadoDocumento unEstado = new BeanEstadoDocumento();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select * from estadooficio where Estado = ?; ");) {

                pstm.setInt(1, Estado);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()){
                    unEstado.setEstado(rs.getInt("Estado"));
                    unEstado.setNombre(rs.getString("Nombre"));
                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        return unEstado;
    }

}
