package it.polito.ai.struts2v1.example.service;

import it.polito.ai.struts2v1.example.model.Booking;

import java.sql.SQLException;
import java.util.List;

public interface BookingService {
    public List<Booking> getAllBookings() throws SQLException; 
}
