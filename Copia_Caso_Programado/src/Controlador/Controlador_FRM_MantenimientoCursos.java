/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosConexionBD1;
import Modelo.XML_Cursos;
import Modelo.ArchivosCursos;
import Modelo.MetodosCursos;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    //Se declaran las variables
    String sistemaInfo = "";
    
    //Referencias
    FRM_MantenimientoCursos frmmc;
    MetodosConexionBD1 conexionBD1;
    XML_Cursos xmlc;
    public MetodosCursos metodosCursos;
    ArchivosCursos cursosArchivos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frmmc, String sistemaInfo, MetodosConexionBD1 conexionBD1)//Constructor
    {
        this.conexionBD1 = conexionBD1;
        this.conexionBD1.realizarConexion();
        this.sistemaInfo = sistemaInfo;
        this.frmmc= frmmc;
        xmlc = new XML_Cursos(frmmc);
        cursosArchivos = new ArchivosCursos();
        metodosCursos = new MetodosCursos(cursosArchivos);
                
        if(cursosArchivos.cargarInfoCursosArchivo())
        {
            System.out.println("Se cargó el archivo curso(controlador)");
        }
        else
        {
            System.out.println("No se cargó el archivo curso(controlador)");
        }
        
        metodosCursos.arrayCursos = cursosArchivos.leerInfoCursosArchivo();
        
    } 
    
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
                    
                    if(metodosCursos.consultarCurso(frmmc.devolverSigla())) {
                        
                        frmmc.mostrarInformacion(metodosCursos.getArregloInformacion());
                        frmmc.habilitarBotones();
                        frmmc.habilitarCampos();
                        
                    }else {
                        
                        frmmc.habilitarAgregar();
                        frmmc.habilitarCampos();
                        metodosCursos.mensajeConsultar();
                        
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    metodosCursos.agregarCurso(frmmc.devolverInformacion());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoAgregado();
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    metodosCursos.modificarCurso(frmmc.devolverInformacion());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    metodosCursos.eliminarCurso(frmmc.devolverSigla());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoEliminado();
                    
                }
                 
                break;
                //Fin del caso ArchivosPlanos
            
            //En el caso que fuera XML
            case "XML":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(xmlc.consultarInformacionDelXml(frmmc.devolverSigla())) {
                        
                        frmmc.mostrarInformacion(xmlc.getArregloInformacion());
                        frmmc.habilitarAgregar();
                        frmmc.habilitarBotones();
                        frmmc.habilitarCampos();
                        
                        
                    }else {
                        
                        metodosCursos.mensajeConsultar();
                        frmmc.habilitarAgregar();
                        frmmc.habilitarCampos();
                        frmmc.habilitarAgregar();
                        
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    xmlc.guardarEnXML(frmmc.devolverInformacion());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoAgregado();
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    xmlc.modificarInformacionDelXml(frmmc.devolverInformacion());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    xmlc.eliminarInformacionDelXml(frmmc.devolverSigla());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoEliminado();
                    
                }
                
                break;
                //Fin del caso XML
            
            //En el caso que fuera Bases de Datos
            case "Bases_de_Datos":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    if(conexionBD1.consultarCurso(frmmc.devolverSigla())) {
                        
                        frmmc.mostrarInformacion(conexionBD1.devolverArregloCurso());
                        frmmc.habilitarCampos();
                        frmmc.habilitarBotones();
                        
                    }else {
                        
                        metodosCursos.mensajeConsultar();
                        frmmc.habilitarAgregar();
                        frmmc.habilitarCampos();
                        
                    }
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    conexionBD1.registrarCurso(frmmc.devolverInformacion());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoAgregado();
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    conexionBD1.actualizarCurso(frmmc.devolverInformacion());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoModificado();
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                    conexionBD1.eliminarCurso(frmmc.devolverSigla());
                    frmmc.limpiarCampos();
                    frmmc.estadoInicialBotones();
                    frmmc.estadoInicialCampos();
                    metodosCursos.mensajeCursoEliminado();
                    
                }
                
                break;
                //Fin del caso Bases de Datos
            
        }//Fin del switch
        
    }//Fin del método actionPerformed
    
    public void consultaRapida() {
        
        //Inicio del switch
        switch(this.sistemaInfo) {
            
            //En el caso que fuera ArchivosPlanos
            case "ArchivosPlanos":
                
                if(conexionBD1.consultarCurso(frmmc.devolverSigla())) {
                        
                        frmmc.mostrarInformacion(conexionBD1.devolverArregloCurso());
                        frmmc.habilitarCampos();
                        frmmc.habilitarBotones();
                        
                    }else {
                        
                        metodosCursos.mensajeConsultar();
                        frmmc.habilitarAgregar();
                        frmmc.habilitarCampos();
                        
                    }
                
                break;
                
            //En el caso que fuera XML
            case "XML":
                
                if(xmlc.consultarInformacionDelXml(frmmc.devolverSigla())) {
                        
                        frmmc.mostrarInformacion(xmlc.getArregloInformacion());
                        frmmc.habilitarAgregar();
                        frmmc.habilitarBotones();
                        frmmc.habilitarCampos();
                        
                        
                    }else {
                        
                        metodosCursos.mensajeConsultar();
                        frmmc.habilitarAgregar();
                        frmmc.habilitarCampos();
                        frmmc.habilitarAgregar();
                        
                    }
                
                break;
                
            //En el caso que fuera Bases_de_Datos
            case "Bases_de_Datos":
                
                if(conexionBD1.consultarCurso(frmmc.devolverSigla())) {
                        
                        frmmc.mostrarInformacion(conexionBD1.devolverArregloCurso());
                        frmmc.habilitarCampos();
                        frmmc.habilitarBotones();
                        
                    }else {
                        
                        metodosCursos.mensajeConsultar();
                        frmmc.habilitarAgregar();
                        frmmc.habilitarCampos();
                        
                    }
                
                break;
            
        }//Fin del switch
        
    }
    
}//Fin de la clase Controlador_FRM_MantenimientoCurso
