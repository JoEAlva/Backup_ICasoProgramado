/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_LoginUsuario;
import Modelo.ArchivosUsuario;
import Modelo.MetodosConexionBD1;
import Modelo.XML_Usuarios;
/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class Controlador_FRM_MantenimientoUsuarios implements ActionListener
{   
    //Se declaran las variables
    String sistemaInfo = "";
    
    // Referencias
    FRM_MantenimientoUsuarios frmmu;
    FRM_LoginUsuario fRM_LoginUsuario;
    public MetodosUsuario metodosUsuario;
    public ArchivosUsuario archivosUsuario;
    MetodosConexionBD1 conexionBD1;
    XML_Usuarios xML_Usuarios;
    
        
    // Contructor de la clase
    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios frmmu, String sistemaInfo, MetodosConexionBD1 conexionBD1) {
               
        //Se iguala sistemaInfo al valos sistemaInfo que entra por parámetro
        this.sistemaInfo = sistemaInfo;
        //Hace referencia a FRM_MantenimientoUsuarios
        this.frmmu=frmmu;

        
        
        archivosUsuario = new ArchivosUsuario();
        metodosUsuario  = new MetodosUsuario(archivosUsuario);
        
        if(archivosUsuario.cargarArchivoUsuario())
        {
             System.out.println("Se cargó el archivo usuario correctamente(controlador)");
        }
        else
        {
            //Si no existe archivo creado con
             System.out.println("Error al cargar el archivo usuario(controlador)");
        }

        //Iguala arrayUsuario a los valores retornados 
        metodosUsuario.arrayUsuario = archivosUsuario.leerArchivoUsuario();

        xML_Usuarios = new XML_Usuarios(this.frmmu);
    
        this.conexionBD1 = conexionBD1;
        this.conexionBD1.realizarConexion();

    }//Fin del constructor
    
    public void actionPerformed(ActionEvent e)
    {
        
        //Inicio del switch
        switch(this.sistemaInfo) {
            
            //En el caso que fuera ArchivosPlanos
            case "ArchivosPlanos":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(metodosUsuario.consultarUsuario(frmmu.devolverInfoUsuario())) {
                        
                        frmmu.mostrarInfoPantalla(metodosUsuario.devolverArregloUsuario());
                        frmmu.habilitarBotones();
                        frmmu.administrarCampos();

                        
                    }else {
                        
                        frmmu.habilitarAgregar();
                        frmmu.administrarCampos();
                        metodosUsuario.mensajeNoSeEncuentraUsuario();
                        
                    }
                                      
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    metodosUsuario.agregarUsuario(frmmu.devolverInfoUsuario());
                    metodosUsuario.mensajeUsuarioAgregado();
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialCampos();
                    frmmu.estadoInicialBotones();
                    
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    metodosUsuario.modificarUsuario(frmmu.devolverInfoUsuario());
                    metodosUsuario.mensajeModificado();
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialCampos();
                    frmmu.estadoInicialBotones();
                    
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    metodosUsuario.eliminarUsuario(frmmu.devolverIdUsuario());
                    metodosUsuario.mensajeUsuarioEliminado();
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialCampos();
                    frmmu.estadoInicialBotones();
                    
                }
                 
                break;
                //Fin del caso ArchivosPlanos
            
            //En el caso que fuera XML
            case "XML":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(xML_Usuarios.consultarInformacionDelXml(frmmu.devolverIdUsuario())) {
                        
                        frmmu.mostrarInfoPantalla(xML_Usuarios.getArregloInformacion());
                        frmmu.habilitarBotones();
                        frmmu.administrarCampos();
                        
                    }else {
                        
                        metodosUsuario.mensajeNoSeEncuentraUsuario();
                        frmmu.habilitarAgregar();
                        frmmu.administrarCampos();
                        
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    xML_Usuarios.guardarEnXML(frmmu.devolverInfoUsuario());
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialCampos();
                    frmmu.estadoInicialBotones();
                    metodosUsuario.mensajeUsuarioAgregado();
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    xML_Usuarios.modificarInformacionDelXml(frmmu.devolverInfoUsuario());
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialCampos();
                    frmmu.estadoInicialBotones();
                    metodosUsuario.mensajeModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    xML_Usuarios.eliminarInformacionDelXml(frmmu.devolverIdUsuario());
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialCampos();
                    frmmu.estadoInicialBotones();
                    metodosUsuario.mensajeUsuarioEliminado();
                    
                }            
                                
                break;
                //Fin del caso XML
            
            //En el caso que fuera Bases de Datos
            case "Bases_de_Datos":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(conexionBD1.consultarUsuario(frmmu.devolverIdUsuario())) {
                        
                        frmmu.mostrarInfoPantalla(conexionBD1.devolverArregloUsuar());
                        frmmu.habilitarBotones();
                        frmmu.administrarCampos();
                        
                        
                    }else {
                        
                        frmmu.habilitarAgregar();
                        frmmu.administrarCampos();
                        metodosUsuario.mensajeNoSeEncuentraUsuario();
                        
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    conexionBD1.registrarUsuario(frmmu.devolverInfoUsuario());
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialBotones();
                    frmmu.estadoInicialCampos();
                    metodosUsuario.mensajeUsuarioAgregado();
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    conexionBD1.actualizarUsuario(frmmu.devolverInfoUsuario());
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialBotones();
                    frmmu.estadoInicialCampos();
                    metodosUsuario.mensajeModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    conexionBD1.eliminarUsuario(frmmu.devolverInfoUsuario());
                    frmmu.limpiarCampos();
                    frmmu.estadoInicialBotones();
                    frmmu.estadoInicialCampos();
                    metodosUsuario.mensajeUsuarioEliminado();
                    
                }  
                
                break;
                //Fin del caso Bases de Datos
            
        }//Fin del switch
        
    }//Fin del método actionPerformed
    
}//Fin Controlador_FRM_MantenimientoUsuarios
