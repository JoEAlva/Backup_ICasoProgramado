/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author JorgeIgnacio
 */
public class ArchivosCursos {
    
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    
    /*
    Crea un archivo para el objeto Cursos
    */
    public void crearArchivoCursos()
    {
        try
        {
            salida = new ObjectOutputStream( new FileOutputStream("archivosCursos.dat") );
            System.out.println("Se creó el archivo curso");
        }
        catch(Exception e)
        {
            System.out.println("No se creó el archivo curso " + e);
        }
    }//Fin crearArchivosCursos
    
    /*
    Escribi la información en el archivo
    */
    public void escribirInfoArchivoCursos(Cursos curso)
    {
        try
        {
            salida.writeObject(curso);
            System.out.println("Se escribió en el archivo curso");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en el archivo curso " + e);
        }
    }//Fin escribirInfoArchivoCursos
    
    /*
    Carga la información del archivo
    */
    public boolean cargarInfoCursosArchivo()
    {
        boolean exist = false;
        try
        {
            entrada = new ObjectInputStream( new FileInputStream("archivosCursos.dat") );
            exist = true;
            System.out.println("Se cargó cargó la información del archivo curso");
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo curso " + e);
        }
        return exist;
    }//Fin cargarInfoCursosArchivo
    
    public ArrayList<Cursos> leerInfoCursosArchivo()
    {
        ArrayList<Cursos> arrayCursos = new ArrayList<Cursos>();
        try
        {
            while(true)
            {
                arrayCursos.add((Cursos)entrada.readObject());
            }
        }
        catch(Exception e)
        {
            System.out.println("Se llegó al final del archivo curso "+ e);
        }
        return arrayCursos;
    }
    
}//Fin ArchivosCursos
