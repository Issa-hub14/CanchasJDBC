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

}
