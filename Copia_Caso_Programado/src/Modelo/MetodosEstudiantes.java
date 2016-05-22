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
 * @author JorgeIgnacioElizondoAlvarado
 */
public class MetodosEstudiantes {
    
    //Se declaran las variables
    public ArrayList <Estudiante> arrayEstudiantes;
    String arregloInformacionConsultada[]=new String[3];
    
    //Referencias
    ArchivosEstudiante estudianteArchivos;  
    
    //Constructor de la clase
    public MetodosEstudiantes(ArchivosEstudiante estudianteArchivos)
    {
        
        arrayEstudiantes=new ArrayList <Estudiante>();
        this.estudianteArchivos = estudianteArchivos;
        //arrayEstudiantes = archivosEstudiante.leerInfoArchivoEstudiante();
        
    }//Fin del constructor de la clase
    
    /*
    Método que agrega un nuevo estudiante al arrayEstudiante.
    @param informacion[] arreglo de información relacionada al estudiante; como
    cédula, nombre y dirección.
    */
    public void agregarEstudiante(String informacion[])
    {
        Estudiante temporal=new Estudiante(informacion[0], informacion[1], informacion[2]);
        arrayEstudiantes.add(temporal);
        
    }
    
    /*
    Método que extrae la información de un estudiante en el arrayEstudiante.
    @param es el identificador del estudiante para el arrayEstudiante.
    @return un boolean para demostrar que el estudiante de verdad existe en el
    arrayEstudiante.
    */
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getCedula();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getNombreCompleto();
                arregloInformacionConsultada[2]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
                contador = arrayEstudiantes.size();
                
            }
        }
        return existe;
    }
    
    /*
    Método que modifica un estudiante en el arrayEstudiante.
    @param arreglo[] arreglo de información relacionada al estudiante; como
    cédula, nombre y dirección. Va a cambiar la información del estudiante con
    esa información.
    */
    public void modificarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.get(contador).setNombreCompleto(arreglo[1]);
                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
                mensajeEstudianteModificado();
                contador = arrayEstudiantes.size();
            }
        }
    }
    
    /*
    Método que elimina un estudiante en el arrayEstudiante.
    @param cedula es el identificador del estudiante para el arrayEstudiante.
    */
    public void eliminarEstudiante(String cedula)
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arrayEstudiantes.remove(contador);
                mensajeEstudianteEliminado();
                contador = arrayEstudiantes.size();
            }
        }
    }
    
    /*
    Método que devuelve un arreglo
    @return arreglo de dos elementos que contiene la información consultada
    */
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    /*
    Método que crea un nuevo archivo. La información perteneciente al array
    se escribe en el nuevo archivo.
    */
    public void escribirInformacionArchivo() {
        estudianteArchivos.crearArchivoEstudiante();
        for(int i=0; i<arrayEstudiantes.size(); i++) {
            
            estudianteArchivos.escribirInfoArchivoEstudiante(arrayEstudiantes.get(i));
            
        }
    }
    
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajeConsultar()
    {
        JOptionPane.showMessageDialog(null, "El estudiante no"
                        + " se encuentra registrado.", "Universidad de"
                                + " Costa Rica", JOptionPane.OK_OPTION);
    }
    
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajejUsuario()
    {
        JOptionPane.showMessageDialog(null, "Acción realizada correctamente",
        "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
     
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajeEstudianteAgregado() {
        JOptionPane.showMessageDialog(null, "El estudiante fue agregado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajeEstudianteEliminado() {
        JOptionPane.showMessageDialog(null, "El estudiante fue eliminado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajeEstudianteModificado() {
        JOptionPane.showMessageDialog(null, "El estudiante fue modificado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
}//Fin de la clase MetodosEstudiante
