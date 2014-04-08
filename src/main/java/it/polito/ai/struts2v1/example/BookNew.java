package it.polito.ai.struts2v1.example;

import it.polito.ai.struts2v1.example.model.Booking;
import it.polito.ai.struts2v1.example.service.BookingService;
import it.polito.ai.struts2v1.example.service.BookingServiceImpl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class BookNew extends ExampleSupport {
    public String execute() throws Exception {
    	Map session = (Map) ActionContext.getContext().get("session");
        String username = (String)session.get("loggedin"); 
        BookingService bookingService = new BookingServiceImpl();
        
        DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
        Date dday =  df.parse(day);  
        String startTime = parseStartTime(slot);
        String endTime = parseEndTime(slot);
        System.out.println(startTime + " " + endTime + " " + dday);
        Booking b = new Booking(dday, Time.valueOf(startTime),Time.valueOf(endTime), Integer.parseInt(room), username); 
        bookingService.bookNew(b);
        return SUCCESS;
    }
    
    private String parseStartTime(String slot) {
    	String[] times = slot.split("-");
		return times[0];
    }
    
    private String parseEndTime(String slot) {
		String[] times = slot.split("-");
		return times[1];
	}


	String room;
    String day;
    String slot; 
    
    
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
}
