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

    public int mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Registrar nueva cancha");
        System.out.println("2. Actualizar cancha existente");
        System.out.println("3. Eliminar cancha existente");
        System.out.println("4. Salir");

        System.out.print("Seleccione una opcion: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirNombre() {
        System.out.print("Ingrese el nombre de la cancha: ");
        return scanner.nextLine();
    }

    public String pedirDeporte() {
        System.out.print("Ingrese el deporte (ej. Futbol, Tenis): ");
        return scanner.nextLine();
    }

    public int pedirCapacidad() {
        System.out.print("Ingrese la capacidad (numero de jugadores): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int pedirId() {
        System.out.print("Ingrese el ID de la cancha: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">>> " + mensaje);
    }
}
