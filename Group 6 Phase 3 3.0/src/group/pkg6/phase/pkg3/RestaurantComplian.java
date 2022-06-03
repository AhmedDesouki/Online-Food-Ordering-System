/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group.pkg6.phase.pkg3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kareem
 */
public class RestaurantComplian extends ComplainHandler {
    
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    
    @Override
    public void HandleCompain(int complian_id){
    
    
    
                try {
            
            Statement stmt = con.createStatement();  
            String sql = "DELETE FROM complain WHERE complain_id = "+complian_id;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql);
            JOptionPane.showMessageDialog(null, "Restaurant Complain Handeled successfully");
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    
    
    
    
    
    
    
    
    }
    
}
