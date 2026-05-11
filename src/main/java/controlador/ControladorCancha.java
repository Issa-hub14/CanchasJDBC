/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author isabe
 */
import modelo.Cancha;
import modelo.CanchaDAO;
import vista.VistaCancha;

public class ControladorCancha {

    private VistaCancha vista;
    private CanchaDAO modeloDAO;

    public ControladorCancha(VistaCancha vista, CanchaDAO modeloDAO) {
        this.vista = vista;
        this.modeloDAO = modeloDAO;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarNuevaCancha();
                    break;

                case 2:
                    editarCancha();
                    break;

                case 3:
                    eliminarCancha();
                    break;

                case 4:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida");
            }
        } while (opcion != 4);
    }

    public void registrarNuevaCancha() {
        vista.mostrarMensaje("--- REGISTRO DE NUEVA CANCHA ---");

        String nombre = vista.pedirNombre();
        String deporte = vista.pedirDeporte();
        int capacidad = vista.pedirCapacidad();

        Cancha nuevaCancha = new Cancha(nombre, deporte, capacidad);

        boolean exito = modeloDAO.guardarCancha(nuevaCancha);

        if (exito) {
            vista.mostrarMensaje("¡La cancha ha sido registrada exitosamente en MySQL!");
        } else {
            vista.mostrarMensaje("Ocurrió un error al intentar registrar la cancha.");
        }
    }

    public void editarCancha() {
        vista.mostrarMensaje("--- ACTUALIZAR DATOS DE CANCHA ---");

        int id = vista.pedirId();
        String nombre = vista.pedirNombre();
        String deporte = vista.pedirDeporte();
        int capacidad = vista.pedirCapacidad();

        Cancha canchaActualizada = new Cancha(nombre, deporte, capacidad);

        boolean exito = modeloDAO.editarCancha(id, canchaActualizada);

        if (exito) {
            vista.mostrarMensaje("¡La cancha ha sido actualizada exitosamente en MySQL!");
        } else {
            vista.mostrarMensaje("Ocurrió un error al intentar actualizar la cancha.");
        }
    }

    public void eliminarCancha() {
        vista.mostrarMensaje("--- ELIMINAR CANCHA ---");

        int id = vista.pedirId();

        boolean exito = modeloDAO.eliminarCancha(id);

        if (exito) {
            vista.mostrarMensaje("¡La cancha ha sido eliminada exitosamente en MySQL!");
        } else {
            vista.mostrarMensaje("Ocurrió un error al intentar eliminar la cancha.");
        }
    }

}
