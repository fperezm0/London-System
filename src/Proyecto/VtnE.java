package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VtnE extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public VtnE() {
        initComponents();
        cargarTabla();
        llenarcombop();
        llenarcombot();
        llenarcombo();
    }

    /**
     * metodo que sirve para llamar la funcion de Oracle y mostrar el resultado
     * de la misma funcion
     */
    public void diasrestantes(String id) {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL con la funcion para llamar la funcion que retorna dias 
        String SSQL = "select F_DIAS(FECHA_ENVIO,FECHA_DE_RECEPCION)  as tiempo_restante_de_envio  from envio where envio_id = ?";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            pst.setString(1, id);
            result = pst.executeQuery();

            while (result.next()) {

                JOptionPane.showMessageDialog(null, ("los dias restantes del envio son :" + result.getString(1)));

            }
 //Atrapamos los errores  
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
  /**
     * Metodo para hacer una consulta a la base de datos concretamente a una vista  retornando los valores para llenar el combo con la misma consulta
     * facilitando el uso de llaves foraneas
     */
    public void llenarcombop() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;
//Creamos la Consulta SQL
        String SSQL = "Select* from view_paquete";
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

            while (result.next()) {

                ComboPaquete.addItem(result.getString(1));

            }
 //Atrapamos los errores  
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
  /**
     * Metodo para hacer una consulta a la base de datos concretamente a una vista  retornando los valores para llenar el combo con la misma consulta
     * facilitando el uso de llaves foraneas
     */
    public void llenarcombo() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select* from view_mensajero";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            ComboMensajero.addItem("Seleccione una opción");

            while (result.next()) {

                ComboMensajero.addItem(result.getString(1));

            }
 //Atrapamos los errores  
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
  /**
     * Metodo para hacer una consulta a la base de datos concretamente a una vista  retornando los valores para llenar el combo con la misma consulta
     * facilitando el uso de llaves foraneas
     */
    public void llenarcombot() {
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
 //Atrapamos los errores  
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

    /**
     * Metodo para hacer una consulta a la base de datos y retornar los  resultados a la tabla
     */
    public void cargarTabla() {

        DefaultTableModel modelotabla = (DefaultTableModel) TablaEnvio.getModel();
        modelotabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        try {
            //Creamos objeto tipo Connection
            Connection con = Conexion.getConexion();
            //Creamos la Consulta SQL
            ps = con.prepareStatement("Select* from envio");
              //Ejecutamos la consulta
            rs = ps.executeQuery();

            while (rs.next()) {
                rsmd = rs.getMetaData();
                columnas = rsmd.getColumnCount();
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelotabla.addRow(fila);
            }
 //Atrapamos los errores  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
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

        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEnvio = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jdt = new com.toedter.calendar.JDateChooser();
        Fecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtEnvio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtcodigoPostal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCuidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtDomiciio = new javax.swing.JTextField();
        ComboPaquete = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ComboTransporte = new javax.swing.JComboBox<>();
        ComboMensajero = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel14.setText("jLabel14");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaEnvio.setBackground(new java.awt.Color(0, 0, 0));
        TablaEnvio.setForeground(new java.awt.Color(255, 255, 255));
        TablaEnvio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Envio ID", "Fecha de envio", "Fecha de recepción ", "Dirección", "Codigo Postal", "Pais", "Cuidad", "Domicilio", "Paquete", "Transporte", "Mensajero"
            }
        ));
        TablaEnvio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEnvioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEnvio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 780, 220));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Insertar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(0, 255, 255));
        jButton1.setText("Tiempo  restante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 120, 30));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(0, 255, 255));
        jButton6.setText("Cambia fecha");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, -1, -1));

        jdt.setBackground(new java.awt.Color(0, 0, 0));
        jdt.setForeground(new java.awt.Color(255, 255, 255));
        jdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdtKeyPressed(evt);
            }
        });
        getContentPane().add(jdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 260, 20));

        Fecha.setBackground(new java.awt.Color(0, 0, 0));
        Fecha.setForeground(new java.awt.Color(255, 255, 255));
        Fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FechaKeyPressed(evt);
            }
        });
        getContentPane().add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 260, 20));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Envio ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        txtEnvio.setBackground(new java.awt.Color(0, 0, 0));
        txtEnvio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtEnvio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 260, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de envio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de recepcion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        TxtDireccion.setBackground(new java.awt.Color(0, 0, 0));
        TxtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 260, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Codigo postal");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        TxtcodigoPostal.setBackground(new java.awt.Color(0, 0, 0));
        TxtcodigoPostal.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtcodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 260, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pais");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        txtPais.setBackground(new java.awt.Color(0, 0, 0));
        txtPais.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 260, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ciudad");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        txtCuidad.setBackground(new java.awt.Color(0, 0, 0));
        txtCuidad.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtCuidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 310, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Domicilio");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        TxtDomiciio.setBackground(new java.awt.Color(0, 0, 0));
        TxtDomiciio.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtDomiciio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 310, -1));

        ComboPaquete.setBackground(new java.awt.Color(0, 0, 0));
        ComboPaquete.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ComboPaquete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 310, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Paquete");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Transporte");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        ComboTransporte.setBackground(new java.awt.Color(0, 0, 0));
        ComboTransporte.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ComboTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 310, -1));

        ComboMensajero.setBackground(new java.awt.Color(0, 0, 0));
        ComboMensajero.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ComboMensajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 310, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mensajero");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Envios");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\kike\\Documents\\NetBeansProjects\\Proyecto_base_de_datos\\Imagenes\\Interfacedoble.jpg")); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 560));

        setSize(new java.awt.Dimension(911, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jdtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdtKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

        }
    }//GEN-LAST:event_jdtKeyPressed

    private void FechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

        }
    }//GEN-LAST:event_FechaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dispose();

    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Metodo para hacer la seleccion de campos para poder editarlos
     */
    private void TablaEnvioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEnvioMouseClicked
        try {
            //Creamos objeto tipo Connection
            PreparedStatement ps;
            ResultSet rs;
            int fila = TablaEnvio.getSelectedRow();
            int id = Integer.parseInt(TablaEnvio.getValueAt(fila, 0).toString());
            Connection con = Conexion.getConexion();
//Creamos la Consulta SQL
            ps = con.prepareStatement("Select ENVIO_ID, FECHA_ENVIO, FECHA_DE_RECEPCION,  DIRECCION, CODIGO_POSTAL, PAIS, CUIDAD, DOMICILIO, PAQUETE_ID, TRANSPORTE_ID , MENSAJERO_ID  from envio where envio_ID=?");
  //Ejecutamos la consulta
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                // de la consulta obtenemos los datos y se los regresamos a los textfield
                txtEnvio.setText(String.valueOf(id));
                TxtDireccion.setText(rs.getString("DIRECCION"));
                TxtcodigoPostal.setText(rs.getString("CODIGO_POSTAL"));
                txtPais.setText(rs.getString("PAIS"));
                txtCuidad.setText(rs.getString("CUIDAD"));
                TxtDomiciio.setText(rs.getString("DOMICILIO"));
                ComboPaquete.setSelectedItem(rs.getString("Paquete_ID"));
                ComboMensajero.setSelectedItem(rs.getString("Mensajero_ID"));
                ComboTransporte.setSelectedItem(rs.getString("transporte_ID"));

            }
             //Atrapamos los errores  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
    }//GEN-LAST:event_TablaEnvioMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            //validacion de fechas 
            if (jdt.getDate() == null || Fecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "fecha sin valores, por favor ingrese una fecha");

            } else if (jdt.getDate().before(Fecha.getDate())) {
                JOptionPane.showMessageDialog(null, "fecha de envio mayor a fecha de repecion ingrese las fechas correctamente");
            } else {
                //inicialicacion de variables 
                int envio_id = Integer.parseInt(txtEnvio.getText());
                String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
                String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
                String fecha_emision = (dia + "/" + mes + "/" + year);
                dia = Integer.toString(Fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                mes = Integer.toString(Fecha.getCalendar().get(Calendar.MONTH) + 1);
                year = Integer.toString(Fecha.getCalendar().get(Calendar.YEAR));
                String fecha_recepcion = (dia + "/" + mes + "/" + year);
                String direccion = TxtDireccion.getText();
                String ciudad = txtCuidad.getText();
                String pais = txtPais.getText();
                String domicilio = TxtDomiciio.getText();
                int codigopostal = Integer.parseInt(TxtcodigoPostal.getText());
                int transporte_id = Integer.parseInt(ComboTransporte.getSelectedItem().toString());
                int paquete_id = Integer.parseInt(ComboPaquete.getSelectedItem().toString());
                int mensjaero_id = Integer.parseInt(ComboMensajero.getSelectedItem().toString());

                Connection con = Conexion.getConexion();
                //Creamos la Consulta SQL
                PreparedStatement ps = con.prepareStatement("INSERT INTO envio (ENVIO_ID, FECHA_ENVIO, FECHA_DE_RECEPCION,  DIRECCION, CODIGO_POSTAL, PAIS, CUIDAD,  DOMICILIO, PAQUETE_ID, TRANSPORTE_ID ,"
                        + " MENSAJERO_ID )VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, envio_id);
                ps.setString(2, fecha_emision);
                ps.setString(3, fecha_recepcion);
                ps.setString(4, direccion);
                ps.setInt(5, codigopostal);
                ps.setString(6, pais);
                ps.setString(7, ciudad);
                ps.setString(8, domicilio);
                ps.setInt(9, paquete_id);
                ps.setInt(10, transporte_id);
                ps.setInt(11, mensjaero_id);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro guardado");
                cargarTabla();

            }
 //Atrapamos los errores  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
    }//GEN-LAST:event_jButton3ActionPerformed

      /**
     * Metodo para actualizar valores a la tabla en la base de datos
     * 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
             //validacion de fechas 
            if (jdt.getDate() == null || Fecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "fecha sin valores, por favor ingrese una fecha");

            } else if (jdt.getDate().before(Fecha.getDate())) {
                JOptionPane.showMessageDialog(null, "fecha de envio mayor a fecha de repecion ingrese las fechas correctamente");
            } else {
                PreparedStatement ps;
                ResultSet rs;
                //inicialicacion de variables
                int fila = TablaEnvio.getSelectedRow();
                int id = Integer.parseInt(TablaEnvio.getValueAt(fila, 0).toString());
                String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
                String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
                String fecha_emision = (dia + "/" + mes + "/" + year);
                dia = Integer.toString(Fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                mes = Integer.toString(Fecha.getCalendar().get(Calendar.MONTH) + 1);
                year = Integer.toString(Fecha.getCalendar().get(Calendar.YEAR));
                String fecha_recepcion = (dia + "/" + mes + "/" + year);
                String direccion = TxtDireccion.getText();
                String ciudad = txtCuidad.getText();
                String pais = txtPais.getText();
                String domicilio = TxtDomiciio.getText();
                int codigopostal = Integer.parseInt(TxtcodigoPostal.getText());
                int transporte_id = Integer.parseInt(ComboTransporte.getSelectedItem().toString());
                int paquete_id = Integer.parseInt(ComboPaquete.getSelectedItem().toString());
                int mensjaero_id = Integer.parseInt(ComboMensajero.getSelectedItem().toString());
                Connection con = Conexion.getConexion();
//Creamos la Consulta SQL
                ps = con.prepareStatement("update ENVIO Set FECHA_ENVIO=?, FECHA_DE_RECEPCION=?, DIRECCION=?, CODIGO_POSTAL=?, PAIS=?, CUIDAD=?, DOMICILIO=?, PAQUETE_ID=?, TRANSPORTE_ID=?, MENSAJERO_ID=?  where envio_ID=?");
                ps.setString(1, fecha_emision);
                ps.setString(2, fecha_recepcion);
                ps.setString(3, direccion);
                ps.setInt(4, codigopostal);
                ps.setString(5, pais);
                ps.setString(6, ciudad);
                ps.setString(7, domicilio);
                ps.setInt(8, paquete_id);
                ps.setInt(9, transporte_id);
                ps.setInt(10, mensjaero_id);
                ps.setInt(11, id);
                  //Ejecutamos la consulta
                rs = ps.executeQuery();

                JOptionPane.showMessageDialog(null, "Registro Modificado");
                cargarTabla();

            }
             //Atrapamos los errores  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
  
    /**
     * Metodo para eliminar un registro de la base de datos mediante el id escogido
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            int id_envio = Integer.parseInt(txtEnvio.getText());
//Creamos objeto tipo Connection
            Connection con = Conexion.getConexion();
            //Creamos la Consulta SQL
            PreparedStatement ps = con.prepareStatement("delete from Envio  where ENVIO_ID=?  ");
            ps.setInt(1, id_envio);
            ps.executeUpdate(); 
           JOptionPane.showMessageDialog(null, "Registro borrado");
            cargarTabla();
          
 //Atrapamos los errores  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }      // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (txtEnvio.getText().toString() == "") {
                JOptionPane.showMessageDialog(null, "id sin valores, por favor ingrese una id");

            } else {
                String envio_id = txtEnvio.getText();

                diasrestantes(envio_id);
 //Atrapamos los errores  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }

    }//GEN-LAST:event_jButton1ActionPerformed
  /**
     * Metodo para ejecutar el procedimiento
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
                PreparedStatement ps;
                ResultSet rs;
                //inicialicacion de variables
                              int envio_id = Integer.parseInt(txtEnvio.getText());
               int codigopostal = Integer.parseInt(TxtcodigoPostal.getText());

                Connection con = Conexion.getConexion();
//Creamos la Consulta SQL y le damos los parametros que queremos ingresar
                ps = con.prepareStatement(" { call  reporte(?, ?)}");
                ps.setInt(1, envio_id);
                ps.setInt(2, codigopostal);
                
  //Ejecutamos la consulta
              ps.executeQuery();
                new report().setVisible(true);

                JOptionPane.showMessageDialog(null, "procedimiento ejecutado");
                cargarTabla();

            
             //Atrapamos los errores  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(VtnE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboMensajero;
    private javax.swing.JComboBox<String> ComboPaquete;
    private javax.swing.JComboBox<String> ComboTransporte;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JTable TablaEnvio;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtDomiciio;
    private javax.swing.JTextField TxtcodigoPostal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JTextField txtCuidad;
    private javax.swing.JTextField txtEnvio;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}
