/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group.pkg6.phase.pkg3;

/**
 *
 * @author Kareem
 */
public class LoggedIn_Customer {
    
    
    static LoggedIn_Customer instance;
    int CustomerID;
    
    
    private LoggedIn_Customer(){}
    
    public static LoggedIn_Customer getInstance(){
        
        if (instance == null){
            instance = new LoggedIn_Customer();}
        
        return instance;}


public void setID(int ID){

this.CustomerID = ID;
}


public int getID(){
return CustomerID;
}


}