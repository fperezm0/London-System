package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kike
 */
public class VtnC extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public VtnC() {
        initComponents();
        cargarTabla();
        llenarcombo();

    }

    public void cargarTabla() {
        try {
            DefaultTableModel modelotabla = (DefaultTableModel) TablaClientes.getModel();
            modelotabla.setRowCount(0);
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsmd;
            int columnas;

            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("Select* from cliente");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelotabla.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void llenarcombo() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL 
        String SSQL = "Select* from view_transporte";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            ComboTransporte.addItem("Seleccione una opción");

            while (result.next()) {
                ComboTransporte.addItem(result.getString(1));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            if (conectar != null) {

                try {
                    conectar.close();
                    result.close();

                    conectar = null;
                    result = null;

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, ex);

                }

            }

        }

    }

    public String RFC(String id) {
//Creamos objeto tipo Connection
        String s = "";
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select calcularfc(?) from cliente where cliente_id = ?";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            pst.setString(1, id);
            pst.setString(2, id);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            while (result.next()) {
                s += (result.getString(1));
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            if (conectar != null) {

                try {
                    conectar.close();
                    result.close();

                    conectar = null;
                    result = null;

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, ex);

                }

            }

        }

        return s;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtApellidosma = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCliente_id = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        txtnombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtCoreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ComboTransporte = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Nacimiento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        TablaClientes.setBackground(new java.awt.Color(0, 0, 0));
        TablaClientes.setForeground(new java.awt.Color(255, 255, 255));
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cliente ID", "Nombres", "Apellido paterno ", "Apellido Materno", "Fecha Nacimiento", "RFC", "Direccion", "Correo electronico", "Telefono", "Transporte"
            }
        ));
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 780, 70));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Apellido Materno");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        txtApellidosma.setBackground(new java.awt.Color(0, 0, 0));
        txtApellidosma.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtApellidosma, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 374, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Clientes");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Apellido Paterno");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        txtCliente_id.setBackground(new java.awt.Color(0, 0, 0));
        txtCliente_id.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente_id.setText("Cliente ID");
        getContentPane().add(txtCliente_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        txtCliente.setBackground(new java.awt.Color(0, 0, 0));
        txtCliente.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 374, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 60, -1));

        fecha.setBackground(new java.awt.Color(0, 0, 0));
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaKeyPressed(evt);
            }
        });
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 370, -1));

        txtnombres.setBackground(new java.awt.Color(0, 0, 0));
        txtnombres.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 374, -1));

        txtApellidos.setBackground(new java.awt.Color(0, 0, 0));
        txtApellidos.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 374, -1));

        txtTelefono.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 374, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo electronico");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        TxtCoreo.setBackground(new java.awt.Color(0, 0, 0));
        TxtCoreo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtCoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 374, -1));

        txtDireccion.setBackground(new java.awt.Color(0, 0, 0));
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 374, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Dirección");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Transporte");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        ComboTransporte.setBackground(new java.awt.Color(0, 0, 0));
        ComboTransporte.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ComboTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 374, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\kike\\Documents\\NetBeansProjects\\Proyecto_base_de_datos\\Imagenes\\Interfacedoble.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 890, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            if (fecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "fecha sin valores, por favor ingrese una fecha");

            } else {

                String dia = Integer.toString(fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString(fecha.getCalendar().get(Calendar.MONTH) + 1);
                String year = Integer.toString(fecha.getCalendar().get(Calendar.YEAR));
                String fechanac = (dia + "/" + mes + "/" + year);
                int cliente_id = Integer.parseInt(txtCliente.getText());
                String nombres = txtnombres.getText();
                String apellidos = txtApellidos.getText();
                String apellidosM = txtApellidosma.getText();
                String correo = TxtCoreo.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                int transporte_id = Integer.parseInt(ComboTransporte.getSelectedItem().toString());
                Connection con = Conexion.getConexion();
                String RFC = "";
                PreparedStatement ps = con.prepareStatement("INSERT INTO Cliente (CLIENTE_ID, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, FECHANAC, RFC, DIRECCION, CORREO_ELECTRONICO, TELEFONO, TRANSPORTE_ID) VALUES(?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, cliente_id);
                ps.setString(2, nombres);
                ps.setString(3, apellidos);
                ps.setString(4, apellidosM);
                ps.setString(5, fechanac);
                ps.setString(6, RFC);
                ps.setString(7, direccion);
                ps.setString(8, correo);
                ps.setString(9, telefono);
                ps.setInt(10, transporte_id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");
                update();
                cargarTabla();

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked
        try {
            PreparedStatement ps;
            ResultSet rs;
            int fila = TablaClientes.getSelectedRow();
            int id = Integer.parseInt(TablaClientes.getValueAt(fila, 0).toString());
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("Select CLIENTE_ID, NOMBRES, APELLIDO_PATERNO, APELLIDO_MATERNO, FECHANAC, RFC, DIRECCION,"
                    + " CORREO_ELECTRONICO,  TELEFONO, TRANSPORTE_ID from Cliente where Cliente_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtCliente.setText(String.valueOf(id));
                txtnombres.setText(rs.getString("NOMBRES"));
                txtApellidos.setText(rs.getString("APELLIDO_PATERNO"));
                txtApellidosma.setText(rs.getString("APELLIDO_MATERNO"));
                TxtCoreo.setText(rs.getString("CORREO_ELECTRONICO"));
                txtDireccion.setText(rs.getString("DIRECCION"));
                txtTelefono.setText(rs.getString("TELEFONO"));
                ComboTransporte.setSelectedItem(rs.getString("TRANSPORTE_ID"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }           // TODO add your handling code here: */
    }//GEN-LAST:event_TablaClientesMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if (fecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "fecha sin valores, por favor ingrese una fecha");

            } else {

                String dia = Integer.toString(fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString(fecha.getCalendar().get(Calendar.MONTH) + 1);
                String year = Integer.toString(fecha.getCalendar().get(Calendar.YEAR));
                String fechanac = (dia + "/" + mes + "/" + year);
                int cliente_id = Integer.parseInt(txtCliente.getText());
                String nombres = txtnombres.getText();
                String apellidos = txtApellidos.getText();
                String apellidosM = txtApellidosma.getText();
                String correo = TxtCoreo.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                int transporte_id = Integer.parseInt(ComboTransporte.getSelectedItem().toString());
                Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("update Cliente set NOMBRES=?,  APELLIDO_PATERNO=?,  APELLIDO_MATERNO=?,  FECHANAC=?,  RFC=?, DIRECCION=?, CORREO_ELECTRONICO=?, TELEFONO=?, TRANSPORTE_ID=? where CLIENTE_ID=? ");

                ps.setString(1, nombres);
                ps.setString(2, apellidos);
                ps.setString(3, apellidosM);
                ps.setString(4, fechanac);
                ps.setString(5, "");
                ps.setString(6, direccion);
                ps.setString(7, correo);
                ps.setString(8, telefono);
                ps.setInt(9, transporte_id);
                ps.setInt(10, cliente_id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                update();
                cargarTabla();

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }        // TODO add your handling code here:


    }//GEN-LAST:event_jButton4ActionPerformed

    public void update() {

        try {
            int cliente_id = Integer.parseInt(txtCliente.getText());

            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("update Cliente set RFC=? where CLIENTE_ID=? ");

            ps.setString(1, RFC(txtCliente.getText()));
            ps.setInt(2, cliente_id);

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }        // 

    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int cliente_id = Integer.parseInt(txtCliente.getText());
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("delete from Cliente  where CLIENTE_ID=? ");
            ps.setInt(1, cliente_id);
            ps.executeUpdate();
            cargarTabla();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }      // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

        }
    }//GEN-LAST:event_fechaKeyPressed

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
            java.util.logging.Logger.getLogger(VtnA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTransporte;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JTextField TxtCoreo;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosma;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JLabel txtCliente_id;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtnombres;
    // End of variables declaration//GEN-END:variables
}
