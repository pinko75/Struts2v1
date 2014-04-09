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
        
		String sql = "select BUSER_ID, NAME, EMAIL, USERNAME, PASSWORD  from BUSER WHERE USERNAME='" +username +"'";
		try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			rs = st.executeQuery(sql);
			
			if (rs != null && rs.next()){
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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

	public User createUser(String name, String username, String password, String email) throws SQLException {
		Statement st = null;
		Connection c = null;
        User u = null;
        int nextId;
        
        nextId = daoUtil.getNextIdVal(User.class); 
        String sql = "insert into BUSER VALUES (" + nextId + ",'" + name + "','" + email + "','" + username + "','" + password +  "')";
		
    	try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			st.executeUpdate(sql);
			u = new User(nextId, name, email , username, password);
			return u;
		}finally{
			st.close();
			c.close();
		}	
	}

}
