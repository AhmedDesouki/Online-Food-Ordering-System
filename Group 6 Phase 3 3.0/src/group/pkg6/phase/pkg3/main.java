/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.pkg6.phase.pkg3;
import group.pkg6.phase.pkg3.DBConnect;
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
 * @author patri
 */
public class main {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();
    
    private static PayStrategy strategy;
    static {
        // product id 1 , price 2200
//        priceOnProducts.put(1, 2200);
//        priceOnProducts.put(2, 1850);
//        priceOnProducts.put(3, 1100);
//        priceOnProducts.put(4, 890);
    }
  public static void main(String[] args) throws IOException {
      //CTRL-SHIFT-C   (to comment and un-comment)
//        while (!order.isClosed()) {
//            int cost;
//
//            String continueChoice;
//            do {
//                System.out.print("Please, select a product:" + "\n" +
//                        "1 - Mother board price: 2200" + "\n" +
//                        "2 - CPU price: 18500" + "\n" +
//                        "3 - HDD price: 11000" + "\n" +
//                        "4 - Memory price: 890" + "\n");
//                int choice = Integer.parseInt(reader.readLine());
//                cost = priceOnProducts.get(choice);
//                System.out.print("Count: ");
//                int count = Integer.parseInt(reader.readLine());
//                order.setTotalCost(cost * count);
//                System.out.print("Do you wish to continue selecting products? Y/N: ");
//                continueChoice = reader.readLine();
//            } while (continueChoice.equalsIgnoreCase("Y"));
//
//            if (strategy == null) {
//                System.out.println(
//                        "Please, select a payment method:" + "\n" +
//                        "1 - PalPay" + "\n" +
//                        "2 - Credit Card"+"\n"+"3- Cash"
//                );
//                String paymentMethod = reader.readLine();
//
//                // Client creates different strategies based on input from user,
//                // application configuration, etc.
//                if (paymentMethod.equals("1")) {
//                    strategy = new PayByPayPal();
//                } else if(paymentMethod.equals("2")){
//                    strategy = new PayByCreditCard();
//                }
//                else
//                {
//                    strategy = new PayByCash();
//                }
//            }
//
//            // Order object delegates gathering payment data to strategy object,
//            // since only strategies know what data they need to process a
//            // payment.
//            order.processOrder(strategy);
//
//            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
//            String proceed = reader.readLine();
//            if (proceed.equalsIgnoreCase("P")) {
//                // Finally, strategy handles the payment.
//                if (strategy.pay(order.getTotalCost())) {
//                    System.out.println("Payment has been successful.");
//                } else {
//                    System.out.println("FAIL! Please, check your data.");
//                }
//                order.setClosed();
//            }
//        }
//    }

//          DBConnect db = new DBConnect();
          //db.Make_Order(1, 1, "date", 123, "test");
          //db.Add_to_Cart(1, 1, 1, 0);
          //Add_to_Cart(int cart_id ,int customer_id ,int product_id,int quntaity) 
//            db.Add_to_Cart( 1, 2, 1);
//            db.Add_to_Cart( 1, 2, 2);
//            db.Add_to_Cart( 1, 2, 4);
//            db.Add_to_Cart( 1, 1, 4);
//            db.Make_Order(1,"test","PayPal");
        
        
      
  }
}
  
