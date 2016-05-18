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
import Modelo.ArchivosUsuario;
import Modelo.MetodosConexionBD1;
/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class Controlador_FRM_MantenimientoUsuarios implements ActionListener
{   
    //Se declaran las variables
    String sistemaInfo = "";
    
    // Referencias
    FRM_MantenimientoUsuarios frmmu;
    public MetodosUsuario metodosUsuario;
    ArchivosUsuario archivosUsuario;
    MetodosConexionBD1 conexionBD1;
        
    // Contructor de la clase
    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios frmmu, String sistemaInfo, MetodosConexionBD1 conexionBD1) {
        
        this.conexionBD1 = conexionBD1;
        this.sistemaInfo = sistemaInfo;
        this.frmmu=frmmu;
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

    }//Fin del constructor
    
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
    
}//Fin Controlador_FRM_MantenimientoUsuarios
