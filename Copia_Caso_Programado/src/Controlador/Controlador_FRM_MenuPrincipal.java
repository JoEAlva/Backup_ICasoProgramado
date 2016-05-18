/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Manejador_Ventanas;
import Modelo.MetodosConexionBD1;
import Vista.FRM_SistemaInformacion;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_Matricula;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_MantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener{
    
    //Se declaran las variables
    String sistemaInformacion = "";
    
    //Referencias
    Manejador_Ventanas manejador_Clases;
    MetodosConexionBD1 conexionBD1;
    FRM_SistemaInformacion fRM_SistemaInformacion;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_Matricula matricula;
    FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios; 
    
    public Controlador_FRM_MenuPrincipal(Manejador_Ventanas manejador_Clases)
    {
        this.manejador_Clases = manejador_Clases;
        
        //Se instancia la conexion a la base de datos
        conexionBD1 = new MetodosConexionBD1();
        
        
        manejador_Clases.mostrarFRM_SistemaInformacion();
        
    }
    
    /*
    Método que pasa por el contructor a cada ventana el la fuente de información
    a utilizar
    */
    public void setFuenteDeInformacion(String sistemaInformacion)
    {
        
        this.sistemaInformacion=sistemaInformacion;
        mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes(this.sistemaInformacion, conexionBD1);
        mantenimientoCursos=new FRM_MantenimientoCursos(this.sistemaInformacion, this.conexionBD1);
        fRM_MantenimientoUsuarios = new FRM_MantenimientoUsuarios(this.sistemaInformacion, conexionBD1);
        matricula= new FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos, conexionBD1, this.sistemaInformacion);     
        
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
