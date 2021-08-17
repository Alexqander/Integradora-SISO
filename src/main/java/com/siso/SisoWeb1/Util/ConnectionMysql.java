package com.siso.SisoWeb1.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/siso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "ALEXANDER",
                "PipO995410"
        );
    }

    public static void main(String args[]) {
        try {


            System.out.println("Abriendo conexion a base de datos......");

            Connection con = ConnectionMysql.getConnection();
            System.out.println("Conexion exitosa.....");
            con.close();
            System.out.println("Cerrando Conexion....");

        } catch (Exception ex) {

            System.out.println("Conexion fallida mi pana......");
            ex.printStackTrace();


        }


    }
}
