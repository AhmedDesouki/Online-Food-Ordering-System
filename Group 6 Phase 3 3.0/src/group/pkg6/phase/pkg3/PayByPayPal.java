package group.pkg6.phase.pkg3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author patrick195232
 */
public class PayByPayPal implements PayStrategy {
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;
    DBConnect db = new DBConnect();
    
      Order or = new Order();
    static 
    {
        DATA_BASE.put("test", "test@test.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    /**
     * Collect customer's data.
     */
//    @Override
//    public void collectPaymentDetails() {
//        try {
//            while (!signedIn) {
//                System.out.print("Enter the user's email: ");
//                email = READER.readLine();
//                System.out.print("Enter the password: ");
//                password = READER.readLine();
//                if (verify()) {
//                    System.out.println("Data verification has been successful.");
//                } else {
//                    System.out.println("Wrong email or password!");
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
    //login function here
    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal.");
                 // Change the hard coded value
                 // public void Make_Order(int order_id,int cart_id,String date,String PaymentMethod) 
                or.Make_Order(1,"test","PayPal");
            
            return true;
        } else {
            return false;
        }
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
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
}
