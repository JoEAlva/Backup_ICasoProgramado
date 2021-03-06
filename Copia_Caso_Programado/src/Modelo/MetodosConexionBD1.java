/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class MetodosConexionBD1 {
    
    //Referencias
    Connection con = null;
    public String infoEst[];
    public String infoCurso[];
    public String infoUsuario[];
    public String infoLogin[];
    public String infoEstMatricula[];
    public String infoCursoMatricula[];
    public String nombreCurso;
    public String nombreEst;
    public int numeroFila = 0;
    
    String nombre = "";
    String direccion = "";
            
    //Se declaran las variables
    
    //Constructor
    public MetodosConexionBD1() {
                
        infoEst = new String[2];
        infoCurso = new String[3];
        infoUsuario = new String[5];
        infoLogin = new String[2];
        infoEstMatricula = new String[2];
        infoCursoMatricula = new String[2];
        
    }//Fin constructor
    
    /*
    Realiza la conexion con la base de datos
    */
    public boolean realizarConexion()
    {
        boolean conxR = false;
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            conxR = true;
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
        
        return conxR;
        
    }//Fin realizarConexion
    
    /*
    Registra un estudiante en la base de datos
    */
    public boolean registrarEstudiante(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
                cmd = con.createStatement();
                ejecutar = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }//Fin registrarEmpleado
    
    /*
    Altualiza los datos de la base de datos o modifica un estudiante
    */
    public boolean actualizarEstudiante(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("UPDATE estudiantes SET nombre='"+arregloInformacion[1]+"',direccion='"+arregloInformacion[2]+"' WHERE cedula='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia " + e.getMessage());
            return false;
        }
        
    }//Fin actualizarEstudiante
    
    /*
    Elimina un estudiante de la base de datos
    */
    public boolean eliminarEstudiante(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("DELETE FROM `estudiantes` WHERE cedula='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia "+e.getMessage());
            return false;
        }
        
    }//Fin eliminarEstudiante
    
    /*
    Busca un estuddiante en la base de datos y guarda los valores un arreglo
    */
    public boolean consultarEstudiante(String cedula) {
        
        boolean existe = false;
        ResultSet rs = null;
        Statement cmd = null;
        String info[] = new String[3];

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre, direccion FROM estudiantes WHERE cedula = '"+cedula+"'");
                
                while (rs.next()) 
                {
                    info[0] = ""+cedula;
                    info[1] = rs.getString("nombre");
                    info[2] = rs.getString("direccion");
                    //int edad = rs.getInt(2);
                    this.infoEst = info;
                    existe = true;
                    
                }
                
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
        return existe;
       
    }//Fin consultarEmpleado

    /*
    Retorna el arreglo con la información del estudiante
    */
    public String[] devolverArregloEst() {
        
        return this.infoEst;
        
    }//Fin devolverArregloInformacion

    /*
    Registra un estudiante en la base de datos
     */
    public boolean registrarCurso(String arregloInformacion[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
            cmd = con.createStatement();
            ejecutar = cmd.execute("INSERT INTO cursos(sigla, nombre, creditos, horario) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"','"+arregloInformacion[3]+"')");
            
            return true;
            // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    } //Fin registrarEmpleado
    
    /*
    Altualiza los datos de la base de datos o modifica un estudiante
    */
    public boolean actualizarCurso(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("UPDATE cursos SET nombre='"+arregloInformacion[1]+"',creditos='"+arregloInformacion[2]+"',horario='"+arregloInformacion[3]+"' WHERE sigla='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia " + e.getMessage());
            return false;
        }
        
    }//Fin actualizarEstudiante
    
    /*
    Elimina un estudiante de la base de datos
    */
    public boolean eliminarCurso(String sigla) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("DELETE FROM `cursos` WHERE sigla='"+sigla+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia "+e.getMessage());
            return false;
        }
        
    }//Fin eliminarEstudiante
    
    /*
    Busca un estuddiante en la base de datos y guarda los valores un arreglo
    */
    public boolean consultarCurso(String sigla) {
        
        boolean existe = false;
        ResultSet rs = null;
        Statement cmd = null;
        String info[] = new String[4];

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT sigla, nombre, creditos, horario FROM cursos WHERE sigla = '"+sigla+"'");
                
                while (rs.next()) 
                {
                    info[0] = ""+sigla;
                    info[1] = rs.getString("nombre");
                    info[2] = ""+rs.getInt("creditos");
                    info[3] = rs.getString("horario");
                    //int edad = rs.getInt(2);
                    this.infoCurso = info;
                    existe = true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
        return existe;
        
    }//Fin consultarEmpleado
    
    /*
    
    */
    public String[] devolverArregloCurso() {
        
        return this.infoCurso;
        
    }//Fin devolverArregloCurso
    
    /*
    
    */
    public boolean consultarCursoMatricula(String sigla) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe = false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre FROM cursos WHERE sigla = '"+sigla+"'");
                
                while (rs.next()) 
                {
                   
                    String nombreCurso = rs.getString("nombre");
                    this.nombreCurso = nombreCurso;
                    existe = true;
                    //int edad = rs.getInt(2);
                   
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }//Fin consultarCursoMatricula
    
    /*
    
    */
    public String devolverNombreCurso() {
        
        return this.nombreCurso;
        
    }//Fin devolverNombreCurso
    
    /*
    
    */
    public void msjCursoNoEncontrado() {
        JOptionPane.showMessageDialog(null, "No se encuentra el curso, diríjase al módulo Mantenimiento Cursos", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    /*
    
    */
    public boolean consultarEstudianteMatricula(String cedula) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe = false;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre FROM estudiantes WHERE cedula = '"+cedula+"'");
                
                while (rs.next()) 
                {
                    
                    String nombreEst = rs.getString("nombre");
                    this.nombreEst = nombreEst;
                    existe = true;
                   
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }//Fin consultarEstudianteMatricula
    
    /*
    
    */
    public String devolverNombreEst() {
        
        return this.nombreEst;
        
    }//Fin devolverNombreEst
    
    /*
    
    */
    public void msjEstNoEncontrado() {
        JOptionPane.showMessageDialog(null, "No se encuentra el estudiante, diríjase al módulo Mantenimiento Estudiantes", "Universidad de Costa Rica", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean metodoLogin(String usuario, String contrasena) {
        
        boolean existe = false;
        ResultSet rs = null;
        Statement cmd = null;
        String info[] = new String[2];

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombreUsuario, contrasena FROM usuarios WHERE nombreUsuario = '"+usuario+"'");
                
                while (rs.next()) 
                {
                    info[0] = rs.getString("nombreUsuario");
                    info[1] = rs.getString("contrasena");
                    
                    //int edad = rs.getInt(2);
                    this.infoLogin = info;
                    existe = true;
                    
                }
                
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    
    public String[] devolverArregloLogin() {
        return this.infoLogin;
    }
    
    /*
    Registra un estudiante en la base de datos
    */
    public boolean registrarUsuario(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
                cmd = con.createStatement();
                ejecutar = cmd.execute("INSERT INTO usuarios(idUsuario, nombreCompleto, nombreUsuario, contrasena, tipo) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"','"+arregloInformacion[3]+"','"+arregloInformacion[4]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }//Fin registrarEmpleado
    
    /*
    Altualiza los datos de la base de datos o modifica un estudiante
    */
    public boolean actualizarUsuario(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("UPDATE usuarios SET nombreCompleto='"+arregloInformacion[1]+"',nombreUsuario='"+arregloInformacion[2]+"',contrasena='"+arregloInformacion[3]+"', tipo='"+arregloInformacion[4]+"' WHERE idUsuario='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia " + e.getMessage());
            return false;
        }
        
    }//Fin actualizarEstudiante
    
    /*
    Elimina un estudiante de la base de datos
    */
    public boolean eliminarUsuario(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("DELETE FROM `usuarios` WHERE idUsuario='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia "+e.getMessage());
            return false;
        }
        
    }//Fin eliminarEstudiante
    
    /*
    Busca un estuddiante en la base de datos y guarda los valores un arreglo
    */
    public boolean consultarUsuario(String idUsuario) {
        
        boolean existe = false;
        ResultSet rs = null;
        Statement cmd = null;
        String info[] = new String[5];

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombreCompleto, nombreUsuario, contrasena, tipo FROM usuarios WHERE idUsuario = '"+idUsuario+"'");
                
                while (rs.next()) 
                {
                    info[0] = ""+idUsuario;
                    info[1] = rs.getString("nombreCompleto");
                    info[2] = rs.getString("nombreUsuario");
                    info[3] = rs.getString("contrasena");
                    info[4] = rs.getString("tipo");
                    //int edad = rs.getInt(2);
                    this.infoUsuario = info;
                    existe = true;
                    
                }
                
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
        return existe;
       
    }//Fin consultarEmpleado

    /*
    Retorna el arreglo con la información del estudiante
    */
    public String[] devolverArregloUsuar() {
        
        return this.infoUsuario;
        
    }//Fin devolverArregloInformacion
    
    /*
    
    */
    public boolean registrarMatricula(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        String arregloInfoMatricula[] = new String[3];
        
        try {
            cmd = con.createStatement();
            ejecutar = cmd.execute("INSERT INTO matricula(codigo, cedula, sigla) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"')");
            
            return true;
            // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    } //Fin registrarEmpleado
    
    /*
    
    */
    public boolean registrarDetalleMatricula(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
            cmd = con.createStatement();
            ejecutar = cmd.execute("INSERT INTO detalle_matricula(cedula, nombreEstudiate, sigla, nombreCurso) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"','"+arregloInformacion[3]+"')");
            
            return true;
            // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }//Fin registrarDetalleMatricula
    
    public void contarNumeroFilasMatricula() {
        
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(*) AS total FROM matricula ");
                
                while (rs.next()) 
                {
                    
                    int totalFilas = rs.getInt("total");
                    this.numeroFila = totalFilas+1;
                    System.out.println(" "+totalFilas);
                    System.out.println("Pasó por aquí");
                    
                   
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: contarFilas" + e.getMessage());
        }
        
    }//Fin consultarEstudianteMatricula
    
    public int generarCodigo() {
        return this.numeroFila;
    }
    
    /*
    Devuele un número entero que representa un código
    */
    public String devolverCodigoMatricula() {
        
        return ""+this.numeroFila;
        
    }
    
}//Fin MetodoConexionBD
