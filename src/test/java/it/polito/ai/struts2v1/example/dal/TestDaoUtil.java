package it.polito.ai.struts2v1.example.dal;

import static org.junit.Assert.*;
import it.polito.ai.struts2v1.example.model.Booking;
import it.polito.ai.struts2v1.example.model.Room;
import it.polito.ai.struts2v1.example.model.User;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class TestDaoUtil {
	DaoUtil daoUtil = null;
	
	@Before
	public void init(){
		daoUtil = new DaoUtil();
		
	}
    @Test
	public void testDBConnection() throws Exception {
		Connection c = daoUtil.getConnection();
		assertNotNull(c);
	}
    
    @Test
	public void getsNextIdValForBooking() throws Exception {
	    int id = daoUtil.getNextIdVal(Booking.class);
	    assertTrue(id > 0);
	}
    
    @Test
	public void getsNextIdValForRoom() throws Exception {
    	int id = daoUtil.getNextIdVal(Room.class);
	    assertTrue(id > 0);
	}
    
    @Test
	public void getNextIdValForUser() throws Exception {
    	int id = daoUtil.getNextIdVal(User.class);
	    assertTrue(id > 0);
	}
}
