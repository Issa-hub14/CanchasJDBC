/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.canchasjdbc;

import controlador.ControladorCancha;
import modelo.CanchaDAO;
import vista.VistaCancha;

/**
 *
 * @author isabe
 */
public class CanchasJDBC {

    public static void main(String[] args) {
        System.out.println("jdbc");
        
        VistaCancha vista = new VistaCancha();

        CanchaDAO dao = new CanchaDAO();

        ControladorCancha controlador = new ControladorCancha(vista, dao);

        controlador.iniciar();
    }
}
