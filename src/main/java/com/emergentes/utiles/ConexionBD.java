
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    /*Driver es la ruta de la clase Driver*/
    String driver = "com.mysql.jdbc.Driver";

    /*Para hacer la conexion*/
    String url = "jdbc:mysql://localhost:3306/bd_biblioteca";
    String usuario = "root";
    String password = "";
    
    Connection connection = null;
    
    public ConexionBD(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, password);
            
            if (connection != null) {
                System.out.println("Conexion OK: " + connection);
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver: " + e.getMessage());
            
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());

        }
        
    }
    
    
    
    public Connection conectar(){
        return connection;
    }
    
    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
            
        }
    }
    
}
