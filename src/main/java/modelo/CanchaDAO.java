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
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class CanchaDAO {

    public boolean guardarCancha(Cancha cancha) {
        String sql = "INSERT INTO canchas (nombre, deporte, capacidad) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cancha.getNombre());
            pstmt.setString(2, cancha.getDeporte());
            pstmt.setInt(3, cancha.getCapacidad());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error en la BD: " + e.getMessage());
            return false;
        }
    }

    public boolean editarCancha(int id, Cancha cancha) {
        String sql = "UPDATE canchas SET nombre=?, deporte=?, capacidad=? WHERE id=?";

        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cancha.getNombre());
            pstmt.setString(2, cancha.getDeporte());
            pstmt.setInt(3, cancha.getCapacidad());
            pstmt.setInt(4, id);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error en la BD al actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCancha(int id) {
        String sql = "DELETE FROM canchas WHERE id=?";

        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error en la BD al eliminar: " + e.getMessage());
            return false;
        }
    }

    public List<Cancha> obtenerCanchas() {
        List<Cancha> lista = new ArrayList<>();
        String sql = "SELECT * FROM canchas";
        
        try (Connection conn = ConexionDB.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); 
                ResultSet resultado = pstmt.executeQuery()) {

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String deporte = resultado.getString("deporte");
                int capacidad = resultado.getInt("capacidad");
                Cancha cancha = new Cancha(id, nombre, deporte, capacidad);
                lista.add(cancha);
            }

        } catch (SQLException e) {
            System.out.println("Error en la BD al listar: " + e.getMessage());
        }

        return lista;
    }
}
