/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.ArchivosEstudiante;
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
    
    
    public MetodosEstudiantes metodos;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    ArchivosEstudiante estudianteArchivos;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        estudianteArchivos = new ArchivosEstudiante();
        metodos = new MetodosEstudiantes(estudianteArchivos);
                
        
        if(estudianteArchivos.cargarInfoArchivoEstudiante())
        {
            System.out.println("Se cargó el archivo estudiante correctamente");
        }else
        {
            System.out.println("Error al cargar el archivo estudiante(controlador)");
        }
        
        metodos.arrayEstudiantes = estudianteArchivos.leerInfoArchivoEstudiante();
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ConsultaRapida"))
        {
            if(metodos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
            }
            else
            {
                metodos.mensajeConsultar();
                mantenimientoEstudiantes.limpiarCampos();
            }           
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(metodos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
            }
            else
            {
                metodos.mensajeConsultar();
                mantenimientoEstudiantes.limpiarCampos();
            }
            
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            metodos.agregarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            mantenimientoEstudiantes.limpiarCampos();
            metodos.mostrarInformacion();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            metodos.modificarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            mantenimientoEstudiantes.limpiarCampos();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            metodos.eliminarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            mantenimientoEstudiantes.limpiarCampos();
        }
            
    }
    
    public void consultaRapida()
    {
        
        if(metodos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
            }
            else
            {
                metodos.mensajeConsultar();
                mantenimientoEstudiantes.limpiarCampos();
            }
        
    }
    
}
