package group.pkg6.phase.pkg3;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {

    private final String userName = "root";
    private final String password = "";
    private final String dbName = "group6";

    private Connection con;

    public DBConnect() {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }
    public Connection connect(){
        return con;
    }
}
