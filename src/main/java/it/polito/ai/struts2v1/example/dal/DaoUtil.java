package it.polito.ai.struts2v1.example.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.ai.struts2v1.example.model.Booking;
import it.polito.ai.struts2v1.example.model.Room;
import it.polito.ai.struts2v1.example.model.User;

public class DaoUtil {
	
	public DaoUtil(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/"
                + "Sale",     
                "sa",                     
                "");                      
		return conn;
	}
	
    public  int getNextIdVal(Class entity) throws SQLException{
    	String idCol = null;
		String table = null;
		if (entity == User.class){
			idCol = "BUSER_ID";
			table = "BUSER";
		}else if (entity == Booking.class){
			idCol = "BOOKING_ID";
			table = "BOOKING";
		}else if (entity == Room.class){
			idCol = "ROOM_ID";
			table = "ROOM";
		}
		
		return  query(idCol, table);
    	
    }

	private int query(String idCol, String table) throws SQLException  {
   	    Statement st = null;
	    ResultSet rs = null;
		Connection c = null;
        int nextId = -1; 
        
		String sql = "select MAX("+ idCol +")" +  " from " +  table;
		 
		try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			rs = st.executeQuery(sql);
			
			if ( rs.next())
				nextId = rs.getInt(1);
			
			return nextId +1;
		} catch ( SQLException e ){
			e.printStackTrace();
			throw e;
		}
		finally{
			if ( rs != null)
			    rs.close();
			if ( st != null)
			    st.close();
			if ( c != null)
			    c.close();
			
		}
	}
	            
}
