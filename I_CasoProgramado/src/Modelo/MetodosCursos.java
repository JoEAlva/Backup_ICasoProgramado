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
 * @author tecnologiamultimedia
 */
public class MetodosCursos {
    
    public ArrayList <Cursos> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    ArchivosCursos cursosArchivos;
    
    public MetodosCursos(ArchivosCursos cursosArchivos)
    {
        arrayCursos=new ArrayList <Cursos>();
        this.cursosArchivos = cursosArchivos;
    }
    public void agregarCurso(String informacion[])
    {
        Cursos temporal=new Cursos(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
        arrayCursos.add(temporal);
        JOptionPane.showMessageDialog(null, "El curso fue agregado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
        
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            //System.out.println(arrayCursos.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarCurso(String sigla)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(sigla))
            {
                arregloInformacionConsultada[0]=arrayCursos.get(contador).getNombre();
                arregloInformacionConsultada[1]=""+arrayCursos.get(contador).getCreditos();
                arregloInformacionConsultada[2]=arrayCursos.get(contador).getHorario();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.get(contador).setNombre(arreglo[1]);
                arrayCursos.get(contador).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(contador).setHorario(arreglo[3]);
                mensajejUsuario();
                contador = arrayCursos.size();
            }
        }
    }
    public void eliminarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.remove(contador);
                mensajejUsuario();
                contador = arrayCursos.size();
            } 
        }
    }
    
    public void escribirInformacionArchivo()
    {
        cursosArchivos.crearArchivoCursos();
        for(int contador=0;contador<arrayCursos.size();contador++) {
            cursosArchivos.escribirInfoArchivoCursos(arrayCursos.get(contador));
        }
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
    
    public void mensajeConsultar()
    {
        JOptionPane.showMessageDialog(null, "El curso no"
                        + " se encuentra registrado.", "Universidad de"
                                + " Costa Rica", JOptionPane.OK_OPTION);
    }
    
    public void mensajejUsuario()
    {
        JOptionPane.showMessageDialog(null, "Acción realizada correctamente",
        "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
