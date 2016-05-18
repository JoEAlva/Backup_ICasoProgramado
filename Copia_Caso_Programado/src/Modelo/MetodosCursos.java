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
 * @author JorgeIgnacioElizondoAlvarado
 */
public class MetodosCursos {
    
    //Se declaran las variables
    public ArrayList <Cursos> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    
    //Referencias
    ArchivosCursos cursosArchivos;
    
    //Contructor de la clase
    public MetodosCursos(ArchivosCursos cursosArchivos)
    {
        arrayCursos=new ArrayList <Cursos>();
        this.cursosArchivos = cursosArchivos;
    }//Fin del constructor de la clase    
    
    
    /*
    Método que agrega un nuevo curso al arrayCursos.
    @param informacion[] arreglo de información relacionada al curso; como
    sigla, nombre, cantidad de créditos y horario.
    */
    public void agregarCurso(String informacion[])
    {
        Cursos temporal=new Cursos(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
        arrayCursos.add(temporal);
        mensajeCursoAgregado();        
    }
    
    /*
    Método que extrae la información de un curso en el arrayCursos.
    @param es el identificador del curso para el arrayCursos.
    @return un boolean para demostrar que el curso de verdad existe en el
    arrayCursos.
    */
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
    
    /*
    Método que modifica un curso en el arrayCursos.
    @param informacion[] arreglo de información relacionada al curso; como
    sigla, nombre, cantidad de créditos y horario. Va a cambiar la información
    del curso con esa información.
    */
    public void modificarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.get(contador).setNombre(arreglo[1]);
                arrayCursos.get(contador).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(contador).setHorario(arreglo[3]);
                mensajeCursoModificado();
                contador = arrayCursos.size();
            }
        }
    }
    
    /*
    Método que elimina un curso en el arrayCursos.
    @param sigla es el identificador del curso para el arrayCurso.
    */
    public void eliminarCurso(String sigla)
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(sigla))
            {
                arrayCursos.remove(contador);
                mensajeCursoEliminado();
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
    
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajeCursoAgregado() {
        JOptionPane.showMessageDialog(null, "El curso fue agregado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajeCursoEliminado() {
        JOptionPane.showMessageDialog(null, "El curso fue eliminado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /*
    Método que muestra un mensaje al usuario
    */
    public void mensajeCursoModificado() {
        JOptionPane.showMessageDialog(null, "El curso fue modificado en el"
                + " registro.", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
}//Fin de metodosCursos
