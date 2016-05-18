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
 * @author JorgeIgnacioElizondoAlvarado
 */
public class ArchivosUsuario {
    
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    
    public void crearArchivoUsuario()
    {
        try
        {
            salida = new ObjectOutputStream(new FileOutputStream("archivosUsuario.dat"));
            System.out.println("Se creó el archivo usuario correctamente");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear el archivo  usuario" + e);
        }
    }
    
    public boolean cargarArchivoUsuario()
    {
        boolean existe = false;
        try
        {
            entrada = new ObjectInputStream( new FileInputStream("archivosUsuario.dat"));
            existe = true;
            System.out.println("Se cargó el archivo usuario correctamente");
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo usuario" + e);
        }
        return existe;
    }
    
    public void escribirArchivoUsuario(Usuario usuario)
    {
        try
        {
            salida.writeObject(usuario);
            System.out.println("Se escribió en el archivo usuario");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en el archivo usuario" + e);
        }
    }
    
    public ArrayList<Usuario> leerArchivoUsuario()
    {
        ArrayList<Usuario> arrayUsuario = new ArrayList<Usuario>();
        try
        {
            arrayUsuario.add((Usuario)entrada.readObject());
            System.out.println("Se leyó el archivo usuario correctamente ");
            
        }
        catch(Exception e)
        {
            System.out.println("Error al leer el archivo usuario " + e);
        }
        return arrayUsuario;
    }
    
}//Fin ArchivosUsuario
