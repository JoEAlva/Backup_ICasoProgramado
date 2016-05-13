/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosEstudiantes {
    
    public ArrayList <Estudiante> arrayEstudiantes;
    String arregloInformacionConsultada[]=new String[2];
    ArchivosEstudiante estudianteArchivos;
    FRM_MantenimientoEstudiantes fRM_MantenimientoEstudiantes;
    
    public MetodosEstudiantes(ArchivosEstudiante estudianteArchivos)
    {
        arrayEstudiantes=new ArrayList <Estudiante>();
        this.estudianteArchivos = estudianteArchivos;
        //arrayEstudiantes = archivosEstudiante.leerInfoArchivoEstudiante();
    }
    public void agregarEstudiante(String informacion[])
    {
        Estudiante temporal=new Estudiante(informacion[0], informacion[1], informacion[2]);
        arrayEstudiantes.add(temporal);
        JOptionPane.showMessageDialog(null, "El estudiante fue agregado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            System.out.println(arrayEstudiantes.get(contador).getInformacion());
        
        }
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombreCompleto();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
                contador = arrayEstudiantes.size();
                
            }
        }
        return existe;
    }
    public void modificarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.get(contador).setNombreCompleto(arreglo[1]);
                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
                mensajejUsuario();
                contador = arrayEstudiantes.size();
            }
        }
    }
    public void eliminarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.remove(contador);
                mensajejUsuario();
                contador = arrayEstudiantes.size();
            }
        }
    }//Fin eliminarEstudiante
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    /*
    Crea un nuevo archivo. La información perteneciente al array
    se escribe en el nuevo archivo
    */
    public void escribirInformacionArchivo() {
        estudianteArchivos.crearArchivoEstudiante();
        for(int i=0; i<arrayEstudiantes.size(); i++) {
            
            estudianteArchivos.escribirInfoArchivoEstudiante(arrayEstudiantes.get(i));
            
        }
    }
    
    public void mensajeConsultar()
    {
        JOptionPane.showMessageDialog(null, "El estudiante no"
                        + " se encuentra registrado.", "Universidad de"
                                + " Costa Rica", JOptionPane.OK_OPTION);
    }
    
    public void mensajejUsuario()
    {
        JOptionPane.showMessageDialog(null, "Acción realizada correctamente",
        "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
     
}//Fin de la clase MetodosEstudiante
