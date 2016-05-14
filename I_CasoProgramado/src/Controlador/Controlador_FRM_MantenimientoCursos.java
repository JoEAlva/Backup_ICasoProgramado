/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.XML_Cursos;
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
    
    FRM_MantenimientoCursos frmmc;
    XML_Cursos xmlc;
    public MetodosCursos metodos;
    ArchivosCursos cursosArchivos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frmmc)//Constructor
    {
        this.frmmc= frmmc;
        xmlc = new XML_Cursos(frmmc);
        cursosArchivos = new ArchivosCursos();
        metodos = new MetodosCursos(cursosArchivos);
                
//        if(cursosArchivos.cargarInfoCursosArchivo())
//        {
//            System.out.println("Se cargó el archivo curso(controlador)");
//        }
//        else
//        {
//            System.out.println("No se cargó el archivo curso(controlador)");
//        }
//        
//        metodos.arrayCursos = cursosArchivos.leerInfoCursosArchivo();
        
    } 
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            xmlc.guardarEnXML(frmmc.devolverInformacion());
//            metodos.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
            frmmc.limpiarCampos();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            xmlc.consultarInformacionDelXml(frmmc.devolverSigla());
            frmmc.mostrarInformacion(xmlc.getArregloInformacion());
//            if(metodos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
//            {
//                frm_MantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
//            }
//            else
//            {
//                metodos.mensajeConsultar();
//                frm_MantenimientoCursos.limpiarCampos();
//            }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
//            metodos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
           xmlc.modificarInformacionDelXml(frmmc.devolverInformacion());
            frmmc.limpiarCampos();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            xmlc.eliminarInformacionDelXml(frmmc.devolverSigla());
//            metodos.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
            frmmc.limpiarCampos();
        }
    }
}
