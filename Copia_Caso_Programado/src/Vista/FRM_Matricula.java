/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.MetodosConexionBD1;

/**
 *
 * @author JorgeIgnacioElizondoAlvarado
 */
public class FRM_Matricula extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Matricula
     */
    //Se declaran las variables
    String sistemaInfo = "";    
    DefaultTableModel modelo;
    
    //Referencias
    Controlador_FRM_Matricula controlador;
    MetodosConexionBD1 conexionBD1;
    
    public FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos, MetodosConexionBD1 conexionBD1, String sistemaInfo) {
        initComponents();
        
        this.sistemaInfo = sistemaInfo;
        this.conexionBD1 = conexionBD1;
        controlador=new Controlador_FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos,this, this.conexionBD1, this.sistemaInfo);
        modelo=new DefaultTableModel();
        this.tbl_Matricula.setModel(modelo);
        colocarTitulosTabla();
        agregarEventos();
        gUI_Botones2.estadoInicialBotones();
    }
    public void habilitarAgregar()
    {
        this.gUI_Botones2.habilitarAgregar();
    }
    public void estadoInicial()
    {
        this.gUI_Botones2.estadoInicialBotones();
    }
    public void limpiarCurso()
    {
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
    }
    public void limpiarEst() {
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
    }
    public void cargarTabla()
    {
        String arreglo[]=new String[4];
        arreglo[0]=this.jt_Cedula.getText();
        arreglo[1]=this.jt_NombreEstudiante.getText();
        arreglo[2]=this.jt_Sigla.getText();
        arreglo[3]=this.jt_NombreCurso.getText();
        
        modelo.addRow(arreglo);
    }
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    public void mostrarNombreEstudiante(String nombre)
    {
        this.jt_NombreEstudiante.setText(nombre);
    }
    public void mostrarNombreCurso(String nombre)
    {
        this.jt_NombreCurso.setText(nombre);
    }
    /*
    En el caso para archivos 
    */
    public void mostrarNombEst(String arreglo[])
    {
        this.jt_NombreEstudiante.setText(arreglo[1]);
    }
    public void mostrarNombCurso(String arreglo[])
    {
        this.jt_NombreCurso.setText(arreglo[0]);
    }
    ///////////////////////////////////////////////////////////////////////////
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }        
    public void agregarEventos()
    {
        this.btn_ConsultaRapidaEstudiante.addActionListener(controlador);
        this.btn_ConsultaRapidaSigla.addActionListener(controlador);
        this.btn_Finalizar.addActionListener(controlador);
        this.gUI_Botones2.agregarEventos(controlador);
    }
    public int getCantidadDeCursosMatriculados()
    {
        return modelo.getRowCount();
    }
    public void colocarTitulosTabla()
    {
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre Estudiante");
        modelo.addColumn("Sigla");
        modelo.addColumn("Nombre Curso");
    }
    public String[] getInformacionTablaMatricula(int contador)
    {
        String arreglo[] = new String[3];
        
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=""+this.modelo.getValueAt(contador, 0);
        arreglo[2]=""+this.modelo.getValueAt(contador, 2);
        
        return arreglo;
    }
    public String[] getInformacionTablaDetalle(int contador){
        
        String arreglo[] = new String[4];
        
        arreglo[0] = ""+this.modelo.getValueAt(contador, 0);
        arreglo[1] = ""+this.modelo.getValueAt(contador, 1);
        arreglo[2] = ""+this.modelo.getValueAt(contador, 2);
        arreglo[3] = ""+this.modelo.getValueAt(contador, 3);
        
        return arreglo;
    }
    public void resetearInterfaz()
    {
        colocarCodigo();
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
        
        int tamanio=modelo.getRowCount();
        
        for(int contador=0;contador<tamanio;contador++)
        {
            modelo.removeRow(0);
        }   
    }
    public void colocarCodigo()
    {
        this.jt_CodigoMatricula.setText(controlador.colocarCodigo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jl_NombreEstudiante = new javax.swing.JLabel();
        jl_Sigla = new javax.swing.JLabel();
        jl_NombreCurso = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreEstudiante = new javax.swing.JTextField();
        jt_Sigla = new javax.swing.JTextField();
        jt_NombreCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Matricula = new javax.swing.JTable();
        gUI_Botones2 = new Vista.GUI_Botones2();
        btn_ConsultaRapidaSigla = new javax.swing.JButton();
        btn_ConsultaRapidaEstudiante = new javax.swing.JButton();
        jl_CodigoMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();
        btn_Finalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_Cedula.setText("Cédula");
        getContentPane().add(jl_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 67, -1, -1));

        jl_NombreEstudiante.setText("Nombre");
        getContentPane().add(jl_NombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 117, -1, -1));

        jl_Sigla.setText("Sigla");
        getContentPane().add(jl_Sigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 71, -1, -1));

        jl_NombreCurso.setText("Nombre");
        getContentPane().add(jl_NombreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 117, -1, -1));
        getContentPane().add(jt_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 61, 66, -1));

        jt_NombreEstudiante.setEnabled(false);
        getContentPane().add(jt_NombreEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 111, 120, -1));
        getContentPane().add(jt_Sigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 65, 86, -1));

        jt_NombreCurso.setEnabled(false);
        getContentPane().add(jt_NombreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 111, 161, -1));

        tbl_Matricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Matricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_MatriculaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Matricula);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 157, 423, 88));

        gUI_Botones2.setOpaque(false);
        getContentPane().add(gUI_Botones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 251, -1, -1));

        btn_ConsultaRapidaSigla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaSigla.setActionCommand("ConsultaRapidaCurso");
        getContentPane().add(btn_ConsultaRapidaSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 61, -1, -1));

        btn_ConsultaRapidaEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapidaEstudiante.setActionCommand("ConsultaRapidaEstudiante");
        getContentPane().add(btn_ConsultaRapidaEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 61, -1, -1));

        jl_CodigoMatricula.setText("Código");
        getContentPane().add(jl_CodigoMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, -1, -1));
        getContentPane().add(jt_CodigoMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 21, 132, -1));

        btn_Finalizar.setBackground(new java.awt.Color(255, 153, 51));
        btn_Finalizar.setText("Finalizar Matrícula");
        btn_Finalizar.setActionCommand("Finalizar");
        getContentPane().add(btn_Finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 277, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoMatricula.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_MatriculaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MatriculaMousePressed
        System.out.println("Hola");
    }//GEN-LAST:event_tbl_MatriculaMousePressed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        controlador.metodosMatricula.escribirInfoArchivo();
    }//GEN-LAST:event_formComponentHidden
    
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapidaEstudiante;
    private javax.swing.JButton btn_ConsultaRapidaSigla;
    private javax.swing.JButton btn_Finalizar;
    private Vista.GUI_Botones2 gUI_Botones2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_CodigoMatricula;
    private javax.swing.JLabel jl_NombreCurso;
    private javax.swing.JLabel jl_NombreEstudiante;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private javax.swing.JTable tbl_Matricula;
    // End of variables declaration//GEN-END:variables
}
