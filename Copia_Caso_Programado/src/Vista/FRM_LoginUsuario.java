/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.Controlador_FRM_LoginUsuario;
import Vista.FRM_MantenimientoUsuarios;
import Modelo.MetodosConexionBD1;
import Modelo.MetodosUsuario;
import Modelo.Manejador_Ventanas;
import javax.swing.JOptionPane;

/**
 *
 * @author JorgeIgnacio
 */
public class FRM_LoginUsuario extends javax.swing.JFrame {

    //Se declaran las variables de la clase
    String sistemaInformacion = "";
    
    //Referencias
    FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios;
    MetodosConexionBD1 metodosConexionBD1;
    Controlador_FRM_LoginUsuario controlador_FRM_LoginUsuario;
    MetodosUsuario metodosUsuario;
    Manejador_Ventanas manejador_Ventanas;
    
    
    
    /**
     * Constructor de la clase
     */
    public FRM_LoginUsuario(String sistemaInformacion, MetodosConexionBD1 metodosConexionBD1) {
        
        initComponents();
        setLocation(450, 200);
        this.metodosConexionBD1 = metodosConexionBD1;
        this.sistemaInformacion = sistemaInformacion;
        
//        controlador_FRM_LoginUsuario = new Controlador_FRM_LoginUsuario(this, this.sistemaInformacion, this.metodosConexionBD1);
        agregarEventoBtn();
        
    }
    
    /*
    Agrega las funciones al botón
    */
    public void agregarEventoBtn() {
        this.jB_Entrar.addActionListener(controlador_FRM_LoginUsuario);
    }
    
    
    /*
    Método que extrae los datos de los campos
    */
    public String getInfoPass() {
        
        char[] arrayC = this.jP_Contrasena.getPassword();
        String pass = new String(arrayC);
        
        return pass;
        
    }
    
    public String getUsuario() {
        
        String user = this.jT_Usuario.getText();
        return user;
        
    }
    
    public void limpiarCampos() {
        this.jT_Usuario.setText("");
        this.jP_Contrasena.setText("");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_Entrar = new javax.swing.JButton();
        jL_Usuario = new javax.swing.JLabel();
        jL_Contrasena = new javax.swing.JLabel();
        jT_Usuario = new javax.swing.JTextField();
        jP_Contrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jB_Entrar.setText("Entrar al Sistema");
        jB_Entrar.setActionCommand("Entrar");
        jB_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_EntrarActionPerformed(evt);
            }
        });

        jL_Usuario.setText("Usuario");

        jL_Contrasena.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jB_Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jL_Contrasena)
                            .addComponent(jL_Usuario))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jP_Contrasena)
                            .addComponent(jT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Usuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jP_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Contrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_Entrar)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_EntrarActionPerformed
        // TODO add your handling code here:
        switch(this.sistemaInformacion) {
            
            //En caso que fuera "ArchivosPlanos"
            case "ArchivosPlanos":
                
                System.err.println("Hola ArchivosPlanos");
                
                break;
                
            //En caso que fuera archivosXML
            case "XML":

                System.err.println("Hola XML");
                
                break;
            
            //En caso que fuera Bases_de_Datos
            case "Bases_de_Datos":

                System.err.println("Bases_de_Datos");
                
                break;
                
        }//Fin del switch
    }//GEN-LAST:event_jB_EntrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Entrar;
    private javax.swing.JLabel jL_Contrasena;
    private javax.swing.JLabel jL_Usuario;
    private javax.swing.JPasswordField jP_Contrasena;
    private javax.swing.JTextField jT_Usuario;
    // End of variables declaration//GEN-END:variables
}
