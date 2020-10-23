package mx.uv.basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DAO {
    private static Conexion conexion = new Conexion();

    public static List<Usuarios> dameUsuarios(){
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Usuarios> resultado = new ArrayList<>();

        con = conexion.getConexion();

        try {
            String sql = "SELECT * FROM USUARIOS";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Usuarios u = new Usuarios(rs.getString(1), rs.getString(2), rs.getString("password"));
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stm = null;
            }
            try {
                con.close();
                System.out.println("Closed Connection");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public static String crearUsuarios(Usuarios usuario){
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        String mensaje = "";

        con = conexion.getConexion();

        try {
            String sql = "INSERT INTO USUARIOS (id, email, password) VALUES (?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, usuario.getId());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getPassword());

            if(stm.executeUpdate() > 0){
                mensaje = "El Usuario se agregó correctamente";
            } else{
                mensaje = "No se pudo crear al Usuario";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null){
                try{
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stm = null;
            }
            try {
                con.close();
                System.out.println("Closed Connection");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }
}