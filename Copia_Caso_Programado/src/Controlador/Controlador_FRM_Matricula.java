/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivosMatricula;
import Modelo.MetodosConexionBD1;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class Controlador_FRM_Matricula implements ActionListener{
    
    //Se declaran las variables
    String sistemaInfo = "";
    
    //Referecnias a las clases
    MetodosConexionBD1 conexionBD1;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    public MetodosMatricula metodosMatricula;
    FRM_Matricula frm_Matricula;
    boolean encontroEstudiante=false; 
    boolean encontroCurso=false;
    ArchivosMatricula archivosMatricula;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos,FRM_Matricula frm_Matricula, MetodosConexionBD1 conexionBD1, String sistemaInfo)
    {
        //Se iguala sistemaInfo al valos sistemaInfo que entra por parámetro
        this.sistemaInfo = sistemaInfo;
        //Hace referencia a FRM_MantenimientoUsuarios
        this.frm_Matricula=frm_Matricula;

        this.metodosCursos=mantenimientoCursos.controlador.metodosCursos;
        this.metodosEstudiantes=mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;

        //Arreglar los archivos de matricula
        metodosMatricula=new MetodosMatricula();
        archivosMatricula = new ArchivosMatricula();

        if(archivosMatricula.cargarInfoArchivoMatricula())
        {
            System.out.println("Se cargó correctamente el archivo matrícula(controlador)");
        }else
        {
            System.out.println("Error al cargar el archivo matrícula(controlador)");
        }      
              
        //XML
        
        this.conexionBD1 = conexionBD1;
        this.conexionBD1.realizarConexion();
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        //Inicio del switch
        switch(this.sistemaInfo) {
            
            //En el caso que fuera ArchivosPlanos
            case "ArchivosPlanos":
                
                if(e.getActionCommand().equals("ConsultaRapidaEstudiante")) {
                    
                    if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula())) {
                        frm_Matricula.mostrarNombEst(metodosEstudiantes.getArregloInformacion());
                        encontroEstudiante = true;
                    }else {
                        conexionBD1.msjEstNoEncontrado();
                    }
                    
                }
                
                if(e.getActionCommand().equals("ConsultaRapidaCurso")) {
                    
                    if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla())) {
                        frm_Matricula.mostrarNombCurso(metodosCursos.getArregloInformacion());
                        encontroCurso = true;
                    }else {
                        conexionBD1.msjCursoNoEncontrado();
                    }
                    
                }
                
                if(encontroEstudiante && encontroCurso) {
                    frm_Matricula.habilitarAgregar();
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    frm_Matricula.cargarTabla();
                    encontroCurso=false;
                    frm_Matricula.estadoInicial();
                    frm_Matricula.limpiarEst();
                    frm_Matricula.limpiarCurso(); 
                }
                
                if(e.getActionCommand().equals("Finalizar")) {  
                    
                    for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
                    {
                       metodosMatricula.agregarMatricula(frm_Matricula.getInformacionTablaMatricula(contador));
                    }
                    frm_Matricula.resetearInterfaz();

                    metodosMatricula.mostrarInformacion();
                }
                 
                break;
                //Fin del caso ArchivosPlanos
            
            //En el caso que fuera XML
            case "XML":
                
                if(e.getActionCommand().equals("Consultar")) {
                    
                    System.out.println("XML");
                    
                }
                
                break;
                //Fin del caso XML
            
            //En el caso que fuera Bases de Datos
            case "Bases_de_Datos":
                
                if(e.getActionCommand().equals("ConsultaRapidaEstudiante")) {
                    if(conexionBD1.consultarEstudianteMatricula(frm_Matricula.devolverCedula())) {
                        frm_Matricula.mostrarNombreEstudiante(conexionBD1.devolverNombreEst());
                        encontroEstudiante = true;
                    }else {
                        conexionBD1.msjEstNoEncontrado();
                    }                 
                }
                
                if(e.getActionCommand().equals("ConsultaRapidaCurso")) {
                    if(conexionBD1.consultarCursoMatricula(frm_Matricula.devolverSigla())) {
                        frm_Matricula.mostrarNombreCurso(conexionBD1.devolverNombreCurso());
                        encontroCurso = true;
                    }else {
                        conexionBD1.msjCursoNoEncontrado();
                    }
                }
                
                if(encontroEstudiante && encontroCurso) {
                    frm_Matricula.habilitarAgregar();
                }
                
                if(e.getActionCommand().equals("Agregar")) {
                    frm_Matricula.cargarTabla();
                    encontroCurso=false;
                    frm_Matricula.estadoInicial();
                    frm_Matricula.limpiarEst();
                    frm_Matricula.limpiarCurso(); 
                }
                
                if(e.getActionCommand().equals("Finalizar")) {  
                    
                    for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
                    {
                       conexionBD1.registrarMatricula(frm_Matricula.getInformacionTablaMatricula(contador));
                       conexionBD1.registrarDetalleMatricula(frm_Matricula.getInformacionTablaDetalle(contador));
                    }
                    frm_Matricula.resetearInterfaz();

                    metodosMatricula.mostrarInformacion();
                }
                
                break;
                //Fin del caso Bases de Datos
            
        }//Fin del switch
        
//        if(e.getActionCommand().equals("ConsultaRapidaEstudiante"))
//        {
//            if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
//            {
//                String arreglo[]=metodosEstudiantes.getArregloInformacion();
//                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
//                encontroEstudiante=true;        
//            }
//            else
//            {
//                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
//            }
//        }
//        if(e.getActionCommand().equals("ConsultaRapidaCurso"))
//        {
//           if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
//            {
//                String arreglo[]=metodosCursos.getArregloInformacion();
//                frm_Matricula.mostrarNombreCurso(arreglo[0]);
//                encontroCurso=true;
//            }
//            else
//            {
//                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
//            } 
//        }
//        if(e.getActionCommand().equals("Agregar"))
//        {  
//            frm_Matricula.cargarTabla();
//            encontroCurso=false;
//            frm_Matricula.estadoInicial();
//            frm_Matricula.limpiarCurso(); 
//        }
//        if(e.getActionCommand().equals("Finalizar"))
//        {  
//            for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
//            {
//               metodosMatricula.agregarMatricula(frm_Matricula.getInformacionTabla(contador));
//            }
//            frm_Matricula.resetearInterfaz();
//            
//            metodosMatricula.mostrarInformacion();
//        }
//        
//        if(encontroEstudiante && encontroCurso)
//        {
//            frm_Matricula.habilitarAgregar();
//        }
        
    }
    public String colocarCodigo()
    {
        conexionBD1.contarNumeroFilasMatricula();
        return conexionBD1.devolverCodigoMatricula();
    }
}
