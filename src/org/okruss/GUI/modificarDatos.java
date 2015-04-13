/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.okruss.GUI;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;
import org.okruss.CNC.classes.NumeroLetra;
import org.okruss.CNC.classes.conex;
import org.okruss.CNC.classes.file_browser;
import org.okruss.CNC.classes.reportes;

/**
 *
 * @author Okruss
 */
public class modificarDatos extends javax.swing.JFrame {
    
    conex cone = new conex();
    reportes report= new reportes();
    file_browser fl = new file_browser();
    Connection con;
    Statement stmt = null;
    String prod="";
    String clave="";
    String  tit=" VERIFICACIÓN DE DATOS: ";
    /**
     * Creates new form modificarDatos
     */
    public modificarDatos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VERIFICACION DE REGISTRO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("VERIFICACIÓN DE DATOS");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "KEY", "SUP", "DOMPROD", "UBIPAR", "RFC", "CURP", "IFE", "TEL", "EMAIL", "ESTRA", "BANCO", "NCUENT", "TIPO"
            }
        ));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("ACTUALIZAR DATOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VERIFICAR CONTRATO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        final JProgressBar barraProgreso = new JProgressBar(0, 1000);
        final JDialog dialogoProgreso = new JDialog(this, "Procesando...");
        dialogoProgreso.getContentPane().add(barraProgreso);
        dialogoProgreso.pack();
        dialogoProgreso.setLocationRelativeTo(null);

        final javax.swing.SwingWorker worker;
        worker = new javax.swing.SwingWorker() {
            
            @Override
            protected Void doInBackground() throws Exception {
                dialogoProgreso.setVisible(true);
                barraProgreso.setVisible(true);
                barraProgreso.setIndeterminate(true);
                try
                {
                    titulo.setText(tit+": "+clave+"::"+prod);
                    stmt=cone.conexion();
                    stmt.getConnection();
                    stmt.executeUpdate("use credito");
                    ResultSet rs=stmt.executeQuery("Select LLAVE,SUP,DOMPROD,UBIPAR,RFC,"
                            + "CURP,IFE,TEL,EMAIL,ESTRA,BANCO,NCUENT,TIPO "
                            + "from padron where "
                            + "CLAVE='"+clave+"'");

                    ResultSetMetaData mD = rs.getMetaData();
                    int ncol=mD.getColumnCount();
                    Object label [] = new Object [ncol];
                    for (int i=0;i<ncol;i++)
                    {
                        label[i]=mD.getColumnLabel(i+1);
                    }

                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0);
                    modelo.setColumnIdentifiers(label);
                    while(rs.next())
                    {
                        Object [] fila = new Object [ncol];
                        for (int i=0;i<ncol;i++)
                        {
                            fila[i]=rs.getObject(i+1);
                        }
                        modelo.addRow(fila);
                    }
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
                    e.printStackTrace();
                }
                                
                return null;
            }

            @Override
            protected void done() {
                barraProgreso.setIndeterminate(false);;
                barraProgreso.setVisible(false);
                dialogoProgreso.setVisible(false);
            }
        };
        worker.execute();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                
                final JProgressBar barraProgreso = new JProgressBar(0, 1000);
                final JDialog dialogoProgreso = new JDialog(this, "Procesando...");
                dialogoProgreso.getContentPane().add(barraProgreso);
                dialogoProgreso.pack();
                dialogoProgreso.setLocationRelativeTo(null);
                final javax.swing.SwingWorker worker;
                worker = new javax.swing.SwingWorker() {
            
                @Override
                protected Void doInBackground() throws Exception {
                dialogoProgreso.setVisible(true);
                barraProgreso.setVisible(true);
                barraProgreso.setIndeterminate(true);
                try
                    {
                        for(int x=0; x<tabla.getRowCount();x++)
                            {
                            System.out.println("LLAVE PARA LA FILA:"+tabla.getValueAt(x,0)+"///////////////");
                            
                                for (int c=1; c<tabla.getColumnCount();c++)
                                    {
                                        stmt=(Statement) cone.conexion();
                                        stmt.getConnection();
                                        stmt.executeUpdate("use credito");
                                        System.out.println("update padron set "+tabla.getColumnName(c)+"='"+tabla.getValueAt(x, c)+"' where llave='"+tabla.getValueAt(x,0)+"'");
                                        stmt.executeUpdate("update padron set "+tabla.getColumnName(c)+"='"+tabla.getValueAt(x, c)+"' where llave='"+tabla.getValueAt(x,0)+"'");
                                        //System.out.println(tabla.getColumnName(c)+"::"+tabla.getValueAt(x,c));
                                        
                                    }
                            }
                        JOptionPane.showMessageDialog(null,"SE ACTUALIZARON LOS REGISTROS");
                    
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
                    e.printStackTrace();
                }
                                
                return null;
            }

            @Override
            protected void done() {
                barraProgreso.setIndeterminate(false);;
                barraProgreso.setVisible(false);
                dialogoProgreso.setVisible(false);
            }
        };
        worker.execute();
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        NumeroLetra nl = new NumeroLetra();
         DecimalFormat df = new DecimalFormat("#,###.##");
        Double supT=0.0, mont=0.0, montT=0.0;
        String ubicPar="", domprod="", folCon="", has="", letra="";
        String fepa="",gen="";
        
        
        
        //obtengo la suma de la superficie de esa clave
