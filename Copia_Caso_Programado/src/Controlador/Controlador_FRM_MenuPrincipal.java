/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Manejador_Ventanas;
import Modelo.MetodosConexionBD1;
import Modelo.MetodosUsuario;
import Modelo.ArchivosUsuario;
import Modelo.XML_Usuarios;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_SistemaInformacion;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_Matricula;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_LoginUsuario;
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
    ArchivosUsuario archivosUsuario;
    FRM_LoginUsuario fRM_LoginUsuario;
    FRM_MantenimientoCursos fRM_MantenimientoCursos;
    FRM_MantenimientoEstudiantes fRM_MantenimientoEstudiantes;
    FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios; 
    FRM_MenuPrincipal fRM_MenuPrincipal;
    FRM_Matricula fRM_Matricula;
    FRM_SistemaInformacion fRM_SistemaInformacion;
    Manejador_Ventanas manejador_Clases;
    MetodosConexionBD1 conexionBD1;
    MetodosUsuario mu;
    
    XML_Usuarios xmlu;
        
    //Constructor de la clase
    public Controlador_FRM_MenuPrincipal(Manejador_Ventanas manejador_Clases, FRM_MenuPrincipal fRM_MenuPrincipal)
    {
        //Se instancia la clase de la conexion a la base de datos
        conexionBD1 = new MetodosConexionBD1();
        //Se instancia la ventana principal
        this.fRM_MenuPrincipal = fRM_MenuPrincipal;
        //Se iguala y ejecuta un método de la clase Manejador_Ventanas
        this.manejador_Clases = manejador_Clases;
        this.manejador_Clases.mostrarFRM_SistemaInformacion();
        //Se instancian las clases de los Archivos
        archivosUsuario = new ArchivosUsuario();
        //Se instancian las clases de los métodos
        mu = new MetodosUsuario(archivosUsuario);

    }
    
    /*
    Método que pasa por el contructor a cada ventana el la fuente de información
    a utilizar
    */
    public void setFuenteDeInformacion(String sistemaInformacion)
    {
        
        this.sistemaInformacion=sistemaInformacion;
        
        fRM_MantenimientoEstudiantes = new FRM_MantenimientoEstudiantes(this.sistemaInformacion, conexionBD1);
        fRM_MantenimientoCursos = new FRM_MantenimientoCursos(this.sistemaInformacion, this.conexionBD1);
        fRM_MantenimientoUsuarios = new FRM_MantenimientoUsuarios(this.sistemaInformacion, conexionBD1);
        fRM_Matricula = new FRM_Matricula(fRM_MantenimientoEstudiantes,fRM_MantenimientoCursos, conexionBD1, this.sistemaInformacion);
        fRM_LoginUsuario = new FRM_LoginUsuario(this.sistemaInformacion, conexionBD1, this.manejador_Clases, mu, fRM_MantenimientoUsuarios);
    }
    
    public void decisionVentana()
    {
        if(this.sistemaInformacion.equals("ArchivosPlanos"))
        {
            if(fRM_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.archivosUsuario.cargarArchivoUsuario())
            {  
                fRM_LoginUsuario.setVisible(true);   
            }
            else
            {
                fRM_MantenimientoUsuarios.setVisible(true);
                
                if(fRM_MantenimientoUsuarios.isVisible())
                {
                    fRM_MenuPrincipal.setVisible(false);

                }
            }
        }
        if(this.sistemaInformacion.equals("XML"))
        {
        
            if(fRM_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.xML_Usuarios.cargarXML())
            {
                fRM_LoginUsuario.setVisible(true); 
            }
            else
            {
                fRM_MantenimientoUsuarios.setVisible(true);
                
                if(fRM_MantenimientoUsuarios.isVisible())
                {
                    fRM_MenuPrincipal.setVisible(false);

                }
            }
            
        }
        if(this.sistemaInformacion.equals("Bases_de_Datos"))
        {
            if(fRM_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.conexionBD1.realizarConexion())
            {
                fRM_LoginUsuario.setVisible(true); 
            }
            else
            {
                fRM_MantenimientoUsuarios.setVisible(true);
                
                if(fRM_MantenimientoUsuarios.isVisible())
                {
                    fRM_MenuPrincipal.setVisible(false);

                }
            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);        
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            this.fRM_MantenimientoEstudiantes.setVisible(true);
            
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            this.fRM_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            this.fRM_Matricula.setVisible(true);
            this.fRM_Matricula.colocarCodigo();
        }
        if(e.getActionCommand().equals("Usuarios"))
        {
            this.fRM_MantenimientoUsuarios.setVisible(true);
        }
    
    }
    
}
