package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoDocumentos {

    public List<BeanDocumentos> findAll(){
        List<BeanDocumentos> documentsList = new ArrayList<>();
        try(Connection con = ConnectionMysql.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from documentos;");
        ) {
            while (rs.next()){
                BeanDocumentos unDocument = new BeanDocumentos();
                unDocument.setFolio(rs.getInt("Folio"));
                unDocument.setFechaIngreso(rs.getDate("Fecha_ingre"));
                unDocument.setDepartamento(rs.getString("Departamento"));
                unDocument.setId_empleado(rs.getInt("Id_Empleado"));
                unDocument.setFecfaRespuesta(rs.getDate("Fecha_Resp"));
                unDocument.setEstadoOficio(rs.getInt("EstadoOficio_Estado"));
                documentsList.add(unDocument);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return documentsList;

    }

    public Blob getFileByDocument (int Folio) {
        Blob archivo = null;

        try(Connection con = ConnectionMysql.getConnection();) {
            try(PreparedStatement pstm = con.prepareStatement("select  * from oficios where Folio = ?;");) {

                pstm.setInt(1,Folio);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()){
                    archivo = rs.getBlob("archivo");
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        } catch (SQLException ex){
            ex.printStackTrace();

        }
        return archivo;
    }

}
