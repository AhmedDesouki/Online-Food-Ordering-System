package group.pkg6.phase.pkg3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomerSupport extends User
{
    Complain ticket;
    static int CustomerSupport_ID;
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();


    public CustomerSupport() 
    {
        
        
    }

    public CustomerSupport(String username, String email, String password, PaymentMethod payment)
    {
        super(username, email, password, payment);
        CustomerSupport_ID += 1;
    }
    
    public void Login(String username,String password){
         
         try {
             
        String query= "select * from CustomerSupport where username=? and password=?";
             
                PreparedStatement ps = null;
                ResultSet rs =null;
            
               ps=con.prepareStatement(query);
               ps.setString(1, username);
               ps.setString(2, password);
               rs=ps.executeQuery();
               if(rs.next()){
                   
                 CustomerSupport_ID  = rs.getInt(1);
                 JOptionPane.showMessageDialog(null, CustomerSupport_ID);
                 JOptionPane.showMessageDialog(null, "Logged In ");
                 new CustomerSupport_Menu().setVisible(true);
               }
               else
               {
               
                 JOptionPane.showMessageDialog(null, "Invalid username or password");
                 new Login().setVisible (true);
               }
        } catch (SQLException ex) {
            
           JOptionPane.showMessageDialog(null, ex);
           
        }
    }
    
    
    
    public JTable ViewComplians (JTable jTable1) {
        try {
            ResultSet rs = null;
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM complain";
            
            System.out.println(sql);
            rs = stmt.executeQuery(sql);

            DefaultTableModel model;
            model = (DefaultTableModel) jTable1.getModel();
            Object rowData[] = new Object[4];

            while (rs.next()) {
                rowData[0] = rs.getInt("complain_id");
                rowData[1] = rs.getString("complain");
                rowData[2] = rs.getInt("customer_id");
                rowData[3] = rs.getInt("date");
                model.addRow(rowData);
            }
        } catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }

        return jTable1;
    }
    
    
            public void CS_Member(String username, String Password, String email) 
    {
        try {
            
            Statement stmt = con.createStatement();  
            String sql = "INSERT INTO customersupport (username, Password, email) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, Password);
            ps.setString(3, email);
            ps.executeUpdate();
            System.out.println(sql);
            JOptionPane.showMessageDialog(null, "Inserted succesfull");
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }
    
    
}
