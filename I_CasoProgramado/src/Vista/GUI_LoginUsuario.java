/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
//import Controlador.Controlador_FRM_UsuarioLogin;
import Controlador.Controlador_FRM_MantenimientoUsuarios;

/**
 *
 * @author JorgeIgnacio
 */
public class GUI_LoginUsuario extends javax.swing.JPanel {

    //Controlador_FRM_UsuarioLogin controlador_FRM_UsuarioLogin;
    Controlador_FRM_MantenimientoUsuarios cfrmmu;
    /**
     * Creates new form GUI_LoginUsuario
     */
    public GUI_LoginUsuario() {
        initComponents();
        
    }
    
    public String[] devolverInfoLogin()
    {
   
        char[] pass = this.jP_Contrasena.getPassword();
        String passString = new String(pass);

        String arregloLogin[] = new String[2];
        
        arregloLogin[0] = this.jT_Usuario.getText();
        arregloLogin[1] = passString;
        
        System.out.println("Esta es el usuario " + arregloLogin[0] );
        System.out.println("Esta es la password " + arregloLogin[1] );
        return arregloLogin;
    }
    
    public void agregarEventos(Controlador_FRM_MantenimientoUsuarios cfrmmu)
    {
        this.cfrmmu=cfrmmu;
        this.jB_Login.addActionListener(cfrmmu);
    }
    
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Usuario = new javax.swing.JLabel();
        jT_Usuario = new javax.swing.JTextField();
        jP_Contrasena = new javax.swing.JPasswordField();
        jL_Contrasena = new javax.swing.JLabel();
        jB_Login = new javax.swing.JButton();

        jL_Usuario.setText("Usuario");

        jP_Contrasena.setName("jT_pass"); // NOI18N

        jL_Contrasena.setText("Contraseña");

        jB_Login.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jL_Contrasena)
                    .addComponent(jL_Usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Login)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jP_Contrasena)
                        .addComponent(jT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Usuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jP_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Contrasena))
                .addGap(18, 18, 18)
                .addComponent(jB_Login)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Login;
    private javax.swing.JLabel jL_Contrasena;
    private javax.swing.JLabel jL_Usuario;
    private javax.swing.JPasswordField jP_Contrasena;
    private javax.swing.JTextField jT_Usuario;
    // End of variables declaration//GEN-END:variables
}
