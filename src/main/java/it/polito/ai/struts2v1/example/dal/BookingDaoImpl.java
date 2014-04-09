package it.polito.ai.struts2v1.example.dal;

import it.polito.ai.struts2v1.example.model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		String sql = "select BOOKING_ID, BDATE, SLOT_START_TIME, SLOT_END_TIME, USERNAME, ROOM_ID from BOOKING, BUSER where Booking.BUSER_ID = BUSER.BUSER_ID";
		try {
			c = DaoUtil.getConnection();
			st = c.createStatement();
			rs = st.executeQuery(sql);
			Booking b = null;
			while (rs.next()){
				b = new Booking();
				b.setBookingId(rs.getInt("BOOKING_ID"));
				b.setDate(rs.getTimestamp("BDATE"));
				b.setStartTime(rs.getTime("SLOT_START_TIME"));
				b.setEndTime(rs.getTime("SLOT_END_TIME"));
				b.setRoomId(rs.getInt("ROOM_ID"));
				b.setUserName(rs.getString("USERNAME"));
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
	
	public void bookNew(Booking b) throws SQLException {
		Connection c = null;
		Statement statement = null;
        try{
            int nextId = new DaoUtil().getNextIdVal(Booking.class);
            String sql = "INSERT INTO BOOKING(BOOKING_ID, BDATE, SLOT_START_TIME, SLOT_END_TIME, ROOM_ID, BUSER_ID) "
            		+ " VALUES(" + nextId + ",'" + new java.sql.Date(b.getDay().getTime()) + "','" + b.getStartTime() + "','"  +b.getEndTime() + "'," + b.getRoomId() + "," + "(select buser_id from buser where username ='" +  b.getUserName() + "'))";
            System.out.println(sql);
            c = DaoUtil.getConnection();
            statement = c.createStatement();
            statement.executeUpdate(sql);
        } finally{
			
			if (statement != null)
				statement.close();
			
			if (c != null)
			    c.close();
		}
	}
	public void deleteBooking(int bid) throws SQLException {
		Connection c = null;
		Statement statement = null;
		try{
		    String sql = "delete from Booking where booking_id=" + bid;
		    c = DaoUtil.getConnection();
            statement = c.createStatement();
            statement.executeUpdate(sql);
		} finally{
			
			if (statement != null)
				statement.close();
			
			if (c != null)
			    c.close();
		}
	}

}
