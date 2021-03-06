/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class MetodosMatricula {
    
    private ArrayList <Matricula> arrayMatricula;
    String arregloInformacionConsultada[]=new String[2];
    ArchivosMatricula archivosMatricula;
    
    public MetodosMatricula()
    {
        arrayMatricula=new ArrayList <Matricula>();
        archivosMatricula = new ArchivosMatricula();
        
    }
    public void agregarMatricula(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2]);
        arrayMatricula.add(temporal);    
    }
    public void agregarDetalleMatricula(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2]);
        arrayMatricula.add(temporal);    
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            System.out.println(arrayMatricula.get(contador).getInformacion());
        }
    }
    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(codigo))
            {
                arregloInformacionConsultada[0]=arrayMatricula.get(contador).getCedula();
                arregloInformacionConsultada[1]=arrayMatricula.get(contador).getSigla();
                existe=true;
            }
        }
        return existe;
    }
    public void modificarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.get(contador).setCedula(arreglo[1]);
                arrayMatricula.get(contador).setSigla(arreglo[2]);
            }
        }
    }
    public void eliminarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    } 
    public String devolverCodigo()
    {
        String codigo= "";
        if(arrayMatricula.size()==0)
        {
            codigo="1";
        }
        else
        {
            for(int contador=0;contador<arrayMatricula.size();contador++)
            {
                if(arrayMatricula.get(contador)!=null)
                {
                    codigo=arrayMatricula.get(contador).getCodigo();
                }
            }
            int numero=Integer.parseInt(codigo);
            numero++;
            codigo=""+numero;
        }
        return codigo; 
    }//Fin devolverCodigo
    
    public void escribirInfoArchivo() 
    {
        archivosMatricula.crearArchivoMatricula();
        for(int contador=0; contador<arrayMatricula.size(); contador++)
        {
            archivosMatricula.escribirInfoArchivoMatricula(arrayMatricula.get(contador));
        }
            
    }
    
}//Fin MetodosMatricula
