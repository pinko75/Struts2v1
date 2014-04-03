package it.polito.ai.struts2v1.example;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class HSQLTest {
    @Test
	public void testDB() throws Exception {
    	 try {
    	     Class.forName("org.hsqldb.jdbc.JDBCDriver" );
    	 } catch (Exception e) {
    	     System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
    	     e.printStackTrace();
    	     return;
    	 }

    	 Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb;ifexists=true", "SA", "");
    	 assertNotNull(c);
	}
}
