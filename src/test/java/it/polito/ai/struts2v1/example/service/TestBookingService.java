package it.polito.ai.struts2v1.example.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBookingService {
    @Test
	public void getsAllBookings() throws Exception {
		BookingService bs = new BookingServiceImpl();
		assertTrue(bs.getAllBookings().size() > 0 );
	}
}
