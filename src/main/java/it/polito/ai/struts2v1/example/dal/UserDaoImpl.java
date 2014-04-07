package it.polito.ai.struts2v1.example.dal;

import it.polito.ai.struts2v1.example.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			if (rs != null && rs.next()){
				u = new User(rs.getString(2));
			}	
			
			return u;
		}catch(SQLException e){
            e.printStackTrace();
            throw e;
		}finally{
			if (rs != null)
			    rs.close();
			
			if (st != null)
			    st.close();
			
			if (c != null)
			    c.close();
		}
	}

	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	public User createUser(String username, String password) throws SQLException {
		Statement st = null;
		Connection c = null;
        User u = null;
        
        String sql = "insert into BUSER VALUES (" + daoUtil.getNextIdVal(User.class) + ",'" + username + "')";
		
    	try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			st.executeUpdate(sql);
			u = new User(username, password);
			return u;
		}finally{
			st.close();
			c.close();
		}	
	}

}
