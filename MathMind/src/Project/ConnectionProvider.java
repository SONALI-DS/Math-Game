package Project; //Package declaration

import java.sql.*;

/**
 *
 * @author soni
 */
public class ConnectionProvider {
    public static Connection getCon()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mathmind","root","root");
        return con;
        }
        catch (Exception e)
        {
           return null; 
        }
        
    }
    
}
