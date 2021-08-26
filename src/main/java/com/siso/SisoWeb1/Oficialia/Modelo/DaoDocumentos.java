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
            try (PreparedStatement pstm = Connection.prepareStatement("INSERT INTO documentos (folio, asunto, departamento  ,estado ,archivo,nombreArchi) VALUES (?,?,?,?,?,? );")) {
                pstm.setInt(1, unDocumento.getFolio());
                pstm.setString(2,unDocumento.getAsunto());
                pstm.setString(3, unDocumento.getDepartamento());
                pstm.setString(4,unDocumento.getEstadoOficio());
                pstm.setBlob(5, unDocumento.getArchivo());
                pstm.setString(6, unDocumento.getNombreArchivo());
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
    public BeanDocumentos getPdf(int folio) {

        BeanDocumentos docu = new BeanDocumentos();

        Blob archiv = null;

        try (Connection con = ConnectionMysql.getConnection();) {

            try (PreparedStatement pstm = con.prepareStatement("select archivo,nombreArchi from documentos where folio =?;");) {

                pstm.setInt(1, folio);
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    docu.setArchivo1(rs.getBlob("archivo"));
                    docu.setNombreArchivo(rs.getString("nombreArchi"));


                }
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return docu;

    }

    public List<BeanDocumentos> findAux(int empleado) {
        List<BeanDocumentos>auxLista = new ArrayList<>();
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select folio,asunto from documentos where empleado =? ");) {

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

    public int docsAssi (String estado){
        int contador =0;
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select folio from  documentos where estado =? ");) {
                pstm.setString(1,estado);
                ResultSet resultado = pstm.executeQuery();

                while (resultado.next()){
                    contador = contador+1;

                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        System.out.println(contador);
        return contador;
    }
    public int todosDocus (){
        int contador =0;
        try (Connection Connection = ConnectionMysql.getConnection();) {
            try (PreparedStatement pstm = Connection.prepareStatement("select folio from documentos;");) {
                ResultSet resultado = pstm.executeQuery();

                while (resultado.next()){
                    contador = contador+1;

                }

            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }catch (SQLException exception){
            exception.printStackTrace();

        }
        System.out.println(contador);
        return contador;
    }


}
