package group.pkg6.phase.pkg3;

public class User 
{
    String username;
    String email; 
    String password;
    PaymentMethod payment;

    public User() 
    {
        this.username = "";
        this.email = "";
        this.password = "";
        this.payment = null; 
    }
    
    public User(String username, String email, String password, PaymentMethod payment) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.payment = payment;
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
    
    public void forgetPassword(String oldpassword, String newpassword) {
        if(oldpassword == password)
        {
            password = newpassword;
        }
    }
    
    public User login(String name, String pass) 
    {


        return null;
    }

    public void logout(String username)
    {
        
    }    
    
    public void changeUsername(String oldusername, String newusername)
    {
        
    }    
    
}
