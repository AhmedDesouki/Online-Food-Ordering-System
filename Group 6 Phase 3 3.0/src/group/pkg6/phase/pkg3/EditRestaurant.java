package group.pkg6.phase.pkg3;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class EditRestaurant extends javax.swing.JFrame {

        DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Restaurant rest = null;
    
    public EditRestaurant(Restaurant r) {
        initComponents();

        this.rest=r;
        getInfo();
    }
        public EditRestaurant() {
               initComponents();

           }
//    public void fillcombo()
//    {
//        try {
//            // TODO add your handling code here:
//             Statement stat = con.createStatement();
//             String query = "select * from restaurant";
//             ResultSet rs = stat.executeQuery(query);
//             while(rs.next())
//             {
//                 //restidcombo.addItem(Integer.toString(rs.getInt("restaurant_id"))); //sha8ala
//                 restidcombo.addItem(Integer.toString(rs.getInt("restaurant_id")));
//                 //restid.setText(rs.getString("username"));
//             }
//             
//        }  catch (SQLException ex) {
//            Logger.getLogger(DeleteRestaurant.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void getInfo()
    {
                try {
            // TODO add your handling code here:
             Statement stat = con.createStatement();
             String query = "select * from restaurant where restaurant_id="+rest.getRestaurantid();
             ResultSet rs = stat.executeQuery(query);
             while(rs.next())
             {
                 idtext.setText(rs.getString("restaurant_id"));
                 username.setText(rs.getString("username"));
                 password.setText(rs.getString("password"));
                 email.setText(rs.getString("email"));
                 location.setText(rs.getString("location"));
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
        location = new javax.swing.JTextField();
        EditRestaurant = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idtext = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        EditRestaurant.setText("Edit Restaurant");
        EditRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditRestaurantActionPerformed(evt);
            }
        });

        jLabel1.setText("Edit Restaurant");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("E-Mail");

        jLabel5.setText("Location");

        jLabel6.setText("Restaurant ID");

        idtext.setEditable(false);
        idtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtextActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(84, 84, 84)
                .addComponent(EditRestaurant)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(username)
                            .addComponent(location)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(idtext))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addGap(153, 153, 153)))))
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditRestaurant)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void EditRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditRestaurantActionPerformed
        // TODO add your handling code here:
        //int id = Integer.parseInt(restid.getText());
       int id=rest.getRestaurantid();
//        String x = restidcombo.getSelectedItem().toString();
//         Integer id = Integer.valueOf(x);
            
        String user = username.getText();
        String mail = email.getText();
        String pass = password.getText();
        String loc = location.getText();
        

        if (!"".equals(user) && !"".equals(mail) && !"".equals(pass) && !"".equals(loc)){
            Restaurant rest = new Restaurant();
            rest.editRestaurant(id, user, pass, mail, loc);
        }else {
            JOptionPane.showMessageDialog(null, "Not all fields were filled");
        }
        
        
        username.setText("");
        email.setText("");
        password.setText("");
        location.setText("");
        
//        JOptionPane.showMessageDialog(null, cust.getCustomerid());
        
        JOptionPane.showMessageDialog(null, "Edited");
//         int result = JOptionPane.showConfirmDialog(null,"Do you want to edit something?", "Edit Restaurant",
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
    }//GEN-LAST:event_EditRestaurantActionPerformed

    private void idtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        RestaurantMenu rm = new RestaurantMenu(rest); 
        rm.setVisible(true);
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
            java.util.logging.Logger.getLogger(EditRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Customer c = null;
                Restaurant r=null;
                new EditRestaurant(r).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditRestaurant;
    private javax.swing.JTextField email;
    private javax.swing.JTextField idtext;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField location;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
