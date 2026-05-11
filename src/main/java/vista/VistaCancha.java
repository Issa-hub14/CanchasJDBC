/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author isabe
 */
public class VistaCancha {

    private Scanner scanner;

    public VistaCancha() {
        scanner = new Scanner(System.in);
    }

    public String pedirNombre() {
        System.out.print("Ingrese el nombre de la cancha: ");
        return scanner.nextLine();
    }

    public String pedirDeporte() {
        System.out.print("Ingrese el deporte (ej. Fútbol, Tenis): ");
        return scanner.nextLine();
    }

    public int pedirCapacidad() {
        System.out.print("Ingrese la capacidad (número de jugadores): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">>> " + mensaje);
    }
}
