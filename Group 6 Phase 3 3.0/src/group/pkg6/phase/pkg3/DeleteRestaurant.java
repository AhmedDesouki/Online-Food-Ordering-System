package group.pkg6.phase.pkg3;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DeleteRestaurant extends javax.swing.JFrame {

    String userName = "root";
    String password = "";
    String dbName = "group6";
//    Connection conn=null;
//    PreparedStatement pst=null;
//    ResultSet rs=null;
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    
    public DeleteRestaurant() {
        initComponents();
        fillcombo();
    }
 
    public void fillcombo()
    {
        try {
            // TODO add your handling code here:
             Statement stat = con.createStatement();
             String query = "select * from restaurant";
             ResultSet rs = stat.executeQuery(query);
             while(rs.next())
             {
                 //restidcombo.addItem(Integer.toString(rs.getInt("restaurant_id"))); //sha8ala
                 restidcombo.addItem(Integer.toString(rs.getInt("restaurant_id")));
                 //restid.setText(rs.getString("username"));
             }
             
        }  catch (SQLException ex) {
            Logger.getLogger(DeleteRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getInfo(int id)
    {
                try {
            // TODO add your handling code here:
             Statement stat = con.createStatement();
             String query = "select * from restaurant where restaurant_id="+id;
             ResultSet rs = stat.executeQuery(query);
             while(rs.next())
             {
                 restid.setText(rs.getString("username"));
                 email.setText(rs.getString("email"));
                 loc.setText(rs.getString("location"));
             }
//             rs.close();
//             stat.close();
//             con.close();
             
        }  catch (SQLException ex) {
            Logger.getLogger(DeleteRestaurant.class.getName()).log(Level.SEVERE, null, ex);
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

        restid = new javax.swing.JTextField();
        DeleteRestaurant = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        restidcombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        loc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        restid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restidActionPerformed(evt);
            }
        });

        DeleteRestaurant.setText("Delete Restaurant");
        DeleteRestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRestaurantActionPerformed(evt);
            }
        });

        jLabel1.setText("Delete Restaurant");

        jLabel2.setText("Restaurant Name");

        restidcombo.setToolTipText("");
        restidcombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                restidcomboFocusGained(evt);
            }
        });
        restidcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restidcomboActionPerformed(evt);
            }
        });

        jLabel3.setText("Restaurant ID");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel4.setText("E-Mail");

        loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locActionPerformed(evt);
            }
        });

        jLabel5.setText("Location");

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
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restid, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restidcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(DeleteRestaurant)
                        .addGap(50, 50, 50))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(jLabel3)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(restidcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteRestaurant)
                    .addComponent(jButton1))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jLabel3)
                    .addContainerGap(177, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteRestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRestaurantActionPerformed
        // TODO add your handling code here:
        //Integer id = Integer.parseInt(restid.getText()); // sha8ala       
        //        Integer chosenNumber = (Integer) restidcombo.getSelectedItem();
       //        int i = Integer.parseInt(x);
       
            String x = restidcombo.getSelectedItem().toString();
            Integer id = Integer.valueOf(x);
            
            String sql ="select restaurant_id from restaurant where restaurant_id="+id;
        
            Restaurant rest = new Restaurant();
            rest.deleteRestaurant(id);
            restid.setText("");
            email.setText("");
            loc.setText("");
        
        
        int result = JOptionPane.showConfirmDialog(null,"Do you want to delete another Restaurant?", "Delete Restaurant",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               this.setVisible(true);
            }else if (result == JOptionPane.NO_OPTION){
               this.setVisible(false);
               new ActionAdmin().setVisible(true);
            }
        
    }//GEN-LAST:event_DeleteRestaurantActionPerformed

    private void restidcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restidcomboActionPerformed
//        Integer i = (Integer) restidcombo.getSelectedItem();
//        //int i = Integer.parseInt((String) restidcombo.getSelectedItem()); 
//        
//                String sql ="select restaurant_id from restaurant where restaurant_id="+(Integer) restidcombo.getSelectedItem();
//        
//        if(sql != null)
//        {
//        Restaurant rest = new Restaurant();
//        rest.deleteRestaurant(i);
//        restid.setText("");
//        }
//        
//        int result = JOptionPane.showConfirmDialog(null,"Do you want to delete another Restaurant?", "Delete Restaurant",
//               JOptionPane.YES_NO_OPTION,
//               JOptionPane.QUESTION_MESSAGE);
//            if(result == JOptionPane.YES_OPTION){
//               this.setVisible(true);
//            }else if (result == JOptionPane.NO_OPTION){
//               this.setVisible(false);
//            }

            String x = restidcombo.getSelectedItem().toString();
            Integer id = Integer.valueOf(x);
            
            getInfo(id);
         
    }//GEN-LAST:event_restidcomboActionPerformed

    private void restidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restidActionPerformed

    private void restidcomboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_restidcomboFocusGained
        // TODO add your handling code here:
        //restid.setText(restidcombo.getSelectedItem().toString());
    }//GEN-LAST:event_restidcomboFocusGained

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ActionAdmin aa = new ActionAdmin(); 
        aa.setVisible(true);
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
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteRestaurant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteRestaurant;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField loc;
    private javax.swing.JTextField restid;
    private javax.swing.JComboBox<String> restidcombo;
    // End of variables declaration//GEN-END:variables
}