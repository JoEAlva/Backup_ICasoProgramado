/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionEvent;
import Vista.FRM_MenuPrincipal;

/**
 *
 * @author JorgeIgnacio
 */
public class FRM_SistemaInformacion extends javax.swing.JFrame {

    //Referencias
    FRM_MenuPrincipal frmmp;
    FRM_MantenimientoEstudiantes frmme;
    FRM_MantenimientoCursos frmmc;
    FRM_MantenimientoUsuarios frmmu;
    
    //Se declaran las variables
    String sistemaInfo = "";
    
    //Constructor de la clase
    public FRM_SistemaInformacion(FRM_MenuPrincipal frmmp) {
        
        initComponents();
        this.frmmp = frmmp;
                
    }//Fin del constructor
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regeneted by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRB_ArchivosPlanos = new javax.swing.JRadioButton();
        jRB_XML = new javax.swing.JRadioButton();
        jRB_Bases_de_Datos = new javax.swing.JRadioButton();
        jB_Aceptar = new javax.swing.JButton();

        jRB_ArchivosPlanos.setText("Archivos Planos");

        jRB_XML.setText("XML");

        jRB_Bases_de_Datos.setText("Bases de Datos");

        jB_Aceptar.setText("Aceptar");
        jB_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRB_Bases_de_Datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRB_XML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRB_ArchivosPlanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jB_Aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jRB_ArchivosPlanos)
                .addGap(18, 18, 18)
                .addComponent(jRB_XML)
                .addGap(18, 18, 18)
                .addComponent(jRB_Bases_de_Datos)
                .addGap(18, 18, 18)
                .addComponent(jB_Aceptar)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AceptarActionPerformed
        
        if(this.jRB_ArchivosPlanos.isSelected()) {
                
                sistemaInfo = "ArchivosPlanos";
                                
            }
            
            if(this.jRB_XML.isSelected()) {
                
                sistemaInfo = "XML";
                                
            }
            
            if(this.jRB_Bases_de_Datos.isSelected()) {
                
                sistemaInfo = "Bases_de_Datos";
                                
            }
            
            if(frmmp.getRegistro().equals("Estudiantes")) {
             
                frmme = new FRM_MantenimientoEstudiantes(sistemaInfo);
                this.setVisible(false);
                frmme.setVisible(true);
                
            }
            
            if(frmmp.getRegistro().equals("Cursos")) {
                
                frmmc = new FRM_MantenimientoCursos(sistemaInfo);
                this.setVisible(false);
                frmmc.setVisible(true);
                
            }
            
            if(frmmp.getRegistro().equals("Usuarios")) {
                
                frmmu = new FRM_MantenimientoUsuarios(sistemaInfo);
                this.setVisible(false);
                frmmu.setVisible(true);
                
            }
                                          
    }//GEN-LAST:event_jB_AceptarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Aceptar;
    private javax.swing.JRadioButton jRB_ArchivosPlanos;
    private javax.swing.JRadioButton jRB_Bases_de_Datos;
    private javax.swing.JRadioButton jRB_XML;
    // End of variables declaration//GEN-END:variables
}
