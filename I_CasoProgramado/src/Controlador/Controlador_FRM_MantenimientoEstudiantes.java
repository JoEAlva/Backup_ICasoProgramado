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
    public MetodosEstudiantes metodos;
    FRM_MantenimientoEstudiantes frmme;
    ArchivosEstudiante estudianteArchivos;
    XML_Estudiantes mxml;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frmme)
    {
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
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ConsultaRapida"))
        {
            
            consultaRapida();
            
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            mxml.consultarInformacionDelXml(frmme.devolverCedula());
            frmme.mostrarInformacion(mxml.getArregloInformacion());
//            if(metodos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
//            {
//                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
//            }
//            else
//            {
//                metodos.mensajeConsultar();
//                mantenimientoEstudiantes.limpiarCampos();
//            }
            
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            mxml.guardarEnXML(frmme.devolverInformacion());
//            metodos.agregarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            frmme.limpiarCampos();
//            metodos.mostrarInformacion();

        }
        if(e.getActionCommand().equals("Modificar"))
        {
            
//            metodos.modificarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            frmme.limpiarCampos();
            
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            
//            metodos.eliminarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            frmme.limpiarCampos();
            
        }
            
    }
    
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
