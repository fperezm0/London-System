package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kike
 */
public class Conexion {

    /**
     *
     * Metodo para hacer la conexion a la base de datos
     */
    public static Connection getConexion() {
        try {
            // la conexion a la base de datos con las especificaciones que es tipo de Base que usara, puertos, version, usuario y contraseña 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "London_system", "123456");
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }

    }
}
