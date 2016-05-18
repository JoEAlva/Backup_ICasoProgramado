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
 * @author JorgeIgnacioElizondoAlvarado
 */
public class FRM_SistemaInformacion extends javax.swing.JFrame {

    //Referencias
    FRM_MenuPrincipal frmmp;
    FRM_MantenimientoEstudiantes frmme;
    FRM_MantenimientoCursos frmmc;
    FRM_MantenimientoUsuarios frmmu;
    
    //Se declaran las variables
    String sistemaInfo = "";//Almacena el sistema de información seleccionado por el usuario
    
    //Constructor de la clase
    public FRM_SistemaInformacion(FRM_MenuPrincipal frmmp) {
        
        initComponents();
        
        this.setLocation(450, 200);//Ubica la ésta ventana en un llugar específico
        this.jRB_ArchivosPlanos.setSelected(true);//Selecciona el radioButton especificado
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

        grupoSistemaInformacion = new javax.swing.ButtonGroup();
        jRB_ArchivosPlanos = new javax.swing.JRadioButton();
        jRB_XML = new javax.swing.JRadioButton();
        jRB_Bases_de_Datos = new javax.swing.JRadioButton();
        jB_Aceptar = new javax.swing.JButton();

        grupoSistemaInformacion.add(jRB_ArchivosPlanos);
        jRB_ArchivosPlanos.setText("Archivos Planos");

        grupoSistemaInformacion.add(jRB_XML);
        jRB_XML.setText("XML");

        grupoSistemaInformacion.add(jRB_Bases_de_Datos);
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
        
        /*
        Cualquiera de los tres opciones a elegir asigna un valor identificativo
        a la variable "sistemaInfo" para ser utilizada luego.
        */
        
        if(this.jRB_ArchivosPlanos.isSelected()) {
            
            sistemaInfo = "ArchivosPlanos";
            
        }
        
        if(this.jRB_XML.isSelected()) {
            
            sistemaInfo = "XML";
            
        }
        
        if(this.jRB_Bases_de_Datos.isSelected()) {
                
            sistemaInfo = "Bases_de_Datos";
                                
        }        
                                
        frmmp.setVisible(true);//Muestra FRM_MenuPrincipal al ser pulsado el botón "Aceptar"
        frmmp.seleccionarFuenteDeInformacion();//Método que 
        setVisible(false);//Oculta FRM_SistemaInformacion al ser pulsado el botón "Aceptar"       
                
                                
            
            
            
                                          
    }//GEN-LAST:event_jB_AceptarActionPerformed

    /*
    Método que se encarga de devolver el sistema de información a utilizar por
    el usuario en determinado tiempo
    @return sistemaInformacion variable que se utiliza para elegir luego el
    sistema de informaición a utilizar
    */
    public String getSistemaInformacion() {
        
        return sistemaInfo;
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoSistemaInformacion;
    private javax.swing.JButton jB_Aceptar;
    private javax.swing.JRadioButton jRB_ArchivosPlanos;
    private javax.swing.JRadioButton jRB_Bases_de_Datos;
    private javax.swing.JRadioButton jRB_XML;
    // End of variables declaration//GEN-END:variables
}
