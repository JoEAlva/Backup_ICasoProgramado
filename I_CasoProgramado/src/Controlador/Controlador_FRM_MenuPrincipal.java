/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_Matricula;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_MantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener{
    
    //Se declaran las variables
    String sistemaInfo = "";
    
    //Referencias
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_Matricula matricula;
    FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios; 
    
    public Controlador_FRM_MenuPrincipal()
    {
        mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes(sistemaInfo);
        mantenimientoCursos=new FRM_MantenimientoCursos(sistemaInfo);
        fRM_MantenimientoUsuarios = new FRM_MantenimientoUsuarios(sistemaInfo);
        matricula= new FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos);       
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);        
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            this.mantenimientoEstudiantes.setVisible(true);
            
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            this.mantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            this.matricula.setVisible(true);
            this.matricula.colocarCodigo();
        }
        if(e.getActionCommand().equals("Usuarios"))
        {
            this.fRM_MantenimientoUsuarios.setVisible(true);
        }
    
    }
    
}
