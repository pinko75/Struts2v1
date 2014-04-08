package it.polito.ai.struts2v1.example;

import it.polito.ai.struts2v1.example.service.BookingService;
import it.polito.ai.struts2v1.example.service.BookingServiceImpl;

public class RemoveBooking extends ExampleSupport {
	
	public String execute() throws Exception {
        BookingService bookingService = new BookingServiceImpl();
        bookingService.deleteBooking(bid);
        return SUCCESS;
	}

	int bid;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

}
