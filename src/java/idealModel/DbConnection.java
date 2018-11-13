/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idealModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    public static String HOST = "jdbc:mysql://localhost:3306/ideal?autoReconnect=true&useSSL=false";
    public static String USERNAME = "root";
    public static String PASSWORD = "Remington870E";
//    public static String PASSWORD = "meiofasknasmisse123";
    private static Connection con;
       
    public void dbConnect() throws SQLException, ClassNotFoundException {
        
        if (con == null)    {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);   
        }
    }
   
    public ResultSet runSql(String sql){
        ResultSet rs = null;
        try {
            dbConnect();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage( ));
        }   
        catch (ClassNotFoundException cfe)   {
            System.out.println("Class not found"+ cfe);
        }
        return rs;
    }
}