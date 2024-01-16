package com24.biswo.factoryClass;
import java.sql.*;
public class ConnectionFactory {

    private static  Connection con = null;

    static  {
       try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bishnu");
       }catch (Exception e) {
            e.printStackTrace();
       }
    }

    public static Connection getConnection() {
        return con;
    }
    
    public static void cleanUp() {
        try {
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
