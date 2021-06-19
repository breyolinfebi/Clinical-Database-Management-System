
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fredi
 */
public class F5 extends javax.swing.JFrame {

    /**
     * Creates new form F5
     */
    public F5() {
        try{
          
        initComponents();
        setSize(750,500);
        listfill();
        autoid();
        }catch(Exception e){System.out.println(e);}
    }
    
    public void autoid(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:breyo", "system", "hackpassword123");
            if (con != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
             Statement stmt;
            stmt = con.createStatement();
            ResultSet rs= null;
            PreparedStatement pst = null;
            
            String q1 = ("select max(bill_no) from bill");
             pst = con.prepareStatement(q1);
             rs=pst.executeQuery();
             int x = stmt.executeUpdate(q1);
             System.out.println(x);
            
            if(rs.next()){
                int id = rs.getInt(x);
                id++;
                bn.setText(Integer.toString(id));
            }
            
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    } 
        
    public void sum()
    {
        int total=0;
            for(int k=0;k<tab2.getRowCount();k++){
                total = total + Integer.parseInt(tab2.getValueAt(k,3).toString());
                
            }
           
            amt.setText(Integer.toString(total));
            
            String st = df.getText();
            int de = Integer.parseInt(st);
            int res = total+de;
            tt.setText(Integer.toString(res));
            String dat = da.getText();
            String b = bn.getText();
            int bi = Integer.parseInt(b);
            try{
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:breyo", "system", "hackpassword123");
            if (con != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
             Statement stmt;
            stmt = con.createStatement();
            String tmp=(String)list1.getSelectedValue();
            String q1 = "INSERT INTO BILL VALUES('" + tmp + "','" + total + "','" + st + "','" + res +"','" + bi + "','" + dat +"')";
            
            //String q1 = "INSERT INTO DOCT VALUES('"+ id +"','" + na + "','" + ge + "','" + a + "','" + pno + "','" + ad + "','" + text + "')";
            
            int x = stmt.executeUpdate(q1);
           // int y = stmt.executeUpdate(q2);
            if (x>0) {
                JOptionPane.showMessageDialog(null, "Bill Added !");
                //setVisible(false);
                //F8 f8 = new F8();
                //f8.setVisible(true);
            }
            
            }
            catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR", "WARNING", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        } catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR", "WARNING", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
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
        ResultSet rs=stmt.executeQuery("select * from PAT");
        while(rs.next()){
            String id = rs.getString("regid");
            m.addElement(id); 
        }
        list1.setModel(m);
            }    catch (SQLException | ClassNotFoundException ex) { 
            Logger.getLogger(F1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Us> usList(){
        ArrayList<Us> usersList = new ArrayList<>();
        
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
        String tmp=(String)list1.getSelectedValue();
        String sql = "SELECT * FROM MED WHERE REGID='"+tmp+"'";
        pst = con.prepareStatement(sql);
        //pst.setString(1, tmp);
        rs=pst.executeQuery();
        Us user;
        System.out.println(tmp);
        while(rs.next()){
            //System.out.println(rs.getString("medid"));
            user=new Us(rs.getString("medid"),rs.getString("medname"),rs.getString("quantity"),rs.getInt("price"));
            usersList.add(user);
            //System.out.println("hi");
  
        }
        
        
        }    catch (Exception e) {  
            System.out.println(e);
        }
         return usersList;
    }
    
    public void showuser(){
        try{
        ArrayList<Us> list = usList();
        DefaultTableModel model = (DefaultTableModel)tab2.getModel();
        Object[] row = new Object[4];
        
        
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getmid();
            row[1]=list.get(i).getname();
            row[2]=list.get(i).getquan();
            row[3]=list.get(i).getpr();
            model.addRow(row);
            
        }
        }catch(Exception e){
            System.out.println(e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        na = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        da = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        df = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        bn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("PATIENT ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 200, 92, 25);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 270, 67, 24);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setText("MEDICINE INFORMATION");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 20, 305, 28);
        getContentPane().add(pid);
        pid.setBounds(40, 240, 92, 30);

        na.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naActionPerformed(evt);
            }
        });
        getContentPane().add(na);
        na.setBounds(40, 300, 92, 30);

        tab2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MED ID", "NAME", "QUANTITY", "PRICE"
            }
        ));
        jScrollPane2.setViewportView(tab2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(182, 212, 534, 242);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(35, 433, 71, 21);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("AMOUNT");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 140, 92, 24);
        getContentPane().add(amt);
        amt.setBounds(610, 140, 92, 28);
        getContentPane().add(da);
        da.setBounds(40, 380, 92, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("DATE");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 350, 92, 22);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("TOTAL BILL");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(500, 180, 92, 21);
        getContentPane().add(tt);
        tt.setBounds(610, 180, 92, 25);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("DOCTOR FEE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(500, 110, 100, 14);
        getContentPane().add(df);
        df.setBounds(610, 100, 89, 28);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel9.setText("RED ID");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(220, 70, 50, 20);

        list1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 70, 70, 110);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Bill No");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(510, 60, 70, 30);
        getContentPane().add(bn);
        bn.setBounds(610, 60, 90, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\breyo\\Pictures\\Saved Pictures\\istockphoto-1003420604-1024x1024.jpg")); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-210, -110, 980, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void naActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_naActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        F4 f4 = new F4();
        f4.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked
        // TODO add your handling code here:
        String tmp=(String)list1.getSelectedValue();
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
         //String r = pid.getText();
        //String sql = "SELECT * FROM PAT WHERE PID = '"+r+"' AND REGID=?";
        String sql = "SELECT * FROM PAT WHERE REGID=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, tmp);
        rs=pst.executeQuery();
        if(rs.next()){
            //String ad0 = rs.getString("reg");
            //rid.setText(ad0);
            String ad1 = rs.getString("pname");
            na.setText(ad1);
            String ad6 = rs.getString("dat");
            da.setText(ad6);
            int p = rs.getInt("pid");
            String ad7 = Integer.toString(p);
            pid.setText(ad7);
            showuser();
            sum();
            
        }
        
        }    catch (Exception e) {  
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_list1MouseClicked

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
            java.util.logging.Logger.getLogger(F5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amt;
    private javax.swing.JTextField bn;
    private javax.swing.JTextField da;
    private javax.swing.JTextField df;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list1;
    private javax.swing.JTextField na;
    private javax.swing.JTextField pid;
    private javax.swing.JTable tab2;
    private javax.swing.JTextField tt;
    // End of variables declaration//GEN-END:variables
}
