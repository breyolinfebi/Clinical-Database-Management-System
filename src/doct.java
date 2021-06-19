
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author breyo
 */
public class doct extends javax.swing.JFrame {

    /**
     * Creates new form doct
     */
    public doct() {
        initComponents();
        setSize(560,430);
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
        ResultSet rs=stmt.executeQuery("select * from DOCT");
        while(rs.next()){
            String id = rs.getString("id");
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

        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        na = new javax.swing.JTextField();
        gen = new javax.swing.JTextField();
        ag = new javax.swing.JTextField();
        nu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Doctor Information");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 11, 200, 28);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 89, 62, 130);

        jLabel2.setText("Doctor Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 51, 62, 14);

        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 51, 78, 14);

        jLabel4.setText("Gender");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 95, 78, 14);

        jLabel5.setText("Age");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 140, 78, 14);

        jLabel6.setText("Contact Number");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 190, 110, 14);
        getContentPane().add(na);
        na.setBounds(241, 45, 111, 27);
        getContentPane().add(gen);
        gen.setBounds(241, 89, 111, 27);

        ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agActionPerformed(evt);
            }
        });
        getContentPane().add(ag);
        ag.setBounds(241, 134, 111, 27);
        getContentPane().add(nu);
        nu.setBounds(241, 179, 111, 29);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(129, 351, 90, 23);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(241, 351, 90, 23);

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(352, 351, 70, 23);

        jLabel7.setText("Username");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 250, 110, 14);

        jLabel8.setText("Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(120, 290, 110, 14);
        getContentPane().add(user);
        user.setBounds(241, 237, 111, 30);

        pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdActionPerformed(evt);
            }
        });
        getContentPane().add(pwd);
        pwd.setBounds(241, 285, 111, 27);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\breyo\\Pictures\\Saved Pictures\\istockphoto-1003420604-1024x1024.jpg")); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(-100, -260, 670, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try  {
            
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:breyo", "system", "hackpassword123");
            if (con != null) {
                System.out.println("Connected to the database!");
            } else 
            {
                System.out.println("Failed to make connection!");
            }
            String tmp=(String)jList1.getSelectedValue();
            //String tmp = pid.getText();
            
            java.sql.Statement st = null;
            Statement stmt = con.createStatement();
            String n = na.getText();
            String g = gen.getText();
            int a = Integer.parseInt(ag.getText());            
            int nm = Integer.parseInt(nu.getText());
            String ar = user.getText();
            String d = pwd.getText();
            
            
            String q1 = "UPDATE DOCT SET NAME='"+n+"',GENDER='"+g+"',AGE='"+a+"',NUM = '"+nm+"',USERNAME='"+ar+"',PASSWORD='"+d+"'";
            
            int x = stmt.executeUpdate(q1);
            if(x>0){
                JOptionPane.showMessageDialog(null,"DETAILS UPDATED!");
            
            }
            else
            {
                  JOptionPane.showMessageDialog(null,"INVALID!");  
                    }
            
            
            }
        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            System.out.println(e);
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR", "WARNING", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        String sql = "SELECT * FROM DOCT WHERE ID=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, tmp);
        rs=pst.executeQuery();
        if(rs.next()){
            //String ad0 = rs.getString("reg");
            //rid.setText(ad0);
            String ad1 = rs.getString("name");
            na.setText(ad1);
            String ad2 = rs.getString("gender");
            gen.setText(ad2);
            int ad3 = rs.getInt("age");
            String st1 = Integer.toString(ad3);
            ag.setText(st1);
            int ad4 = rs.getInt("num");
            String st2 = Integer.toString(ad4);
            nu.setText(st2);
            String ad5 = rs.getString("username");
            user.setText(ad5);
            String ad6 = rs.getString("password");
            pwd.setText(ad6);
            
        }
        
        }    catch (SQLException | ClassNotFoundException ex) {  
            Logger.getLogger(F1.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try  {
            
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:breyo", "system", "hackpassword123");
            if (con != null) {
                System.out.println("Connected to the database!");
            } else 
            {
                System.out.println("Failed to make connection!");
            }
            String tmp=(String)jList1.getSelectedValue();
           
            String r = "doctor";
            
            java.sql.Statement st = null;
            Statement stmt = con.createStatement();
            String q1 = "DELETE FROM DOCT WHERE ID='"+ tmp +"'";
            String q2 ="DELETE FROM LOGIN WHERE USERTYPE='"+ r +"'";
            int y = stmt.executeUpdate(q2);
            int x = stmt.executeUpdate(q1);
            
            if(x>0){
                JOptionPane.showMessageDialog(null,"DETAILS DELETED!");
            
            }
            else
            {     try{
                  JOptionPane.showMessageDialog(null,"INVALID!"); 
            }catch(Exception e){System.out.println(e);}
            }
        }
        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR", "WARNING", JOptionPane.ERROR_MESSAGE);
e.printStackTrace();}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agActionPerformed

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
            java.util.logging.Logger.getLogger(doct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ag;
    private javax.swing.JTextField gen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField na;
    private javax.swing.JTextField nu;
    private javax.swing.JTextField pwd;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}