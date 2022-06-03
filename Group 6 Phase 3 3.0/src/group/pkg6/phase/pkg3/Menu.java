package group.pkg6.phase.pkg3;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Menu  implements ReadMenu
{
    static int menuid = 0;
    Restaurant restaurant;
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();

    public Menu() 
    {
        this.restaurant = null;
    }  
    
    public Menu(Restaurant restaurant) 
    {
        this.menuid += 1;
        this.restaurant = restaurant;
        restaurant.setMenu(this); 
    }
    
//    public void addProdtoMenu(String pname, int quanitity, double price)
//    {
//        Product prod = new Product(pname, quanitity, price);
//        products.add(prod);
//        //Yb2a y7oto fe database el product brdu 34an el products tetmeli
//    }
    
    public void deleteMenu()
    {
        
    }
    
    public void editMenu()
    {
        
    }

    @Override
public JTable displayMenu(JTable jTable1, int restaurant_id) {
        try {
            
            ResultSet rs = null;
            Statement stmt = con.createStatement();
           String sql2 = "SELECT * FROM product where product.menu_id IN (select menu.menu_id from menu where menu.restaurant_id='" +restaurant_id+"')";
//            String sql2 = "SELECT * FROM product where product.menu_id IN (select menu.menu_id from menu)";
            
            System.out.println(sql2);
            rs = stmt.executeQuery(sql2);

            DefaultTableModel model;
            model = (DefaultTableModel) jTable1.getModel();
            Object rowData[] = new Object[3];

            while (rs.next()) {
                rowData[0] = rs.getInt("product_id");
                rowData[1] = rs.getString("product_name");
                rowData[2] = rs.getInt("price");
                model.addRow(rowData);
            }
        } catch (Exception e) 
        {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }

        return jTable1;
    }
    
    
    
    @Override
    public String toString() {
        return "Menu{" + "menuid=" + menuid + ", restaurant=" + restaurant + '}';
    }
    
    
    
}
