/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Ctr_FRM_VentanaNodos;
import modelo.MetodosNodo;
/**
 *
 * @author JorgeIgnacio
 */
public class FRM_VentanaNodos extends javax.swing.JFrame {

    //Referencias
    Ctr_FRM_VentanaNodos ctr_FRM_VentanaNodos;
    
    public FRM_VentanaNodos() {
        initComponents();
        ctr_FRM_VentanaNodos = new Ctr_FRM_VentanaNodos(this);
        this.setLocation(475, 75);
        agregarEventos();
    }
    
    public void agregarEventos() {
        this.jB_CrearLista.addActionListener(ctr_FRM_VentanaNodos);
        this.jB_AgregarAlFinal.addActionListener(ctr_FRM_VentanaNodos);
        this.jB_Modificar.addActionListener(ctr_FRM_VentanaNodos);
        this.jB_Eliminar.addActionListener(ctr_FRM_VentanaNodos);
        this.jB_MenorMayor.addActionListener(ctr_FRM_VentanaNodos);
        this.jB_MayorMenor.addActionListener(ctr_FRM_VentanaNodos);
    }
    
    public int getCantidad() {
        return Integer.parseInt(jT_Cant_Nodos.getText().trim());
    }
    
    public String getAgregarAlFinal() {
        return this.jT_AgregarAlFinal.getText();
    }
    
    public void limpiarInterfaz() {
        this.jTA_Informacion.setText("");
    }
    
    public void imprimirEnTextArea(String texto) {
        this.jTA_Informacion.setText(texto);
    }
    
    public int datoModificar() {
        return Integer.parseInt(this.jT_DatoModificar.getText());
    }
    
    public int datoNuevo() {
        return Integer.parseInt(this.jT_DatoNuevo.getText());
    }
    
    public int getDatoEliminar() {
        return Integer.parseInt(this.jT_Eliminar.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Cant_Nodos = new javax.swing.JLabel();
        jT_Cant_Nodos = new javax.swing.JTextField();
        jB_CrearLista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA_Informacion = new javax.swing.JTextArea();
        jL_AgregarAlFinal = new javax.swing.JLabel();
        jT_AgregarAlFinal = new javax.swing.JTextField();
        jT_DatoModificar = new javax.swing.JTextField();
        jL_DatoModificar = new javax.swing.JLabel();
        jB_AgregarAlFinal = new javax.swing.JButton();
        jL_DatoNuevo = new javax.swing.JLabel();
        jT_DatoNuevo = new javax.swing.JTextField();
        jB_Modificar = new javax.swing.JButton();
        jL_Eliminar = new javax.swing.JLabel();
        jT_Eliminar = new javax.swing.JTextField();
        jB_Eliminar = new javax.swing.JButton();
        jLOrdenar = new javax.swing.JLabel();
        jB_MayorMenor = new javax.swing.JButton();
        jB_MenorMayor = new javax.swing.JButton();
        jL_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_Cant_Nodos.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jL_Cant_Nodos.setText("Cantidad de Nodos");
        getContentPane().add(jL_Cant_Nodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 17, -1, -1));
        getContentPane().add(jT_Cant_Nodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 15, 60, -1));

        jB_CrearLista.setBackground(new java.awt.Color(102, 0, 0));
        jB_CrearLista.setForeground(new java.awt.Color(204, 204, 204));
        jB_CrearLista.setText("Crear Lista");
        jB_CrearLista.setActionCommand("CrearLista");
        getContentPane().add(jB_CrearLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 12, 120, -1));

        jTA_Informacion.setBackground(new java.awt.Color(204, 204, 204));
        jTA_Informacion.setColumns(20);
        jTA_Informacion.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTA_Informacion.setRows(5);
        jScrollPane1.setViewportView(jTA_Informacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 322, 190));

        jL_AgregarAlFinal.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jL_AgregarAlFinal.setText("Agregar al final");
        getContentPane().add(jL_AgregarAlFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 61, 100, -1));
        getContentPane().add(jT_AgregarAlFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 59, 60, -1));
        getContentPane().add(jT_DatoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 100, 60, -1));

        jL_DatoModificar.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jL_DatoModificar.setText("Dato a modificar");
        getContentPane().add(jL_DatoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 102, 90, -1));

        jB_AgregarAlFinal.setBackground(new java.awt.Color(102, 0, 0));
        jB_AgregarAlFinal.setForeground(new java.awt.Color(204, 204, 204));
        jB_AgregarAlFinal.setText("Agregar al final");
        jB_AgregarAlFinal.setActionCommand("AgregarFinal");
        getContentPane().add(jB_AgregarAlFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 56, 120, -1));

        jL_DatoNuevo.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jL_DatoNuevo.setText("Dato nuevo");
        getContentPane().add(jL_DatoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 143, 60, -1));
        getContentPane().add(jT_DatoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 141, 60, -1));

        jB_Modificar.setBackground(new java.awt.Color(102, 0, 0));
        jB_Modificar.setForeground(new java.awt.Color(204, 204, 204));
        jB_Modificar.setText("Modificar");
        getContentPane().add(jB_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 138, 120, -1));

        jL_Eliminar.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jL_Eliminar.setText("Dato a eliminar");
        getContentPane().add(jL_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 187, 80, -1));
        getContentPane().add(jT_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 185, 60, -1));

        jB_Eliminar.setBackground(new java.awt.Color(102, 0, 0));
        jB_Eliminar.setForeground(new java.awt.Color(204, 204, 204));
        jB_Eliminar.setText("Eliminar");
        getContentPane().add(jB_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 182, 120, -1));

        jLOrdenar.setFont(new java.awt.Font("Impact", 2, 12)); // NOI18N
        jLOrdenar.setText("Ordenar lista");
        getContentPane().add(jLOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 231, 85, -1));

        jB_MayorMenor.setBackground(new java.awt.Color(0, 0, 102));
        jB_MayorMenor.setForeground(new java.awt.Color(204, 204, 204));
        jB_MayorMenor.setText(">");
        jB_MayorMenor.setActionCommand("MayorMenor");
        getContentPane().add(jB_MayorMenor, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 226, 60, -1));

        jB_MenorMayor.setBackground(new java.awt.Color(0, 0, 102));
        jB_MenorMayor.setForeground(new java.awt.Color(204, 204, 204));
        jB_MenorMayor.setText("<");
        jB_MenorMayor.setActionCommand("MenorMayor");
        getContentPane().add(jB_MenorMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 226, 60, -1));

        jL_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image10.png"))); // NOI18N
        getContentPane().add(jL_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FRM_VentanaNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VentanaNodos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_AgregarAlFinal;
    private javax.swing.JButton jB_CrearLista;
    private javax.swing.JButton jB_Eliminar;
    private javax.swing.JButton jB_MayorMenor;
    private javax.swing.JButton jB_MenorMayor;
    private javax.swing.JButton jB_Modificar;
    private javax.swing.JLabel jLOrdenar;
    private javax.swing.JLabel jL_AgregarAlFinal;
    private javax.swing.JLabel jL_Cant_Nodos;
    private javax.swing.JLabel jL_DatoModificar;
    private javax.swing.JLabel jL_DatoNuevo;
    private javax.swing.JLabel jL_Eliminar;
    private javax.swing.JLabel jL_Fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTA_Informacion;
    private javax.swing.JTextField jT_AgregarAlFinal;
    private javax.swing.JTextField jT_Cant_Nodos;
    private javax.swing.JTextField jT_DatoModificar;
    private javax.swing.JTextField jT_DatoNuevo;
    private javax.swing.JTextField jT_Eliminar;
    // End of variables declaration//GEN-END:variables
}
