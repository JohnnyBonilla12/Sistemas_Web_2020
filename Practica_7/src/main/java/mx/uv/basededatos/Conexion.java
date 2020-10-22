package mx.uv.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/sistemas_web";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "admin";
    private static Connection conexion = null;

    //DEspues del nombre de la base de Datos, si hay problemas de SSL
    //?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";

    public static Connection getConexion(){
        try{
            Class.forName(driverName);
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Succes Connection");
        } catch (SQLException e){
            System.out.println("Failed to create Connection.");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Driver not found.");
        }
        return conexion;
    }
}