/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor;

import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.controlador.ControladorCompositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Cancion;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Cantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Compositor;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Usuario
 */
public class CrearCompositor extends javax.swing.JInternalFrame {
    private ControladorCompositor controladorCompositor;
    private ResourceBundle mensajes;
    /**
     * Creates new form CrearCompositor
     */
    public CrearCompositor(ControladorCompositor controladorCompositor) {
        initComponents();
        this.controladorCompositor = controladorCompositor;
    }

    public void cambiarIdioma(Locale localizacion){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        jblIdCrearCompositor.setText(mensajes.getString("ventana.id"));
        jblNombreCrearCompositor.setText(mensajes.getString("ventana.nombre"));
        jblApellidoCrearCompositor.setText(mensajes.getString("ventana.apellido"));
        jblEdadCrearCompositor.setText(mensajes.getString("ventana.edad"));
        jblSalarioCrearCompositor.setText(mensajes.getString("ventana.salario"));
        jblNacionalidadCrearCompositor.setText(mensajes.getString("ventana.nacionalidad"));
        jblNumeroComposicionesCrearCompositor.setText(mensajes.getString("ventanaCompositor.numerocomposiciones"));
        btnAceptar.setText(mensajes.getString("boton.aceptar"));
        btnCancelar.setText(mensajes.getString("boton.cancelar"));
        Border borde = BorderFactory.createTitledBorder(mensajes.getString("panel.crearcompositor"));
        jpanelA.setBorder(borde);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelA = new javax.swing.JPanel();
        jblIdCrearCompositor = new javax.swing.JLabel();
        jblNombreCrearCompositor = new javax.swing.JLabel();
        jblApellidoCrearCompositor = new javax.swing.JLabel();
        jblEdadCrearCompositor = new javax.swing.JLabel();
        jblNacionalidadCrearCompositor = new javax.swing.JLabel();
        jblSalarioCrearCompositor = new javax.swing.JLabel();
        jblNumeroComposicionesCrearCompositor = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtNumeroComposiciones = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jpanelA.setBorder(javax.swing.BorderFactory.createTitledBorder("CREAR COMPOSITOR"));
        jpanelA.setLayout(null);

        jblIdCrearCompositor.setText("ID:");
        jpanelA.add(jblIdCrearCompositor);
        jblIdCrearCompositor.setBounds(75, 38, 120, 16);

        jblNombreCrearCompositor.setText("Nombre:");
        jpanelA.add(jblNombreCrearCompositor);
        jblNombreCrearCompositor.setBounds(75, 73, 47, 16);

        jblApellidoCrearCompositor.setText("Apellido:");
        jpanelA.add(jblApellidoCrearCompositor);
        jblApellidoCrearCompositor.setBounds(75, 107, 47, 16);

        jblEdadCrearCompositor.setText("Edad:");
        jpanelA.add(jblEdadCrearCompositor);
        jblEdadCrearCompositor.setBounds(75, 141, 29, 16);

        jblNacionalidadCrearCompositor.setText("Nacionalidad:");
        jpanelA.add(jblNacionalidadCrearCompositor);
        jblNacionalidadCrearCompositor.setBounds(75, 175, 73, 16);

        jblSalarioCrearCompositor.setText("Salario:");
        jpanelA.add(jblSalarioCrearCompositor);
        jblSalarioCrearCompositor.setBounds(75, 215, 38, 16);

        jblNumeroComposicionesCrearCompositor.setText("Numero de Composiciones:");
        jpanelA.add(jblNumeroComposicionesCrearCompositor);
        jblNumeroComposicionesCrearCompositor.setBounds(75, 249, 148, 16);

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jpanelA.add(txtId);
        txtId.setBounds(227, 35, 131, 22);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jpanelA.add(txtNombre);
        txtNombre.setBounds(227, 70, 131, 22);

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jpanelA.add(txtApellido);
        txtApellido.setBounds(227, 104, 131, 22);

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jpanelA.add(txtEdad);
        txtEdad.setBounds(227, 138, 131, 22);

        txtNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacionalidadActionPerformed(evt);
            }
        });
        jpanelA.add(txtNacionalidad);
        txtNacionalidad.setBounds(227, 172, 131, 22);

        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });
        jpanelA.add(txtSalario);
        txtSalario.setBounds(227, 212, 131, 22);

        txtNumeroComposiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroComposicionesActionPerformed(evt);
            }
        });
        jpanelA.add(txtNumeroComposiciones);
        txtNumeroComposiciones.setBounds(229, 246, 131, 22);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jpanelA.add(btnAceptar);
        btnAceptar.setBounds(177, 288, 72, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jpanelA.add(btnCancelar);
        btnCancelar.setBounds(284, 288, 76, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Conpositor.png"))); // NOI18N
        jpanelA.add(jLabel1);
        jLabel1.setBounds(17, 24, 46, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ImgenCompositor.jpg"))); // NOI18N
        jpanelA.add(jLabel2);
        jLabel2.setBounds(11, 17, 450, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelA, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelA, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacionalidadActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void txtNumeroComposicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroComposicionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroComposicionesActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (this.validacionDeCampos()) {
            int id = Integer.parseInt(txtId.getText());
            if(controladorCompositor.buscarCompositor(id)==null) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String nacionalidad = txtNacionalidad.getText();
                double salario = Double.parseDouble(txtSalario.getText());
                int numeroComposiciones = Integer.parseInt(txtNumeroComposiciones.getText());
                if (nombre.length()>25 || apellido.length()>25||nacionalidad.length()>25) {
                        JOptionPane.showMessageDialog(this, "El nombre o apellido es muy largo debe ser menor a 25");
                    }else{
                        Compositor compositor = new Compositor(numeroComposiciones, id, llenarEspacio(nombre), llenarEspacio(apellido), edad, llenarEspacio(nacionalidad), salario);
                        this.agregarCancionesVacias(compositor); 
                        //Cantante cantante = new Cantante(llenarEspacio(""), llenarEspacio(" "), 0, 0, 0, 0, llenarEspacio(" "), llenarEspacio(" "), 0, llenarEspacio(" "), 0.00);
                        this.agregarCliente(compositor); 
                        //Disco disco = new Disco(12, "La noche", 2000);
                        //cantante.agregarDisco(disco);
                        controladorCompositor.crearCompositor(compositor); 
                        this.limpiarCampos();
                        JOptionPane.showMessageDialog(this, mensajes.getString("joption.secreocompositor"));
                        //System.out.println(controladorCompositor.verCompositores());
                    }
                
            }else{
                JOptionPane.showMessageDialog(this, mensajes.getString("joption.elid")); 
            }
        }else{
            JOptionPane.showMessageDialog(this,mensajes.getString("joption.nosehanllenado")); 
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limpiarCampos();
        this.setVisible(false); 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.limpiarCampos();
    }//GEN-LAST:event_formInternalFrameClosing

    
    private boolean validacionDeCampos(){
        if (txtId.getText().isEmpty()||txtNombre.getText().isEmpty()||txtApellido.getText().isEmpty()||txtEdad.getText().isEmpty()||txtNacionalidad.getText().isEmpty()
                || txtSalario.getText().isEmpty()||txtNumeroComposiciones.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    private void limpiarCampos(){
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtNacionalidad.setText("");
        txtSalario.setText("");
        txtNumeroComposiciones.setText("");
    }
    
    public void agregarCancionesVacias(Compositor compositor){
        for (int i = 0; i < 10; i++) {
            /*int codigo = 0;
            String titulo = "          ";
            String letra = "          ";
            double tiempo = 0.00;*/
            
            Cancion cancion = new Cancion(0, llenarEspacio(""), llenarEspacio(""), 0.00);
            compositor.agregarCancion(cancion); 
        }
    }
    
    private String llenarEspacio(String palabra){
        StringBuilder nueva = new StringBuilder(palabra);
        for (int i = palabra.length(); i < 25; i++) {
            nueva.append(" ");
        }
        System.out.println("Espacio del caracter :" + nueva.length());
        return nueva.toString();
        
    }
    
    private String llenarGeneroMusica(String pa){
        StringBuilder nueva = new StringBuilder(pa);
        for (int i = pa.length(); i < 10; i++) {
            nueva.append(" ");
        }
        System.out.println("Espacio del caracter :" + nueva.length());
        return nueva.toString();
    }
    
    public void agregarCliente(Compositor compositor){
        for (int i = 0; i < 10; i++) {
            
            Cantante cantante = new Cantante(llenarEspacio(""), llenarGeneroMusica(""), 0, 0, 0, 0, llenarEspacio(""), llenarEspacio(""), 0, llenarEspacio(""), 0.00); 
            compositor.agregarClientE(cantante); 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jblApellidoCrearCompositor;
    private javax.swing.JLabel jblEdadCrearCompositor;
    private javax.swing.JLabel jblIdCrearCompositor;
    private javax.swing.JLabel jblNacionalidadCrearCompositor;
    private javax.swing.JLabel jblNombreCrearCompositor;
    private javax.swing.JLabel jblNumeroComposicionesCrearCompositor;
    private javax.swing.JLabel jblSalarioCrearCompositor;
    private javax.swing.JPanel jpanelA;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroComposiciones;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
