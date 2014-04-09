package it.polito.ai.struts2v1.example.dal;

import java.sql.SQLException;

import it.polito.ai.struts2v1.example.model.User;

public interface UserDao {
    public User getUser(String username) throws SQLException;
    
    public void deleteUser(String username);
    
    public User createUser(String name, String username, String password, String email) throws SQLException;
    
}
