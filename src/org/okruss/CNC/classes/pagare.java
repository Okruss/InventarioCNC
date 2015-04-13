/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.okruss.CNC.classes;

import com.mysql.jdbc.Connection;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.okruss.GUI.modificarDatos;
import org.okruss.GUI.validaContrato;

/**
 *
 * @author Okruss
 */
public class pagare extends javax.swing.JFrame {
    
    NumeroLetra nl = new NumeroLetra();
    public String prod="", domprod="",fecha="", id="", clave="";
    conex cone = new conex();
        reportes report= new reportes();
        file_browser fl = new file_browser();
        Connection con;
        Statement stmt = null;
    
    
    /**
     * Creates new form pagare
     */
    public pagare() {
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        folpag = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        montopag = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fechapag = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        interes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagaré");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAGARÉ");

        jLabel2.setText("FOLIO PAGARÉ:");

        jLabel3.setText("MONTO:");

        montopag.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jButton1.setText("PAGARÉ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("FECHA:");

        jLabel5.setText("INTERÉS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(folpag)
                            .addComponent(montopag, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(fechapag)
                            .addComponent(interes))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(folpag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(montopag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechapag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String por=interes.getText();
        Double segu=0.0, pagare=0.0;
        pagare=Double.parseDouble(montopag.getText().replaceAll(",",""));
        segu=pagare*.03;
        String ms=String.format("%.2f", segu);
        String lesegu=nl.Convertir(ms, true);
        
        
        fecha=fechapag.getText().toUpperCase();
        String mon=montopag.getText().toString();
        String monle=nl.Convertir(mon.replaceAll(",",""),true);
        System.out.println(mon+".------"+monle);
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
                    stmt=(Statement) cone.conexion();
                      stmt.getConnection();
                      System.out.println("FOLIO"+folpag);
                      stmt.executeUpdate("use credito");
                      
                      stmt.executeUpdate("insert into pagare values ("
                              + "'"+id+"','"+folpag.getText()+"','"+prod+"','"+mon.replaceAll(",","")+"',"
                              + "'"+monle+"','"+fecha.toUpperCase()+"','"+domprod+"'"
                              + ")");
                    
                    reportes rep = new reportes();
                    rep.PAGARE(folpag.getText(), mon,monle, prod, domprod, fecha.toUpperCase(),clave,por,ms,lesegu);
                    stmt.executeUpdate("delete from alert where folioPag='"+folpag.getText()+"'");
                    System.out.println("ya emití el reporte");
                    pagare pag = new pagare();
                    stmt.executeUpdate("use credito");
                    //elimino el folio de alerte que se trabajo
                    
                      modificarDatos md = new modificarDatos();
                    md.dispose();
                    pag.dispose();
                    
                    validaContrato vc = new validaContrato();
                    vc.dispose();
                    
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
            java.util.logging.Logger.getLogger(pagare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pagare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pagare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pagare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pagare pag = new pagare();
                pag.setVisible(true);
                pag.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField fechapag;
    public javax.swing.JTextField folpag;
    public javax.swing.JTextField interes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JFormattedTextField montopag;
    // End of variables declaration//GEN-END:variables
}