package com.siso.SisoWeb1.Oficialia.Modelo;

import com.siso.SisoWeb1.Util.ConnectionMysql;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoDocumentos {

    //consultar la lista de documentos

    public List<BeanDocumentos> findAll(){
        List<BeanDocumentos> documentsList = new ArrayList<>();
        try(Connection con = ConnectionMysql.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from documentos;");
        ) {
            while (rs.next()){
                BeanDocumentos unDocument = new BeanDocumentos();
                unDocument.setFolio(rs.getInt("folio"));
                unDocument.setAsunto(rs.getString("asunto"));
                unDocument.setDepartamento(rs.getString("departamento"));
                unDocument.setEmpleado(rs.getInt("empleado"));
                unDocument.setEstadoOficio(rs.getString("estado"));
                unDocument.setFechaIngreso(rs.getDate("fechaEnvio"));
                unDocument.setFecfaRespuesta(rs.getDate("fechaResp"));
                documentsList.add(unDocument);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return documentsList;

    }

    //CREAR UN REGISTRO DE DOCUMENTO
    public boolean newDoc(BeanDocumentos unDocumento) {

        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("INSERT INTO documentos (folio, asunto, departamento , empleado ,estado ,fechaEnvio ,fechaResp,archivo) VALUES (?,?,?,?,?,?,?,? );")) {
                pstm.setInt(1, unDocumento.getFolio());
                pstm.setString(2,unDocumento.getAsunto());
                pstm.setString(3, unDocumento.getDepartamento());
                pstm.setInt(4,unDocumento.getEmpleado());
                pstm.setString(5,unDocumento.getEstadoOficio());
                pstm.setDate(6, (Date) unDocumento.getFechaIngreso());
                pstm.setDate(7,(Date) unDocumento.getFecfaRespuesta());
                pstm.setBlob(8, unDocumento.getArchivo());
                return pstm.executeUpdate() == 1;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    //BORRAR EL DOCUMENTO
    public boolean delete (int folio ){
        try (Connection connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = connection.prepareStatement( "delete from documentos where (folio= ?)" );) {
                pstm.setInt(1,folio);
                pstm.executeUpdate();
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return false;

    }
    //METODO PARA BUSCAR EL REGISTRO DE UN DOCUMENTO

    public BeanDocumentos search(int folio){
        BeanDocumentos unDocumento = new BeanDocumentos();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select * from oficios where Folio = ?; ");) {

                pstm.setInt(1, folio);
                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()){
                    unDocumento.setFolio(resultado.getInt("folio"));
                    unDocumento.setAsunto(resultado.getString("asunto"));
                    unDocumento.setDepartamento(resultado.getString("departamento"));
                   unDocumento.setEmpleado(resultado.getInt("empleado"));
                   unDocumento.setEstadoOficio(resultado.getString("estado"));
                   unDocumento.setFechaIngreso(resultado.getDate("fechaEnvio"));
                   unDocumento.setFecfaRespuesta(resultado.getDate("fechaResp"));

                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        System.out.println(unDocumento);
        return unDocumento;

    }





//METDOD PARA OBTENER EL ARCHVIVO POR MEDIO DEL ID
    public Blob getPdf(int folio) {

        Blob archiv = null;

        try (Connection con = ConnectionMysql.getConnection();) {

            try (PreparedStatement pstm = con.prepareStatement("select archivo from documentos where folio =?;");) {

                pstm.setInt(1, folio);
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    archiv = rs.getBlob("archivo");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return archiv;

    }

    public List<BeanDocumentos> findAux(int empleado) {
        List<BeanDocumentos>auxLista = new ArrayList<>();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select documentos.folio, documentos.asunto from documentos where empleado =? ");) {

                pstm.setInt(1, empleado);
                ResultSet resultado = pstm.executeQuery();
                while (resultado.next()){
                    BeanDocumentos docAux = new BeanDocumentos();
                    docAux.setFolio(resultado.getInt("folio"));
                    docAux.setAsunto(resultado.getString("asunto"));
                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        System.out.println(auxLista);
        return auxLista;
    }
}
