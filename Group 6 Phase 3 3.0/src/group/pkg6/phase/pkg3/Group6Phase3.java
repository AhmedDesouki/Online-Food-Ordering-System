package group.pkg6.phase.pkg3;
import java.util.*;
import java.lang.*;
import java.time.*;

public class Group6Phase3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        HomePage hp = new HomePage();
        hp.setVisible(true);
        // TODO code application logic here
        
        Admin x = Admin.getInstance();
        System.out.println(x);
        System.out.println(x.getUsername());
        System.out.println(x.getPassword());
        System.out.println(x.getEmail());
         
        
        
        Restaurant y = new Restaurant("N1", "M1", "123", null, "makan", null, null);
        System.out.println(y.restaurantid);
        
        Restaurant z = new Restaurant("N1", "M1", "123", null, "makan", null, null);
        System.out.println(z.toString());
        
        

        
        //Product p = new Product("Prod1", 5, 20.0);
        //System.out.println(p.toString());
        
        Menu m = new Menu(z);
        //m.addProdtoMenu("Prod1", 5, 20.0);
        //m.addProdtoMenu("Prod2", 5, 20.0);
        //System.out.println(m.displayMenu());
       
        //z.setMenu(m); //ai sout ba3d el add dih bydrb fe kolo
        
        PromoCode prom1 = new PromoCode("Mario20", 20, "2022-05-05");
        System.out.println(prom1.toString());

         LocalDate currentdate = LocalDate.now();
    
         if(currentdate.isAfter(prom1.getExpirydate()))
        {
            System.out.println("Wa2tak 5eles yngm");
        }
        else
        {
            System.out.println("Lesa 3andak wa2t");
        }
        
    }
}
