/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.imageio.plugins.jpeg.JPEG;
import vista.FRM_VentanaNodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosNodo;

/**
 *
 * @author JorgeIgnacio
 */
public class Ctr_FRM_VentanaNodos implements ActionListener{
    
    //Referencias de la clase
    FRM_VentanaNodos fRM_VentanaNodos;
    MetodosNodo metodosNodo;
    
    //Constructor de la clase    
    public Ctr_FRM_VentanaNodos(FRM_VentanaNodos ventanaNodos) {
        this.fRM_VentanaNodos = ventanaNodos;
        metodosNodo = new MetodosNodo();
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("CrearLista")) {
            fRM_VentanaNodos.getCantidad();
            metodosNodo.crear(fRM_VentanaNodos.getCantidad());
            fRM_VentanaNodos.limpiarInterfaz();
            fRM_VentanaNodos.imprimirEnTextArea(metodosNodo.imprimir());
            
        }
        
        if(e.getActionCommand().equals("AgregarFinal")) {
            metodosNodo.agregarAlFinal(Integer.parseInt(fRM_VentanaNodos.getAgregarAlFinal()));
            fRM_VentanaNodos.limpiarInterfaz();
            fRM_VentanaNodos.imprimirEnTextArea(metodosNodo.imprimir());
        }
        
        if(e.getActionCommand().equals("Modificar")) {
            metodosNodo.modificar(fRM_VentanaNodos.datoModificar(), fRM_VentanaNodos.datoNuevo());
            fRM_VentanaNodos.limpiarInterfaz();
            fRM_VentanaNodos.imprimirEnTextArea(metodosNodo.imprimir());
        }
        
        if(e.getActionCommand().equals("Eliminar")) {
            metodosNodo.eliminar(fRM_VentanaNodos.getDatoEliminar());
            fRM_VentanaNodos.limpiarInterfaz();
            fRM_VentanaNodos.imprimirEnTextArea(metodosNodo.imprimir());
        }
        
        if(e.getActionCommand().equals("MenorMayor")) {
            metodosNodo.ordenarMenorAMayor();
            fRM_VentanaNodos.limpiarInterfaz();
            fRM_VentanaNodos.imprimirEnTextArea(metodosNodo.imprimir());
        }
        
        if(e.getActionCommand().equals("MayorMenor")) {
            metodosNodo.ordenarMayorAMenor();
            fRM_VentanaNodos.limpiarInterfaz();
            fRM_VentanaNodos.imprimirEnTextArea(metodosNodo.imprimir());
        }
        
    }
    
}
