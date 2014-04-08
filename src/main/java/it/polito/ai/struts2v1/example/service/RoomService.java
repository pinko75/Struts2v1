package it.polito.ai.struts2v1.example.service;

import it.polito.ai.struts2v1.example.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
    public List<Room> getAllRooms() throws SQLException; 
}
