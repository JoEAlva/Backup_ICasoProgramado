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
public class ArchivosMatricula {
    
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    
    public void crearArchivoMatricula()
    {
        try
        {
            salida = new ObjectOutputStream(new FileOutputStream("archivosMatricula.dat"));
            System.out.println("Se creó el archivo matrícula correctamrente");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear el archivo matrícula "+e);
        }
    }
    
    public void escribirInfoArchivoMatricula(Matricula matricula)
    {
        try
        {
            salida.writeObject(matricula);
            System.out.println("Se escribió en el archivo matrícula");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en el archivo matrícula"+e);
        }
    }
    
    public boolean cargarInfoArchivoMatricula()
    {
        boolean exist = true;
        try
        {
            entrada = new ObjectInputStream( new FileInputStream("archivosMatricula.dat"));
            exist = true;
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo matrícula"+e);
        }
        return exist;
    }
    
    public ArrayList<Matricula> leerInfoArchivoMatricula()
    {
        ArrayList<Matricula> arrayMatricula =  new ArrayList<Matricula>();
        try
        {
            arrayMatricula.add((Matricula)entrada.readObject());
        }
        catch(Exception e)
        {
            System.out.println("Error al leer la información del archivo matrícula "+e);
        }
        return arrayMatricula;
    }
    
}
