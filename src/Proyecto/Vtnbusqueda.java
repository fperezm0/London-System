/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kike
 */
public class Vtnbusqueda extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Vtnbusqueda() {
        initComponents();
    }

    public String id;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Combobusqueda = new javax.swing.JComboBox<>();
        ComboTabla = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaJoin = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Busqueda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        Combobusqueda.setBackground(new java.awt.Color(0, 0, 0));
        Combobusqueda.setForeground(new java.awt.Color(255, 255, 255));
        Combobusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion de busqueda de", "Envio", "Paquete", "Transporte", "Almacen", "Cliente", "Mensajero" }));
        Combobusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombobusquedaActionPerformed(evt);
            }
        });
        getContentPane().add(Combobusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 452, -1));

        ComboTabla.setBackground(new java.awt.Color(0, 0, 0));
        ComboTabla.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(ComboTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 452, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Busqueda por lista ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busqueda por lista");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Información");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        TablaJoin.setBackground(new java.awt.Color(0, 0, 0));
        TablaJoin.setForeground(new java.awt.Color(255, 255, 255));
        TablaJoin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Descripcion Transporte", "Descricpcion del paquete", "E&S", "Fecha Salida", "Pais", "Ciudad", "Dirrecion", "Nombre mensajero", "Apellidos Mensajero", "Nombre Cliente", "Apellido Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaJoin);
        if (TablaJoin.getColumnModel().getColumnCount() > 0) {
            TablaJoin.getColumnModel().getColumn(0).setResizable(false);
            TablaJoin.getColumnModel().getColumn(1).setResizable(false);
            TablaJoin.getColumnModel().getColumn(2).setResizable(false);
            TablaJoin.getColumnModel().getColumn(3).setResizable(false);
            TablaJoin.getColumnModel().getColumn(4).setResizable(false);
            TablaJoin.getColumnModel().getColumn(5).setResizable(false);
            TablaJoin.getColumnModel().getColumn(6).setResizable(false);
            TablaJoin.getColumnModel().getColumn(7).setResizable(false);
            TablaJoin.getColumnModel().getColumn(8).setResizable(false);
            TablaJoin.getColumnModel().getColumn(9).setResizable(false);
            TablaJoin.getColumnModel().getColumn(10).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 204, 760, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\kike\\Documents\\NetBeansProjects\\Proyecto_base_de_datos\\Imagenes\\busqueda.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 900, 360));

        setSize(new java.awt.Dimension(802, 362));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CombobusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombobusquedaActionPerformed

        String com = Combobusqueda.getSelectedItem().toString();
        if (com == "Envio") {
            ComboTabla.removeAllItems();
            llenarcomboEnvio();
        } else if (com == "Seleccione una opcion de busqueda de") {
            ComboTabla.removeAllItems();
        } else if (com == "Paquete") {
            ComboTabla.removeAllItems();
            llenarcomboPaquete();
        } else if (com == "Transporte") {
            ComboTabla.removeAllItems();
            llenarcomboTransporte();
        } else if (com == "Cliente") {
            ComboTabla.removeAllItems();
            llenarcomboCliente();
        } else if (com == "Mensajero") {
            ComboTabla.removeAllItems();
            llenarcomboMensajero();
        } else if (com == "Almacen") {
            ComboTabla.removeAllItems();
            llenarcomboAlmacen();
        }


    }//GEN-LAST:event_CombobusquedaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String com = Combobusqueda.getSelectedItem().toString();
            if (com == "Seleccione una opcion de busqueda de") {
                JOptionPane.showMessageDialog(null, "seleccion de busqueda invalida");
            }  else {
                DefaultTableModel modelotabla = (DefaultTableModel) TablaJoin.getModel();
                modelotabla.setRowCount(0);
                PreparedStatement ps;
                ResultSet rs;
                ResultSetMetaData rsmd;
                int columnas = 0;

                if (com == "Envio") {
                    id = ComboTabla.getSelectedItem().toString();
                    Connection con = Conexion.getConexion();
                    ps = con.prepareStatement("select t.descripcion,  p.descripcion, a.Entrada_salida,  e.fecha_envio , e.pais, e.CUIDAD, e.DIRECCION, m.nombres, m.apellidos, c.nombres, c.apellido_paterno, c.apellido_materno  \n"
                            + "FROM Transporte t, Paquete p ,Almacen a, Envio e, Mensajero m, Cliente c\n"
                            + "WHERE t.transporte_id = p.transporte_id \n"
                            + "And a.paquete_id = p.paquete_id\n"
                            + "And e.paquete_id = p.paquete_id\n"
                            + "And e.mensajero_id = m.mensajero_id\n"
                            + "And  e.envio_id =  +?"
                    );
                    ps.setString(1, id);
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
                    if (columnas == 0) {
                             JOptionPane.showMessageDialog(null, "el dato esta vacio"
                        );
                    }
                } else if (com == "Paquete") {
                   id = ComboTabla.getSelectedItem().toString();
                    Connection con = Conexion.getConexion();
                    ps = con.prepareStatement("select t.descripcion,  p.descripcion, a.Entrada_salida,  e.fecha_envio , e.pais, e.CUIDAD, e.DIRECCION, m.nombres, m.apellidos, c.nombres, c.apellido_paterno, c.apellido_materno  \n"
                            + "FROM Transporte t, Paquete p ,Almacen a, Envio e, Mensajero m, Cliente c\n"
                            + "WHERE t.transporte_id = p.transporte_id \n"
                            + "And a.paquete_id = p.paquete_id\n"
                            + "And e.paquete_id = p.paquete_id\n"
                            + "And e.mensajero_id = m.mensajero_id\n"
                            + "And   p.PAQUETE_ID =  +?"
                    );
                    ps.setString(1, id);
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
                    if (columnas == 0) {
                            JOptionPane.showMessageDialog(null, "el dato esta vacio"
                        );
                    }

                } else if (com == "Transporte") {
                    id = ComboTabla.getSelectedItem().toString();
                    Connection con = Conexion.getConexion();
                    ps = con.prepareStatement("select t.descripcion,  p.descripcion, a.Entrada_salida,  e.fecha_envio , e.pais, e.CUIDAD, e.DIRECCION, m.nombres, m.apellidos, c.nombres, c.apellido_paterno, c.apellido_materno  \n"
                            + "FROM Transporte t, Paquete p ,Almacen a, Envio e, Mensajero m, Cliente c\n"
                            + "WHERE t.transporte_id = p.transporte_id \n"
                            + "And a.paquete_id = p.paquete_id\n"
                            + "And e.paquete_id = p.paquete_id\n"
                            + "And e.mensajero_id = m.mensajero_id\n"
                            + "And  t.transporte_id  =  +?"
                    );
                    ps.setString(1, id);
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
                    if (columnas == 0) {
                           JOptionPane.showMessageDialog(null, "el dato esta vacio"
                        );
                    }

                } else if (com == "Cliente") {
       id = ComboTabla.getSelectedItem().toString();
                    java.sql.Connection conectar = null;
                    PreparedStatement pst = null;
                    ResultSet result = null;
                    String SSQL = "Select Cliente_ID from Cliente where nombres = ?";
                    try {

                        //Establecemos conexión con la BD 
                        Connection con = Conexion.getConexion();
                        //Preparamos la consulta SQL
                        pst = con.prepareStatement(SSQL);
                          pst.setString(1, id);
                        //Ejecutamos la consulta
                        result = pst.executeQuery();

                        //LLenamos nuestro ComboBox
                        while (result.next()) {
                            id = (result.getString("Cliente_ID"));
                        }

                       

                        ps = con.prepareStatement("select t.descripcion,  p.descripcion, a.Entrada_salida,  e.fecha_envio , e.pais, e.CUIDAD, e.DIRECCION, m.nombres, m.apellidos, c.nombres, c.apellido_paterno, c.apellido_materno  \n"
                                + "FROM Transporte t, Paquete p ,Almacen a, Envio e, Mensajero m, Cliente c\n"
                                + "WHERE t.transporte_id = p.transporte_id \n"
                                + "And a.paquete_id = p.paquete_id\n"
                                + "And e.paquete_id = p.paquete_id\n"
                                + "And e.mensajero_id = m.mensajero_id\n"
                                + "And  c.cliente_id =  +?"
                        );
                        ps.setString(1, id);
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
                        if (columnas == 0) {
                                 JOptionPane.showMessageDialog(null, "el dato esta vacio"
                            );
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

                                JOptionPane.showMessageDialog(null, ex.toString(), "", JOptionPane.ERROR_MESSAGE);
                            }

                        }

                    }

                } else if (com == "Mensajero") {
          id = ComboTabla.getSelectedItem().toString();
                    java.sql.Connection conectar = null;
                    PreparedStatement pst = null;
                    ResultSet result = null;
                    String SSQL = "Select Mensajero_ID from mensajero where nombres = ?";

                    try {

                        //Establecemos conexión con la BD 
                        Connection con = Conexion.getConexion();
                        //Preparamos la consulta SQL
                        pst = con.prepareStatement(SSQL);
                            pst.setString(1, id);
                        //Ejecutamos la consulta
                        result = pst.executeQuery();

                        //LLenamos nuestro ComboBox
                        while (result.next()) {

                            id = (result.getString("Mensajero_ID"));

                        }

                    

                        ps = con.prepareStatement("select t.descripcion,  p.descripcion, a.Entrada_salida,  e.fecha_envio , e.pais, e.CUIDAD, e.DIRECCION, m.nombres, m.apellidos, c.nombres, c.apellido_paterno, c.apellido_materno  \n"
                                + "FROM Transporte t, Paquete p ,Almacen a, Envio e, Mensajero m, Cliente c\n"
                                + "WHERE t.transporte_id = p.transporte_id \n"
                                + "And a.paquete_id = p.paquete_id\n"
                                + "And e.paquete_id = p.paquete_id\n"
                                + "And e.mensajero_id = m.mensajero_id\n"
                                + "And  m.mensajero_id =  +?"
                        );
                        ps.setString(1, id);
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
                        if (columnas == 0) {
                                JOptionPane.showMessageDialog(null, "el dato esta vacio"
                            );
                        }

                    } catch (SQLException e) {

                        JOptionPane.showMessageDialog(null, e.toString(), "", JOptionPane.ERROR_MESSAGE);

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

                } else if (com == "Almacen") {
                    id = ComboTabla.getSelectedItem().toString();
                    Connection con = Conexion.getConexion();
                    ps = con.prepareStatement("select t.descripcion,  p.descripcion, a.Entrada_salida,  e.fecha_envio , e.pais, e.CUIDAD, e.DIRECCION, m.nombres, m.apellidos, c.nombres, c.apellido_paterno, c.apellido_materno  \n"
                            + "FROM Transporte t, Paquete p ,Almacen a, Envio e, Mensajero m, Cliente c\n"
                            + "WHERE t.transporte_id = p.transporte_id \n"
                            + "And a.paquete_id = p.paquete_id\n"
                            + "And e.paquete_id = p.paquete_id\n"
                            + "And e.mensajero_id = m.mensajero_id\n"
                            + "And  a.almacen_id =  +?"
                    );
                    ps.setString(1, id);
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
                    if (columnas == 0) {
                             JOptionPane.showMessageDialog(null, "el dato esta vacio"
                        );
                    }
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void llenarcomboEnvio() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select Envio_ID from Envio";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            ComboTabla.addItem("Seleccione una opción de los Envios existes");

            while (result.next()) {

                ComboTabla.addItem(result.getString("Envio_ID"));

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

    public void llenarcomboCliente() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select Nombres from Cliente";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();
            //LLenamos nuestro ComboBox
            ComboTabla.addItem("Seleccione una opción de los Clientes existes");
            while (result.next()) {
                ComboTabla.addItem(result.getString("nombres"));

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

    public void llenarcomboMensajero() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select Nombres from Mensajero";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            ComboTabla.addItem("Seleccione una opción de los Mensajeros existes");

            while (result.next()) {

                ComboTabla.addItem(result.getString("nombres"));

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

    public void llenarcomboTransporte() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select Transporte_ID from Transporte";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            ComboTabla.addItem("Seleccione una opción de los Transportes existes");

            while (result.next()) {

                ComboTabla.addItem(result.getString("Transporte_ID"));

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

    public void llenarcomboAlmacen() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select Almacen_ID from Almacen";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            ComboTabla.addItem("Seleccione una opción de los Almacen existes");

            while (result.next()) {

                ComboTabla.addItem(result.getString("Almacen_ID"));

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

    public void llenarcomboPaquete() {
//Creamos objeto tipo Connection    
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;

//Creamos la Consulta SQL
        String SSQL = "Select Paquete_ID from Paquete";

//Establecemos bloque try-catch-finally
        try {

            //Establecemos conexión con la BD 
            Connection con = Conexion.getConexion();
            //Preparamos la consulta SQL
            pst = con.prepareStatement(SSQL);
            //Ejecutamos la consulta
            result = pst.executeQuery();

            //LLenamos nuestro ComboBox
            ComboTabla.addItem("Seleccione una opción de los Paquetes existes");

            while (result.next()) {

                ComboTabla.addItem(result.getString("Paquete_ID"));

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
            java.util.logging.Logger.getLogger(Vtnbusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vtnbusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vtnbusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vtnbusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vtnbusqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTabla;
    private javax.swing.JComboBox<String> Combobusqueda;
    private javax.swing.JTable TablaJoin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
