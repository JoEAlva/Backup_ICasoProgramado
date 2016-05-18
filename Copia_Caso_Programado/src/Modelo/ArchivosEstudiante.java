/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class ArchivosEstudiante 
{
    
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    
    /*
    crearArchivosUsuario
    */
    public void crearArchivoEstudiante()
    {
        try
        {
            salida = new ObjectOutputStream( new FileOutputStream("archivosEstudiante.dat") );
            System.out.println("Se creó el archivo estudiante correctamente");
        }
        catch(Exception ex)
        {
            System.out.println("No se creó el archivo estudiante " + ex);
        }
    }//End crearArchivosUsuario
    
    /*
    addInfoFileStudent
    */
    public void escribirInfoArchivoEstudiante(Estudiante estudiante)
    {
        try
        {
            salida.writeObject(estudiante);
            System.out.println("Se escribió en el archivo estudiante");
        }
        catch(Exception ex)
        {
            System.out.println("Error al escribir en el archivo estudiante " + ex);
        }
    }//End addInfoFileStudent
    
    /*
    chargeInfoFileStudent
    */
    public boolean cargarInfoArchivoEstudiante()
    {
        boolean existe = false;
        try
        {
            entrada = new ObjectInputStream( new FileInputStream("archivosEstudiante.dat"));
            existe = true;
        }
        catch(Exception ex)
        {
            System.out.println("Error al cargar la información " + ex);
        }
        
        return existe;
        
    }//End chargeInfoFileStudent
    
    /*
    leerInformacionArchivo
    */
    public ArrayList<Estudiante> leerInfoArchivoEstudiante() {
        
        ArrayList<Estudiante> arrayEstudiante = new ArrayList<Estudiante>();
        
        try
        {
           while(true)
           {
               arrayEstudiante.add((Estudiante)entrada.readObject());
           }
           
        }
        catch(Exception e)
        {
            System.out.println("Se llegó al final dal archivo " + e);
        }
        
        return arrayEstudiante;
        
    }//leerInfoArchivoEstudiente
    
}
