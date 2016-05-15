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
    
    //Se declaran las variables
    String sistemaInfo = "";
    
    //Referencias
    FRM_MantenimientoCursos frmmc;
    XML_Cursos xmlc;
    public MetodosCursos metodos;
    ArchivosCursos cursosArchivos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frmmc, String sistemaInfo)//Constructor
    {
        this.sistemaInfo = sistemaInfo;
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
    
}//Fin de la clase Controlador_FRM_MantenimientoCurso
