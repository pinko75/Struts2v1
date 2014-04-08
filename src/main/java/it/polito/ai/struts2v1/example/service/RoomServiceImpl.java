package it.polito.ai.struts2v1.example.service;

import it.polito.ai.struts2v1.example.dal.RoomDao;
import it.polito.ai.struts2v1.example.dal.RoomDaoImpl;
import it.polito.ai.struts2v1.example.model.Room;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements RoomService{
	RoomDao dao = null;
	
	public RoomServiceImpl(){
    	dao = new RoomDaoImpl();
    }
	
	public List<Room> getAllRooms() throws SQLException {
		return dao.findAllRooms();
	}
}
