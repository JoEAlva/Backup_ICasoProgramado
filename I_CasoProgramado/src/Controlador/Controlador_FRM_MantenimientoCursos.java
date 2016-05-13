/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivosCursos;
import Modelo.MetodosCursos;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public MetodosCursos metodos;
    ArchivosCursos cursosArchivos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)//Constructor
    {
        this.frm_MantenimientoCursos= frm_MantenimientoCursos;
        cursosArchivos = new ArchivosCursos();
        metodos = new MetodosCursos(cursosArchivos);
                
        if(cursosArchivos.cargarInfoCursosArchivo())
        {
            System.out.println("Se cargó el archivo curso(controlador)");
        }
        else
        {
            System.out.println("No se cargó el archivo curso(controlador)");
        }
        
        metodos.arrayCursos = cursosArchivos.leerInfoCursosArchivo();
        
    } 
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            metodos.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.limpiarCampos();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(metodos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
            }
            else
            {
                metodos.mensajeConsultar();
                frm_MantenimientoCursos.limpiarCampos();
            }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            metodos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.limpiarCampos();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            metodos.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.limpiarCampos();
        }
    }
}
