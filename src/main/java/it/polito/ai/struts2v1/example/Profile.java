package it.polito.ai.struts2v1.example;

import java.util.Map;

import it.polito.ai.struts2v1.example.dal.UserDao;
import it.polito.ai.struts2v1.example.dal.UserDaoImpl;
import it.polito.ai.struts2v1.example.model.User;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class Profile extends ExampleSupport {
	public String execute() throws Exception {
		String username = ServletActionContext.getRequest().getParameter("username");
	    UserDao dao = new UserDaoImpl();
	    User u = dao.getUser(username);
        System.out.println("Profile.username : " + u.getUsername());
	    Map session = (Map) ActionContext.getContext().get("session");
        session.put("user_profile", u);
		return SUCCESS;
		
	}
}
