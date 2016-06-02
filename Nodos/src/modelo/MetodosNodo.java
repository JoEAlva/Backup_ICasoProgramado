/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JorgeIgnacio
 */
public class MetodosNodo {
    
    //Referencias de la clase
    Nodo principal;

    public MetodosNodo() {
        this.principal = principal;
    }
    
    public void crear(int cantidad) {
        
        principal = new Nodo(1, null);
        Nodo temporal = principal;
        for (int contador = 2; contador <= cantidad; contador++) {
            temporal.setSiguiente(new Nodo(contador, null));
            temporal = temporal.getSiguiente();
        }
    
    }
    
    public int contar() {
        
        Nodo temporal = principal;
        try {
            if(temporal.getSiguiente() == null) {
                return 0;
            }
        }catch(NullPointerException e) {
            System.err.println("Error: " + e);
            return 0;
        }
        int cont = 0;
        while(temporal.getSiguiente()!=null) {
            temporal = temporal.getSiguiente();
            cont++;
        }
        cont++;
        temporal = null;
        return cont; 
    }
    
    public String imprimir() {
        
        String valores = "";
        Nodo temporal = principal;
        while(temporal.getSiguiente()!=null) {
            valores+=temporal.getDato()+"\n";
            temporal = temporal.getSiguiente();
        }
        valores+=temporal.getDato();
        return valores;
    }
    
    public void agregarAlFinal(int dato) {
        
        Nodo temporal = devolverUltimoNodo();
        temporal.setSiguiente(new Nodo(dato, null));
        
    }
    
    public Nodo devolverUltimoNodo() {
        Nodo temporal = principal;
        while(temporal.getSiguiente()!=null) {
            temporal = temporal.getSiguiente();
        }
        return temporal;  
    }
    
    public Nodo devolverPenultimoNodo() {
        
        Nodo temporal = principal;
        while(temporal.getSiguiente().getSiguiente() != null) {
            temporal = temporal.getSiguiente();
        }
        
        return temporal;
        
    }
    
    public void modificar(int datoModificar, int datoNuevo) {
        
        Nodo temporal = principal;
        while(temporal.getDato() != datoModificar) {
            temporal = temporal.getSiguiente();
        }
        temporal.setDato(datoNuevo);
        
    }
        
    public void eliminar(int dato) {
      
        Nodo temporal = principal;
        Nodo aux;
        boolean eliminado = false;
        
        if(dato <= contar()) {
            if(temporal.getDato() == dato) {
                temporal = temporal.getSiguiente();
                eliminado = true;
            }else {
                while(temporal.getDato() != dato) {
                    temporal = temporal.getSiguiente();
                    System.err.println("Lo encontró");
                    temporal.getSiguiente().getDato();
                }
            }
                
        }else {
            System.err.println("No se puede borrar el dato");
        }
    }
    
    public Nodo nodoAnterior(int buscarNodo) {
        Nodo temporal = principal;
        while(temporal.getSiguiente().getDato() != buscarNodo) {
            temporal = temporal.getSiguiente();
        }
        
        return temporal;
    }
    
    public void ordenarMayorAMenor()
    {
        System.err.println("No funciona");
    }
    public void ordenarMenorAMayor()
    {
        System.err.println("No funciona");
    }
    
}//Fin de la clase MetodosNodo
