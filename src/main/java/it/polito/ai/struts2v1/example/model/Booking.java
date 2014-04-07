package it.polito.ai.struts2v1.example.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Booking {

	private Timestamp day;
	private Time startTime;
	private Time endTime;
	private int roomId;
	private String userName;

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

	public Timestamp getDay() {
		return day;
	}

	public void setDay(Timestamp day) {
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
