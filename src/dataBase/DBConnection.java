package dataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author 
 *
 */
public class DBConnection {
	
	
    public Connection con;
    
    String url ="jdbc:mysql://localhost:3306/";
    String DBdriver="com.mysql.jdbc.Driver";
    String user = "root";
    String pass = "";    
    
    /**
     * connect APP to data base
     * @return Connection to data base
     * @throws SQLException
     */
    public Connection mkConnection() throws SQLException{
        try {
            Class.forName(DBdriver);
            System.out.println("driver loaded");
            
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("connected to data base!");
           
            
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
     
        }
        return con;
    }
    
}
