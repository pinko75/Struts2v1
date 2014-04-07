package it.polito.ai.struts2v1.example.dal;

import it.polito.ai.struts2v1.example.model.Booking;

import java.sql.SQLException;
import java.util.List;

public interface BookingDao {
    public List<Booking> findAllBookings() throws SQLException; 
}
