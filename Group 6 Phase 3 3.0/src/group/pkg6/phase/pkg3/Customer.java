package group.pkg6.phase.pkg3;

import java.sql.*;
import javax.swing.*;

public class Customer extends User implements Observer
{
        int customerid;
        String address;

        
        DBConnect databaseconnection= new DBConnect();
        private Connection con = databaseconnection.connect();

    public Customer() {
    }

    public Customer(int customerid, String address, String username, String email, String password, PaymentMethod payment) {
        super(username, email, password, payment);
        this.customerid = customerid;
        this.address = address;
    }

        
        
        
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }


        
        
        
        
            public void addCustomer(String user, String pass, String mail, String adrs) 
    {
        try {
            
            Statement stmt = con.createStatement();  
            String sql = "INSERT INTO customer (username, password, email, address) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, mail);
            ps.setString(4, adrs);
            ps.executeUpdate();
            System.out.println(sql);
            JOptionPane.showMessageDialog(null, "Inserted succesfull");
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }
            
            
             public  void editCustomer(int id, String user, String mail, String pass, String adrs){
     
         try {
             
             String query= "update group6.customer set username= '"+user+"', password='"+pass+"', email='"+mail+"', address='"+adrs+"' where customer_id="+id;
  
            Statement s=null;
            s=con.createStatement();
            s.executeUpdate(query);
      
            JOptionPane.showMessageDialog(null, "Account Updated");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
     }

            
        public void Login(String username,String password){ 
         try {
             
        String query= "select * from customer where username=? and password=?";
             
                PreparedStatement ps = null;
                ResultSet rs =null;
            
               ps=con.prepareStatement(query);
               ps.setString(1, username);
               ps.setString(2, password);
               rs=ps.executeQuery();
               if(rs.next()){
                   
                 customerid  = rs.getInt(1);
                 LoggedIn_Customer X = LoggedIn_Customer.getInstance();
                 X.setID(customerid);
                 JOptionPane.showMessageDialog(null, customerid);
                 JOptionPane.showMessageDialog(null, "Logged In ");
                 new CustomerMenu(this).setVisible(true);
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
    
    
             @Override
    public String update(String message) {
        
      JFrame frame = new JFrame();
        //System.out.printf("%s New notification: %s%n",message);
        Icon blueIcon = new ImageIcon("yourFile.gif");
          Object stringArray[] = { "Next", "Close" };
         JOptionPane.showOptionDialog(frame, message,"New Promocodes",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, blueIcon, stringArray,
        stringArray[0]);
         
         String msg=message;
         

         
          return message;
         
         
         
        
        
    }
    
    
    
}
