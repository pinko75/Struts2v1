package it.polito.ai.struts2v1.example.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class JdbcTutorial {
 
 public Connection getConnection() {
  Connection con = null;
  try {
   //load the HSQLDB Database Driver. 
   //This gets loaded from the hsqldb-xxx.jar
   Class.forName("org.hsqldb.jdbcDriver");
  } catch (ClassNotFoundException cnfe) {
   System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
   cnfe.printStackTrace();
  }
   
  try {
   //connect to the database. 
	  con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sale", "sa", ""); 
  }
  catch (SQLException e) {
   System.out.println("ERROR: failed to connect to the databse");
   e.printStackTrace();
  }
   
  return con;
 }
  
  
 public void executeInsertQuery(Connection con) {
  PreparedStatement ps = null;
 
  try {
	   ps = con.prepareStatement("INSERT INTO BUSER VALUES(?,?)");
	   ps.setInt(1, 11);
	   ps.setString(2, "Roman");
	   ps.executeUpdate(); // executes the insert query
    
  }
  catch (Exception e) {
   System.out.println("ERROR executing query: ");
   e.printStackTrace();
  }
  finally {
   try {
    //close the statement
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  }
 }
  
  
 public void executeSelectQuery(Connection con) {
  PreparedStatement ps = null;
   
  try {
	  ps = con.prepareStatement("SELECT * FROM BUSER");
	   ResultSet rs = ps.executeQuery(); // read from database
	   while(rs.next()){
	    Integer id = rs.getInt("BUSER_ID");
	    String name = rs.getString("NAME");
	    System.out.println("id:" + id + ", name:" + name );
	   }
  }
  catch (Exception e) {
   System.out.println("ERROR executing query: ");
   e.printStackTrace();
  }
  finally{
   try {
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  }
 }
 
 
 //main method
 public static void main(String[] args) {
   
  JdbcTutorial tut = new JdbcTutorial();
   
  //1. get the connection to the database
  final Connection con = tut.getConnection();
   
  //2. Insert a record via JDBC
  tut.executeInsertQuery(con);
   
  //3. select all records from the database
  tut.executeSelectQuery(con);
   
   
  //4. close the connection to the databse
  try {
   con.close();
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }
 
}