package group.pkg6.phase.pkg3;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author patri
 */
public class Cart {
       DBConnect databaseconnection= new DBConnect();
       private Connection con = databaseconnection.connect();
       
       public void Add_to_Cart(int customer_id ,int product_id,int quntaity ) 
        {
        try {
            
            Statement stmt = con.createStatement();
          //stmt.executeUpdate("insert into cart values("+ customer_id + ", "+cart_id+", '1/1/1969', "+Total_price+",'"+PaymentMethod+"')");
            String sql = "INSERT INTO cart (cart_id, customer_id, product_id, quntaity) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, customer_id);
            ps.setInt(2, customer_id);
            ps.setInt(3, product_id);
            ps.setInt(4, quntaity);
            ps.executeUpdate();
            System.out.println("Product Added to cart");
            }
        catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
      }
}
