
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author breyo
 */
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.Printable;
import java.awt.print.*;

public class Bill extends javax.swing.JFrame {

    /**
     * Creates new form Bill
     */
    public Bill() {
        initComponents();
        setSize(640,400);
        listfill();
    }
    private void listfill(){
        DefaultListModel m = new DefaultListModel();
         try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step3 create the statement object
   //step2 create  the connection object
    Connection con = DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:breyo","system","hackpassword123");
        //step3 create the statement object
        Statement stmt=con.createStatement();
        //step4 execute query
        ResultSet rs=stmt.executeQuery("select * from BILL");
        while(rs.next()){
            String id = rs.getString("regid");
            m.addElement(id); 
        }
        jList1.setModel(m);
            }    catch (SQLException | ClassNotFoundException ex) {  
            Logger.getLogger(F1.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Bill Generation");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 70, 159, 28);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 150, 64, 130);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Patient Register Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 110, 14);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(240, 100, 256, 183);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 320, 59, 23);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(440, 320, 59, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\breyo\\Pictures\\Saved Pictures\\istockphoto-1003420604-1024x1024.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-6, -6, 630, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
            String tmp=(String)jList1.getSelectedValue();
         try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step3 create the statement object
   //step2 create  the connection object
    Connection con = DriverManager.getConnection(  "jdbc:oracle:thin:@localhost:1521:breyo","system","hackpassword123");
        //step3 create the statement object
        Statement stmt=con.createStatement();
        //step4 execute query
        ResultSet rs= null;
        PreparedStatement pst = null;
       // String r = pid.getText();
        String sql = "SELECT * FROM BILL WHERE REGID=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, tmp);
        rs=pst.executeQuery();
        if(rs.next()){
            //String ad0 = rs.getString("reg");
            //rid.setText(ad0);
            int ad3 = rs.getInt("med_tot_price");
            String st1 = Integer.toString(ad3);
            int ad4 = rs.getInt("doct_fee");
            String st2 = Integer.toString(ad4);
            int ad1 = rs.getInt("tot_amt");
            String st3 = Integer.toString(ad1);
            int ad2 = rs.getInt("bill_no");
            String st4 = Integer.toString(ad2);
            String st5 = rs.getString("bill_date");
            jTextArea1.append("\t Clinic Bill\n"+"Bill No: "+st4+"\nBill Date: "+st5+ "\nRegid: "+tmp+ "\nMedicine Price in Rs: "+st1+ "\nDoctor Fee: "+st2+ "\nTotal Amount: "+st3+ "\n \t Thank You");
            
        }
        
        }    catch (SQLException | ClassNotFoundException ex) {  
            Logger.getLogger(F1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String printdata = jTextArea1.getText();
        PrinterJob job = PrinterJob.getPrinterJob();
        boolean doPrint = job.printDialog();
        if (doPrint)
        {
            try{
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
