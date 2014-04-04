package it.polito.ai.struts2v1.example.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.polito.ai.struts2v1.example.model.User;

public class UserDaoImpl implements UserDao{
	private DaoUtil daoUtil;

	public UserDaoImpl(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		daoUtil = new DaoUtil();
	}

	Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:"
                + "Sale",     
                "sa",                     
                "");                      
		return conn;
	}
	
	public User getUser(String username) throws SQLException {
		Statement st = null;
	    ResultSet rs = null;
		Connection c = null;
        User u = null;
        
		String sql = "select BUSER_ID, NAME  from BUSER WHERE NAME='" +username +"'";
		try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			rs = st.executeQuery(sql);
			
			if ( rs.next()){
				u = new User(rs.getString(2));
			}	
			
			return u;
		}finally{
			rs.close();
			st.close();
			c.close();
			
		}
	}

	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	public User createUser(String username, String password) throws SQLException {
		Statement st = null;
	    int res;
		Connection c = null;
        User u = null;
        
        String sql = "insert into BUSER VALUES (" + daoUtil.getNextIdVal(User.class) + ",'" + username + "')";
		
    	try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			res = st.executeUpdate(sql);
			u = new User(username, password);
			return u;
		}finally{
			st.close();
			c.close();
		}	
	}

}
