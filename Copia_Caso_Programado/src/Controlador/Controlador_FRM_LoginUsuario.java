/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FRM_LoginUsuario;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MenuPrincipal;
import Modelo.MetodosUsuario;
import Modelo.XML_Usuarios;
import Modelo.MetodosConexionBD1;
import Modelo.Manejador_Ventanas;
import Modelo.ArchivosUsuario;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_LoginUsuario implements ActionListener{

    //Se declaran las variables de la clase
    String sistemaInfo = "";
    
    //Referencias
    FRM_LoginUsuario fRM_LoginUsuario;
    ArchivosUsuario archivosUsuario;
    MetodosUsuario metodosUsuario;
    FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios;
    XML_Usuarios xML_Usuarios;
    MetodosConexionBD1 metodosConexionBD1;
    Manejador_Ventanas manejador_Ventanas;
    
    /**
     * Constructor de la clase
     */
    public Controlador_FRM_LoginUsuario(FRM_LoginUsuario fRM_LoginUsuario, String sistemaInfo, MetodosConexionBD1 metodosConexionBD1) {
        
        this.metodosConexionBD1 = metodosConexionBD1;
        this.sistemaInfo = sistemaInfo;
        this.fRM_LoginUsuario = fRM_LoginUsuario;

        
    }//Fin del constructor de la clase
    
    public void actionPerformed(ActionEvent evt) {
        
        if(evt.getActionCommand().equals("Entrar"))
        switch(this.sistemaInfo) {
            
            //En caso que fuera "ArchivosPlanos"
            case "ArchivosPlanos":
                    

                
                break;
                
            //En caso que fuera archivosXML
            case "XML":

                System.out.println("XML");
                
                break;
            
            //En caso que fuera Bases_de_Datos
            case "Bases_de_Datos":

                
                
                break;
                
        }//Fin del switch
        
    }    
    
}//Fin de la clase Controlador_FRM_LoginUsuario
