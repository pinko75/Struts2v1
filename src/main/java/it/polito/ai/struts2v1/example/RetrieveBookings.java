package it.polito.ai.struts2v1.example;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import it.polito.ai.struts2v1.example.service.BookingService;
import it.polito.ai.struts2v1.example.service.BookingServiceImpl;

public class RetrieveBookings extends ExampleSupport {
	public String execute() throws Exception {
		BookingService service = new BookingServiceImpl();
		
		Map session = (Map) ActionContext.getContext().get("session");
        session.put("all_bookings", service.getAllBookings());
		return SUCCESS;
	}
}
