package group.pkg6.phase.pkg3;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class EditCustomer extends javax.swing.JFrame {

        DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Customer cust = null;
    
    public EditCustomer(Customer c) {
        initComponents();
        this.cust=c;
        getInfo();
    }

    
    public void getInfo()
    {
                try {
            // TODO add your handling code here:
             Statement stat = con.createStatement();
             String query = "select * from customer where customer_id="+cust.getCustomerid();
             ResultSet rs = stat.executeQuery(query);
             while(rs.next())
             {
                 custid.setText(rs.getString("customer_id"));
                 username.setText(rs.getString("username"));
                 password.setText(rs.getString("password"));
                 email.setText(rs.getString("email"));
                 address.setText(rs.getString("address"));
             }
//             rs.close();
//             stat.close();
//             con.close();
             
        }  catch (SQLException ex) {
            Logger.getLogger(DeleteRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        EditCustomer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        custid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        EditCustomer.setText("Edit Customer");
        EditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCustomerActionPerformed(evt);
            }
        });

        jLabel1.setText("Edit Customer");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("E-Mail");

        jLabel5.setText("Address");

        jLabel6.setText(" ID");

        custid.setEditable(false);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(address)
                            .addComponent(email)
                            .addComponent(username)
                            .addComponent(custid)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditCustomer)))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(custid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditCustomer)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void EditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCustomerActionPerformed
        // TODO add your handling code here:
        //int id = Integer.parseInt(restid.getText());
        
//        String x = restidcombo.getSelectedItem().toString();
//         Integer id = Integer.valueOf(x);
        int id = cust.getCustomerid();    
        String user = username.getText();
        String mail = email.getText();
        String pass = password.getText();
        String loc = address.getText();
         if (user.equals("") || mail.equals("")|| pass.equals("")|| loc.equals("")){
           JOptionPane.showMessageDialog(this,"Please fill all fields.");
       }
        else{
        Customer test = new Customer();
        test.editCustomer(id, user, mail, pass, loc);

        
        //JOptionPane.showMessageDialog(null, test.getCustomerid());
        JOptionPane.showMessageDialog(null, "Edited");
//         int result = JOptionPane.showConfirmDialog(null,"Do you want to edit another Customer?", "Edit Customer",
//               JOptionPane.YES_NO_OPTION,
//               JOptionPane.QUESTION_MESSAGE);
//            if(result == JOptionPane.YES_OPTION)
//            {
//               this.setVisible(true);
//            }
//            else if (result == JOptionPane.NO_OPTION)
//            {
//               this.setVisible(false);
//            }
    }//GEN-LAST:event_EditCustomerActionPerformed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CustomerMenu cm = new CustomerMenu(cust); 
        cm.setVisible(true);
        
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
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Customer c = null;
                new EditCustomer(c).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditCustomer;
    private javax.swing.JTextField address;
    private javax.swing.JTextField custid;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
