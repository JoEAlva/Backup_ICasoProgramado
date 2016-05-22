/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.Controlador_FRM_MantenimientoUsuarios;
/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class GUI_InformacionUsuario extends javax.swing.JPanel {

    //Referencias
    Controlador_FRM_MantenimientoUsuarios controlador_FRM_MantenimientoUsuarios;
    
    public GUI_InformacionUsuario() {
        initComponents();
        llenarComboBox();
        
    }
    
    /*
    Método que devuelve la información de los jT
    */
    public String[] devolverInfoUsuario()
    {
        String arregloUsuario[] = new String[5];
        arregloUsuario[0] = this.jT_IdUsuario.getText();
        arregloUsuario[1] = this.jT_NombreCompleto.getText();
        arregloUsuario[2] = this.jT_NombreUsuario.getText();
        arregloUsuario[3] = this.jT_Contrasena.getText();
        arregloUsuario[4] = ""+this.jC_TipoUsuario.getSelectedIndex();
        return arregloUsuario;
    }
    
    public String devolverIdUsuario() {
        return this.jT_IdUsuario.getText();
    }
    
    /*
    Método que recibe un arreglo para mostrar los datos del usuario en pantalla
    */
    public void mostrarInfoPantalla(String arregloUsuario[])
    {
        this.jT_IdUsuario.setText(arregloUsuario[0]);
        this.jT_NombreCompleto.setText(arregloUsuario[1]);
        this.jT_NombreUsuario.setText(arregloUsuario[2]);
        this.jT_Contrasena.setText(arregloUsuario[3]);
        this.jC_TipoUsuario.setSelectedIndex(Integer.parseInt(arregloUsuario[4]));
    }
    
    /*
    Método que limpia los jT
    */
    public void limpiarCampos()
    {
        this.jT_IdUsuario.setText("");
        this.jT_NombreCompleto.setText("");
        this.jT_IdUsuario.setText("");
        this.jC_TipoUsuario.setSelectedIndex(1);
        this.jT_NombreUsuario.setText("");
        this.jT_Contrasena.setText("");
        
    }
    
    /*
    Método que llena el jC con opciones para el tipo de usurio
    */
    public void llenarComboBox()
    {
        this.jC_TipoUsuario.removeAllItems();
        String arregloTipoUsuario[] = new String[4];
        arregloTipoUsuario[0] = "Usuario Normal";
        arregloTipoUsuario[1] = "Programador de Aplicaciones";
        arregloTipoUsuario[2] = "Usuario Sofisticado";
        arregloTipoUsuario[3] = "Usuario Especializado";
        
        for(int j=0; j<arregloTipoUsuario.length; j++)
        {
            this.jC_TipoUsuario.addItem(arregloTipoUsuario[j]);
            
        }
        this.jC_TipoUsuario.setSelectedIndex(2);
    }
    
    /*
    Método que hablita los campos para editarlos
    */
    public void estadoInicialCampos() {
        this.jT_IdUsuario.setEnabled(true);
        this.jT_NombreCompleto.setEnabled(false);
        this.jT_NombreUsuario.setEnabled(false);
        this.jT_Contrasena.setEnabled(false);
        this.jC_TipoUsuario.setEnabled(false);
    }
    
    /*
    
    */
    public void administrarCampos() {
        this.jT_IdUsuario.setEnabled(false);
        this.jT_NombreCompleto.setEnabled(true);
        this.jT_NombreUsuario.setEnabled(true);
        this.jT_Contrasena.setEnabled(true);
        this.jC_TipoUsuario.setEnabled(true);
    }
    
    public void agregarEventoConsultaRapida(Controlador_FRM_MantenimientoUsuarios controlador_FRM_MantenimientoUsuarios) {
        this.controlador_FRM_MantenimientoUsuarios = controlador_FRM_MantenimientoUsuarios;
    }
    
    /*
    Método que comprueba si todos los campos se encuentran llenos
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_NombreCompleto = new javax.swing.JLabel();
        jT_NombreCompleto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jT_NombreUsuario = new javax.swing.JTextField();
        jL_Contrasena = new javax.swing.JLabel();
        jT_Contrasena = new javax.swing.JTextField();
        jL_TipoUsuario = new javax.swing.JLabel();
        jC_TipoUsuario = new javax.swing.JComboBox<>();
        jL_Usuario = new javax.swing.JLabel();
        jT_IdUsuario = new javax.swing.JTextField();

        jL_NombreCompleto.setText("Nombre");

        jLabel1.setText("Usuario");

        jL_Contrasena.setText("Contraseña");

        jL_TipoUsuario.setText("Tipo");

        jC_TipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jL_Usuario.setText("ID_Usuario");

        jT_IdUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_IdUsuarioKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jL_TipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jT_NombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jC_TipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jL_Contrasena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jT_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jL_Usuario)
                            .addComponent(jL_NombreCompleto))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jT_IdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Usuario)
                    .addComponent(jT_IdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_NombreCompleto)
                    .addComponent(jT_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Contrasena)
                    .addComponent(jT_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jT_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_TipoUsuario)
                    .addComponent(jC_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jT_IdUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_IdUsuarioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10) {
            this.controlador_FRM_MantenimientoUsuarios.consultaRapida();
        }
    }//GEN-LAST:event_jT_IdUsuarioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jC_TipoUsuario;
    private javax.swing.JLabel jL_Contrasena;
    private javax.swing.JLabel jL_NombreCompleto;
    private javax.swing.JLabel jL_TipoUsuario;
    private javax.swing.JLabel jL_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jT_Contrasena;
    private javax.swing.JTextField jT_IdUsuario;
    private javax.swing.JTextField jT_NombreCompleto;
    private javax.swing.JTextField jT_NombreUsuario;
    // End of variables declaration//GEN-END:variables
}
