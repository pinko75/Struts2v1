package it.polito.ai.struts2v1.example.dal;

import it.polito.ai.struts2v1.example.model.Booking;
import it.polito.ai.struts2v1.example.model.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    public RoomDaoImpl(){
    	try {
			Class.forName("org.hsqldb.jdbcDriver");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
	public List<Room> findAllRooms() throws SQLException{
		Statement st = null;
	    ResultSet rs = null;
		Connection c = null;
		List<Room> rooms = new ArrayList<Room>();
		String sql = "select * from ROOM";
		try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			rs = st.executeQuery(sql);
			Room r = null;
			while (rs.next()){
				r = new Room();
				r.setRoomId(rs.getInt("ROOM_ID"));
				rooms.add(r);
			}	
			
			return rooms;
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

}
