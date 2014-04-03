package it.polito.ai.struts2v1.example.dal;

import it.polito.ai.struts2v1.example.model.User;

public interface UserDao {
    public User getUser(String username);
    
    public void deleteUser(String username);
    
    public User createUser(String username, String password);
    
    
}
