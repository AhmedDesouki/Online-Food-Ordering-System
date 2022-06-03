
package group.pkg6.phase.pkg3;

/**
 *
 * @author patri
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;
      DBConnect db = new DBConnect();
      Order or = new Order();
    /**
     * Collect credit card data.
     */
//    @Override
//    public void collectPaymentDetails() {
//        try {
//            System.out.print("Enter the card number: ");
//            String number = READER.readLine();
//            System.out.print("Enter the card expiration date 'mm/yy': ");
//            String date = READER.readLine();
//            System.out.print("Enter the CVV code: ");
//            String cvv = READER.readLine();
//            card = new CreditCard(number, date, cvv);
//
//            // Validate credit card number...
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    /**
     * After card validation we can charge customer's credit card.
     */
 
    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);
            // Change the hard coded value 
            or.Make_Order(1,"test","PayPal");
            return true;
        } else {
            return false;
        }
    }
       @Override
    public void Make_Order(int customer_id,String date,String PaymentMethod) 
        {
        try {
            
            Statement stmt = con.createStatement();
            //it will get the total price of the products in the cart 
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
    private boolean cardIsPresent() {
        return card != null;
    }
    
}