/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FRM_LoginUsuario;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_LoginUsuario implements ActionListener{

    //Se declaran las variables de la clase
    String sistemaInfo = "";
    
    //Referencias
    FRM_LoginUsuario fRM_LoginUsuario;
    /**
     * Constructor de la clase
     */
    public Controlador_FRM_LoginUsuario(FRM_LoginUsuario fRM_LoginUsuario, String sistemaInfo) {
        
        this.fRM_LoginUsuario = fRM_LoginUsuario;
        this.sistemaInfo = sistemaInfo;
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        
        switch(this.sistemaInfo) {
            
            //En caso que fuera "ArchivosPlanos"
            case "ArchivosPlanos":
                
                
                
                break;
                
            //En caso que fuera archivosXML
            case "XML":
                
                
                
                break;
            
            //En caso que fuera Bases_de_Datos
            case "Bases_de_Datos":
                
                
                
                break;
                
        }//Fin del switch
        
    }    
    
}//Fin de la clase Controlador_FRM_LoginUsuario
