package Proyecto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
public class VtnA extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public VtnA() {
        initComponents();
        llenarcombo();
        cargarTabla();
    }
    
      public void llenarcombo() {
//Creamos objeto tipo Connection    
java.sql.Connection conectar = null;    
PreparedStatement pst = null;
ResultSet result = null;

//Creamos la Consulta SQL
String SSQL = "Select* from view_Paquete";

//Establecemos bloque try-catch-finally
try {
       
   //Establecemos conexión con la BD 
  Connection con = Conexion.getConexion();
   //Preparamos la consulta SQL
   pst = con.prepareStatement(SSQL);
   //Ejecutamos la consulta
   result = pst.executeQuery();
   
   //LLenamos nuestro ComboBox
   ComboPaquete.addItem("Seleccione una opción");
   
   while(result.next()){
   
       ComboPaquete.addItem(result.getString("paquete_ID"));
   
   }
   
    
} catch (SQLException e) {

    JOptionPane.showMessageDialog(null, e);
    
}finally{

    if(conectar!=null){
        
        try {
        
            conectar.close();
            result.close();
            
            conectar=null;
            result=null;
            
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString(),"", JOptionPane.ERROR_MESSAGE);

        }
      
      catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        } 
    }

}
    
    }
    
     public void cargarTabla(){
      try {
        DefaultTableModel modelotabla = (DefaultTableModel) TablaAlmacen.getModel();
        modelotabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
      
             Connection con = Conexion.getConexion();
                ps = con.prepareStatement("Select* from Almacen");
           rs= ps.executeQuery();
                rsmd =rs.getMetaData();
                columnas = rsmd.getColumnCount();
            while(rs.next()){
            Object [] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                modelotabla.addRow(fila);
            }
                
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.toString(),"", JOptionPane.ERROR_MESSAGE);

        }
      
      catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlmacen = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtES = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAlmacen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        ComboPaquete = new javax.swing.JComboBox<>();
        txtStatus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaAlmacen.setBackground(new java.awt.Color(0, 0, 0));
        TablaAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        TablaAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Almacen ID", "Entreda/ Salida", "Codigo de recepcion", "Paquete ID", "Status"
            }
        ));
        TablaAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAlmacenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAlmacen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 510, 90));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Insertar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Borrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Almacen");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Paquete ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        TxtES.setBackground(new java.awt.Color(0, 0, 0));
        TxtES.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtES, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 270, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Codigo de Recepción");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, -1));

        txtAlmacen.setBackground(new java.awt.Color(0, 0, 0));
        txtAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 270, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Almacen ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        txtcodigo.setBackground(new java.awt.Color(0, 0, 0));
        txtcodigo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 270, -1));

        ComboPaquete.setBackground(new java.awt.Color(0, 0, 0));
        ComboPaquete.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ComboPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 270, -1));

        txtStatus.setBackground(new java.awt.Color(0, 0, 0));
        txtStatus.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 270, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Status");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 50, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Entrada / Salida ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 139, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\kike\\Documents\\NetBeansProjects\\Proyecto_base_de_datos\\Imagenes\\Interface.jpg")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        dispose();  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAlmacenMouseClicked
 try {
            PreparedStatement ps;
            ResultSet rs;
            int fila = TablaAlmacen.getSelectedRow();
            int id = Integer.parseInt(TablaAlmacen.getValueAt(fila, 0).toString());
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("Select ALMACEN_ID, ENTRADA_SALIDA, CODIGO_RECEPCION, PAQUETE_ID,STATUS from almacen where ALMACEN_ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                txtAlmacen.setText(String.valueOf(id));
                TxtES.setText(rs.getString("ENTRADA_SALIDA"));
                txtcodigo.setText(rs.getString("CODIGO_RECEPCION"));
                ComboPaquete.setSelectedItem(rs.getString("Paquete_ID"));
                txtStatus.setText(rs.getString("status"));
            }

          } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.toString(),"", JOptionPane.ERROR_MESSAGE);

        }
      
      catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }     // TODO add your handling code here:
    }//GEN-LAST:event_TablaAlmacenMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     try { int id_almacen = Integer.parseInt(txtAlmacen.getText());
        int codigo = Integer.parseInt(txtcodigo.getText());
        String Entrada_salida = TxtES.getText();
        int status = Integer.parseInt(txtStatus.getText());
        int id_paquete =  Integer.parseInt(ComboPaquete.getSelectedItem().toString());
        

       
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Almacen ( ALMACEN_ID, ENTRADA_SALIDA, CODIGO_RECEPCION, PAQUETE_ID,STATUS)VALUES(?,?,?,?,?)");
            ps.setInt(1, id_almacen);
            ps.setString(2, Entrada_salida);
            ps.setInt(3, codigo);
            ps.setInt(4, id_paquete);
            ps.setInt(5, status);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro guardado");
            cargarTabla();

          } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
      
      catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }   // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
      try {   int id_almacen = Integer.parseInt(txtAlmacen.getText());
        int codigo = Integer.parseInt(txtcodigo.getText());
        String Entrada_salida = TxtES.getText();
        int status = Integer.parseInt(txtStatus.getText());
        int id_paquete =  Integer.parseInt(ComboPaquete.getSelectedItem().toString());
        

       
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("update Almacen SET ENTRADA_SALIDA=?, CODIGO_RECEPCION=?, PAQUETE_ID=?,STATUS=? where ALMACEN_ID=?  ");
            
            ps.setString(1, Entrada_salida);
            ps.setInt(2, codigo);
            ps.setInt(3, id_paquete);
            ps.setInt(4, status);
            ps.setInt(5, id_almacen);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Modificado");
            cargarTabla();

       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(),"", JOptionPane.ERROR_MESSAGE);

        }
      
      catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }   // TODO add your handling code here:
          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    try {   int id_almacen = Integer.parseInt(txtAlmacen.getText());
       
        

       
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("delete from Almacen  where ALMACEN_ID=?  ");
            
            ps.setInt(1, id_almacen);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro borrado");
            cargarTabla();

       } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(),"", JOptionPane.ERROR_MESSAGE);

        }
      
      catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JComboBox<String> ComboPaquete;
    private javax.swing.JTable TablaAlmacen;
    private javax.swing.JTextField TxtES;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlmacen;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtcodigo;
    // End of variables declaration//GEN-END:variables
}
