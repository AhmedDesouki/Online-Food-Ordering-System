package group.pkg6.phase.pkg3;

import static java.lang.Integer.parseInt;
import java.sql.*;


/**
 * Order class. Doesn't know the concrete payment method (strategy) user has
 * picked. It uses common strategy interface to delegate collecting payment data
 * to strategy object. It can be used to save order to database.
 */
public class Order {
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    
    private int totalCost = 0;
    private boolean isClosed = false;

//    public void processOrder(PayStrategy strategy) {
//        //strategy.collectPaymentDetails();
//        // Here we could collect and store payment data from the strategy.
//    }

//    public void setTotalCost(int cost) {
//        this.totalCost += cost;
//    }
//
//    public int getTotalCost() {
//        return totalCost;
//    }
//
//    public boolean isClosed() {
//        return isClosed;
//    }
//
//    public void setClosed() {
//        isClosed = true;
//    }
    public void Make_Order(int customer_id,String date,String PaymentMethod) 
        {
        try {
            
            Statement stmt = con.createStatement();
            //it will get the total price of the products in the cart
            //String sql1="SELECT sum(cart.quntaity*product.price) as TOTAL FROM product,cart WHERE product.product_id=cart.product_id="+customer_id+" AND cart.in_cart=1";
            String sql1="SELECT sum(cart.quntaity*product.price) as TOTAL FROM product,cart WHERE product.product_id=cart.product_id AND cart.in_cart=1 AND cart.cart_id="+customer_id+"";
            System.out.println(sql1);
            ResultSet rs1=stmt.executeQuery(sql1);
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