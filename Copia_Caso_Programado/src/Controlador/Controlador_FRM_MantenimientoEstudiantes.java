/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.MetodosConexionBD1;
import Modelo.ArchivosEstudiante;
import Modelo.XML_Estudiantes;
import Modelo.MetodosEstudiantes;
import Vista.FRM_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    //Se declaran las variables
    String sistemaInfo = "";
    
    //Referencias
    FRM_MantenimientoEstudiantes frmme;
    MetodosConexionBD1 conexionBD1;
    public MetodosEstudiantes metodosEstudiantes;
    ArchivosEstudiante estudianteArchivos;
    XML_Estudiantes mxml;
    
    //Constructor de la clase
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frmme, String sistemaInfo, MetodosConexionBD1 conexionBD1)
    {
        //Se iguala sistemaInfo al valos sistemaInfo que entra por parámetro
        this.sistemaInfo = sistemaInfo;
        //Hace referencia a FRM_MantenimientoEstudiantes
        this.frmme=frmme;
        
        estudianteArchivos = new ArchivosEstudiante();
        metodosEstudiantes = new MetodosEstudiantes(estudianteArchivos);

        if(estudianteArchivos.cargarInfoArchivoEstudiante())
        {
            System.out.println("Se cargó el archivo estudiante correctamente");
        }else
        {
            System.out.println("Error al cargar el archivo estudiante(controlador)");
        }

        //Iguala arrayUsuario a los valores retornados
        metodosEstudiantes.arrayEstudiantes = estudianteArchivos.leerInfoArchivoEstudiante();

        mxml = new XML_Estudiantes(this.frmme);

        this.conexionBD1 = conexionBD1;
        this.conexionBD1.realizarConexion();
             
    }//Fin del constructor de la clase
    
    /*
    Método que evalua las siguientes condiciones 
    */
    public void actionPerformed(ActionEvent e)
    {
       
        //Inicio del switch
        switch(this.sistemaInfo) {
            
            //En el caso que fuera ArchivosPlanos
            case "ArchivosPlanos":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(metodosEstudiantes.consultarEstudiante(frmme.devolverCedula())) {
                        
                        frmme.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                        frmme.administrarCampos();
                        frmme.habilitarBotones();
                        
                    }else {
                        
                        metodosEstudiantes.mensajeConsultar();
                        frmme.habilitarAgregar();
                        frmme.administrarCampos();
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    metodosEstudiantes.agregarEstudiante(frmme.devolverInformacion());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteAgregado();
                    
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    metodosEstudiantes.modificarEstudiante(frmme.devolverInformacion());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    metodosEstudiantes.eliminarEstudiante(frmme.devolverCedula());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteEliminado();
                    
                }
                 
                break;
                //Fin del caso ArchivosPlanos
            
            //En el caso que fuera XML
            case "XML":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(mxml.consultarInformacionDelXml(frmme.devolverCedula())) {
                        
                        frmme.mostrarInformacion(mxml.getArregloInformacion());
                        frmme.administrarCampos();
                        frmme.habilitarBotones();
                        
                    }else {
                        
                        metodosEstudiantes.mensajeConsultar();
                        frmme.habilitarAgregar();
                        frmme.administrarCampos();
                        
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    mxml.guardarEnXML(frmme.devolverInformacion());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteAgregado();
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    mxml.modificarInformacionDelXml(frmme.devolverInformacion());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    mxml.eliminarInformacionDelXml(frmme.devolverCedula());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteEliminado();
                    
                }
                
                break;
                //Fin del caso XML
            
            //En el caso que fuera Bases de Datos
            case "Bases_de_Datos":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(conexionBD1.consultarEstudiante(frmme.devolverCedula())) {
                        
                        frmme.mostrarInformacion(conexionBD1.devolverArregloEst());
                        frmme.administrarCampos();
                        frmme.habilitarBotones();
                        
                    }else {
                        
                        metodosEstudiantes.mensajeConsultar();
                        frmme.habilitarAgregar();
                        frmme.administrarCampos();
                        
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) { 
                    
                    conexionBD1.registrarEstudiante(frmme.devolverInformacion());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteAgregado(); 
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    conexionBD1.actualizarEstudiante(frmme.devolverInformacion());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    conexionBD1.eliminarEstudiante(frmme.devolverInformacion());
                    frmme.limpiarCampos();
                    frmme.estadoInicialBotones();
                    frmme.estadoInicialCampos();
                    metodosEstudiantes.mensajeEstudianteEliminado();
                    
                }
                
                break;
                //Fin del caso Bases de Datos
            
        }//Fin del switch
            
    }//Fin del método actionPerformed
    
    /*
    Método que 
    */
    public void consultaRapida()
    {
        //Inicio del switch
        switch(this.sistemaInfo) {
            
            //En el caso que fueran ArchivosPlanos
            case "ArchivosPlanos":
                
                if(metodosEstudiantes.consultarEstudiante(frmme.devolverCedula())) {
                        
                        frmme.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                        frmme.administrarCampos();
                        frmme.habilitarBotones();
                        
                    }else {
                        
                        metodosEstudiantes.mensajeConsultar();
                        frmme.habilitarAgregar();
                        frmme.administrarCampos();
                    }
                
                break;
                //Fin del caso ArchivosPlanos
                
            //En el caso que fuera XML  
            case "XML":
                
                if(mxml.consultarInformacionDelXml(frmme.devolverCedula())) {
                        
                        frmme.mostrarInformacion(mxml.getArregloInformacion());
                        frmme.administrarCampos();
                        frmme.habilitarBotones();
                        
                    }else {
                        
                        metodosEstudiantes.mensajeConsultar();
                        frmme.habilitarAgregar();
                        frmme.administrarCampos();
                        
                    }
                
                break;
                //Fin del caso XML
                
            //En el caso que fuera Bases_de_Datos    
            case "Bases_de_Datos":
                
                if(conexionBD1.consultarEstudiante(frmme.devolverCedula())) {
                        
                        frmme.mostrarInformacion(conexionBD1.devolverArregloEst());
                        frmme.administrarCampos();
                        frmme.habilitarBotones();
                        
                    }else {
                        
//                        metodosEstudiantes.mensajeConsultar();
                        frmme.habilitarAgregar();
                        frmme.administrarCampos();
                        
                    }
                
                break;
                //Fin del caso Bases_de_Datos
            
        }//Fin del switch
        
    }//Fin del método consultaRapida
    
}//Controlador_FRM_MantenimientoEstudiantes
