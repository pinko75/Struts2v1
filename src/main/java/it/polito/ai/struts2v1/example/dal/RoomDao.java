package it.polito.ai.struts2v1.example.dal;

import it.polito.ai.struts2v1.example.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDao {

	List<Room> findAllRooms() throws SQLException;
    
}