//        for (int x=0;x<tabla.getRowCount();x++)
//        {
//            supT=supT+Double.parseDouble(tabla.getValueAt(x,1).toString());
//        }
        String supAlert="";
        try {
            stmt.executeUpdate("use credito");
            ResultSet rs8=stmt.executeQuery("Select sum(sup) where padron where prod "+prod+"");
            while(rs8.next())
                    {
                     supT=Double.parseDouble(rs8.getString(1));
                    }
        } catch (SQLException ex) {
            Logger.getLogger(modificarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        //obtengo desglose de has y ubicaciones
//        for(int x=0;x<tabla.getRowCount();x++)
//        {
//            ubicPar=ubicPar+" "+tabla.getValueAt(x, 1).toString()+" HAS en "+tabla.getValueAt(x, 3).toString()+" ";
//        } 
        try {
            stmt.executeUpdate("use credito");
            ResultSet rs9=stmt.executeQuery("Select sup,ubipar where padron where prod "+prod+"");
            while(rs9.next())
                    {
                     ubicPar=ubicPar+" "+rs9.getString(1)+" HAS en"+rs9.getString(2);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(modificarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //obtengo domicilio del productor
//        domprod=tabla.getValueAt(0,2).toString();
        try {
            stmt.executeUpdate("use credito");
            ResultSet rs9=stmt.executeQuery("Select domprod where padron where prod "+prod+"");
            while(rs9.next())
                    {
                     domprod=rs9.getString(1);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(modificarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //calculo el monto de préstamo has*7,000
        mont=supT*7000;
        //convierto a letra el monto
        String let=(nl.Convertir(mont.toString(), true));
        //inversion total mont+25%
        montT=(mont*.25)+mont;
        
        System.out.println("Superficie de la clave: "+clave+" :" +supT);
        System.out.println("Domicilio del productor es: "+domprod);
        System.out.println("Ubicación de parcelas: "+ubicPar);
        System.out.println("Monto máximo de préstamo: "+mont);
        System.out.println("Monto en letra:"+let);
        System.out.println("Inversión total: "+montT);
        
        //Llamo la ventana de autorizar contrato
        validaContrato vC = new validaContrato();
        vC.clave=clave;
        vC.letra=let;
        vC.domProd.setText(domprod);
        vC.prod.setText(prod);
        vC.has.setText(supT.toString());
        vC.ubPar.setText(ubicPar);
        vC.mont.setText(df.format(mont));
        vC.montT.setText(df.format(montT));
        vC.setVisible(true);
        vC.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(modificarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                modificarDatos md= new modificarDatos();
                md.setVisible(true);
                md.setLocationRelativeTo(null);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}