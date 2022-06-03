/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.pkg6.phase.pkg3;
import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ahmed Desouki
 */

public class PromoCode implements Subject{
    String promocode;
    int discount;
    LocalDate expirydate; //"2018-05-05" yy/mm/dd
    //https://www.baeldung.com/java-string-to-date
    //https://www.baeldung.com/java-comparing-dates
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();

    public PromoCode(String promocode, int discount, String expirydate) {
        this.promocode = promocode;
        this.discount = discount;
        this.expirydate = LocalDate.parse(expirydate);
    }

    PromoCode() {
    }

    public String getPromocode() {
        return promocode;
    }

    public int getDiscount() {
        return discount;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setExpirydate(LocalDate expirydate) {
        this.expirydate = expirydate;
    }

     public void addpromocode(String promocode, int disc, String expiry ) 
    {
        try {
            
            Statement stmt = con.createStatement();  
            String sql = "INSERT INTO promocode (promocode, discount,expiry) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, promocode);
            ps.setInt(2, disc);
            ps.setString(3, expiry);
           
            ps.executeUpdate();
            System.out.println(sql);
            JOptionPane.showMessageDialog(null, "Done");
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }
    
    
    @Override
    public String toString() {
        return "PromoCode{" + "promocode=" + promocode + ", discount=" + discount + ", expirydate=" + expirydate + '}';
    }

   @Override
    public void addObserver(int customerid,String username ) {
         //observer.update(promocode);
        
        try {
            
            Statement stmt = con.createStatement();  
            String sql = "INSERT INTO subscribers (customer_id, customername) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customerid);
            ps.setString(2, username);
            
           
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Inserted succesfull");
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE  ERROR: " + e.toString());
        }
        
        
    }

    @Override
    public void removeObserver(int custid) {
        
        
         try {

                 String query = "delete from subscribers where customer_id = "+custid;
                 Statement s = null;
                 s = con.createStatement();
                 s.executeUpdate(query);

                 //JOptionPane.showMessageDialog(null, " deleted");
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, ex);
             }
         
       
    }

//    @Override
//    public void notifyy() {
//        
//        //loop le kol el obsever el fe el database 
//        String message=this.getPromocode()+"available now";
//        
//        Observer observer=null;
//        observer.update(message);
//    }
     @Override
    public void notifyy() {
        
        //loop le kol el obsever el fe el database 
                     try {
            
            Statement stmt = con.createStatement();  
           String sql="SELECT * FROM promocode ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

               String message=rs.getString("promocode")+" "+"available now"+" "+"and you have "+rs.getInt("discount")+"% discount";
        
                Customer observer=new Customer();
                  observer.update(message);

            }
            
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE ERROR promocode: " + e.toString());
        }
           
        
    }

   

   
}
