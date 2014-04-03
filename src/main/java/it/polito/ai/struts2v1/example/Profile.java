package it.polito.ai.struts2v1.example;

import it.polito.ai.struts2v1.example.dal.UserDao;
import it.polito.ai.struts2v1.example.dal.UserDaoImpl;
import it.polito.ai.struts2v1.example.model.User;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class Profile extends ExampleSupport {
	public String execute() throws Exception {
		String username = ServletActionContext.getRequest().getParameter("user");
	    UserDao dao = new UserDaoImpl();
	    User u = dao.getUser(username);

		return SUCCESS;
		
	}
}
