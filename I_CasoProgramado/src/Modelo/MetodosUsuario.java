/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author JorgeIgnacio
 */
public class MetodosUsuario
{
    
    //Se declaran los campos de la clase
    public ArrayList<Usuario> arrayUsuario;
    public String arregloUsuario[];
    ArchivosUsuario archivosUsuario;
    
    /*
    Constructor de la clase
    param@  archivosUsuario El parámetro archivosUsuario se recibe de
    Controlador_FRM_MantanimientoUsuario para poder hacer uso de ArchivosUsuario
    en ésta clase.
    */
    public MetodosUsuario(ArchivosUsuario archivosUsuario)
    {
        arrayUsuario = new ArrayList<Usuario>();
        arregloUsuario = new String[4];
        this.archivosUsuario = archivosUsuario;
    }//Fin del constructor
    
    
    /*
    Busca un estudiante en el ArrayList arrayUsuario
    @param arregloInfo Un arreglo que contiene la información del usuario
    */
    public boolean consultarUsuario(String arregloInfo[])
    {
        boolean exist = false;
        for(int j=0; j<arrayUsuario.size(); j++)
        {
            if(arrayUsuario.get(j).getIdUsuario().equals(arregloInfo[0]))
            {
                arregloUsuario[0] = arrayUsuario.get(j).getNombreCompleto();
                arregloUsuario[1] = arrayUsuario.get(j).getNombreUsuario();
                arregloUsuario[2] = arrayUsuario.get(j).getContrasena();
                arregloUsuario[3] = arrayUsuario.get(j).getTipo();
                exist = true;
                j=arrayUsuario.size();
            }
        }
        return exist;
    }//consultarUsuario
    
    
    /*
    Método que agrega un nuevo usuario al ArrayList arrayUsurio
    param@ arregloInfo Un arreglo que contiene la información del usuario
    */
    public void agregarUsuario(String arregloInfo[])
    {
        
        Usuario temporal = new Usuario(arregloInfo[0], arregloInfo[1],
        arregloInfo[2], arregloInfo[3], arregloInfo[4]);
        arrayUsuario.add(temporal);
        JOptionPane.showMessageDialog(null, "El usuario fue agregado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
        
    }//Fin de agregarUsuario
    
    /*
    Método que modifica un usuario del ArrayList arrayUsuario
    @param arregloInfo Un arreglo que contiene la información del usuario
    */
    public void modificarUsuario(String arregloInfo[])
    {
        for(int j=0; j<arrayUsuario.size(); j++)
        {
            if(arrayUsuario.get(j).getIdUsuario().equals(arregloInfo[0]))
            {
                arrayUsuario.get(j).setNombreCompleto(arregloInfo[1]);
                arrayUsuario.get(j).setNombreUsuario(arregloInfo[2]);
                arrayUsuario.get(j).setContrasena(arregloInfo[3]);
                arrayUsuario.get(j).setContrasena(arregloInfo[4]);
                mensajejUsuario();
                j = arrayUsuario.size();
            }
        }
    }//Fin de modificarUsuario
    
    public String[] devolverArregloUsuario()
    {
        return this.arregloUsuario;
    }
    
    /*
    Método que elimina un usuario del ArrayList arrayUsuario
    @param arregloInfo Un arreglo que contiene la información del usuario
    */
    public void eliminarUsuario(String arregloInfo[])
    {
        for(int j=0; j<arrayUsuario.size(); j++)
        {
            if(arrayUsuario.get(j).equals(arregloInfo[0]))
            {
                arrayUsuario.remove(j);
                mensajejUsuario();
                j = arrayUsuario.size();
            }
        }
    }//Fin de eliminarUsuario
    
    /*
    Método que muestra un mensaje al usuario en pantalla
    */
    public void mensajejUsuario()
    {
        JOptionPane.showMessageDialog(null, "Acción realizada correctamente",
        "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }//Fin de mensajeUsuario
    
    /*
    Método que muestra un mensaje al usuario en pantalla
    */
    public void mensajeConsultar()
    {
        JOptionPane.showMessageDialog(null, "El usuario no"
                        + " se encuentra registrado.", "Universidad de"
                                + " Costa Rica", JOptionPane.OK_OPTION);
    }//Fin de mensajeConsultar
    
    /*
    Método que ejecuta una llamado a un método para crear un archivo de tipo
    Usurio. Recorre el ArrayList arrayUsuario para que la llamada al método
    escribirArchivoUsuario lea el archivo binario.
    */
    public void escribirInformacionArchivo()
    {
        archivosUsuario.crearArchivoUsuario();
        for(int contador = 0; contador<arrayUsuario.size(); contador++)
        {
            this.archivosUsuario.escribirArchivoUsuario(arrayUsuario.get(contador));
        }
    }
    
    /*
    
    */
    public void verificarUsuario(String arregloInfo[])
    {
        for(int i=0; i<arrayUsuario.size(); i++)
        {
            
        }
    }//Fin de verificarUsuario
    
    
        
}//Fin de MetodosUsuario
