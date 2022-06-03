package group.pkg6.phase.pkg3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class Admin extends User
{
    DBConnect databaseconnection= new DBConnect();
     private Connection con = databaseconnection.connect();

    static Admin instance;
    static boolean logAdmin; //bagarab 7aga
    
    private Admin() 
    {
        super("Admin",  "Admin@bue.com",  "1234",  null);   //N3mlha noPay ba3den badal null
    }

    private Admin(String username, String email, String password, PaymentMethod payment) 
    {
        super(username, email, password, payment);
    }
    
    public static Admin getInstance()
    {
        if(instance == null)
        {
            instance = new Admin();
        }
            return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
        public void Login(String username,String password){ 
         try {
             
        String query= "select * from admin where username=? and password=?";
             
                PreparedStatement ps = null;
                ResultSet rs =null;
            
               ps=con.prepareStatement(query);
               ps.setString(1, username);
               ps.setString(2, password);
               rs=ps.executeQuery();
               if(rs.next()){
                   
//                 customerid  = rs.getInt(1);
                 //JOptionPane.showMessageDialog(null, customerid);
                 JOptionPane.showMessageDialog(null, "Logged In ");
                new ActionAdmin().setVisible(true);
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
}
