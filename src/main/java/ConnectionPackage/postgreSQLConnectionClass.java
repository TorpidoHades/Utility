/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionPackage;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jaswant
 */

   
   
public class postgreSQLConnectionClass 
{
 
 private Connection conn = null;
 
 public Connection getConnection(String username,String password,String port,String hostname,String dbname) throws ClassNotFoundException, SQLException    
 {
     
     Class.forName("org.postgresql.Driver");
    
     String url = "jdbc:postgresql://"+hostname+":"+port+"/"+dbname+"?user="+username+"&password="+password;
     System.out.println(url);
     conn = DriverManager.getConnection(url);
     ResultSet rsCheck = null;
     Statement  stmtCheck = null;
     stmtCheck = conn.createStatement();
             
     rsCheck = stmtCheck.executeQuery("select now()");
     if(!rsCheck.next())
     {
        rsCheck.first();
        return null;
     }
     
     return conn;
 
 }
 public void closeConnection(Connection con) throws SQLException
 {
     con.close();
 }
    
}
