package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUsuarios {
    public BeanUsuarios login (String username , String password) {
        BeanUsuarios unUser = new BeanUsuarios();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select * from usuarios where username = ? and clave = ?; ");) {


                pstm.setString(1, username);
                pstm.setString(2, password);
                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()) {
                    unUser.setIduser(resultado.getInt("idusuarios"));
                    unUser.setId_empleadoU(resultado.getInt("id_empleado"));
                    unUser.setUsername(resultado.getString("username"));
                    unUser.setPassword(resultado.getString("clave"));
                    unUser.setRol(resultado.getString("rol"));
                    unUser.setNombre(resultado.getString("nombre"));

                }

            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();

        }
        return unUser;

    }

}
