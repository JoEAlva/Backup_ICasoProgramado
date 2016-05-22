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
        this.jRB_Bases_de_Datos.setSelected(true);//Selecciona el radioButton especificado
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
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grupoSistemaInformacion.add(jRB_ArchivosPlanos);
        jRB_ArchivosPlanos.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jRB_ArchivosPlanos.setText("Archivos Planos");
        getContentPane().add(jRB_ArchivosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 75, 111, -1));

        grupoSistemaInformacion.add(jRB_XML);
        jRB_XML.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jRB_XML.setText("XML");
        getContentPane().add(jRB_XML, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 111, 111, -1));

        grupoSistemaInformacion.add(jRB_Bases_de_Datos);
        jRB_Bases_de_Datos.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jRB_Bases_de_Datos.setText("Bases de Datos");
        getContentPane().add(jRB_Bases_de_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 147, -1, -1));

        jB_Aceptar.setBackground(new java.awt.Color(0, 192, 243));
        jB_Aceptar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jB_Aceptar.setText("Aceptar");
        jB_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jB_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 183, 111, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoSistemaArchivos.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

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
        setVisible(false);//Oculta FRM_SistemaInformacion al ser pulsado el botón "Aceptar"                     
//        frmmp.setVisible(true);//Muestra FRM_MenuPrincipal al ser pulsado el botón "Aceptar"
        frmmp.seleccionarFuenteDeInformacion();//Método que 
        frmmp.controlador_FRM_MenuPrincipal.decisionVentana();
                                            
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRB_ArchivosPlanos;
    private javax.swing.JRadioButton jRB_Bases_de_Datos;
    private javax.swing.JRadioButton jRB_XML;
    // End of variables declaration//GEN-END:variables
}
