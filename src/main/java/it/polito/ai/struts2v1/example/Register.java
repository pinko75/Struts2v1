package it.polito.ai.struts2v1.example;

import it.polito.ai.struts2v1.example.model.User;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class Register extends ExampleSupport {
	public String execute() throws Exception {
		
		Map session = (Map) ActionContext.getContext().get("session");
		Map<String, User> userDB = (Map<String, User>)session.get("UserDB");
		if (userDB == null){
			System.out.println("creating userDB");
			userDB = new HashMap<String, User>();
			session.put("UserDB", userDB);
		}
		User u = new User(getUsername(), getPassword());
		userDB.put(getUsername(), u);
		//test
		Map<String, User> testuserDB = (Map<String, User>)session.get("UserDB");
		User us = testuserDB.get(getUsername());
		System.out.println(us.getUsername() + " " + getPassword());
		return SUCCESS;
	}

	String username;
	String password;
	String confirm_password;
	String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
