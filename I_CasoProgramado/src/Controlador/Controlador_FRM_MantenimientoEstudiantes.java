/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.ArchivosEstudiante;
import Modelo.XML_Estudiantes;
import Modelo.MetodosEstudiantes;
import Vista.FRM_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    //Se declaran las variables
    String sistemaInfo = "";
    
    //Referencias
    FRM_MantenimientoEstudiantes frmme;
    public MetodosEstudiantes metodos;
    ArchivosEstudiante estudianteArchivos;
    XML_Estudiantes mxml;
    
    //Constructor de la clase
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frmme, String sistemaInfo)
    {
        this.sistemaInfo = sistemaInfo;
        this.frmme=frmme;
        mxml = new XML_Estudiantes(this.frmme);
        estudianteArchivos = new ArchivosEstudiante();
        metodos = new MetodosEstudiantes(estudianteArchivos);
                        
//        if(estudianteArchivos.cargarInfoArchivoEstudiante())
//        {
//            System.out.println("Se cargó el archivo estudiante correctamente");
//        }else
//        {
//            System.out.println("Error al cargar el archivo estudiante(controlador)");
//        }
//        
//        metodos.arrayEstudiantes = estudianteArchivos.leerInfoArchivoEstudiante();
        
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
                    
                    System.out.println("ArchivosPlanos");
                    
                }
                 
                break;
                //Fin del caso ArchivosPlanos
            
            //En el caso que fuera XML
            case "XML":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    System.out.println("XML");
                    
                }
                
                break;
                //Fin del caso XML
            
            //En el caso que fuera Bases de Datos
            case "Bases_de_Datos":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    System.out.println("Bases_de_Datos");
                    
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
        
//        if(metodos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
//            {
//                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
//            }
//            else
//            {
//                metodos.mensajeConsultar();
//                mantenimientoEstudiantes.limpiarCampos();
//            }
        mxml.consultarInformacionDelXml(frmme.devolverCedula());
        
    }
    
}//Controlador_FRM_MantenimientoEstudiantes
