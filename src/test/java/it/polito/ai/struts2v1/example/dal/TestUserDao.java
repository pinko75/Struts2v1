package it.polito.ai.struts2v1.example.dal;

import static org.junit.Assert.*;
import it.polito.ai.struts2v1.example.model.User;

import org.junit.Before;
import org.junit.Test;

public class TestUserDao {
	private UserDao userDao;

	@Before
	public void init(){
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void createsAUser() throws Exception {
		User u = userDao.createUser("Rocco", "Rocco");
		assertEquals("Rocco", u.getUsername());
	}
}
