/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_MantenimientoUsuarios;
/**
 *
 * @author JorgeIgnacio
 */
public class FRM_MantenimientoUsuarios extends javax.swing.JFrame {

     //Referencia
    Controlador_FRM_MantenimientoUsuarios controlador_FRM_MantenimientoUsuarios;
    /**
     * Creates new form FRM_MantenimientoUsuarios
     */
    public FRM_MantenimientoUsuarios(FRM_UsuarioLogin frmul) {
        initComponents();
        controlador_FRM_MantenimientoUsuarios = new Controlador_FRM_MantenimientoUsuarios(this, frmul);
        
        this.gUI_Botones1.agregarEventos(controlador_FRM_MantenimientoUsuarios);            
    }
    
    /*
    
    */
    public String[] devolverInfoUsuario()
    {
        return this.gUI_InformacionUsuario2.devolverInfoUsuario();
    }
    
    /*
    
    */
    public void mostrarInfoPantalla(String arregloUsuario[])
    {
        this.gUI_InformacionUsuario2.mostrarInfoPantalla(arregloUsuario);
    }
    
    /*
    
    */
    public void limpiarCampos()
    {
        this.gUI_InformacionUsuario2.limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_Botones1 = new Vista.GUI_Botones2();
        gUI_InformacionUsuario2 = new Vista.GUI_InformacionUsuario();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gUI_InformacionUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gUI_InformacionUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
        controlador_FRM_MantenimientoUsuarios.metodosUsuario.escribirInformacionArchivo();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones2 gUI_Botones1;
    private Vista.GUI_InformacionUsuario gUI_InformacionUsuario2;
    // End of variables declaration//GEN-END:variables
}
