/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.FRM_MenuPrincipal;
import Vista.FRM_SistemaInformacion;
import Vista.FRM_LoginUsuario;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class Manejador_Ventanas {

    //Referencias 
    FRM_MenuPrincipal frmmp; //Referencia a ala clase FRM_MenuPrincipal
    FRM_SistemaInformacion frmsi;//Referencia a la clase FRM_SistemaInformacion
    FRM_LoginUsuario frmlu;//Referencia a la clase FRM_LoginUsuario


    //Constructor de la clase
    public Manejador_Ventanas(FRM_MenuPrincipal frmmp, FRM_SistemaInformacion frmsi) {
        
        this.frmmp = frmmp;
        this.frmsi = frmsi;
        
        
    }//Fin del constructor de la clase
    
    /*
    Método que muestra la ventana de sistema de información la primera vez
    oculta el menú principal
    */
    public void mostrarFRM_SistemaInformacion() {
        
        frmsi.setVisible(true);
        frmmp.setVisible(false);
        
    }
    
    /*
    Método que muestra la ventana de sistema de información la primera vez
    oculta el menú principal
    */
    public void mostrarFRM_MenuPrincipal() {
        
        
        frmmp.setVisible(true);
        
    }
    
}//Fin de Manejador_Ventanas
