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
import Vista.FRM_UsuarioLogin;
import Modelo.ArchivosUsuario;
/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_MantenimientoUsuarios implements ActionListener
{   
    // Referencias
    FRM_MantenimientoUsuarios frmmu;
    FRM_UsuarioLogin frmul;
    public MetodosUsuario metodosUsuario;
    ArchivosUsuario archivosUsuario;
        
    // Contructor
    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios frmmu, FRM_UsuarioLogin frmul) { 
        this.frmmu=frmmu;
        this.frmul=frmul;
        archivosUsuario = new ArchivosUsuario();
        metodosUsuario=new MetodosUsuario(archivosUsuario);
        
        if(archivosUsuario.cargarArchivoUsuario())
        {
            System.out.println("Se cargó el archivo usuario correctamente(controlador)");
        }
        else
        {
            System.out.println("Error al cargar el archivo usuario(controlador)");
        }
        metodosUsuario.arrayUsuario = archivosUsuario.leerArchivoUsuario();
    }
    
    /*
    Método que evalua condiciones 
    */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar"))
        {
            System.out.println("C");
            if(metodosUsuario.consultarUsuario(frmmu.devolverInfoUsuario()))
            {
                frmmu.mostrarInfoPantalla(metodosUsuario.devolverArregloUsuario());
            }
            else
            {
             frmmu.limpiarCampos();
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            System.out.println("A");
            metodosUsuario.agregarUsuario(frmmu.devolverInfoUsuario());
            frmmu.limpiarCampos();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            System.out.println("M");
            metodosUsuario.modificarUsuario(metodosUsuario.devolverArregloUsuario());
            frmmu.limpiarCampos();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            System.out.println("E");
            metodosUsuario.eliminarUsuario(frmmu.devolverInfoUsuario());
            frmmu.limpiarCampos();
        }
        if(e.getActionCommand().equals("Login"))
        {
            
        }
    }
    
}//Fin Controlador_FRM_MantenimientoUsuarios
