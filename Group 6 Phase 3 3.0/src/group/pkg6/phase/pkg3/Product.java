package group.pkg6.phase.pkg3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Product {

    int productid;
    String pname;
    int quanitity;
    double price;
    static int counter = 1;
    DBConnect databaseconnection= new DBConnect();
    private Connection con = databaseconnection.connect();

        public Product() {
        this.pname = "";
    }
    
    public Product(String pname, int quanitity, double price) {
        this.productid = counter;
        this.pname = pname;
        this.quanitity = quanitity;
        this.price = price;
        counter += 1;
    }
    public void AddProduct(String pname, int price, int menuid){
        try {
            Statement stmt = con.createStatement(); 
            String sql = "INSERT INTO product ( product_name, price, menu_id) VALUES (?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, pname);
            ps.setInt(2, price);
            ps.setInt(3, menuid);
            ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Inserted ");
            
        }catch(Exception e){
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
        
    }
    public int getProductid() {
        return productid;
    }

    public String getPname() {
        return pname;
    }

    public int getQuanitity() {
        return quanitity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setQuanitity(int quanitity) {
        this.quanitity = quanitity;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void deleteProduct()
    {
    
    }
    
    public void editProduct()
    {
    
    }

    @Override
    public String toString() {
        return "Product{" + "productid=" + productid + ", pname=" + pname + ", quanitity=" + quanitity + ", price=" + price + '}';
    }
    
    
}
