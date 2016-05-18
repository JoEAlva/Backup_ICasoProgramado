/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_MenuPrincipal;
import Vista.FRM_SistemaInformacion;
import Modelo.Manejador_Ventanas;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class FRM_MenuPrincipal extends javax.swing.JFrame {

    //Se declaran las variables
    private String registro = "";
    public String sistemaInformacion = "";
    
    //Referencias
    Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal;
    Manejador_Ventanas manejador_Clases;
    FRM_SistemaInformacion frmsi;
    
    //Constructor de la clase
    public FRM_MenuPrincipal() {
        
        initComponents();
        this.setLocation(100, 100);
        frmsi = new FRM_SistemaInformacion(this);
        
        manejador_Clases = new Manejador_Ventanas(this, frmsi);
        controlador_FRM_MenuPrincipal = new Controlador_FRM_MenuPrincipal(manejador_Clases);
              
               
        agregarEventos();
        
    }//Fin del constructor 
    
    /*
    Método pasa por parámetro el valor asginado de la clase FRM_SistemaInformacion
    */
    public void seleccionarFuenteDeInformacion()
    {
        controlador_FRM_MenuPrincipal.setFuenteDeInformacion(frmsi.getSistemaInformacion());
    }
    
    /*
    Método que agrega un evento a cada uno de los JMenu 
    */
    public void agregarEventos()
    {
        this.jm_Salir.addActionListener(controlador_FRM_MenuPrincipal);
        this.jm_Estudiantes.addActionListener(controlador_FRM_MenuPrincipal);
        this.jm_Cursos.addActionListener(controlador_FRM_MenuPrincipal);
        this.jm_Matricula.addActionListener(controlador_FRM_MenuPrincipal);
        this.jM_Usuarios.addActionListener(controlador_FRM_MenuPrincipal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jB_RegistrarEstudiante = new javax.swing.JButton();
        jB_RegistrarCurso = new javax.swing.JButton();
        jB_RegistrarUsuario = new javax.swing.JButton();
        jm_MenuPrincipal = new javax.swing.JMenuBar();
        jm_Archivo = new javax.swing.JMenu();
        jm_Salir = new javax.swing.JMenuItem();
        jm_Mantenimientos = new javax.swing.JMenu();
        jm_Estudiantes = new javax.swing.JMenuItem();
        jm_Cursos = new javax.swing.JMenuItem();
        jm_Matricula = new javax.swing.JMenuItem();
        jM_Usuarios = new javax.swing.JMenuItem();
        jM_Reportes = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jB_RegistrarEstudiante.setText("Registrar Estudiante");
        jB_RegistrarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_RegistrarEstudianteActionPerformed(evt);
            }
        });

        jB_RegistrarCurso.setText("Registrar Curso");
        jB_RegistrarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_RegistrarCursoActionPerformed(evt);
            }
        });

        jB_RegistrarUsuario.setText("Registrar Usuario");
        jB_RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_RegistrarUsuarioActionPerformed(evt);
            }
        });

        jm_Archivo.setText("Archivo");

        jm_Salir.setText("Salir");
        jm_Archivo.add(jm_Salir);

        jm_MenuPrincipal.add(jm_Archivo);

        jm_Mantenimientos.setText("Mantenimientos");

        jm_Estudiantes.setText("Estudiantes");
        jm_Mantenimientos.add(jm_Estudiantes);

        jm_Cursos.setText("Cursos");
        jm_Mantenimientos.add(jm_Cursos);

        jm_Matricula.setText("Matrícula");
        jm_Matricula.setActionCommand("Matricula");
        jm_Mantenimientos.add(jm_Matricula);

        jM_Usuarios.setText("Usuarios");
        jm_Mantenimientos.add(jM_Usuarios);

        jm_MenuPrincipal.add(jm_Mantenimientos);

        jM_Reportes.setText("Reportes");
        jm_MenuPrincipal.add(jM_Reportes);

        setJMenuBar(jm_MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jB_RegistrarEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_RegistrarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_RegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(597, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jB_RegistrarEstudiante)
                .addGap(18, 18, 18)
                .addComponent(jB_RegistrarCurso)
                .addGap(18, 18, 18)
                .addComponent(jB_RegistrarUsuario)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_RegistrarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_RegistrarEstudianteActionPerformed
        
//        registro = "Estudiantes";
//        frmsi.setVisible(true);
        
    }//GEN-LAST:event_jB_RegistrarEstudianteActionPerformed

    private void jB_RegistrarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_RegistrarCursoActionPerformed
//
//        registro = "Cursos";
//        frmsi.setVisible(true);
        
    }//GEN-LAST:event_jB_RegistrarCursoActionPerformed

    private void jB_RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_RegistrarUsuarioActionPerformed
        
//        registro = "Usuarios";
//        frmsi.setVisible(true);
        
    }//GEN-LAST:event_jB_RegistrarUsuarioActionPerformed

    /*
    
    */
    public String getRegistro() {
        
        return registro;
        
    }//
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new FRM_MenuPrincipal();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_RegistrarCurso;
    private javax.swing.JButton jB_RegistrarEstudiante;
    private javax.swing.JButton jB_RegistrarUsuario;
    private javax.swing.JMenu jM_Reportes;
    private javax.swing.JMenuItem jM_Usuarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jm_Archivo;
    private javax.swing.JMenuItem jm_Cursos;
    private javax.swing.JMenuItem jm_Estudiantes;
    private javax.swing.JMenu jm_Mantenimientos;
    private javax.swing.JMenuItem jm_Matricula;
    private javax.swing.JMenuBar jm_MenuPrincipal;
    private javax.swing.JMenuItem jm_Salir;
    // End of variables declaration//GEN-END:variables

}//Fin FRM_MenuPrincipal
