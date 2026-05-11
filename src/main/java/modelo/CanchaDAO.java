/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author isabe
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CanchaDAO {
     public boolean guardarCancha(Cancha cancha) {
        String sql = "INSERT INTO canchas (nombre, deporte, capacidad) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cancha.getNombre());
            pstmt.setString(2, cancha.getDeporte());
            pstmt.setInt(3, cancha.getCapacidad());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se guardó

        } catch (SQLException e) {
            System.out.println("Error en la BD: " + e.getMessage());
            return false;
        }
    }
}
