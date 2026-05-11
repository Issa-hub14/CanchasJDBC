/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author isabe
 */
public class Cancha {

    private String nombre;
    private String deporte;
    private int capacidad;

    public Cancha(String nombre, String deporte, int capacidad) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
