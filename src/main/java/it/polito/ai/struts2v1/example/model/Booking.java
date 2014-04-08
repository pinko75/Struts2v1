package it.polito.ai.struts2v1.example.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Booking {
    private int bookingId;
	private Date day;
	private Time startTime;
	private Time endTime;
	private int roomId;
	private String userName;

	public Booking(){
	}
	
	public Booking(Date day, Time startTime, Time endTime, int roomId,
			String userName) {
		
		super();
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomId = roomId;
		this.userName = userName;
	}
	

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setDate(Timestamp day) {
        this.day = day;		
	}

		// TODO Auto-generated method stub
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Time endTime) {
        this.endTime = endTime;		
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
		
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public int getRoomId() {
		return roomId;
	}

	public String getUserName() {
		return userName;
	}
    
}
