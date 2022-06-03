package group.pkg6.phase.pkg3;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Restaurant extends User 
{
    int restaurantid;
    String location;
    Menu menu;
    ArrayList<Order> orders;
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();

//Complain ticket;
    


    public Restaurant() 
    {
        this.location = "";
        this.menu = null;
        this.orders = null;
    }

    public Restaurant(String username, String email, String password, PaymentMethod payment, String location, Menu menu, ArrayList<Order> orders) {
        super(username, email, password, payment);
        this.restaurantid += 1;
        this.location = location;
        this.menu = menu;
        this.orders = orders;
    }



    
    public void AddMenu(int restid){
         try {
            
           // Statement stmt = con.createStatement();  
            String sql = "INSERT INTO menu (menu_id, restaurant_id) VALUES (?,?)";
            
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setInt(1, restid);
            ps1.setInt(2, restid);

            ps1.executeUpdate();
            System.out.println(sql);
           JOptionPane.showMessageDialog(null, "Inserted succesfull");
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }
    public void addRestaurant(String user, String pass, String mail, String loc) 
    {
        try {
            
          //  Statement stmt = con.createStatement();  
            
            String sql = "INSERT INTO restaurant (username, password, email, location) VALUES (?,?,?,?)";
            String sql1 = "INSERT INTO menu (menu_id, restaurant_id) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, mail);
            ps.setString(4, loc);
            ps.executeUpdate();
            System.out.println(sql);
            JOptionPane.showMessageDialog(null, "Inserted succesfull");
 
            ps1.setInt(1, this.getRestaurantid());
            ps1.setInt(2, this.getRestaurantid());

            ps1.executeUpdate();
            System.out.println(sql1);
            
        } 
            catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }
    
      
    
        public void deleteRestaurant(int id){
         
             try {

                 String query = "delete from restaurant where restaurant_id = "+id;
                 Statement s = null;
                 s = con.createStatement();
                 s.executeUpdate(query);

                 JOptionPane.showMessageDialog(null, "Restaurant deleted");
             } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, ex);
             }
         
         
         }
        
        public  void editRestaurant(int id,String user, String pass, String mail, String loc){
     
         try {
             
             String query= "update group6.restaurant set username= '"+user+"', password='"+pass+"', email='"+mail+"', location='"+loc+"' where restaurant_id="+id;
  
            Statement s=null;
            s=con.createStatement();
            s.executeUpdate(query);
      
            JOptionPane.showMessageDialog(null, "Restaurant Updated");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
     }
        
                public  void editRestaurantAdmin(int id,String user, String mail, String loc){
     
         try {
             
             String query= "update group6.restaurant set username= '"+user+"', email='"+mail+"', location='"+loc+"' where restaurant_id="+id;
  
            Statement s=null;
            s=con.createStatement();
            s.executeUpdate(query);
      
            JOptionPane.showMessageDialog(null, "Restaurant Updated");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
     }

                public void Login(String username,String password){ 
         try {
             
        String query= "select * from restaurant where username=? and password=?";
             
                PreparedStatement ps = null;
                ResultSet rs =null;
            
               ps=con.prepareStatement(query);
               ps.setString(1, username);
               ps.setString(2, password);
               rs=ps.executeQuery();
               if(rs.next()){
                   
                 restaurantid  = rs.getInt(1);
                 JOptionPane.showMessageDialog(null, restaurantid);
                 JOptionPane.showMessageDialog(null, "Logged In ");
                 new RestaurantMenu(this).setVisible(true);
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
        
        
    public int getRestaurantid() {
        return restaurantid;
    }

    public String getLocation() {
        return location;
    }

    public Menu getMenu() {
        return menu;
    }

    public ArrayList<Order> getOrders() {
        return orders;
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

    public PaymentMethod getPayment() {
        return payment;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMenu(Menu menu) 
    {
        this.menu = menu;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "username=" + username + ", email=" + email + ", password=" + password + ", payment=" + payment + "location=" + location + ", menu=" + menu + ", orders=" + orders + '}';
    }

    


    
    
}
