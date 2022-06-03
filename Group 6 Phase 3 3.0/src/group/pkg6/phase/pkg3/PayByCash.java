package group.pkg6.phase.pkg3;

/**
 *
 * @author patri
 */
import group.pkg6.phase.pkg3.DBConnect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
public class PayByCash implements PayStrategy {
        DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
         DBConnect db = new DBConnect();
         private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

//         
//    @Override
//    public void collectPaymentDetails() {
//       //it will not collect data
//    }

    @Override
    public boolean pay(int paymentAmount) 
    {
        //haeader public void Make_Order(int order_id,int cart_id,String date,int Total_price,String PaymentMethod)
        //Change the hard coded value
      //  db.Make_Order(1, 1, "1/1/1690", paymentAmount, "Cash");
             return true;
    }

     @Override
     public void Make_Order(int customer_id,String date,String PaymentMethod) 
        {
        try {
            
            Statement stmt = con.createStatement();
            //it will get the total price of the products in the cart
            String sql3="SELECT sum(cart.quntaity*product.price) as TOTAL FROM product,cart WHERE product.product_id=cart.product_id AND cart.in_cart=1 AND cart.cart_id="+customer_id+"";
            System.out.println(sql3);
            ResultSet rs1=stmt.executeQuery(sql3);
            rs1.next();
            String foundType = rs1.getString(1);
            int Total_price= parseInt(foundType);
       
//            //System.out.println(Total_price);
            
           stmt.executeUpdate("insert into orderr(cart_id,date,TotalPrice,PaymentMethod) values("+customer_id+", '1/1/1969', "+Total_price+",'"+PaymentMethod+"')");
           //to update the boolean condition in_cart to false (i will use it to get order history)
            String sql = "update cart set in_cart=0 where cart_id=?";
           PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, customer_id);
            ps.executeUpdate();        
            System.out.println("the orderd has been added");
            }
        catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
      }
    
}
