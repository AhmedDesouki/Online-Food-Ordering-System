package group.pkg6.phase.pkg3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;

public class Complain {
    static int complainid = 0;
    int customerid;
    String ComplainText;
    Date date;
    //String ComplainType;
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();

    
        public Complain() 
    {
        this.customerid = 0;
        this.ComplainText = "";
        this.date = null;
        //this.ComplainType = "";
    }

    public Complain(String ComplainText, LoggedIn_Customer X) {
        this.complainid += 1;
        this.customerid = X.getID();
        this.date = new Date();
        this.ComplainText = ComplainText;
        //this.ComplainType = ComplainType
    }
    
    public int getCustomerid() {
        return customerid;
    }
    
    public int getComplainid() {
        return complainid;
    }
    
    public String getComplain() {
        return ComplainText;
    }
        
    public Date getDate() {
        return date;
    }
    
//    public String getComplainType() {
//        return ComplainType;
//    }
    
    
    public void SetCustomerid(LoggedIn_Customer X) {
        this.customerid = X.getID();
    }
    
    
    
    public void SetComplian(String ComplainText) {
        this.ComplainText = ComplainText;
    }
    
    
//    public void SetComplianType (String ComplainType) {
//        this.ComplainType = ComplainType;
//    }
    
    
    
//        public void addComplain(LoggedIn_Customer X, String ComplainText) 
//    {
//        try {
//            
//            Statement stmt = con.createStatement();  
//            String sql = "INSERT INTO complain (complain, customer_id) VALUES (?,?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            String Cusid = String.valueOf(X.getID());
//            ps.setString(1, ComplainText);
//            ps.setString(2, Cusid);
//            ps.executeUpdate();
//            System.out.println(sql);
//            JOptionPane.showMessageDialog(null, "Inserted succesfull");
//            
//        } 
//            catch (Exception e) 
//        {
//            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
//        }
//    }
    
            public void addComplain(int Cusid, String ComplainText) 
    {
        try {
            
            Statement stmt = con.createStatement();  
            String sql = "INSERT INTO complain (complain, customer_id) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            //String Cusid = String.valueOf(X.getID());
            ps.setString(1, ComplainText);
            ps.setInt(2, Cusid);
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