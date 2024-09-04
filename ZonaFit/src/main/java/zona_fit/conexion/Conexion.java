package zona_fit.conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        var baseDatos = "zona_fit";
        var url = "jdbc:mysql://localhost:3306/"+ baseDatos;
        var usuario = "root";
        var password = "Eysen@159";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (Exception e){
            System.out.println("Error en conexion a la DB" + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if (conexion !=null)
            System.out.println("Conexion exitosa" + conexion);
        else
            System.out.println("Error al conectarse");
    }
}
