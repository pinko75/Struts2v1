package it.polito.ai.struts2v1.example.dal;

import it.polito.ai.struts2v1.example.model.Booking;
import it.polito.ai.struts2v1.example.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao {
	public BookingDaoImpl(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	public List<Booking> findAllBookings() throws SQLException{
		Statement st = null;
	    ResultSet rs = null;
		Connection c = null;
		List<Booking> bookings = new ArrayList<Booking>();
		String sql = "select BDATE, SLOT_START_TIME, SLOT_END_TIME, NAME, ROOM_ID from BOOKING, BUSER";
		try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			rs = st.executeQuery(sql);
			Booking b = null;
			while (rs.next()){
				b = new Booking();
				b.setDate(rs.getTimestamp("BDATE"));
				b.setStartTime(rs.getTime("SLOT_START_TIME"));
				b.setEndTime(rs.getTime("SLOT_END_TIME"));
				b.setRoomId(rs.getInt("ROOM_ID"));
				b.setUserName(rs.getString("NAME"));
				bookings.add(b);
			}	
			
			return bookings;
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
