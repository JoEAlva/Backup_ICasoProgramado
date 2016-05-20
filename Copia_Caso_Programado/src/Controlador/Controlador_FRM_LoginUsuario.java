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
import Modelo.MetodosUsuario;
import Modelo.XML_Usuarios;
import Modelo.MetodosConexionBD1;
import Modelo.Manejador_Ventanas;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_LoginUsuario implements ActionListener{

    //Se declaran las variables de la clase
    String sistemaInfo = "";
    
    //Referencias
    FRM_LoginUsuario fRM_LoginUsuario;
    MetodosUsuario metodosUsuario;
    FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios;
    XML_Usuarios xML_Usuarios;
    MetodosConexionBD1 metodosConexionBD1;
    Manejador_Ventanas manejador_Ventanas;
    
    /**
     * Constructor de la clase
     */
    public Controlador_FRM_LoginUsuario(FRM_LoginUsuario fRM_LoginUsuario, String sistemaInfo, MetodosConexionBD1 metodosConexionBD1, MetodosUsuario metodosUsuario, FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios, Manejador_Ventanas manejador_Ventanas) {
       
        this.manejador_Ventanas = manejador_Ventanas;
        this.fRM_MantenimientoUsuarios = fRM_MantenimientoUsuarios;
        this.metodosUsuario = metodosUsuario;
        this.metodosConexionBD1 = metodosConexionBD1;
        this.fRM_LoginUsuario = fRM_LoginUsuario;
        this.sistemaInfo = sistemaInfo;
        
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        
        if(evt.getActionCommand().equals("Entrar"))
        switch(this.sistemaInfo) {
            
            //En caso que fuera "ArchivosPlanos"
            case "ArchivosPlanos":
                
                if(metodosUsuario.verificarUsuario(fRM_LoginUsuario.getInfoLogin())) {
                    manejador_Ventanas.mostrarFRM_MenuPrincipal();                    
                }else {
                    metodosUsuario.mensajeNoSeEncuentraUsuario();
                }
                
                
                break;
                
            //En caso que fuera archivosXML
            case "XML":
                
                
                
                break;
            
            //En caso que fuera Bases_de_Datos
            case "Bases_de_Datos":
                
                if(evt.getActionCommand().equals("Entrar")) {
                    
                    
                    
                }
                
                break;
                
        }//Fin del switch
        
    }    
    
}//Fin de la clase Controlador_FRM_LoginUsuario
