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
    public MetodosCursos metodos;
    ArchivosCursos cursosArchivos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frmmc, String sistemaInfo, MetodosConexionBD1 conexionBD1)//Constructor
    {
        this.conexionBD1 = conexionBD1;
        this.sistemaInfo = sistemaInfo;
        this.frmmc= frmmc;
        xmlc = new XML_Cursos(frmmc);
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
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                }
                 
                break;
                //Fin del caso ArchivosPlanos
            
            //En el caso que fuera XML
            case "XML":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                }
                
                break;
                //Fin del caso XML
            
            //En el caso que fuera Bases de Datos
            case "Bases_de_Datos":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Modificar")) {
                    
                    
                    
                }
                
                if(e.getActionCommand().equals("Eliminar")) {
                    
                }
                
                break;
                //Fin del caso Bases de Datos
            
        }//Fin del switch
        
    }//Fin del método actionPerformed
    
}//Fin de la clase Controlador_FRM_MantenimientoCurso
