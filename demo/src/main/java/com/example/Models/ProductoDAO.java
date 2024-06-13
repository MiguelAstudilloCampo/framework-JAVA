package com.example.Models;

import java.sql.Connection;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.Connections.DatabaseConnection;

public class ProductoDAO {

    public void TraerClases() {
        Connection conexion = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conexion = DatabaseConnection.getConnection();
            if (conexion != null) {
                stmt = conexion.createStatement();
                String sql = "SELECT * FROM electrodomesticos";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Descripcion: " + descripcion);
                }
            } else {
                System.out.println("Fallo al conectar.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conexion != null)
                    conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
