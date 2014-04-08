package it.polito.ai.struts2v1.example.service;

import it.polito.ai.struts2v1.example.dal.BookingDao;
import it.polito.ai.struts2v1.example.dal.BookingDaoImpl;
import it.polito.ai.struts2v1.example.model.Booking;

import java.sql.SQLException;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    BookingDao dao = null;
    
	public BookingServiceImpl(){
    	dao = new BookingDaoImpl();
    }
	
	public List<Booking> getAllBookings() throws SQLException {
	    return dao.findAllBookings();	
	}

	public void bookNew(Booking b) throws SQLException {
		dao.bookNew(b);
	}

	public void deleteBooking(int bid) throws SQLException {
		dao.deleteBooking(bid);
		
	}

}
